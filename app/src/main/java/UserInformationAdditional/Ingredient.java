package UserInformationAdditional;

public class Ingredient {/*레시피 창에 들어가는 재료*/
    String name = " ";
    boolean hands;	//already got

    public Ingredient(){}

    public Ingredient(String ingredientName, boolean hands){
        this.name = ingredientName;
        this.hands = hands;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public void setHands(boolean hands) {
        this.hands = hands;
    }
}
