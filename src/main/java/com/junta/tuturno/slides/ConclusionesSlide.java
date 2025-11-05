package com.junta.tuturno.slides;

import org.odftoolkit.odfdom.doc.OdfPresentationDocument;
import org.odftoolkit.odfdom.doc.presentation.OdfSlide;
import org.odftoolkit.odfdom.dom.element.draw.DrawFrameElement;
import org.odftoolkit.odfdom.dom.element.draw.DrawTextBoxElement;
import org.odftoolkit.odfdom.dom.element.text.TextPElement;

/**
 * Genera la diapositiva de conclusiones de la presentación
 */
public class ConclusionesSlide {
    
    public static void create(OdfPresentationDocument presentation) throws Exception {
        OdfSlide slide = presentation.newSlide(7, "Conclusiones", 
            OdfSlide.SlideLayout.TITLE_PLUS_TEXT);
        
        // Título
        DrawFrameElement titleFrame = (DrawFrameElement) slide.getOdfElement()
            .newDrawFrameElement();
        titleFrame.setSvgXAttribute("2cm");
        titleFrame.setSvgYAttribute("1.5cm");
        titleFrame.setSvgWidthAttribute("22cm");
        titleFrame.setSvgHeightAttribute("2cm");
        
        DrawTextBoxElement titleBox = titleFrame.newDrawTextBoxElement();
        TextPElement titleP = titleBox.newTextPElement();
        titleP.setTextContent("Conclusiones");
        titleP.setAttribute("style:font-size", "36pt");
        titleP.setAttribute("style:font-weight", "bold");
        titleP.setAttribute("style:color", "#004080");
        
        // Contenido
        DrawFrameElement contentFrame = (DrawFrameElement) slide.getOdfElement()
            .newDrawFrameElement();
        contentFrame.setSvgXAttribute("2cm");
        contentFrame.setSvgYAttribute("4.5cm");
        contentFrame.setSvgWidthAttribute("22cm");
        contentFrame.setSvgHeightAttribute("10cm");
        
        DrawTextBoxElement contentBox = contentFrame.newDrawTextBoxElement();
        
        // Conclusión 1
        TextPElement p1 = contentBox.newTextPElement();
        p1.setTextContent("✓ Tu Turno representa un avance significativo en la digitalización de la Administración Pública andaluza");
        p1.setAttribute("style:font-size", "20pt");
        p1.setAttribute("style:color", "#333333");
        
        addSpacer(contentBox);
        
        // Conclusión 2
        TextPElement p2 = contentBox.newTextPElement();
        p2.setTextContent("✓ Mejora sustancial en la experiencia ciudadana y optimización de recursos administrativos");
        p2.setAttribute("style:font-size", "20pt");
        p2.setAttribute("style:color", "#333333");
        
        addSpacer(contentBox);
        
        // Conclusión 3
        TextPElement p3 = contentBox.newTextPElement();
        p3.setTextContent("✓ Sistema escalable y adaptable a nuevos servicios y necesidades futuras");
        p3.setAttribute("style:font-size", "20pt");
        p3.setAttribute("style:color", "#333333");
        
        addSpacer(contentBox);
        addSpacer(contentBox);
        
        // Llamada a la acción
        DrawFrameElement ctaFrame = (DrawFrameElement) slide.getOdfElement()
            .newDrawFrameElement();
        ctaFrame.setSvgXAttribute("3cm");
        ctaFrame.setSvgYAttribute("15cm");
        ctaFrame.setSvgWidthAttribute("20cm");
        ctaFrame.setSvgHeightAttribute("3cm");
        
        DrawTextBoxElement ctaBox = ctaFrame.newDrawTextBoxElement();
        TextPElement ctaTitle = ctaBox.newTextPElement();
        ctaTitle.setTextContent("🚀 Próximos Pasos:");
        ctaTitle.setAttribute("style:font-size", "24pt");
        ctaTitle.setAttribute("style:font-weight", "bold");
        ctaTitle.setAttribute("style:color", "#006633");
        
        TextPElement ctaText = ctaBox.newTextPElement();
        ctaText.setTextContent("Expansión a más servicios • Integración con inteligencia artificial • App móvil mejorada");
        ctaText.setAttribute("style:font-size", "18pt");
        ctaText.setAttribute("style:color", "#555555");
        
        // Contacto
        DrawFrameElement contactFrame = (DrawFrameElement) slide.getOdfElement()
            .newDrawFrameElement();
        contactFrame.setSvgXAttribute("2cm");
        contactFrame.setSvgYAttribute("18cm");
        contactFrame.setSvgWidthAttribute("22cm");
        contactFrame.setSvgHeightAttribute("1.5cm");
        
        DrawTextBoxElement contactBox = contactFrame.newDrawTextBoxElement();
        TextPElement contactP = contactBox.newTextPElement();
        contactP.setTextContent("www.juntadeandalucia.es | Teléfono: 955 062 627");
        contactP.setAttribute("style:font-size", "16pt");
        contactP.setAttribute("style:color", "#666666");
        contactP.setAttribute("style:text-align", "center");
    }
    
    private static void addSpacer(DrawTextBoxElement box) {
        TextPElement spacer = box.newTextPElement();
        spacer.setTextContent(" ");
    }
}
