package com.example.jung.a2017termproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import RecipeRecommend.Recipe;
import UserInformationAdditional.Ingredient;

/**
 * Created by JUNG on 2017-11-24.
 */

public class CountryTraditional {
    String countryType;

    /*!!!!!!!!!!!!! HALF-STUB METHOD !!!!!!!!!!!!!!!!*/
    public static Recipe readRecipe(String fileName){//readRecipe from txt File
        String title = null;					//title
        String tempIngredient = null;			//temporary ingredient String
        String tempSpice = null;				//temporary spice String
        String[] directions = new String[30];	//direction

        int index = 0;

        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));   //open File
            //!!!!!!!!!!!!!!!!!!!!!경로 재설정해주어야 한다
            String s;


            while ((s = in.readLine()) != null) {
                if(index == 0){
                    title = s;  //Get first line as title
                } else if (index == 1){
                    tempIngredient = s; //Get second line as Ingredient (need parsing)
                } else if(index == 2) {
                    tempSpice = s;
                } else {
                    directions[index -  3] = s; ////Get third line as step of directions
                }
                index++;
            }

            in.close();
        } catch (IOException e) { //Error Handling
            System.err.println(e);
            System.exit(1);
        }


        // parsing with blank
        String[] ingredientName = tempIngredient.split(" ") ;	//split return array
        Ingredient[] ingredient = new Ingredient[ingredientName.length];

        //ingredientName을 ingredient.name으로 복사해와야 한다. ERROR

        /*
        for(int i = 0; i < ingredient.length; i++) {
        	ingredient[i].name = ingredientName[i];
        }
        */

        String[] spice = tempSpice.split(" ");				//split return array

        Recipe recipe = new Recipe(title, ingredient, spice, directions);
        return recipe;
    }

}
