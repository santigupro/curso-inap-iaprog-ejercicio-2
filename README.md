# Caso Práctico 2 — Generación Automática de Presentaciones con IA

**Objetivo:** Crear un script que genere automáticamente una presentación (.pptx) mediante programación asistida por IA (LLMs), sin crear diapositivas de forma manual.

---

## Resumen del Enunciado

Este ejercicio culmina el curso formativo aplicando técnicas de generación de código con LLMs. Se solicita diseñar un programa o script que:

- Genere **automáticamente** una presentación estructurada (formato .odp).
- Aplique la estructura mediante **código**, no manualmente con interfaz gráfica.
- Use apoyo de un LLM o técnicas de programación asistida por IA.
- Se ejecute desde **línea de comandos**

---

## Requisitos Mínimos de la Presentación

1. **Una diapositiva de portada** — incluir título, subtítulo y fecha.
2. **Una diapositiva con índice** — listado de secciones o contenido a seguir.
3. **De 4 a 6 diapositivas con contenido** — tema a elección, relacionado con la Administración Pública (ej.: sistema de expedientes, cita previa, liquidación de tasas, guía de usuario, etc.).
4. **Una diapositiva de cierre/conclusiones** — resumen y llamada a la acción.

### Elementos de formato y estilo

- Usa la plantilla proporcionada en el directorio plantilla
- Tipografía clara y legible.
- Títulos destacados y jerarquía visual.
- Genera diagramas e imagenes relevantes.

---

## Tecnología Recomendada

### Lenguaje
- **Pyhton** — ejecutable desde línea de comandos
---

## Estructura Recomendada del Proyecto

```
proyecto-presentacion/
├── README.md                 # Este archivo
├── src/                      # Código, a ser posible separado por cada slide
└── output/                   # Presentaciones generadas (.pptx)
```
