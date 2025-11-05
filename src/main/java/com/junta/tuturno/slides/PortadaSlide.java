package com.junta.tuturno.slides;

import org.odftoolkit.odfdom.doc.OdfPresentationDocument;
import org.odftoolkit.odfdom.doc.presentation.OdfSlide;
import org.odftoolkit.odfdom.dom.element.draw.DrawFrameElement;
import org.odftoolkit.odfdom.dom.element.draw.DrawTextBoxElement;
import org.odftoolkit.odfdom.dom.element.text.TextPElement;
import org.w3c.dom.Node;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Genera la diapositiva de portada de la presentación
 */
public class PortadaSlide {
    
    public static void create(OdfPresentationDocument presentation) throws Exception {
        OdfSlide slide = presentation.newSlide(0, "Portada", 
            OdfSlide.SlideLayout.TITLE_ONLY);
        
        // Frame para el título principal
        DrawFrameElement titleFrame = slide.newDrawFrameElement();
        titleFrame.setSvgXAttribute("2cm");
        titleFrame.setSvgYAttribute("3cm");
        titleFrame.setSvgWidthAttribute("22cm");
        titleFrame.setSvgHeightAttribute("4cm");
        
        DrawTextBoxElement titleBox = titleFrame.newDrawTextBoxElement();
        TextPElement titleP = titleBox.newTextPElement();
        titleP.setTextContent("TU TURNO");
        titleP.setStyleName("Title");
        setTextStyle(titleP, "48pt", "bold", "#004080", "center");
        
        // Frame para el subtítulo
        DrawFrameElement subtitleFrame = slide.newDrawFrameElement();
        subtitleFrame.setSvgXAttribute("2cm");
        subtitleFrame.setSvgYAttribute("8cm");
        subtitleFrame.setSvgWidthAttribute("22cm");
        subtitleFrame.setSvgHeightAttribute("3cm");
        
        DrawTextBoxElement subtitleBox = subtitleFrame.newDrawTextBoxElement();
        TextPElement subtitleP1 = subtitleBox.newTextPElement();
        subtitleP1.setTextContent("Sistema de Gestión de Cita Previa");
        setTextStyle(subtitleP1, "32pt", "normal", "#333333", "center");
        
        TextPElement subtitleP2 = subtitleBox.newTextPElement();
        subtitleP2.setTextContent("Junta de Andalucía");
        setTextStyle(subtitleP2, "28pt", "normal", "#006633", "center");
        
        // Frame para la fecha
        DrawFrameElement dateFrame = slide.newDrawFrameElement();
        dateFrame.setSvgXAttribute("2cm");
        dateFrame.setSvgYAttribute("16cm");
        dateFrame.setSvgWidthAttribute("22cm");
        dateFrame.setSvgHeightAttribute("2cm");
        
        DrawTextBoxElement dateBox = dateFrame.newDrawTextBoxElement();
        TextPElement dateP = dateBox.newTextPElement();
        String currentDate = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy").format(new Date());
        dateP.setTextContent(currentDate);
        setTextStyle(dateP, "18pt", "normal", "#666666", "center");
        
        // Fondo de color suave
        slide.setBackgroundColor("#F0F8FF");
    }
    
    private static void setTextStyle(TextPElement element, String fontSize, 
                                     String fontWeight, String color, String align) {
        element.setProperty(TextPElement.FontSizeAttribute, fontSize);
        element.setProperty(TextPElement.FontWeightAttribute, fontWeight);
        element.setProperty(TextPElement.ColorAttribute, color);
        element.setProperty(TextPElement.TextAlignAttribute, align);
    }
}
