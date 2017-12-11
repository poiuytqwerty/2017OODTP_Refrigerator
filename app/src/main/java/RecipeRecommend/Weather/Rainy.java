package RecipeRecommend.Weather;

import RecipeRecommend.Recipe;

/**
 * Created by JUNG on 2017-11-26.
 */

public class Rainy extends Weather {
    Recipe[] RainyRep = new Recipe[100];
    int RecipeCounter = 0;

    public boolean addRecipe(Recipe recipe){
        if(RecipeCounter < RainyRep.length){
            return false;
        } else{
            RainyRep[RecipeCounter] = recipe;
            return true;
        }
    }
}
