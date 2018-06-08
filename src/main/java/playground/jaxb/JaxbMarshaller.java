package playground.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

import static javax.xml.bind.Marshaller.*;

public class JaxbMarshaller {
    private final JAXBContext context;

    JaxbMarshaller(JAXBContext context) {
        this.context = context;
    }

    public String marshal(Object instance) throws JAXBException {
        StringWriter writer = new StringWriter();
        createMarshaller().marshal(instance, writer);
        return writer.toString();
    }

    private Marshaller createMarshaller() throws JAXBException {
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(JAXB_ENCODING, "UTF-8");
        marshaller.setProperty(JAXB_FRAGMENT, true);
        return marshaller;
    }
}
