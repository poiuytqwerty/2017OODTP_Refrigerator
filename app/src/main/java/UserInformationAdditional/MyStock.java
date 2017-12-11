package UserInformationAdditional;

/**
 * Created by JUNG on 2017-11-26.
 */

public class MyStock {
    StockIngredient[] stockIngredientlist = new StockIngredient[100];
    int countIngredient = 0;

    public void addIngredient(StockIngredient ingredient) {//add Ingredient into stock
		stockIngredientlist[countIngredient] = ingredient;
		countIngredient++;
    }
    public void deleteIngredient(/*인자로 id등등 받아야 함*/) {
		/*해당 ingredient와 연동된 재료를 view와 삭제*/
    }
    public void modifyingIngredient(/*인자로 id등등 받아야 함 deleteIngredient와 동일한 형식 인자*/) {
		/*재료 수정*/
    }

    public StockIngredient[] getStockIngredientlist(){/*getter*/
        return this.stockIngredientlist;
    }
}
