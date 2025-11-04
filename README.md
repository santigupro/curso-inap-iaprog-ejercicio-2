# Caso Práctico 2 — Generación Automática de Presentaciones con IA

**Objetivo:** Crear un script TypeScript que genere automáticamente una presentación (.pptx) mediante programación asistida por IA (LLMs), sin crear diapositivas de forma manual.

---

## Resumen del Enunciado

Este ejercicio culmina el curso formativo aplicando técnicas de generación de código con LLMs. Se solicita diseñar un programa o script que:

- Genere **automáticamente** una presentación estructurada (formato .pptx o .odp).
- Aplique la estructura mediante **código**, no manualmente con interfaz gráfica.
- Use apoyo de un LLM o técnicas de programación asistida por IA.
- Se ejecute desde **línea de comandos** (TypeScript / Node.js CLI).

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
- Genera diagramas e imagenes relevantes, si es necesario.

---

## Tecnología Recomendada

### Lenguaje
- **TypeScript** — ejecutable desde línea de comandos mediante Node.js.

### Librería para generar presentaciones
- **pptxgenjs** — librería Node que genera .pptx de forma nativa, sin depender de LibreOffice o software externo.
  - Soporte completo de estilos, colores, tipografías y layouts.
  - API intuitiva y documentación clara.
  - Compatible con CLI y scripts automatizados.

---

## Estructura Recomendada del Proyecto

```
proyecto-presentacion/
├── README.md                 # Este archivo
├── package.json              # Dependencias npm
├── tsconfig.json             # Configuración TypeScript
├── src/
│   ├── index.ts              # Entrada principal (CLI)
│   ├── presentation.ts       # Lógica de generación de presentación
│   ├── slides/
│   │   ├── cover.ts          # Diapositiva de portada
│   │   ├── index.ts          # Diapositiva de índice
│   │   ├── content.ts        # Diapositivas de contenido
│   │   └── closing.ts        # Diapositiva de cierre
│   └── config.ts             # Estilos, colores, fuentes
├── dist/                     # Salida compilada (generada tras `npm run build`)
└── output/                   # Presentaciones generadas (.pptx)
```

---

## Instalación y Ejecución

### 1. Instalación de dependencias

```bash
npm install pptxgenjs
npm install --save-dev typescript ts-node @types/node
npm install --save-dev @types/pptxgenjs
```

### 2. Ejecución durante desarrollo (con ts-node)

```bash
npx ts-node src/index.ts --output output/presentacion.pptx
```

### 3. Compilación y ejecución en producción

```bash
npm run build
node dist/index.js --output output/presentacion.pptx
```

### 4. Configurar scripts en package.json

```json
{
  "scripts": {
    "dev": "ts-node src/index.ts",
    "build": "tsc",
    "start": "node dist/index.js"
  }
}
```

---

## Ejemplo Mínimo de Uso

### src/index.ts

```typescript
import PptxGenJS from 'pptxgenjs';

const pres = new PptxGenJS();

// Diapositiva de portada
const slide1 = pres.addSlide();
slide1.background = { color: '1a4d7a' };
slide1.addText('Mi Presentación', {
  x: 0.5,
  y: 2,
  w: 9,
  h: 1,
  fontSize: 44,
  bold: true,
  color: 'ffffff',
  align: 'center'
});

// Diapositiva de contenido
const slide2 = pres.addSlide();
slide2.addText('Contenido', { x: 0.5, y: 0.5, w: 9, h: 0.5, fontSize: 32, bold: true });
slide2.addText('Punto 1: Lorem ipsum dolor sit amet.', { x: 0.5, y: 1.2, w: 9, h: 0.4 });
slide2.addText('Punto 2: Consectetur adipiscing elit.', { x: 0.5, y: 1.7, w: 9, h: 0.4 });

// Guardar
pres.writeFile({ fileName: 'output/presentacion.pptx' });
console.log('✓ Presentación generada: output/presentacion.pptx');
```

---

## Entregables Requeridos

1. **Código fuente** — script/programa TypeScript que genere la presentación.
2. **Archivo de presentación** — `.pptx` generado ejecutando el código.
3. **Descripción del proceso** — 200–300 palabras máximo, explicando:
   - Herramienta IA utilizada (si aplica).
   - Librerías y tecnologías.
   - Formato final (.pptx o .odp).
   - Si se usó plantilla o recursos visuales.
   - Pasos clave para ejecutar el script.

### Ejemplo de descripción (plantilla)

> *Se utilizó TypeScript con la librería pptxgenjs para generar automáticamente una presentación .pptx sobre [TEMA]. El script se estructura en módulos que crean cada sección (portada, índice, contenido y cierre) de forma programática, permitiendo dinamismo y reutilización. Se empleó una paleta de colores coherente basada en los tonos corporativos de la Administración Pública española ([colores específicos]). Se asignó la fuente Arial para máxima compatibilidad. El script se ejecuta desde línea de comandos con `npx ts-node src/index.ts` y genera el archivo de salida en la carpeta output/. Opcionalmente, se integró [LLM utilizado] para generar dinámicamente el contenido textual de las diapositivas.*

---

## Criterios de Evaluación

- ✅ **Automatización:** La presentación se genera íntegramente mediante código; no contiene diapositivas creadas manualmente.
- ✅ **Cumplimiento de requisitos:** Portada, índice, 4–6 slides de contenido, cierre/conclusiones.
- ✅ **Presentación visual:** Estilos coherentes (colores, tipografía, jerarquía).
- ✅ **Calidad del código:** Legibilidad, estructura modular, manejo de errores.
- ✅ **Ejecutabilidad:** El script se ejecuta sin errores desde línea de comandos.
- ✅ **Documentación:** Descripción clara del proceso (200–300 palabras).

---

## Recursos Útiles

- **pptxgenjs:** https://github.com/gitbrent/PptxGenJS
- **TypeScript:** https://www.typescriptlang.org/
- **Node.js:** https://nodejs.org/
- **OpenAI API (si usas LLM):** https://platform.openai.com/docs/
- **Conversión a ODP (opcional):** `soffice --headless --convert-to odp file.pptx`

---

## Notas Finales

- Mantén el código limpio y modular: separa la lógica de generación de diapositivas de la CLI.
- Documenta el código con comentarios claros.
- Prueba la presentación generada en PowerPoint y LibreOffice para asegurar compatibilidad.
- Incluye manejo de errores (archivos no encontrados, permisos, etc.).
