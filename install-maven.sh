#!/bin/bash

# Script de instalación rápida de Maven para el proyecto Tu Turno

echo "=============================================="
echo "Instalación de Maven - Proyecto Tu Turno"
echo "=============================================="
echo ""

# Detectar el sistema operativo
if [ -f /etc/os-release ]; then
    . /etc/os-release
    OS=$ID
else
    echo "❌ No se pudo detectar el sistema operativo"
    exit 1
fi

echo "Sistema operativo detectado: $OS"
echo ""

# Verificar si Maven ya está instalado
if command -v mvn &> /dev/null; then
    echo "✓ Maven ya está instalado:"
    mvn -version
    echo ""
    echo "¿Deseas reinstalar Maven? (s/n)"
    read -r respuesta
    if [ "$respuesta" != "s" ] && [ "$respuesta" != "S" ]; then
        echo "Saliendo..."
        exit 0
    fi
fi

# Instalar Maven según el sistema operativo
echo "→ Instalando Maven..."
echo ""

case $OS in
    ubuntu|debian)
        echo "Ejecutando: sudo apt update && sudo apt install -y maven"
        sudo apt update && sudo apt install -y maven
        ;;
    fedora|rhel|centos)
        echo "Ejecutando: sudo dnf install -y maven"
        sudo dnf install -y maven
        ;;
    arch|manjaro)
        echo "Ejecutando: sudo pacman -S --noconfirm maven"
        sudo pacman -S --noconfirm maven
        ;;
    *)
        echo "❌ Sistema operativo no soportado: $OS"
        echo ""
        echo "Por favor, instala Maven manualmente:"
        echo "https://maven.apache.org/install.html"
        exit 1
        ;;
esac

# Verificar instalación
echo ""
echo "=============================================="
echo "Verificando instalación..."
echo "=============================================="
echo ""

if command -v mvn &> /dev/null; then
    echo "✓ Maven instalado correctamente"
    echo ""
    mvn -version
    echo ""
    echo "=============================================="
    echo "✓ Instalación completada"
    echo "=============================================="
    echo ""
    echo "Ahora puedes compilar el proyecto:"
    echo "  $ mvn clean package"
    echo ""
    echo "Y ejecutarlo:"
    echo "  $ ./run.sh"
    echo ""
else
    echo "❌ Error: Maven no se instaló correctamente"
    echo "Por favor, instala Maven manualmente"
    exit 1
fi
