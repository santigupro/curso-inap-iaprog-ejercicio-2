"""
Generador de diapositivas de contenido de texto.
"""

from odf.text import P
from odf.draw import Frame, TextBox


def create_content_slide(presentation, template_slide, slide_data):
    """
    Crea una diapositiva de contenido basándose en la plantilla.
    
    Args:
        presentation: Objeto de presentación ODP
        template_slide: Diapositiva plantilla a clonar
        slide_data: Diccionario con title y content (lista de strings)
    
    Returns:
        Nueva diapositiva de contenido
    """
    from copy import deepcopy
    new_slide = deepcopy(template_slide)
    
    frames = new_slide.getElementsByType(Frame)
    
    # Actualizar título (primer frame)
    if len(frames) >= 1:
        textbox = frames[0].getElementsByType(TextBox)[0]
        for p in textbox.getElementsByType(P):
            if p.firstChild:
                p.firstChild.data = slide_data.get('title', 'Título')
                break
    
    # Actualizar contenido (segundo frame)
    if len(frames) >= 2:
        textbox = frames[1].getElementsByType(TextBox)[0]
        
        # Limpiar contenido existente
        for p in list(textbox.getElementsByType(P)):
            textbox.removeChild(p)
        
        # Añadir nuevo contenido
        for line in slide_data.get('content', []):
            p = P(text=line)
            textbox.addElement(p)
    
    return new_slide


def update_content_slide_text(slide, title, content_lines):
    """
    Actualiza el contenido de una diapositiva de texto.
    
    Args:
        slide: Diapositiva a actualizar
        title: Título de la diapositiva
        content_lines: Lista de líneas de contenido
    """
    frames = slide.getElementsByType(Frame)
    
    # Actualizar título
    if len(frames) >= 1:
        textbox = frames[0].getElementsByType(TextBox)[0]
        paragraph = textbox.getElementsByType(P)[0]
        if paragraph.firstChild:
            paragraph.firstChild.data = title
    
    # Actualizar contenido
    if len(frames) >= 2:
        textbox = frames[1].getElementsByType(TextBox)[0]
        
        # Limpiar
        for p in list(textbox.getElementsByType(P)):
            textbox.removeChild(p)
        
        # Añadir líneas
        for line in content_lines:
            p = P(text=line)
            textbox.addElement(p)
