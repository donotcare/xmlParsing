
package playground.jaxb.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "description",
    "recipe"
})
@XmlRootElement(name = "collection", namespace = "http://www.brics.dk/ixwt/recipes")
public class RecipesCollection {

    @XmlElement(namespace = "http://www.brics.dk/ixwt/recipes", required = true)
    private String description;
    @XmlElement(namespace = "http://www.brics.dk/ixwt/recipes")
    private List<Recipe> recipe;

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public List<Recipe> getRecipe() {
        if (recipe == null) {
            recipe = new ArrayList<>();
        }
        return this.recipe;
    }

}
