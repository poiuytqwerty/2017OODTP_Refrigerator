package RecipeRecommend.Drink;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import RecipeRecommend.Recipe;
import UserInformationAdditional.Ingredient;

/**
 * Created by JUNG on 2017-11-26.
 */

public class Drink {
    String name;
    String drinkType;

    public static Recipe readRecipe(String fileName){
        String name = null;
        String tempIngredient = null;
        String[] spices = {null};
        String[] directions = new String[30];

        int index = 0;

        try{
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String s;

            while((s = in.readLine()) != null){
                if(index == 0){
                    name = s; // get first line as name
                } else if (index == 1) {
                    tempIngredient = s;
                } else {
                    directions[index - 2] = s;
                }
                index++;
            }

            in.close();
        } catch (IOException e){
            System.err.println(e);
            System.exit(1);
        }

        Ingredient[] ingredients = new Ingredient[tempIngredient.length()];
        String[] ingredientName = tempIngredient.split(" ");

        //ERROR!!!!!!!!!! ingredientName을 ingredients.name으로 설정해주어야 한다 그런데 계속 오류뜸

        Recipe recipe = new Recipe(name, ingredients, spices, directions);
        return recipe;
    }


}
