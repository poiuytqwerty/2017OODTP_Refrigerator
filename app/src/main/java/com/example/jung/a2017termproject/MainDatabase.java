package com.example.jung.a2017termproject;


/**
 * Created by JUNG on 2017-11-26.
 */

public class MainDatabase {/*앱과 연동시켜서 작업하는 최종 데이타베이스 페이지*/
                            /*Main()안에 전체를 넣어야 하나..?*/


                            /////////Test Korean

    /*Country Traditional*/
    public KoreanTraditional koreanTraditional = new KoreanTraditional();

    /*
    public JapaneseTraditional japaneseTraditional = new JapaneseTraditional();
    public ChineseTraditional chineseTraditional = new ChineseTraditional();
    public WesternTraditional westernTraditional = new WesternTraditional();
    public OtherTraditional otherTraditional = new OtherTraditional();
    /*====================*/

    /*UserInformation*/
    /*
    public UserInformation user = new UserInformation();
    /*==============*/

    /*UserInformation + Additional*/
    /*
    public MyStock myStock = new MyStock();
    ShoppingBasket shoppingBasket = new ShoppingBasket();
    /*============================*/

    /*Weather가 모든 타입의 날씨레시피 객체를 가지고 있음*/
    /*
    Weather weather = new Weather();
*/
    public MainDatabase(){
        koreanTraditional.addRecipe("ggg.txt");
    }


}
