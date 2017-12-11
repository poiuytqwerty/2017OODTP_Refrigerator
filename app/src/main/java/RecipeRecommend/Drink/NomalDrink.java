package RecipeRecommend.Drink;

import RecipeRecommend.Drink.Drink;
import RecipeRecommend.Recipe;

/**
 * Created by JUNG on 2017-11-26.
 */

public class NomalDrink extends Drink {
    Recipe[] NormalRep = new Recipe[100];
    int RecipeCounter = 0;

    public boolean addRecipe(String fileTxt){
        if(RecipeCounter > NormalRep.length-1){
            return false;
        } else{
            Recipe recipe = readRecipe(fileTxt);
            NormalRep[RecipeCounter] = recipe;
            RecipeCounter++;
            return true;
        }
    }
}
