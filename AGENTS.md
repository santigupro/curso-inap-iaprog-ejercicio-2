# Caso Práctico 2 — Generación Automática de Presentaciones con IA

**Objetivo:** Crear un cli que genere automáticamente una presentación libreoffice (.odp).

---

## Requisitos del programa

- Genere **automáticamente** una presentación estructurada (formato .odp , libreoffice).
- Aplique la estructura mediante **código**, no manualmente con interfaz gráfica.
- Se ejecute desde **línea de comandos**

---

## Requisitos Mínimos de la Presentación

1. **Una diapositiva de portada** — incluir título, subtítulo y fecha.
2. **Una diapositiva con índice** — listado de secciones o contenido a seguir.
3. **De 4 a 6 diapositivas con contenido** — tema a elección, relacionado con la Administración Pública (ej.: sistema de expedientes, cita previa, liquidación de tasas, guía de usuario, etc.).
4. **Una diapositiva de cierre/conclusiones** — resumen y llamada a la acción.
5.- El contenido debe tratar sobre el **'Tu Turno', sistema de gestion de cita previa de la Junta de Andalucía**


### Elementos de formato y estilo

- Tipografía clara y legible.
- Títulos destacados y jerarquía visual.
- Estilo profesional y atractivo.
- Genera diagramas e imagenes relevantes sobre el contenido.

---

## Tecnología Recomendada

### Lenguaje
- **Java** — ejecutable desde línea de comandos
- **sdk de libreoffice**
---

## Estructura Recomendada del Proyecto

```
├── README.md                 # Instrucciones instalación y ejecución del cli
├── AGENTS.md                 # Este archivo
├── src/                      # Código, a ser posible separando código de cada slide
└── output/                   # Presentaciones generadas (.odp)
```
