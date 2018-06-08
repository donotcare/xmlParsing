package playground.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;

public class JaxbUnmarshaller {
    private final JAXBContext context;

    JaxbUnmarshaller(JAXBContext context) {
        this.context = context;
    }

    public <T> T unmarshal(Reader reader, Class<T> toClass) throws JAXBException {
        return toClass.cast(createUnmarshaller().unmarshal(reader));
    }

    private Unmarshaller createUnmarshaller() throws JAXBException {
        return context.createUnmarshaller();
    }
}
