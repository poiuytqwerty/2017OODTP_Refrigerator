package RecipeRecommend.Weather;

import RecipeRecommend.Recipe;

/**
 * Created by JUNG on 2017-11-26.
 */

public class Snow extends Weather {
    Recipe[] SnowRep = new Recipe[100];
    int RecipeCounter = 0;

    public boolean addRecipe(Recipe recipe){
        if(RecipeCounter < SnowRep.length){
            return false;
        } else{
            SnowRep[RecipeCounter] = recipe;
            return true;
        }
    }
}
