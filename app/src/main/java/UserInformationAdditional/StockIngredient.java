package UserInformationAdditional;
import java.util.*;
import java.text.*;

/**
 * Created by JUNG on 2017-11-26.
 */

public class StockIngredient extends Ingredient { /*사용자창에 들어가는 재료. 여기서 유통기한 처리 끝내줘야 함*/


    String validationDate;	//유통기한
    String numberOfStockIngredient; //갯수

    public StockIngredient(String ingredientName, String validationDate, String numberOfStockIngredient) {
        super(ingredientName, true);
        this.validationDate = validationDate;
        this.numberOfStockIngredient = numberOfStockIngredient;
    }

    public String getNumberOfStockIngredient(){
        return  numberOfStockIngredient;
    }
    public void setNumberOfStockIngredient(String newNumberOfStockIngredient){
        this.numberOfStockIngredient = newNumberOfStockIngredient;
    }
    public String getValidationDate(){
        return validationDate;
    }
    public void setValidationDate(String newValidationDate){
        this.validationDate = newValidationDate;
    }
}


