package RecipeRecommend.Weather;

import RecipeRecommend.Recipe;

/**
 * Created by JUNG on 2017-11-26.
 */

public class Weather {
    char WeatherType;
    Picnic picnic = new Picnic();
    Dust dust = new Dust();
    Rainy rainy = new Rainy();
    Snow snow = new Snow();

    /*가지고 있는 타입객체 배열에 삽입*/
    public boolean addRecipe(Recipe recipe){
        if(recipe.getType() ==  'I'){ //피크닉
            picnic.addRecipe(recipe);
            return true;
        } else if(recipe.getType() == 'U'){ //미세먼지
            dust.addRecipe(recipe);
            return true;
        } else if(recipe.getType() =='R' ){ //비
            rainy.addRecipe(recipe);
            return true;
        } else if(recipe.getType() == 'O'){ //눈
            snow.addRecipe(recipe);
            return true;
        }
        return false;
    }
}


