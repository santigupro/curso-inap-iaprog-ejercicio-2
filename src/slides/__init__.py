"""
Módulo de generación de diapositivas para presentaciones ODP.
"""

from .cover_slide import create_cover_slide
from .index_slide import create_index_slide
from .content_slide import create_content_slide
from .timeline_slide import create_timeline_slide
from .conclusion_slide import create_conclusion_slide

__all__ = [
    'create_cover_slide',
    'create_index_slide',
    'create_content_slide',
    'create_timeline_slide',
    'create_conclusion_slide'
]
