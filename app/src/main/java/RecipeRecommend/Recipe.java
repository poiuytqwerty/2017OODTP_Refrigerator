package RecipeRecommend;

import UserInformationAdditional.Ingredient;

/**
 * Created by JUNG on 2017-11-24.
 */

public class Recipe {

    String title;           //음식 이름
    Ingredient[] ingredients;
    char type = ' ';
    String[] spices;		//양념
    String[] directions;    //조리법
    boolean favorite = false;		//즐겨찾기

    public Recipe(String title, Ingredient[] ingredient, String[] spices, String[] directions){
        this.title = title;
        this.ingredients = ingredient;
        this.spices = spices;
        this.directions = directions;
    }

    public char getType(){
        return this.type;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

}