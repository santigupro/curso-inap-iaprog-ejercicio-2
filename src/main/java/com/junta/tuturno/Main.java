package com.junta.tuturno;

import com.junta.tuturno.generator.PresentationGenerator;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase principal que genera la presentación sobre el sistema Tu Turno
 * de la Junta de Andalucía.
 */
public class Main {
    
    private static final String OUTPUT_DIR = "output";
    private static final String OUTPUT_FILENAME = "TuTurno_Presentacion.odp";
    
    public static void main(String[] args) {
        try {
            System.out.println("===========================================");
            System.out.println("Generador de Presentación - Tu Turno");
            System.out.println("Sistema de Gestión de Cita Previa");
            System.out.println("Junta de Andalucía");
            System.out.println("===========================================\n");
            
            // Crear directorio de salida si no existe
            File outputDir = new File(OUTPUT_DIR);
            if (!outputDir.exists()) {
                outputDir.mkdirs();
                System.out.println("✓ Directorio de salida creado: " + OUTPUT_DIR);
            }
            
            // Crear documento de presentación
            System.out.println("✓ Iniciando generación de presentación...\n");
            
            String outputPath = OUTPUT_DIR + File.separator + OUTPUT_FILENAME;
            PresentationGenerator generator = new PresentationGenerator();
            generator.generate(outputPath);
            
            System.out.println("\n===========================================");
            System.out.println("✓ Presentación generada exitosamente");
            System.out.println("===========================================");
            System.out.println("📄 Archivo: " + outputPath);
            System.out.println("📅 Fecha: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
            System.out.println("\nPuede abrir el archivo con LibreOffice Impress:");
            System.out.println("  $ libreoffice --impress " + outputPath);
            System.out.println("===========================================\n");
            
        } catch (Exception e) {
            System.err.println("\n✗ Error al generar la presentación:");
            System.err.println("  " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
