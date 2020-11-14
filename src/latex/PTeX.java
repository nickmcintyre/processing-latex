package latex;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import javax.swing.JLabel;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import processing.core.PShapeSVG;
import processing.data.XML;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGeneratorContext;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.svggen.SVGGraphics2DIOException;
import org.scilab.forge.jlatexmath.DefaultTeXFont;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;
import org.scilab.forge.jlatexmath.cyrillic.CyrillicRegistration;
import org.scilab.forge.jlatexmath.greek.GreekRegistration;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;


/**
 * ##library.name##
 * ##library.sentence##
 * ##library.url##
 *
 * 
 * @author      ##author##
 * @modified    ##date##
 * @version     ##library.prettyVersion## (##library.version##)
 *
 * @example ColorExample
 * @example PShapeExample
 * @example XMLExample
 */
public class PTeX {
	
	private static final Color CLEAR = new Color(255, 255, 255, 0);
	private static final Color BLACK = new Color(0, 0, 0);
	
	/**
	 * Convert a LaTeX string to a PShape object.
	 * 
	 * @param  latex
	 * @return rendered formula
	 */
    public static PShapeSVG toPShape(String latex) {
    	return toPShape(latex, 20, CLEAR.getRGB(), BLACK.getRGB());
    }

	/**
	 * Convert a LaTeX string to a PShape object.
	 * 
	 * @param  latex
	 * @param  textSize
	 * @return rendered formula
	 */
    public static PShapeSVG toPShape(String latex, int textSize) {
    	return toPShape(latex, textSize, CLEAR.getRGB(), BLACK.getRGB());
    }
    
    /**
	 * Convert a LaTeX string to a PShape object.
	 * 
	 * @param  latex
	 * @param  textSize
	 * @param  backgroundColor
	 * @return rendered formula
	 */
    public static PShapeSVG toPShape(String latex, int textSize, int backgroundColor) {
    	return toPShape(latex, textSize, backgroundColor, BLACK.getRGB());
    }
    
    /**
     * Convert a LaTeX string to a PShape object.
     * 
     * @param  latex
     * @param  textSize
     * @param  backgroundColor
     * @param  textColor
     * @return rendered formula
     */
    public static PShapeSVG toPShape(String latex, int textSize, int backgroundColor, int textColor) {
        XML xmlOutput  = toXML(latex, textSize, backgroundColor, textColor);
        PShapeSVG output = new PShapeSVG(xmlOutput);
    	
    	return output;
    }
    
    /**
     * Convert a LaTeX string to an XML object.
     * 
     * @param  latex
     * @return rendered formula
     */
    public static XML toXML(String latex) {
    	return toXML(latex, 20, CLEAR.getRGB(), BLACK.getRGB());
    }
    
    /**
     * Convert a LaTeX string to an XML object.
     * 
     * @param  latex
     * @param  textSize
     * @return rendered formula
     */
    public static XML toXML(String latex, int textSize) {
    	return toXML(latex, textSize, CLEAR.getRGB(), BLACK.getRGB());
    }
    
    /**
     * Convert a LaTeX string to an XML object.
     * 
     * @param  latex
     * @param  textSize
     * @param  backgroundColor
     * @return rendered formula
     */
    public static XML toXML(String latex, int textSize, int backgroundColor) {
    	return toXML(latex, textSize, backgroundColor, BLACK.getRGB());
    }
    
    /**
     * Convert a LaTeX string to an XML object.
     * 
     * @param  latex
     * @param  textSize
     * @param  backgroundColor
     * @param  textColor
     * @return rendered formula
     */
    public static XML toXML(String latex, int textSize, int backgroundColor, int textColor) {
    	DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
        String svgNS = "http://www.w3.org/2000/svg";
        Document document = domImpl.createDocument(svgNS, "svg", null);
        SVGGeneratorContext ctx = SVGGeneratorContext.createDefault(document);

        SVGGraphics2D svgGenerator = new SVGGraphics2D(ctx, true);

        DefaultTeXFont.registerAlphabet(new CyrillicRegistration());
        DefaultTeXFont.registerAlphabet(new GreekRegistration());

        TeXFormula formula = new TeXFormula(latex);
        TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, textSize);
        svgGenerator.setSVGCanvasSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        svgGenerator.setColor(new Color(backgroundColor, true));
        svgGenerator.fillRect(0, 0, icon.getIconWidth(), icon.getIconHeight());
        
        JLabel jl = new JLabel();
        jl.setForeground(new Color(textColor, true));
        icon.paintIcon(jl, svgGenerator, 0, 0);
        
        boolean useCSS = true;
        Writer out = new StringWriter();
        
        XML output;
        try {
        	svgGenerator.stream(out, useCSS);
        	output = XML.parse(out.toString());
        	
        	return output;
        	
        } catch (IOException e) {
        	throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
        	throw new RuntimeException(e);
        } catch (SAXException e) {
        	throw new RuntimeException(e);
        }
    }
}
