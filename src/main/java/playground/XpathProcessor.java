package playground;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.io.InputStream;

public class XpathProcessor {
    private static final DocumentBuilderFactory DOCUMENT_FACTORY = DocumentBuilderFactory.newInstance();
    private static final DocumentBuilder DOCUMENT_BUILDER;

    private static final XPathFactory XPATH_FACTORY = XPathFactory.newInstance();

    static {
        try {
            DOCUMENT_FACTORY.setNamespaceAware(true);
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

    public NodeList evaluate(String expression) {
        try {
            return (NodeList) getXpathExpression(expression).evaluate(doc, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private XPathExpression getXpathExpression(String expression) throws XPathExpressionException {
        XPath xpath = XPATH_FACTORY.newXPath();
        xpath.setNamespaceContext(new NamespaceResolver());
        return xpath.compile(expression);
    }
}
