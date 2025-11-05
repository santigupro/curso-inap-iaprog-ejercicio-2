#!/bin/bash

# Script para ejecutar el generador de presentaciones Tu Turno
# Uso: ./run.sh

echo "=========================================="
echo "Generador de Presentación - Tu Turno"
echo "=========================================="
echo ""

# Verificar que existe el JAR
if [ ! -f "target/tuturno-presentation-1.0.0-jar-with-dependencies.jar" ]; then
    echo "❌ Error: No se encuentra el archivo JAR"
    echo ""
    echo "Compilando el proyecto con Maven Wrapper..."
    echo ""
    ./mvnw clean package
    
    if [ $? -ne 0 ]; then
        echo ""
        echo "❌ Error al compilar el proyecto"
        exit 1
    fi
fi

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
