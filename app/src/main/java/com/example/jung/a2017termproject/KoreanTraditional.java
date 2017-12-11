package com.example.jung.a2017termproject;

import RecipeRecommend.Recipe;

/**
 * Created by JUNG on 2017-11-24.
 */

public class KoreanTraditional extends CountryTraditional {
    Recipe[] KoreanRep = new Recipe[100];//Recipe database
    int RecipeCounter = 0;//Number Of Recipe & Recipe[] size
    String country;

    public void setCountry(String country) {
        this.country = country;
    }

    /*complete*/
    public boolean addRecipe(String fileTxt){
        if(RecipeCounter < KoreanRep.length-1){
            return false;
        } else {
            Recipe recipe = readRecipe(fileTxt);//read by txt file
            KoreanRep[RecipeCounter] = recipe;
            RecipeCounter++;
            return true;
        }
    }
}
