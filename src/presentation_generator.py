"""
Generador principal de presentaciones ODP.
"""

import os
import shutil
from copy import deepcopy
from odf.opendocument import load, OpenDocumentPresentation
from odf.draw import Page

from content_generator import get_presentation_content
from slides import (
    create_cover_slide,
    create_index_slide,
    create_content_slide,
    create_timeline_slide,
    create_conclusion_slide
)


class PresentationGenerator:
    """
    Clase para generar presentaciones ODP basadas en plantillas.
    """
    
    def __init__(self, template_path):
        """
        Inicializa el generador con una plantilla.
        
        Args:
            template_path: Ruta al archivo ODP de plantilla
        """
        self.template_path = template_path
        self.template_doc = None
        self.template_slides = []
    
    def load_template(self):
        """
        Carga la plantilla ODP y extrae las diapositivas de ejemplo.
        """
        print(f"📂 Cargando plantilla: {self.template_path}")
        self.template_doc = load(self.template_path)
        
        # Extraer todas las páginas (diapositivas) de la plantilla
        self.template_slides = self.template_doc.presentation.getElementsByType(Page)
        print(f"✓ Plantilla cargada: {len(self.template_slides)} diapositivas encontradas")
    
    def get_template_slide(self, index):
        """
        Obtiene una diapositiva plantilla por índice.
        
        Args:
            index: Índice de la diapositiva (0-based)
        
        Returns:
            Diapositiva plantilla
        """
        if 0 <= index < len(self.template_slides):
            return self.template_slides[index]
        return None
    
    def create_presentation(self, output_path):
        """
        Crea una nueva presentación basada en la plantilla.
        
        Args:
            output_path: Ruta donde guardar la presentación generada
        """
        print("\n🎨 Generando presentación sobre Tu Turno...")
        
        # Cargar plantilla
        self.load_template()
        
        # Crear nueva presentación copiando la plantilla
        new_doc = load(self.template_path)
        
        # Limpiar todas las diapositivas existentes
        presentation = new_doc.presentation
        for slide in list(presentation.getElementsByType(Page)):
            presentation.removeChild(slide)
        
        # Obtener el contenido
        content = get_presentation_content()
        
        # 1. Crear diapositiva de portada
        print("  📄 Creando portada...")
        cover_template = self.get_template_slide(0)  # Página 1
        cover_slide = self._create_cover(cover_template, content)
        presentation.addElement(cover_slide)
        
        # 2. Crear diapositiva de índice
        print("  📄 Creando índice...")
        index_template = self.get_template_slide(1)  # Página 2
        index_slide = self._create_index(index_template, content['index'])
        presentation.addElement(index_slide)
        
        # 3. Crear diapositivas de contenido
        for i, slide_data in enumerate(content['slides'], 1):
            print(f"  📄 Creando diapositiva {i + 2}: {slide_data['title']}")
            
            if slide_data['type'] == 'timeline':
                # Usar plantilla de línea de tiempo (página 4)
                template = self.get_template_slide(3)
                new_slide = self._create_timeline(template, slide_data)
            else:
                # Usar plantilla de contenido (página 3)
                template = self.get_template_slide(2)
                new_slide = self._create_content(template, slide_data)
            
            presentation.addElement(new_slide)
        
        # 4. Crear diapositiva de conclusiones
        print("  📄 Creando conclusiones...")
        conclusion_template = self.get_template_slide(4)  # Página 5
        conclusion_slide = self._create_conclusion(conclusion_template, content['conclusion'])
        presentation.addElement(conclusion_slide)
        
        # Guardar presentación
        os.makedirs(os.path.dirname(output_path), exist_ok=True)
        new_doc.save(output_path)
        print(f"\n✅ Presentación generada exitosamente: {output_path}")
    
    def _create_cover(self, template, content):
        """Crea diapositiva de portada."""
        slide = deepcopy(template)
        from odf.draw import Frame, TextBox
        from odf.text import P, Span
        
        frames = slide.getElementsByType(Frame)
        frame_texts = [
            content['title'],
            content['subtitle'],
            content['organization'],
            content['date']
        ]
        
        for i, frame in enumerate(frames):
            if i < len(frame_texts):
                textboxes = frame.getElementsByType(TextBox)
                if textboxes:
                    paragraphs = textboxes[0].getElementsByType(P)
                    if paragraphs:
                        # Limpiar y añadir nuevo texto
                        p = paragraphs[0]
                        # Eliminar hijos existentes
                        for child in list(p.childNodes):
                            p.removeChild(child)
                        # Añadir nuevo texto
                        p.addText(frame_texts[i])
        
        return slide
    
    def _create_index(self, template, items):
        """Crea diapositiva de índice."""
        slide = deepcopy(template)
        from odf.draw import Frame, TextBox
        from odf.text import P
        
        frames = slide.getElementsByType(Frame)
        if len(frames) >= 2:
            # Segundo frame es el contenido
            textboxes = frames[1].getElementsByType(TextBox)
            if textboxes:
                textbox = textboxes[0]
                
                # Limpiar
                for p in list(textbox.getElementsByType(P)):
                    textbox.removeChild(p)
                
                # Añadir items
                for i, item in enumerate(items, 1):
                    p = P()
                    p.addText(f"{i}. {item}")
                    textbox.addElement(p)
        
        return slide
    
    def _create_content(self, template, slide_data):
        """Crea diapositiva de contenido."""
        slide = deepcopy(template)
        from odf.draw import Frame, TextBox
        from odf.text import P
        
        frames = slide.getElementsByType(Frame)
        
        # Título
        if len(frames) >= 1:
            textboxes = frames[0].getElementsByType(TextBox)
            if textboxes:
                paragraphs = textboxes[0].getElementsByType(P)
                if paragraphs:
                    p = paragraphs[0]
                    for child in list(p.childNodes):
                        p.removeChild(child)
                    p.addText(slide_data['title'])
        
        # Contenido
        if len(frames) >= 2:
            textboxes = frames[1].getElementsByType(TextBox)
            if textboxes:
                textbox = textboxes[0]
                
                # Limpiar
                for p in list(textbox.getElementsByType(P)):
                    textbox.removeChild(p)
                
                # Añadir contenido
                for line in slide_data['content']:
                    p = P()
                    p.addText(line)
                    textbox.addElement(p)
        
        return slide
    
    def _create_timeline(self, template, slide_data):
        """Crea diapositiva de línea de tiempo."""
        slide = deepcopy(template)
        from odf.draw import Frame, TextBox
        from odf.text import P
        
        frames = slide.getElementsByType(Frame)
        
        # Título
        if len(frames) >= 1:
            textboxes = frames[0].getElementsByType(TextBox)
            if textboxes:
                paragraphs = textboxes[0].getElementsByType(P)
                if paragraphs:
                    p = paragraphs[0]
                    for child in list(p.childNodes):
                        p.removeChild(child)
                    p.addText(slide_data['title'])
        
        # Pasos
        if len(frames) >= 2:
            textboxes = frames[1].getElementsByType(TextBox)
            if textboxes:
                textbox = textboxes[0]
                
                # Limpiar
                for p in list(textbox.getElementsByType(P)):
                    textbox.removeChild(p)
                
                # Añadir pasos
                for step in slide_data['steps']:
                    title_p = P()
                    title_p.addText(f"{step['number']}. {step['title']}")
                    textbox.addElement(title_p)
                    
                    desc_p = P()
                    desc_p.addText(f"   {step['description']}")
                    textbox.addElement(desc_p)
                    
                    empty_p = P()
                    empty_p.addText("")
                    textbox.addElement(empty_p)
        
        return slide
    
    def _create_conclusion(self, template, conclusion_data):
        """Crea diapositiva de conclusión."""
        slide = deepcopy(template)
        from odf.draw import Frame, TextBox
        from odf.text import P
        
        frames = slide.getElementsByType(Frame)
        
        # Título
        if len(frames) >= 1:
            textboxes = frames[0].getElementsByType(TextBox)
            if textboxes:
                paragraphs = textboxes[0].getElementsByType(P)
                if paragraphs:
                    p = paragraphs[0]
                    for child in list(p.childNodes):
                        p.removeChild(child)
                    p.addText(conclusion_data['title'])
        
        # Puntos
        if len(frames) >= 2:
            textboxes = frames[1].getElementsByType(TextBox)
            if textboxes:
                textbox = textboxes[0]
                
                # Limpiar
                for p in list(textbox.getElementsByType(P)):
                    textbox.removeChild(p)
                
                # Añadir puntos
                for point in conclusion_data['points']:
                    p = P()
                    p.addText(point)
                    textbox.addElement(p)
        
        return slide
