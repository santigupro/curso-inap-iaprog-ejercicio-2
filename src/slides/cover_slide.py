"""
Generador de diapositivas de portada.
"""

from odf.text import P
from odf.draw import Frame, TextBox


def create_cover_slide(presentation, template_slide, content):
    """
    Crea una diapositiva de portada basándose en la plantilla.
    
    Args:
        presentation: Objeto de presentación ODP
        template_slide: Diapositiva plantilla a clonar
        content: Diccionario con title, subtitle, organization, date
    
    Returns:
        Nueva diapositiva de portada
    """
    # Clonar la diapositiva plantilla
    from copy import deepcopy
    new_slide = deepcopy(template_slide)
    
    # Buscar y reemplazar elementos de texto
    for frame in new_slide.getElementsByType(Frame):
        for textbox in frame.getElementsByType(TextBox):
            for paragraph in textbox.getElementsByType(P):
                text = str(paragraph)
                
                # Reemplazar contenido según el texto encontrado
                if 'Título' in text or 'Tu Turno' in text:
                    paragraph.firstChild.data = content.get('title', 'Tu Turno')
                elif 'Subtítulo' in text or 'Sistema de Gestión' in text:
                    paragraph.firstChild.data = content.get('subtitle', 'Sistema de Gestión de Cita Previa')
                elif 'Junta' in text or 'Andalucía' in text:
                    paragraph.firstChild.data = content.get('organization', 'Junta de Andalucía')
                elif 'fecha' in text.lower() or '202' in text:
                    paragraph.firstChild.data = content.get('date', '6 de noviembre de 2025')
    
    return new_slide


def update_cover_slide_text(slide, content):
    """
    Actualiza el texto de una diapositiva de portada existente.
    
    Args:
        slide: Diapositiva a actualizar
        content: Diccionario con el contenido
    """
    frames = slide.getElementsByType(Frame)
    
    # Intentar actualizar frames por posición/orden
    if len(frames) >= 1:
        # Primer frame grande: título
        textbox = frames[0].getElementsByType(TextBox)[0]
        paragraph = textbox.getElementsByType(P)[0]
        if paragraph.firstChild:
            paragraph.firstChild.data = content.get('title', 'Tu Turno')
    
    if len(frames) >= 2:
        # Segundo frame: subtítulo
        textbox = frames[1].getElementsByType(TextBox)[0]
        paragraph = textbox.getElementsByType(P)[0]
        if paragraph.firstChild:
            paragraph.firstChild.data = content.get('subtitle', 'Sistema de Gestión de Cita Previa')
    
    if len(frames) >= 3:
        # Tercer frame: organización
        textbox = frames[2].getElementsByType(TextBox)[0]
        paragraph = textbox.getElementsByType(P)[0]
        if paragraph.firstChild:
            paragraph.firstChild.data = content.get('organization', 'Junta de Andalucía')
    
    if len(frames) >= 4:
        # Cuarto frame: fecha
        textbox = frames[3].getElementsByType(TextBox)[0]
        paragraph = textbox.getElementsByType(P)[0]
        if paragraph.firstChild:
            paragraph.firstChild.data = content.get('date', '6 de noviembre de 2025')
