package com.junta.tuturno.slides;

import org.odftoolkit.odfdom.doc.OdfPresentationDocument;
import org.odftoolkit.odfdom.doc.presentation.OdfSlide;
import org.odftoolkit.odfdom.dom.element.draw.DrawFrameElement;
import org.odftoolkit.odfdom.dom.element.draw.DrawTextBoxElement;
import org.odftoolkit.odfdom.dom.element.text.TextPElement;
import org.odftoolkit.odfdom.dom.element.text.TextListElement;
import org.odftoolkit.odfdom.dom.element.text.TextListItemElement;

/**
 * Genera la diapositiva de índice de la presentación
 */
public class IndiceSlide {
    
    public static void create(OdfPresentationDocument presentation) throws Exception {
        OdfSlide slide = presentation.newSlide(1, "Índice", 
            OdfSlide.SlideLayout.TITLE_PLUS_TEXT);
        
        // Título
        DrawFrameElement titleFrame = slide.newDrawFrameElement();
        titleFrame.setSvgXAttribute("2cm");
        titleFrame.setSvgYAttribute("1.5cm");
        titleFrame.setSvgWidthAttribute("22cm");
        titleFrame.setSvgHeightAttribute("2cm");
        
        DrawTextBoxElement titleBox = titleFrame.newDrawTextBoxElement();
        TextPElement titleP = titleBox.newTextPElement();
        titleP.setTextContent("Índice de Contenidos");
        setTextStyle(titleP, "36pt", "bold", "#004080");
        
        // Contenido - Lista de secciones
        DrawFrameElement contentFrame = slide.newDrawFrameElement();
        contentFrame.setSvgXAttribute("3cm");
        contentFrame.setSvgYAttribute("4.5cm");
        contentFrame.setSvgWidthAttribute("20cm");
        contentFrame.setSvgHeightAttribute("12cm");
        
        DrawTextBoxElement contentBox = contentFrame.newDrawTextBoxElement();
        
        String[] items = {
            "1. Introducción al Sistema Tu Turno",
            "2. Características Principales",
            "3. Beneficios para Ciudadanos y Administración",
            "4. Proceso de Solicitud de Cita Previa",
            "5. Datos y Estadísticas de Uso",
            "6. Conclusiones y Futuras Mejoras"
        };
        
        for (String item : items) {
            TextPElement itemP = contentBox.newTextPElement();
            itemP.setTextContent("• " + item);
            setTextStyle(itemP, "24pt", "normal", "#333333");
            
            // Espaciado entre items
            TextPElement spacer = contentBox.newTextPElement();
            spacer.setTextContent(" ");
            setTextStyle(spacer, "12pt", "normal", "#333333");
        }
        
        slide.setBackgroundColor("#FFFFFF");
    }
    
    private static void setTextStyle(TextPElement element, String fontSize, 
                                     String fontWeight, String color) {
        element.setProperty(TextPElement.FontSizeAttribute, fontSize);
        element.setProperty(TextPElement.FontWeightAttribute, fontWeight);
        element.setProperty(TextPElement.ColorAttribute, color);
    }
}
