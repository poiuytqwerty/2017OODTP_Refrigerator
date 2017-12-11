package RecipeRecommend.Drink;

import RecipeRecommend.Drink.Drink;
import RecipeRecommend.Recipe;

/**
 * Created by JUNG on 2017-11-26.
 */

public class Alcohol extends Drink {
    Recipe[] AlcoholRep = new Recipe[100];
    int RecipeCounter = 0;

    public boolean addRecipe(String fileTxt){
        if(RecipeCounter > AlcoholRep.length-1){
            return false;
        } else{
            Recipe recipe = readRecipe(fileTxt);
            AlcoholRep[RecipeCounter] = recipe;
            RecipeCounter++;
            return true;
        }
    }
}
