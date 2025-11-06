# Inicio Rápido - Generador de Presentaciones Tu Turno

## 🚀 Instalación y Ejecución Rápida

### 1. Instalar Python y dependencias del sistema

```bash
# Instalar Python 3 y venv (si no están instalados)
sudo apt install python3 python3-venv python3-pip

# Instalar LibreOffice Impress para visualizar las presentaciones
sudo apt install libreoffice-impress
```

### 2. Generar la presentación

```bash
# Ejecutar el script automatizado
./run.sh
```

El script automáticamente:
- ✅ Crea un entorno virtual Python
- ✅ Instala las dependencias necesarias (odfpy, Pillow, requests)
- ✅ Genera la presentación sobre "Tu Turno"
- ✅ Guarda el archivo en `output/presentacion-tuturno.odp`

### 3. Ver la presentación

```bash
# Abrir con LibreOffice
./open-presentation.sh

# O manualmente
libreoffice output/presentacion-tuturno.odp
```

---

## 📝 Contenido de la Presentación

La presentación generada incluye:

1. **Portada** - Título, subtítulo y datos de la Junta de Andalucía
2. **Índice** - Listado de los contenidos
3. **Introducción al sistema** - Qué es Tu Turno
4. **Características principales** - Funcionalidades clave
5. **Beneficios** - Para ciudadanos y administración
6. **Proceso de solicitud** - Pasos para pedir cita (línea de tiempo)
7. **Datos y estadísticas** - Cifras de uso del sistema
8. **Conclusiones** - Resumen y futuras mejoras

---

## 🔧 Ejecución Manual (sin script)

Si prefieres ejecutar paso a paso:

```bash
# 1. Crear entorno virtual
python3 -m venv venv
source venv/bin/activate

# 2. Instalar dependencias
pip install -r requirements.txt

# 3. Generar presentación
python3 src/main.py

# 4. Desactivar entorno virtual
deactivate
```

---

## 📂 Estructura del Proyecto

```
├── src/                           # Código fuente Python
│   ├── main.py                    # Script principal
│   ├── presentation_generator.py  # Generador de presentaciones
│   ├── content_generator.py       # Contenido sobre Tu Turno
│   └── slides/                    # Módulos por tipo de diapositiva
├── plantilla-presentacion.odp     # Plantilla ODP base
├── output/                        # Presentaciones generadas
├── requirements.txt               # Dependencias Python
├── run.sh                         # Script de ejecución automática
└── open-presentation.sh           # Script para abrir la presentación
```

---

## ❓ Solución de Problemas

### Error: "ModuleNotFoundError: No module named 'odf'"

```bash
pip3 install --break-system-packages odfpy Pillow requests
```

### Error: "python3-venv not available"

```bash
sudo apt install python3-venv
```

### LibreOffice no abre la presentación

```bash
# Verificar instalación
which libreoffice

# Instalar si es necesario
sudo apt install libreoffice-impress
```

---

## 🎨 Personalización

Para modificar el contenido de la presentación, edita:

- `src/content_generator.py` - Contenido de las diapositivas
- `plantilla-presentacion.odp` - Estilos y diseño

Luego vuelve a ejecutar `./run.sh` para regenerar la presentación.

---

## 📚 Más Información

Consulta los siguientes archivos para más detalles:

- `README.md` - Documentación completa
- `AGENTS.md` - Instrucciones para agentes de IA
