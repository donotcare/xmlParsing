
package playground.jaxb.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "step"
})
@XmlRootElement(name = "preparation", namespace = "http://www.brics.dk/ixwt/recipes")
public class Preparation {

    @XmlElement(namespace = "http://www.brics.dk/ixwt/recipes")
    private List<String> step;

    public List<String> getStep() {
        if (step == null) {
            step = new ArrayList<>();
        }
        return this.step;
    }

}
