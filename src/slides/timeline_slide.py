"""
Generador de diapositivas de línea de tiempo.
"""

from odf.text import P
from odf.draw import Frame, TextBox


def create_timeline_slide(presentation, template_slide, slide_data):
    """
    Crea una diapositiva de línea de tiempo basándose en la plantilla.
    
    Args:
        presentation: Objeto de presentación ODP
        template_slide: Diapositiva plantilla a clonar
        slide_data: Diccionario con title y steps (lista de dict con number, title, description)
    
    Returns:
        Nueva diapositiva de línea de tiempo
    """
    from copy import deepcopy
    new_slide = deepcopy(template_slide)
    
    frames = new_slide.getElementsByType(Frame)
    
    # Actualizar título (primer frame)
    if len(frames) >= 1:
        textbox = frames[0].getElementsByType(TextBox)[0]
        for p in textbox.getElementsByType(P):
            if p.firstChild:
                p.firstChild.data = slide_data.get('title', 'Línea de tiempo')
                break
    
    # Actualizar pasos (segundo frame)
    if len(frames) >= 2:
        textbox = frames[1].getElementsByType(TextBox)[0]
        
        # Limpiar contenido existente
        for p in list(textbox.getElementsByType(P)):
            textbox.removeChild(p)
        
        # Añadir pasos
        for step in slide_data.get('steps', []):
            # Línea de título del paso
            title_p = P(text=f"{step['number']}. {step['title']}")
            textbox.addElement(title_p)
            
            # Descripción del paso
            desc_p = P(text=f"   {step['description']}")
            textbox.addElement(desc_p)
            
            # Línea en blanco entre pasos
            empty_p = P(text="")
            textbox.addElement(empty_p)
    
    return new_slide


def update_timeline_slide_text(slide, title, steps):
    """
    Actualiza el contenido de una diapositiva de línea de tiempo.
    
    Args:
        slide: Diapositiva a actualizar
        title: Título de la diapositiva
        steps: Lista de diccionarios con number, title, description
    """
    frames = slide.getElementsByType(Frame)
    
    # Actualizar título
    if len(frames) >= 1:
        textbox = frames[0].getElementsByType(TextBox)[0]
        paragraph = textbox.getElementsByType(P)[0]
        if paragraph.firstChild:
            paragraph.firstChild.data = title
    
    # Actualizar pasos
    if len(frames) >= 2:
        textbox = frames[1].getElementsByType(TextBox)[0]
        
        # Limpiar
        for p in list(textbox.getElementsByType(P)):
            textbox.removeChild(p)
        
        # Añadir pasos
        for step in steps:
            title_p = P(text=f"{step['number']}. {step['title']}")
            textbox.addElement(title_p)
            
            desc_p = P(text=f"   {step['description']}")
            textbox.addElement(desc_p)
            
            empty_p = P(text="")
            textbox.addElement(empty_p)
