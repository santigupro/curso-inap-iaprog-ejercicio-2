#!/bin/bash

# Script para ejecutar el generador de presentaciones Tu Turno

echo "=========================================="
echo "  Generador de Presentaciones - Tu Turno"
echo "=========================================="
echo ""

# Verificar Python
if ! command -v python3 &> /dev/null; then
    echo "❌ Error: Python 3 no está instalado"
    echo "   Instálalo con: sudo apt install python3 python3-pip"
    exit 1
fi

echo "✓ Python 3 encontrado: $(python3 --version)"

# Verificar si existe el entorno virtual
if [ ! -d "venv" ] || [ ! -f "venv/bin/activate" ]; then
    echo ""
    echo "📦 Creando entorno virtual..."
    
    # Intentar crear el entorno virtual
    if ! python3 -m venv venv 2>/dev/null; then
        echo "⚠️  Necesitas instalar python3-venv"
        echo "   Ejecuta: sudo apt install python3-venv"
        echo ""
        echo "Mientras tanto, instalando dependencias sin entorno virtual..."
        pip3 install --user -r requirements.txt
        echo ""
        echo "=========================================="
        python3 src/main.py
        exit 0
    fi
    
    echo "✓ Entorno virtual creado"
fi

# Activar entorno virtual si existe
if [ -f "venv/bin/activate" ]; then
    echo ""
    echo "🔧 Activando entorno virtual..."
    source venv/bin/activate
    
    # Instalar dependencias
    echo ""
    echo "📥 Instalando dependencias..."
    pip install --upgrade pip -q
    pip install -r requirements.txt -q
    
    echo "✓ Dependencias instaladas"
    
    # Ejecutar el generador
    echo ""
    echo "=========================================="
    python3 src/main.py
    
    # Desactivar entorno virtual
    deactivate
else
    # Sin entorno virtual
    echo ""
    echo "📥 Instalando dependencias con pip3..."
    pip3 install --user -r requirements.txt
    
    echo ""
    echo "=========================================="
    python3 src/main.py
fi

echo ""
echo "✓ Proceso completado"
