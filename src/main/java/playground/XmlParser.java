package playground;

import com.google.common.io.Resources;
import org.w3c.dom.NodeList;

import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;

public class XmlParser {
    private static final Logger log = Logger.getLogger(XmlParser.class.getName());

    public static void main(String[] args) throws IOException {
        List<String> ingredients = new ArrayList<>();
        URL xmlUrl = Resources.getResource("recipes.xml");
        try (StaxStreamProcessor xmlProcessor = new StaxStreamProcessor(xmlUrl.openStream())) {
            while (xmlProcessor.doUntil(XMLEvent.START_ELEMENT, "ingredient")) {
                ingredients.add(xmlProcessor.getAttributeValue("name"));
            }
            log.info(ingredients::toString);
        } catch (Exception e) {
            log.log(SEVERE, "Error", e);
        }

        XpathProcessor xpathProcessor = new XpathProcessor(xmlUrl.openStream());
        NodeList nodes = xpathProcessor.evaluate("r:collection/r:recipe/r:date");
        log.info(nodes.item(1).getTextContent());
    }
}
