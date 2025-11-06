"""
Generador de diapositivas de índice.
"""

from odf.text import P, List, ListItem
from odf.draw import Frame, TextBox


def create_index_slide(presentation, template_slide, content):
    """
    Crea una diapositiva de índice basándose en la plantilla.
    
    Args:
        presentation: Objeto de presentación ODP
        template_slide: Diapositiva plantilla a clonar
        content: Lista de elementos del índice
    
    Returns:
        Nueva diapositiva de índice
    """
    from copy import deepcopy
    new_slide = deepcopy(template_slide)
    
    # Buscar el frame de contenido y actualizar con los items del índice
    for frame in new_slide.getElementsByType(Frame):
        for textbox in frame.getElementsByType(TextBox):
            # Limpiar contenido existente
            for element in list(textbox.childNodes):
                textbox.removeChild(element)
            
            # Añadir título
            title_p = P(text="Índice")
            textbox.addElement(title_p)
            
            # Añadir items del índice
            for i, item in enumerate(content, 1):
                item_p = P(text=f"{i}. {item}")
                textbox.addElement(item_p)
    
    return new_slide


def update_index_slide_text(slide, items):
    """
    Actualiza el contenido de una diapositiva de índice.
    
    Args:
        slide: Diapositiva a actualizar
        items: Lista de elementos del índice
    """
    frames = slide.getElementsByType(Frame)
    
    if len(frames) >= 2:  # Asumiendo que el segundo frame es el de contenido
        textbox = frames[1].getElementsByType(TextBox)[0]
        
        # Limpiar párrafos existentes
        for p in list(textbox.getElementsByType(P)):
            textbox.removeChild(p)
        
        # Añadir nuevos items
        for i, item in enumerate(items, 1):
            p = P(text=f"{i}. {item}")
            textbox.addElement(p)
