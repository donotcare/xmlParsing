package playground;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.namespace.NamespaceContext;
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
    private final NamespaceContext namespaceContext;

    XpathProcessor(InputStream is) {
        try {
            this.doc = DOCUMENT_BUILDER.parse(is);
            this.namespaceContext = new NamespaceResolver(doc);
        } catch (SAXException | IOException e) {
        throw new IllegalStateException(e);
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
        xpath.setNamespaceContext(namespaceContext);
        return xpath.compile(expression);
    }
}
