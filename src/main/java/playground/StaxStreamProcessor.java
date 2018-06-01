package playground;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.util.stream.IntStream;

public class StaxStreamProcessor implements AutoCloseable {
    private static final XMLInputFactory FACTORY = XMLInputFactory.newInstance();

    private final XMLStreamReader reader;

    StaxStreamProcessor(InputStream is) throws XMLStreamException {
        this.reader = FACTORY.createXMLStreamReader(is);
    }

    public boolean doUntil(int event, String value) throws XMLStreamException {
        while (reader.hasNext()) {
            reader.next();
            if (reader.getEventType() == event && value.equals(reader.getLocalName())) {
                return true;
            }
        }
        return false;
    }

    public String getAttributeValue(String name) {
        return IntStream.range(0, reader.getAttributeCount())
                        .filter(i -> reader.getAttributeLocalName(i).equals(name))
                        .mapToObj(reader::getAttributeValue).findAny().orElse("");
    }

    @Override
    public void close() throws Exception {
        reader.close();
    }
}
