"""
Generador de diapositivas de conclusión.
"""

from odf.text import P
from odf.draw import Frame, TextBox


def create_conclusion_slide(presentation, template_slide, conclusion_data):
    """
    Crea una diapositiva de conclusión basándose en la plantilla.
    
    Args:
        presentation: Objeto de presentación ODP
        template_slide: Diapositiva plantilla a clonar
        conclusion_data: Diccionario con title y points (lista de strings)
    
    Returns:
        Nueva diapositiva de conclusión
    """
    from copy import deepcopy
    new_slide = deepcopy(template_slide)
    
    frames = new_slide.getElementsByType(Frame)
    
    # Actualizar título (primer frame)
    if len(frames) >= 1:
        textbox = frames[0].getElementsByType(TextBox)[0]
        for p in textbox.getElementsByType(P):
            if p.firstChild:
                p.firstChild.data = conclusion_data.get('title', 'Conclusiones')
                break
    
    # Actualizar contenido (segundo frame)
    if len(frames) >= 2:
        textbox = frames[1].getElementsByType(TextBox)[0]
        
        # Limpiar contenido existente
        for p in list(textbox.getElementsByType(P)):
            textbox.removeChild(p)
        
        # Añadir puntos de conclusión
        for point in conclusion_data.get('points', []):
            p = P(text=point)
            textbox.addElement(p)
    
    return new_slide


def update_conclusion_slide_text(slide, title, points):
    """
    Actualiza el contenido de una diapositiva de conclusión.
    
    Args:
        slide: Diapositiva a actualizar
        title: Título de la diapositiva
        points: Lista de puntos de conclusión
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
        
        # Añadir puntos
        for point in points:
            p = P(text=point)
            textbox.addElement(p)
