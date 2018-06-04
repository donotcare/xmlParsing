package playground;

import org.w3c.dom.Document;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import java.util.Iterator;

public class NamespaceResolver implements NamespaceContext {
    private Document sourceDocument;

    NamespaceResolver(Document document) {
        sourceDocument = document;
    }

    public String getNamespaceURI(String prefix) {
        if (prefix.equals(XMLConstants.DEFAULT_NS_PREFIX)) {
            return sourceDocument.lookupNamespaceURI(null);
        } else {
            String namespaceURI = sourceDocument.lookupNamespaceURI(prefix);
            if(namespaceURI == null) {
                return sourceDocument.lookupNamespaceURI(null);
            } else {
                return namespaceURI;
            }
        }
    }

    public String getPrefix(String namespaceURI) {
        return sourceDocument.lookupPrefix(namespaceURI);
    }

    @SuppressWarnings("rawtypes")
    public Iterator getPrefixes(String namespaceURI) {
        return null;
    }
}
