package playground.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.Reader;

public class JaxbParser {
    private JaxbMarshaller marshaller;
    private JaxbUnmarshaller unmarshaller;

    public JaxbParser(Class... classes) {
        try {
            init(JAXBContext.newInstance(classes));
        } catch (JAXBException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void init(JAXBContext jaxbContext) {
        marshaller = new JaxbMarshaller(jaxbContext);
        unmarshaller = new JaxbUnmarshaller(jaxbContext);
    }

    public String marshal(Object object) throws JAXBException {
        return marshaller.marshal(object);
    }

    public <T> T unmarshal(Reader reader, Class<T> toClass) throws JAXBException {
        return unmarshaller.unmarshal(reader, toClass);
    }
}
