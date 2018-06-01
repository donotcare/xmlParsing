package playground;

import com.google.common.io.Resources;

import javax.xml.stream.events.XMLEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;

public class XmlParser {
    private static final Logger log = Logger.getLogger(XmlParser.class.getName());

    public static void main(String[] args) {
        List<String> ingridients = new ArrayList<>();
        URL xmlUrl = Resources.getResource("recipes.xml");
        try (StaxStreamProcessor xmlProcessor = new StaxStreamProcessor(xmlUrl.openStream())) {
            while (xmlProcessor.doUntil(XMLEvent.START_ELEMENT, "ingredient")) {
                ingridients.add(xmlProcessor.getAttributeValue("name"));
            }
            log.info(ingridients::toString);
        } catch (Exception e) {
            log.log(SEVERE, "Error", e);
        }

    }
}
