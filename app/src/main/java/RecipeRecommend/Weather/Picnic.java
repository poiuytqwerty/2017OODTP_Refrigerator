package RecipeRecommend.Weather;

import RecipeRecommend.Recipe;

/**
 * Created by JUNG on 2017-11-26.
 */

public class Picnic extends Weather {
    Recipe[] PicnicRep = new Recipe[100];
    int RecipeCounter = 0;

    public boolean addRecipe(Recipe recipe){
        if(RecipeCounter < PicnicRep.length){
            return false;
        } else{
            PicnicRep[RecipeCounter] = recipe;
            return true;
        }
    }
}
