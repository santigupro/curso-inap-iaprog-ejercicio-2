#!/bin/bash

# Script para abrir la presentación generada

PRESENTATION="output/presentacion-tuturno.odp"

if [ ! -f "$PRESENTATION" ]; then
    echo "❌ Error: La presentación no existe"
    echo "   Primero ejecuta: ./run.sh"
    exit 1
fi

echo "📂 Abriendo presentación..."

if command -v libreoffice &> /dev/null; then
    libreoffice "$PRESENTATION" &
    echo "✓ Presentación abierta en LibreOffice"
elif command -v soffice &> /dev/null; then
    soffice "$PRESENTATION" &
    echo "✓ Presentación abierta en LibreOffice"
else
    echo "⚠️  LibreOffice no encontrado"
    echo "   Instálalo con: sudo apt install libreoffice-impress"
    echo "   O abre manualmente: $PRESENTATION"
    exit 1
fi
