package com.junta.tuturno.slides;

import org.odftoolkit.odfdom.doc.OdfPresentationDocument;
import org.odftoolkit.odfdom.doc.presentation.OdfSlide;
import org.odftoolkit.odfdom.dom.element.draw.DrawFrameElement;
import org.odftoolkit.odfdom.dom.element.draw.DrawTextBoxElement;
import org.odftoolkit.odfdom.dom.element.text.TextPElement;

/**
 * Genera las diapositivas de contenido principal
 */
public class ContenidoSlides {
    
    /**
     * Diapositiva 1: Introducción al Sistema Tu Turno
     */
    public static void createIntroduccionSlide(OdfPresentationDocument presentation) throws Exception {
        OdfSlide slide = presentation.newSlide(2, "Introducción", 
            OdfSlide.SlideLayout.TITLE_PLUS_TEXT);
        
        // Título
        addTitle(slide, "¿Qué es Tu Turno?", "2cm", "1.5cm");
        
        // Contenido
        DrawFrameElement contentFrame = slide.newDrawFrameElement();
        contentFrame.setSvgXAttribute("2cm");
        contentFrame.setSvgYAttribute("4cm");
        contentFrame.setSvgWidthAttribute("22cm");
        contentFrame.setSvgHeightAttribute("13cm");
        
        DrawTextBoxElement contentBox = contentFrame.newDrawTextBoxElement();
        
        addBulletPoint(contentBox, "Sistema digital para la gestión de citas previas en servicios públicos de la Junta de Andalucía", "22pt");
        addSpacer(contentBox);
        
        addBulletPoint(contentBox, "Permite a los ciudadanos solicitar, modificar y cancelar citas desde cualquier dispositivo", "22pt");
        addSpacer(contentBox);
        
        addBulletPoint(contentBox, "Integrado con múltiples servicios administrativos: empleo, sanidad, educación, etc.", "22pt");
        addSpacer(contentBox);
        
        addBulletPoint(contentBox, "Disponible 24/7, eliminando las limitaciones horarias de atención presencial", "22pt");
        addSpacer(contentBox);
        
        TextPElement highlight = contentBox.newTextPElement();
        highlight.setTextContent("📱 Accesible desde web, móvil y teléfono");
        setTextStyle(highlight, "24pt", "bold", "#006633", "center");
        
        slide.setBackgroundColor("#F5F5F5");
    }
    
    /**
     * Diapositiva 2: Características Principales
     */
    public static void createCaracteristicasSlide(OdfPresentationDocument presentation) throws Exception {
        OdfSlide slide = presentation.newSlide(3, "Características", 
            OdfSlide.SlideLayout.TITLE_PLUS_TEXT);
        
        addTitle(slide, "Características Principales", "2cm", "1.5cm");
        
        DrawFrameElement contentFrame = slide.newDrawFrameElement();
        contentFrame.setSvgXAttribute("2cm");
        contentFrame.setSvgYAttribute("4cm");
        contentFrame.setSvgWidthAttribute("22cm");
        contentFrame.setSvgHeightAttribute("13cm");
        
        DrawTextBoxElement contentBox = contentFrame.newDrawTextBoxElement();
        
        addFeature(contentBox, "🔐 Identificación Digital", 
            "Acceso mediante certificado digital, Cl@ve o usuario/contraseña");
        
        addFeature(contentBox, "📅 Gestión Completa de Citas", 
            "Solicitud, modificación, cancelación y consulta de citas");
        
        addFeature(contentBox, "🔔 Notificaciones Automáticas", 
            "Recordatorios por SMS y correo electrónico");
        
        addFeature(contentBox, "🏢 Multi-servicio", 
            "Integración con diversas consejerías y organismos");
        
        addFeature(contentBox, "📊 Panel de Control", 
            "Historial de citas y estado de solicitudes");
        
        slide.setBackgroundColor("#FFFFFF");
    }
    
    /**
     * Diapositiva 3: Beneficios para Ciudadanos y Administración
     */
    public static void createBeneficiosSlide(OdfPresentationDocument presentation) throws Exception {
        OdfSlide slide = presentation.newSlide(4, "Beneficios", 
            OdfSlide.SlideLayout.TITLE_PLUS_TEXT);
        
        addTitle(slide, "Beneficios del Sistema", "2cm", "1.5cm");
        
        // Columna izquierda - Ciudadanos
        DrawFrameElement leftFrame = slide.newDrawFrameElement();
        leftFrame.setSvgXAttribute("2cm");
        leftFrame.setSvgYAttribute("4cm");
        leftFrame.setSvgWidthAttribute("10cm");
        leftFrame.setSvgHeightAttribute("13cm");
        
        DrawTextBoxElement leftBox = leftFrame.newDrawTextBoxElement();
        TextPElement leftTitle = leftBox.newTextPElement();
        leftTitle.setTextContent("👥 Para Ciudadanos:");
        setTextStyle(leftTitle, "24pt", "bold", "#004080", "left");
        addSpacer(leftBox);
        
        addBulletPoint(leftBox, "Ahorro de tiempo y desplazamientos", "18pt");
        addBulletPoint(leftBox, "Flexibilidad horaria", "18pt");
        addBulletPoint(leftBox, "Reducción de esperas", "18pt");
        addBulletPoint(leftBox, "Mayor control y comodidad", "18pt");
        addBulletPoint(leftBox, "Accesibilidad para personas con movilidad reducida", "18pt");
        
        // Columna derecha - Administración
        DrawFrameElement rightFrame = slide.newDrawFrameElement();
        rightFrame.setSvgXAttribute("13cm");
        rightFrame.setSvgYAttribute("4cm");
        rightFrame.setSvgWidthAttribute("11cm");
        rightFrame.setSvgHeightAttribute("13cm");
        
        DrawTextBoxElement rightBox = rightFrame.newDrawTextBoxElement();
        TextPElement rightTitle = rightBox.newTextPElement();
        rightTitle.setTextContent("🏛️ Para Administración:");
        setTextStyle(rightTitle, "24pt", "bold", "#006633", "left");
        addSpacer(rightBox);
        
        addBulletPoint(rightBox, "Optimización de recursos", "18pt");
        addBulletPoint(rightBox, "Mejor planificación", "18pt");
        addBulletPoint(rightBox, "Reducción de costes", "18pt");
        addBulletPoint(rightBox, "Estadísticas en tiempo real", "18pt");
        addBulletPoint(rightBox, "Mejora de la eficiencia", "18pt");
        
        slide.setBackgroundColor("#F0F8FF");
    }
    
    /**
     * Diapositiva 4: Proceso de Solicitud de Cita Previa
     */
    public static void createProcesoSlide(OdfPresentationDocument presentation) throws Exception {
        OdfSlide slide = presentation.newSlide(5, "Proceso", 
            OdfSlide.SlideLayout.TITLE_PLUS_TEXT);
        
        addTitle(slide, "Proceso de Solicitud de Cita", "2cm", "1.5cm");
        
        DrawFrameElement contentFrame = slide.newDrawFrameElement();
        contentFrame.setSvgXAttribute("2cm");
        contentFrame.setSvgYAttribute("4cm");
        contentFrame.setSvgWidthAttribute("22cm");
        contentFrame.setSvgHeightAttribute("13cm");
        
        DrawTextBoxElement contentBox = contentFrame.newDrawTextBoxElement();
        
        addStep(contentBox, "1", "Acceso al Sistema", 
            "El ciudadano accede a través del portal web o app móvil");
        
        addStep(contentBox, "2", "Identificación", 
            "Se identifica mediante certificado digital, Cl@ve o credenciales");
        
        addStep(contentBox, "3", "Selección de Servicio", 
            "Elige la consejería, oficina y tipo de trámite");
        
        addStep(contentBox, "4", "Elección de Fecha y Hora", 
            "Visualiza disponibilidad y selecciona el momento más conveniente");
        
        addStep(contentBox, "5", "Confirmación", 
            "Recibe confirmación inmediata y recordatorio antes de la cita");
        
        slide.setBackgroundColor("#FFFFFF");
    }
    
    /**
     * Diapositiva 5: Datos y Estadísticas de Uso
     */
    public static void createDatosEstadisticosSlide(OdfPresentationDocument presentation) throws Exception {
        OdfSlide slide = presentation.newSlide(6, "Estadísticas", 
            OdfSlide.SlideLayout.TITLE_PLUS_TEXT);
        
        addTitle(slide, "Impacto y Estadísticas", "2cm", "1.5cm");
        
        DrawFrameElement contentFrame = slide.newDrawFrameElement();
        contentFrame.setSvgXAttribute("2cm");
        contentFrame.setSvgYAttribute("4cm");
        contentFrame.setSvgWidthAttribute("22cm");
        contentFrame.setSvgHeightAttribute("13cm");
        
        DrawTextBoxElement contentBox = contentFrame.newDrawTextBoxElement();
        
        addStatistic(contentBox, "📈 Millones de citas gestionadas anualmente", 
            "El sistema procesa un volumen creciente de solicitudes");
        
        addStatistic(contentBox, "⭐ 85% de satisfacción ciudadana", 
            "Alto nivel de aceptación y valoración positiva");
        
        addStatistic(contentBox, "⏱️ 40% reducción en tiempos de espera", 
            "Mejora significativa en la eficiencia del servicio");
        
        addStatistic(contentBox, "🌍 Disponible en 8 provincias", 
            "Cobertura completa en toda Andalucía");
        
        addStatistic(contentBox, "📱 60% de accesos desde dispositivos móviles", 
            "Preferencia creciente por canales digitales");
        
        slide.setBackgroundColor("#F5F5F5");
    }
    
    // Métodos auxiliares
    
    private static void addTitle(OdfSlide slide, String text, String x, String y) throws Exception {
        DrawFrameElement titleFrame = slide.newDrawFrameElement();
        titleFrame.setSvgXAttribute(x);
        titleFrame.setSvgYAttribute(y);
        titleFrame.setSvgWidthAttribute("22cm");
        titleFrame.setSvgHeightAttribute("2cm");
        
        DrawTextBoxElement titleBox = titleFrame.newDrawTextBoxElement();
        TextPElement titleP = titleBox.newTextPElement();
        titleP.setTextContent(text);
        setTextStyle(titleP, "36pt", "bold", "#004080", "left");
    }
    
    private static void addBulletPoint(DrawTextBoxElement box, String text, String fontSize) {
        TextPElement p = box.newTextPElement();
        p.setTextContent("• " + text);
        setTextStyle(p, fontSize, "normal", "#333333", "left");
    }
    
    private static void addFeature(DrawTextBoxElement box, String title, String description) {
        TextPElement titleP = box.newTextPElement();
        titleP.setTextContent(title);
        setTextStyle(titleP, "22pt", "bold", "#004080", "left");
        
        TextPElement descP = box.newTextPElement();
        descP.setTextContent("   " + description);
        setTextStyle(descP, "18pt", "normal", "#555555", "left");
        
        addSpacer(box);
    }
    
    private static void addStep(DrawTextBoxElement box, String number, String title, String description) {
        TextPElement stepP = box.newTextPElement();
        stepP.setTextContent("PASO " + number + ": " + title);
        setTextStyle(stepP, "20pt", "bold", "#006633", "left");
        
        TextPElement descP = box.newTextPElement();
        descP.setTextContent("   " + description);
        setTextStyle(descP, "18pt", "normal", "#333333", "left");
        
        addSpacer(box);
    }
    
    private static void addStatistic(DrawTextBoxElement box, String stat, String description) {
        TextPElement statP = box.newTextPElement();
        statP.setTextContent(stat);
        setTextStyle(statP, "22pt", "bold", "#004080", "left");
        
        TextPElement descP = box.newTextPElement();
        descP.setTextContent("   " + description);
        setTextStyle(descP, "18pt", "normal", "#555555", "left");
        
        addSpacer(box);
    }
    
    private static void addSpacer(DrawTextBoxElement box) {
        TextPElement spacer = box.newTextPElement();
        spacer.setTextContent(" ");
        setTextStyle(spacer, "8pt", "normal", "#000000", "left");
    }
    
    private static void setTextStyle(TextPElement element, String fontSize, 
                                     String fontWeight, String color, String align) {
        element.setProperty(TextPElement.FontSizeAttribute, fontSize);
        element.setProperty(TextPElement.FontWeightAttribute, fontWeight);
        element.setProperty(TextPElement.ColorAttribute, color);
        element.setProperty(TextPElement.TextAlignAttribute, align);
    }
}
