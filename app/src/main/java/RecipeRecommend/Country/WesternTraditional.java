package RecipeRecommend.Country;

import com.example.jung.a2017termproject.CountryTraditional;
import RecipeRecommend.Recipe;

/**
 * Created by JUNG on 2017-11-26.
 */

public class WesternTraditional extends CountryTraditional {
    Recipe[] WesternRep = new Recipe[100];
    int RecipeCounter = 0;
    String country;

    public void setCountry(String country){
        this.country = country;
    }

    public boolean addRecipe(String fileTxt){
        if(RecipeCounter > WesternRep.length-1){
            return false;
        } else{
            Recipe recipe = readRecipe(fileTxt);
            WesternRep[RecipeCounter] = recipe;
            RecipeCounter++;
            return true;
        }
    }
}
