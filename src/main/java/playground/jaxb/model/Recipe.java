
package playground.jaxb.model;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "title",
    "date",
    "ingredient",
    "preparation",
    "comment",
    "nutrition",
    "related"
})
@XmlRootElement(name = "recipe", namespace = "http://www.brics.dk/ixwt/recipes")
public class Recipe {

    @XmlElement(namespace = "http://www.brics.dk/ixwt/recipes", required = true)
    private String title;
    @XmlElement(namespace = "http://www.brics.dk/ixwt/recipes", required = true)
    private String date;
    @XmlElement(namespace = "http://www.brics.dk/ixwt/recipes")
    private List<Ingredient> ingredient;
    @XmlElement(namespace = "http://www.brics.dk/ixwt/recipes", required = true)
    private Preparation preparation;
    @XmlElement(namespace = "http://www.brics.dk/ixwt/recipes")
    private String comment;
    @XmlElement(namespace = "http://www.brics.dk/ixwt/recipes", required = true)
    private Nutrition nutrition;
    @XmlElement(namespace = "http://www.brics.dk/ixwt/recipes")
    private List<Related> related;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    private String id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String value) {
        this.date = value;
    }

    public List<Ingredient> getIngredient() {
        if (ingredient == null) {
            ingredient = new ArrayList<>();
        }
        return this.ingredient;
    }

    public Preparation getPreparation() {
        return preparation;
    }


    public void setPreparation(Preparation value) {
        this.preparation = value;
    }


    public String getComment() {
        return comment;
    }


    public void setComment(String value) {
        this.comment = value;
    }


    public Nutrition getNutrition() {
        return nutrition;
    }

    public void setNutrition(Nutrition value) {
        this.nutrition = value;
    }


    public List<Related> getRelated() {
        if (related == null) {
            related = new ArrayList<>();
        }
        return this.related;
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

}
