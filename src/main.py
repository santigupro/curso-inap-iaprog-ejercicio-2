#!/usr/bin/env python3
"""
Script principal para generar presentaciones ODP sobre Tu Turno.
"""

import os
import sys
from pathlib import Path

# Añadir el directorio src al path
sys.path.insert(0, str(Path(__file__).parent))

from presentation_generator import PresentationGenerator


def main():
    """
    Función principal del generador de presentaciones.
    """
    print("=" * 60)
    print("  GENERADOR DE PRESENTACIONES - TU TURNO")
    print("  Junta de Andalucía")
    print("=" * 60)
    
    # Rutas de archivos
    project_root = Path(__file__).parent.parent
    template_path = project_root / "plantilla-presentacion.odp"
    output_dir = project_root / "output"
    output_path = output_dir / "presentacion-tuturno.odp"
    
    # Verificar que existe la plantilla
    if not template_path.exists():
        print(f"\n❌ Error: No se encuentra la plantilla en {template_path}")
        print("   Por favor, asegúrate de que el archivo 'plantilla-presentacion.odp' existe.")
        sys.exit(1)
    
    try:
        # Crear generador
        generator = PresentationGenerator(str(template_path))
        
        # Generar presentación
        generator.create_presentation(str(output_path))
        
        print("\n" + "=" * 60)
        print("🎉 ¡Presentación generada exitosamente!")
        print(f"📂 Ubicación: {output_path}")
        print("\n💡 Para abrir la presentación:")
        print(f"   libreoffice {output_path}")
        print("=" * 60)
        
    except Exception as e:
        print(f"\n❌ Error al generar la presentación: {str(e)}")
        import traceback
        traceback.print_exc()
        sys.exit(1)


if __name__ == "__main__":
    main()
