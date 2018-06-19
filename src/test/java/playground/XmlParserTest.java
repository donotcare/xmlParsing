package playground;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.jupiter.api.Test;
import org.w3c.dom.NodeList;
import playground.jaxb.JaxbParser;
import playground.jaxb.model.Ingredient;

import javax.xml.bind.JAXBException;
import javax.xml.stream.events.XMLEvent;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQResultSequence;
import java.io.IOException;
import java.io.StringReader;
import java.net.URISyntaxException;
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
        double amount = IntStream.range(0, nodes.getLength()).mapToObj(i -> nodes.item(i).getNodeValue()).mapToDouble(Double::parseDouble).sum();
        assertEquals(0.75, amount);
    }

    @Test
    void jaxbMarshal() throws JAXBException {
        JaxbParser parser = new JaxbParser(Ingredient.class);
        Ingredient ingredient = new Ingredient();
        ingredient.setAmount("10");
        String xml = parser.marshal(ingredient);
        Ingredient ingredientFromXml = parser.unmarshal(new StringReader(xml), Ingredient.class);
        assertEquals("10", ingredientFromXml.getAmount());
    }

    @Test
    void getButterAmountWithXQuery() throws XQException, IOException, URISyntaxException {
        URL xmlUrl = Resources.getResource("recipes.xml");
        String query = Resources.toString(Resources.getResource("recipes.xqy"), Charsets.UTF_8);
        XQueryProcessor processor = new XQueryProcessor();
        XQResultSequence result = processor.evaluate(query.replace("@xmlDocPath", xmlUrl.toURI().getPath()));
        double amount = 0;
        while (result.next()) {
            amount += Double.parseDouble(result.getItemAsString(null));
        }

        assertEquals(0.75, amount);
    }
}
