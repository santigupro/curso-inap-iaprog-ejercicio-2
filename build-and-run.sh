#!/bin/bash

# Script para compilar y ejecutar usando Maven Wrapper (sin necesidad de instalar Maven)
# Uso: ./build-and-run.sh

echo "=========================================="
echo "Generador de Presentación - Tu Turno"
echo "Compilando con Maven Wrapper..."
echo "=========================================="
echo ""

# Compilar el proyecto usando Maven Wrapper
./mvnw clean package

if [ $? -ne 0 ]; then
    echo ""
    echo "❌ Error al compilar el proyecto"
    exit 1
fi

echo ""
echo "=========================================="
echo "Compilación exitosa. Generando presentación..."
echo "=========================================="
echo ""

# Ejecutar el programa
java -jar target/tuturno-presentation-1.0.0-jar-with-dependencies.jar

# Verificar si se creó la presentación
if [ -f "output/TuTurno_Presentacion.odp" ]; then
    echo ""
    echo "¿Deseas abrir la presentación? (s/n)"
    read -r respuesta
    
    if [ "$respuesta" = "s" ] || [ "$respuesta" = "S" ]; then
        if command -v libreoffice &> /dev/null; then
            libreoffice --impress output/TuTurno_Presentacion.odp &
        else
            echo "⚠️  LibreOffice no está instalado"
            echo "Abre manualmente: output/TuTurno_Presentacion.odp"
        fi
    fi
fi
