# Caso Práctico 2 — Generación Automática de Presentaciones con IA

**Objetivo:** Crear un cli que genere automáticamente una presentación libreoffice (.odp).

---

## Requisitos del programa

- Genere **automáticamente** una presentación estructurada (formato .odp , libreoffice) basandose en el ejemplo 'plantilla-presentacion.odp'
- Aplique la estructura mediante **código**, no manualmente con interfaz gráfica.
- Se ejecute desde **línea de comandos**

---

## Pasos para generación de la presentación

1. Busca via web y genera el contenido de texto, imagen y diagramas de la presentación para las distintas diapositivas (portada, diapositivas de contenido de texto o de linea de tiempo, conclusiones)
2. Por cada diapositiva a generar:
    2.1. Leer la presentación de plantilla ( 'plantilla-presentacion.odp' ) y elegir la diapositiva de ejemplo a usar, p.e. portada, contenido de texto, contenido de linea de tiempo, conclusiones
    2.2. Genera una copia esa esa diapositiva en la nueva presentación
    2.3. Sustituye el contenido de esa diapositiva por el del tema de la presentación
    2.4. Revisa que queden todos los estilos bien.
3. Si lo ves necesario para siguientes pasos, actualiza AGENTS.md o README.md.

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
- **Java** — ejecutable desde línea de comandos
- **sdk de libreoffice**
---

## Estructura Recomendada del Proyecto

```
├── README.md                   # Instrucciones instalación y ejecución del cli
├── AGENTS.md                   # Este archivo
├── plantilla-presentacion.odp  # Plantilla de referencia para ir generando la presentación
├── ejemplo-presentacion.odp    # Ejemplo para ir generando la presentación
├── src/                        # Código, a ser posible separando código de cada slide
└── output/                     # Presentaciones generadas (.odp)
```
