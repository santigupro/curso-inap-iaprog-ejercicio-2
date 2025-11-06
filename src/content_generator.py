"""
Generador de contenido sobre el sistema Tu Turno.
"""

def get_presentation_content():
    """
    Retorna todo el contenido de la presentación sobre Tu Turno.
    """
    return {
        'title': 'Tu Turno',
        'subtitle': 'Sistema de Gestión de Cita Previa',
        'organization': 'Junta de Andalucía',
        'date': '6 de noviembre de 2025',
        
        'index': [
            'Introducción al sistema',
            'Características principales',
            'Beneficios para ciudadanos y administración',
            'Proceso de solicitud de cita previa',
            'Datos y estadísticas de uso',
            'Conclusiones y futuras mejoras'
        ],
        
        'slides': [
            {
                'title': 'Introducción al sistema',
                'type': 'content',
                'content': [
                    '• Tu Turno es el sistema centralizado de cita previa de la Junta de Andalucía',
                    '• Permite a los ciudadanos solicitar citas de forma online o presencial',
                    '• Gestiona servicios de múltiples consejerías y organismos',
                    '• Disponible 24/7 a través de web, app móvil y teléfono',
                    '• Mejora la experiencia del ciudadano y optimiza recursos administrativos'
                ]
            },
            {
                'title': 'Características principales',
                'type': 'content',
                'content': [
                    '• Reserva de citas online sin necesidad de desplazamiento',
                    '• Integración con Cl@ve para identificación segura',
                    '• Recordatorios automáticos por SMS y email',
                    '• Gestión de cancelaciones y modificaciones',
                    '• Acceso desde múltiples dispositivos (móvil, tablet, PC)',
                    '• Múltiples idiomas disponibles'
                ]
            },
            {
                'title': 'Beneficios',
                'type': 'content',
                'content': [
                    'Para el ciudadano:',
                    '• Ahorro de tiempo y desplazamientos',
                    '• Mayor comodidad y flexibilidad horaria',
                    '• Reducción de esperas presenciales',
                    '',
                    'Para la administración:',
                    '• Optimización de recursos y personal',
                    '• Reducción de aglomeraciones',
                    '• Mejor planificación de servicios',
                    '• Datos para análisis y mejoras'
                ]
            },
            {
                'title': 'Proceso de solicitud',
                'type': 'timeline',
                'steps': [
                    {
                        'number': '1',
                        'title': 'Acceso',
                        'description': 'Entrar en juntadeandalucia.es/tuturno o mediante app'
                    },
                    {
                        'number': '2',
                        'title': 'Identificación',
                        'description': 'Identificarse con certificado digital, Cl@ve o datos personales'
                    },
                    {
                        'number': '3',
                        'title': 'Selección',
                        'description': 'Elegir servicio, oficina, fecha y hora disponible'
                    },
                    {
                        'number': '4',
                        'title': 'Confirmación',
                        'description': 'Recibir confirmación por email/SMS con código de cita'
                    }
                ]
            },
            {
                'title': 'Datos y estadísticas',
                'type': 'content',
                'content': [
                    '• Más de 5 millones de citas gestionadas anualmente',
                    '• Disponible para más de 200 servicios diferentes',
                    '• Tasa de satisfacción superior al 85%',
                    '• Reducción del 40% en tiempos de espera presencial',
                    '• Más del 70% de citas solicitadas online',
                    '• Presente en todas las provincias andaluzas'
                ]
            }
        ],
        
        'conclusion': {
            'title': 'Conclusiones y Futuras Mejoras',
            'points': [
                '✓ Tu Turno ha transformado la atención ciudadana en Andalucía',
                '✓ Sistema escalable y adaptable a nuevos servicios',
                '✓ Alto nivel de adopción por parte de los ciudadanos',
                '',
                'Próximas mejoras:',
                '• Integración con asistentes virtuales e IA',
                '• Videollamadas para consultas no presenciales',
                '• Predicción inteligente de demanda',
                '• Mayor personalización de la experiencia'
            ]
        }
    }
