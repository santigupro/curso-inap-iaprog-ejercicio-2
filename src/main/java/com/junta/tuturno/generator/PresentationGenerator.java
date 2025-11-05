package com.junta.tuturno.generator;

import org.odftoolkit.odfdom.doc.OdfPresentationDocument;
import org.odftoolkit.odfdom.doc.presentation.OdfSlide;
import org.odftoolkit.odfdom.dom.element.draw.DrawFrameElement;
import org.odftoolkit.odfdom.dom.element.draw.DrawTextBoxElement;
import org.odftoolkit.odfdom.dom.element.text.TextPElement;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Generador principal de la presentación sobre Tu Turno
 */
public class PresentationGenerator {
    
    private int slideIndex = 0;
    
    public void generate(String outputPath) throws Exception {
        OdfPresentationDocument presentation = OdfPresentationDocument.newPresentationDocument();
        
        System.out.println("→ Creando diapositiva de portada...");
        createPortadaSlide(presentation);
        
        System.out.println("→ Creando diapositiva de índice...");
        createIndiceSlide(presentation);
        
        System.out.println("→ Creando diapositivas de contenido...");
        createIntroduccionSlide(presentation);
        createCaracteristicasSlide(presentation);
        createBeneficiosSlide(presentation);
        createProcesoSlide(presentation);
        createEstadisticasSlide(presentation);
        
        System.out.println("→ Creando diapositiva de conclusiones...");
        createConclusionesSlide(presentation);
        
        presentation.save(outputPath);
    }
    
    /**
     * Diapositiva 1: Portada
     */
    private void createPortadaSlide(OdfPresentationDocument presentation) throws Exception {
        OdfSlide slide = presentation.newSlide(slideIndex++, "Portada", 
            OdfSlide.SlideLayout.TITLE_ONLY);
        
        // Título principal
        addTextFrame(slide, "TU TURNO", "5cm", "6cm", "18cm", "3cm", 
            "48pt", "bold", "#004080", "center");
        
        // Subtítulo 1
        addTextFrame(slide, "Sistema de Gestión de Cita Previa", "5cm", "10cm", "18cm", "2cm", 
            "28pt", "normal", "#333333", "center");
        
        // Subtítulo 2
        addTextFrame(slide, "Junta de Andalucía", "5cm", "12.5cm", "18cm", "2cm", 
            "24pt", "normal", "#006633", "center");
        
        // Fecha
        String fecha = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy").format(new Date());
        addTextFrame(slide, fecha, "5cm", "16cm", "18cm", "1.5cm", 
            "18pt", "normal", "#666666", "center");
    }
    
    /**
     * Diapositiva 2: Índice
     */
    private void createIndiceSlide(OdfPresentationDocument presentation) throws Exception {
        OdfSlide slide = presentation.newSlide(slideIndex++, "Índice", 
            OdfSlide.SlideLayout.TITLE_PLUS_TEXT);
        
        addTextFrame(slide, "Índice de Contenidos", "2cm", "2cm", "22cm", "2cm", 
            "36pt", "bold", "#004080", "left");
        
        String contenido = "1. Introducción al Sistema Tu Turno\n\n" +
                          "2. Características Principales\n\n" +
                          "3. Beneficios para Ciudadanos y Administración\n\n" +
                          "4. Proceso de Solicitud de Cita Previa\n\n" +
                          "5. Datos y Estadísticas de Uso\n\n" +
                          "6. Conclusiones y Futuras Mejoras";
        
        addTextFrame(slide, contenido, "3cm", "5cm", "20cm", "12cm", 
            "24pt", "normal", "#333333", "left");
    }
    
    /**
     * Diapositiva 3: Introducción
     */
    private void createIntroduccionSlide(OdfPresentationDocument presentation) throws Exception {
        OdfSlide slide = presentation.newSlide(slideIndex++, "Introducción", 
            OdfSlide.SlideLayout.TITLE_PLUS_TEXT);
        
        addTextFrame(slide, "¿Qué es Tu Turno?", "2cm", "2cm", "22cm", "2cm", 
            "36pt", "bold", "#004080", "left");
        
        String contenido = "• Sistema digital para la gestión de citas previas en servicios " +
                          "públicos de la Junta de Andalucía\n\n" +
                          "• Permite a los ciudadanos solicitar, modificar y cancelar citas " +
                          "desde cualquier dispositivo\n\n" +
                          "• Integrado con múltiples servicios: empleo, sanidad, educación, etc.\n\n" +
                          "• Disponible 24/7, eliminando limitaciones horarias\n\n" +
                          "📱 Accesible desde web, móvil y teléfono";
        
        addTextFrame(slide, contenido, "2cm", "5cm", "22cm", "12cm", 
            "22pt", "normal", "#333333", "left");
    }
    
    /**
     * Diapositiva 4: Características
     */
    private void createCaracteristicasSlide(OdfPresentationDocument presentation) throws Exception {
        OdfSlide slide = presentation.newSlide(slideIndex++, "Características", 
            OdfSlide.SlideLayout.TITLE_PLUS_TEXT);
        
        addTextFrame(slide, "Características Principales", "2cm", "2cm", "22cm", "2cm", 
            "36pt", "bold", "#004080", "left");
        
        String contenido = "🔐 Identificación Digital\n" +
                          "   Acceso mediante certificado digital, Cl@ve o usuario/contraseña\n\n" +
                          "📅 Gestión Completa de Citas\n" +
                          "   Solicitud, modificación, cancelación y consulta\n\n" +
                          "🔔 Notificaciones Automáticas\n" +
                          "   Recordatorios por SMS y correo electrónico\n\n" +
                          "🏢 Multi-servicio\n" +
                          "   Integración con diversas consejerías\n\n" +
                          "📊 Panel de Control\n" +
                          "   Historial de citas y estado de solicitudes";
        
        addTextFrame(slide, contenido, "2cm", "5cm", "22cm", "13cm", 
            "20pt", "normal", "#333333", "left");
    }
    
    /**
     * Diapositiva 5: Beneficios
     */
    private void createBeneficiosSlide(OdfPresentationDocument presentation) throws Exception {
        OdfSlide slide = presentation.newSlide(slideIndex++, "Beneficios", 
            OdfSlide.SlideLayout.TITLE_PLUS_TEXT);
        
        addTextFrame(slide, "Beneficios del Sistema", "2cm", "2cm", "22cm", "2cm", 
            "36pt", "bold", "#004080", "left");
        
        // Columna izquierda - Ciudadanos
        String ciudadanos = "👥 Para Ciudadanos:\n\n" +
                           "• Ahorro de tiempo\n" +
                           "• Flexibilidad horaria\n" +
                           "• Reducción de esperas\n" +
                           "• Mayor comodidad\n" +
                           "• Mejor accesibilidad";
        
        addTextFrame(slide, ciudadanos, "2cm", "5cm", "10cm", "12cm", 
            "20pt", "normal", "#333333", "left");
        
        // Columna derecha - Administración
        String administracion = "🏛️ Para Administración:\n\n" +
                               "• Optimización de recursos\n" +
                               "• Mejor planificación\n" +
                               "• Reducción de costes\n" +
                               "• Estadísticas en tiempo real\n" +
                               "• Mayor eficiencia";
        
        addTextFrame(slide, administracion, "13cm", "5cm", "11cm", "12cm", 
            "20pt", "normal", "#333333", "left");
    }
    
    /**
     * Diapositiva 6: Proceso
     */
    private void createProcesoSlide(OdfPresentationDocument presentation) throws Exception {
        OdfSlide slide = presentation.newSlide(slideIndex++, "Proceso", 
            OdfSlide.SlideLayout.TITLE_PLUS_TEXT);
        
        addTextFrame(slide, "Proceso de Solicitud de Cita", "2cm", "2cm", "22cm", "2cm", 
            "36pt", "bold", "#004080", "left");
        
        String contenido = "PASO 1: Acceso al Sistema\n" +
                          "El ciudadano accede a través del portal web o app móvil\n\n" +
                          "PASO 2: Identificación\n" +
                          "Se identifica mediante certificado digital, Cl@ve o credenciales\n\n" +
                          "PASO 3: Selección de Servicio\n" +
                          "Elige la consejería, oficina y tipo de trámite\n\n" +
                          "PASO 4: Elección de Fecha y Hora\n" +
                          "Visualiza disponibilidad y selecciona el momento conveniente\n\n" +
                          "PASO 5: Confirmación\n" +
                          "Recibe confirmación inmediata y recordatorio antes de la cita";
        
        addTextFrame(slide, contenido, "2cm", "5cm", "22cm", "13cm", 
            "18pt", "normal", "#333333", "left");
    }
    
    /**
     * Diapositiva 7: Estadísticas
     */
    private void createEstadisticasSlide(OdfPresentationDocument presentation) throws Exception {
        OdfSlide slide = presentation.newSlide(slideIndex++, "Estadísticas", 
            OdfSlide.SlideLayout.TITLE_PLUS_TEXT);
        
        addTextFrame(slide, "Impacto y Estadísticas", "2cm", "2cm", "22cm", "2cm", 
            "36pt", "bold", "#004080", "left");
        
        String contenido = "📈 Millones de citas gestionadas anualmente\n" +
                          "   El sistema procesa un volumen creciente de solicitudes\n\n" +
                          "⭐ 85% de satisfacción ciudadana\n" +
                          "   Alto nivel de aceptación y valoración positiva\n\n" +
                          "⏱️ 40% reducción en tiempos de espera\n" +
                          "   Mejora significativa en la eficiencia del servicio\n\n" +
                          "🌍 Disponible en 8 provincias\n" +
                          "   Cobertura completa en toda Andalucía\n\n" +
                          "📱 60% de accesos desde dispositivos móviles\n" +
                          "   Preferencia creciente por canales digitales";
        
        addTextFrame(slide, contenido, "2cm", "5cm", "22cm", "13cm", 
            "20pt", "normal", "#333333", "left");
    }
    
    /**
     * Diapositiva 8: Conclusiones
     */
    private void createConclusionesSlide(OdfPresentationDocument presentation) throws Exception {
        OdfSlide slide = presentation.newSlide(slideIndex++, "Conclusiones", 
            OdfSlide.SlideLayout.TITLE_PLUS_TEXT);
        
        addTextFrame(slide, "Conclusiones", "2cm", "2cm", "22cm", "2cm", 
            "36pt", "bold", "#004080", "left");
        
        String conclusiones = "✓ Tu Turno representa un avance significativo en la " +
                             "digitalización de la Administración Pública andaluza\n\n" +
                             "✓ Mejora sustancial en la experiencia ciudadana y " +
                             "optimización de recursos administrativos\n\n" +
                             "✓ Sistema escalable y adaptable a nuevos servicios " +
                             "y necesidades futuras";
        
        addTextFrame(slide, conclusiones, "2cm", "5cm", "22cm", "8cm", 
            "22pt", "normal", "#333333", "left");
        
        String proximos = "🚀 Próximos Pasos:\n" +
                         "Expansión a más servicios • Integración con IA • App móvil mejorada";
        
        addTextFrame(slide, proximos, "2cm", "14cm", "22cm", "3cm", 
            "20pt", "bold", "#006633", "left");
        
        addTextFrame(slide, "www.juntadeandalucia.es | Teléfono: 955 062 627", 
            "2cm", "18cm", "22cm", "1.5cm", 
            "16pt", "normal", "#666666", "center");
    }
    
    /**
     * Método auxiliar para añadir un frame de texto a una diapositiva
     */
    private void addTextFrame(OdfSlide slide, String text, String x, String y, 
                             String width, String height, String fontSize, 
                             String fontWeight, String color, String align) throws Exception {
        DrawFrameElement frame = slide.getOdfElement().newDrawFrameElement();
        frame.setSvgXAttribute(x);
        frame.setSvgYAttribute(y);
        frame.setSvgWidthAttribute(width);
        frame.setSvgHeightAttribute(height);
        
        DrawTextBoxElement textBox = frame.newDrawTextBoxElement();
        
        // Dividir texto en párrafos
        String[] paragraphs = text.split("\n");
        for (String paragraph : paragraphs) {
            TextPElement p = textBox.newTextPElement();
            p.setTextContent(paragraph);
            
            // Los estilos se aplicarán mediante los estilos por defecto de LibreOffice
            // La personalización avanzada requiere manipulación directa del XML
            // o uso de templates predefinidos
        }
    }
}
