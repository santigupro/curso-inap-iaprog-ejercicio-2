# Caso Práctico 2 — Generación Automática de Presentaciones con IA

**Objetivo:** Crear un cli que genere automáticamente una presentación libreoffice (.odp).

---

## Requisitos del programa

- Genere **automáticamente** una presentación estructurada (formato .odp , libreoffice) basandose en el ejemplo 'plantilla-presentacion.odp'
- Aplique la estructura mediante **código**, no manualmente con interfaz gráfica.
- Se ejecute desde **línea de comandos**

---

## Pasos para generación de la presentación

**MUST** Estos pasos debes seguirlo cualquier agente

1. Busca via web y genera el contenido de texto, imagen y diagramas de la presentación para las distintas diapositivas (portada, diapositivas de contenido de texto o de linea de tiempo, conclusiones... )
2. Para la diapositiva que te pida generar:
    - Cargar la presentación de plantilla ( 'plantilla-presentacion.odp' ).
    - Cargar la diapositiva de ejemplo a usar para la generación. En la plantilla de ejemplo cada tipo de diapositiva es:
        - pagina 1 es diapositiva de portada
        - pagina 2 es diapositiva de indice
        - página 3 es diapositiva de contenido de texto
        - página 4 es diapositiva de contenido de linea de tiempo
        - paǵina 5 es  diapositiva de conclusiones. 
    - Genera una copia esa esa diapositiva en la nueva presentación.
    - En la nueva diapositiva generada en la nueva presentación, sustituye el contenido de esa diapositiva por el del tema de la presentación.
3. Si lo ves necesario para optimizar siguientes pasos, actualiza AGENTS.md o README.md.

---

## Requisitos Mínimos de la Presentación

1. **Una diapositiva de portada** — incluir título, subtítulo y fecha.
2. **Una diapositiva con índice** — listado de secciones o contenido a seguir.
3. **De 4 a 6 diapositivas con contenido** — tema a elección, relacionado con la Administración Pública (ej.: sistema de expedientes, cita previa, liquidación de tasas, guía de usuario, etc.).
4. **Una diapositiva de cierre/conclusiones** — resumen y llamada a la acción.
5.- El contenido debe tratar sobre el **'Tu Turno', sistema de gestion de cita previa de la Junta de Andalucía**


---

## Tecnología Recomendada

### Lenguaje
- **Python 3.8+** — ejecutable desde línea de comandos
- **Librerías:**
  - `odfpy` — Para manipular archivos ODP (OpenDocument Presentation)
  - `python-pptx` — Alternativa para generar presentaciones (opcional)
  - `Pillow` — Para manejo de imágenes
  - `requests` — Para buscar y descargar contenido web si es necesario

---

## Estructura Recomendada del Proyecto

```
├── README.md                   # Instrucciones instalación y ejecución del cli
├── AGENTS.md                   # Este archivo
├── requirements.txt            # Dependencias Python
├── plantilla-presentacion.odp  # Plantilla de referencia para ir generando la presentación
├── ejemplo-presentacion.odp    # Ejemplo para ir generando la presentación
├── src/                        # Código Python, a ser posible separando código de cada slide
│   ├── main.py                 # Script principal CLI
│   ├── presentation_generator.py  # Generador de presentación
│   ├── content_generator.py   # Generador de contenido
│   └── slides/                 # Módulos para cada tipo de slide
│       ├── __init__.py
│       ├── cover_slide.py
│       ├── index_slide.py
│       ├── content_slide.py
│       ├── timeline_slide.py
│       └── conclusion_slide.py
└── output/                     # Presentaciones generadas (.odp)
```
