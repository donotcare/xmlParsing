package playground;

import com.google.common.io.Resources;
import org.junit.jupiter.api.Test;
import org.w3c.dom.NodeList;

import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.net.URL;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XmlParserTest {

    @Test
    void countIngredientsWithStax() throws Exception {
        int count = 0;
        URL xmlUrl = Resources.getResource("recipes.xml");
        try (StaxStreamProcessor xmlProcessor = new StaxStreamProcessor(xmlUrl.openStream())) {
            while (xmlProcessor.doUntil(XMLEvent.START_ELEMENT, "ingredient")) {
                count++;
            }
        }
        assertEquals(86, count);
    }

    @Test
    void getButterAmountWithXpath() throws IOException {
        URL xmlUrl = Resources.getResource("recipes.xml");
        XpathProcessor xpathProcessor = new XpathProcessor(xmlUrl.openStream());
        NodeList nodes = xpathProcessor.evaluate("//r:ingredient[@name='butter']/@amount");
        double amount = IntStream.range(0, nodes.getLength()).mapToObj(i-> nodes.item(i).getNodeValue()).mapToDouble(Double::parseDouble).sum();
        assertEquals(0.75, amount);
    }
}