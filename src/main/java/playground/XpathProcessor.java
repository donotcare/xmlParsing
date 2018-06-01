package playground;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.InputStream;

public class XpathProcessor {
    private static final DocumentBuilderFactory DOCUMENT_FACTORY = DocumentBuilderFactory.newInstance();
    private static final DocumentBuilder DOCUMENT_BUILDER;

    private static final XPathFactory XPATH_FACTORY = XPathFactory.newInstance();

    static {
        try {
            DOCUMENT_BUILDER = DOCUMENT_FACTORY.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException(e);
        }
    }

    private final Document doc;

    public XpathProcessor(InputStream is) {
        try {
            this.doc = DOCUMENT_BUILDER.parse(is);
        } catch (SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void evaluate(String expression) {
        System.out.println("evaluate");
    }

    private XPathExpression getXpathExpression(String expression) throws XPathExpressionException {
        return XPATH_FACTORY.newXPath().compile(expression);
    }
}
