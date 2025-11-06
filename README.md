# Generador de Presentación LibreOffice - Tu Turno

Generador automático de presentaciones en formato ODP (LibreOffice) sobre el sistema **Tu Turno**, el sistema de gestión de cita previa de la Junta de Andalucía.

## 📋 Descripción

Este proyecto genera automáticamente una presentación profesional estructurada con:

- ✅ Diapositiva de portada
- ✅ Diapositiva de índice
- ✅ 5 diapositivas de contenido sobre Tu Turno:
  1. Introducción al sistema
  2. Características principales
  3. Beneficios para ciudadanos y administración
  4. Proceso de solicitud de cita previa
  5. Datos y estadísticas de uso
- ✅ Diapositiva de conclusiones y futuras mejoras

## 🚀 Requisitos Previos

### Software necesario:

1. **Python 3.8 o superior**
   ```bash
   python3 --version
   ```

2. **pip** (gestor de paquetes de Python)
   ```bash
   pip3 --version
   ```

3. **LibreOffice** (para visualizar la presentación generada)
   ```bash
   # En Ubuntu/Debian
   sudo apt install libreoffice-impress
   
   # En Fedora/RHEL
   sudo dnf install libreoffice-impress
   
   # En Arch Linux
   sudo pacman -S libreoffice-impress
   ```

## 📦 Instalación

### 1. Clonar o descargar el proyecto

```bash
cd /home/ssg/workspaces/git/curso-inap-iaprog-ejercicio-2
```

### 2. Crear entorno virtual (opcional pero recomendado)

```bash
python3 -m venv venv
source venv/bin/activate  # En Linux/Mac
# venv\Scripts\activate   # En Windows
```

### 3. Instalar python3-venv (si no está instalado)

```bash
sudo apt install python3-venv
```

### 4. Instalar dependencias

```bash
pip3 install -r requirements.txt
```

**Nota:** Si tienes problemas con `externally-managed-environment`, usa un entorno virtual (recomendado):

```bash
python3 -m venv venv
source venv/bin/activate
pip install -r requirements.txt
```

## 🎯 Ejecución

### Opción 1: Usando el script automatizado (recomendado)

```bash
./run.sh
```

Este script:
- Crea automáticamente un entorno virtual si no existe
- Instala las dependencias necesarias
- Ejecuta el generador de presentaciones

### Opción 2: Ejecución manual

```bash
python3 src/main.py
```

La presentación generada se guardará en el directorio `output/` con el nombre `presentacion-tuturno.odp`.

### Visualizar la presentación

#### Opción 1: Usando el script

```bash
./open-presentation.sh
```

#### Opción 2: Manualmente

```bash
libreoffice output/presentacion-tuturno.odp
```

## 📁 Estructura del Proyecto

```
├── README.md                      # Este archivo
├── AGENTS.md                      # Instrucciones para agentes IA
├── requirements.txt               # Dependencias Python
├── plantilla-presentacion.odp     # Plantilla ODP de referencia
├── src/                           # Código fuente Python
│   ├── main.py                    # Script principal CLI
│   ├── presentation_generator.py  # Lógica de generación de presentación
│   ├── content_generator.py       # Generación de contenido
│   └── slides/                    # Módulos por tipo de diapositiva
│       ├── __init__.py
│       ├── cover_slide.py         # Diapositiva de portada
│       ├── index_slide.py         # Diapositiva de índice
│       ├── content_slide.py       # Diapositivas de contenido
│       ├── timeline_slide.py      # Diapositiva de línea de tiempo
│       └── conclusion_slide.py    # Diapositiva de conclusiones
└── output/                        # Presentaciones generadas
```

## 🔧 Tecnologías Utilizadas

- **Python 3.8+** - Lenguaje de programación
- **odfpy** - Manipulación de archivos ODP (OpenDocument Presentation)
- **Pillow** - Procesamiento de imágenes (opcional)
- **requests** - Obtención de contenido web (opcional)

## 📝 Notas

- La plantilla `plantilla-presentacion.odp` contiene ejemplos de cada tipo de diapositiva
- El script genera automáticamente el contenido sobre el sistema "Tu Turno"
- Se puede personalizar el contenido modificando los archivos en `src/slides/`

## 🤝 Contribución

Este es un proyecto educativo del curso INAP de IA Programming.
```
