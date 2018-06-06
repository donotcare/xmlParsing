
package playground.jaxb.model;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public Nutrition createNutrition() {
        return new Nutrition();
    }

    public Ingredient createIngredient() {
        return new Ingredient();
    }

    public Preparation createPreparation() {
        return new Preparation();
    }

    public Related createRelated() {
        return new Related();
    }

    public Recipe createRecipe() {
        return new Recipe();
    }

    public RecipesCollection createCollection() {
        return new RecipesCollection();
    }

}
