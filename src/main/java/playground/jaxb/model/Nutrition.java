
package playground.jaxb.model;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "nutrition", namespace = "http://www.brics.dk/ixwt/recipes")
public class Nutrition {

    @XmlAttribute(name = "calories", required = true)
    private BigDecimal calories;
    @XmlAttribute(name = "protein", required = true)
    private String protein;
    @XmlAttribute(name = "carbohydrates", required = true)
    private String carbohydrates;
    @XmlAttribute(name = "fat", required = true)
    private String fat;
    @XmlAttribute(name = "alcohol")
    private String alcohol;

    public BigDecimal getCalories() {
        return calories;
    }

    public void setCalories(BigDecimal value) {
        this.calories = value;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String value) {
        this.protein = value;
    }

    public String getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(String value) {
        this.carbohydrates = value;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String value) {
        this.fat = value;
    }

    public String getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(String value) {
        this.alcohol = value;
    }

}
