
package playground.jaxb.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ingredients",
    "preparation"
})
@XmlRootElement(name = "ingredient", namespace = "http://www.brics.dk/ixwt/recipes")
public class Ingredient {

    @XmlElement(name = "ingredient", namespace = "http://www.brics.dk/ixwt/recipes")
    private List<Ingredient> ingredients;
    @XmlElement(namespace = "http://www.brics.dk/ixwt/recipes")
    private Preparation preparation;
    @XmlAttribute(name = "name", required = true)
    @XmlSchemaType(name = "anySimpleType")
    private String name;
    @XmlAttribute(name = "amount")
    private String amount;
    @XmlAttribute(name = "unit")
    @XmlSchemaType(name = "anySimpleType")
    private String unit;

    public List<Ingredient> getIngredients() {
        if (ingredients == null) {
            ingredients = new ArrayList<>();
        }
        return this.ingredients;
    }

    public Preparation getPreparation() {
        return preparation;
    }

    public void setPreparation(Preparation value) {
        this.preparation = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String value) {
        this.amount = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String value) {
        this.unit = value;
    }

}
