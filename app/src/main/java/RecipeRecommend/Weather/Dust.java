package RecipeRecommend.Weather;

import RecipeRecommend.Recipe;
import RecipeRecommend.Weather.Weather;

/**
 * Created by JUNG on 2017-11-26.
 */

public class Dust extends Weather {
    Recipe[] DustRep = new Recipe[100];
    int RecipeCounter = 0;

    public boolean addRecipe(Recipe recipe){
        if(RecipeCounter < DustRep.length){
            return false;
        } else{
            DustRep[RecipeCounter] = recipe;
            return true;
        }
    }
}
