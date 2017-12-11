package com.example.jung.a2017termproject;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import UserInformationAdditional.StockIngredient;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    MainDatabase mainDatabase;
    private static int ONE_MINUTE = 5626;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        startActivity(new Intent(this, userfirstinput_main.class));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new AlarmHATT(getApplicationContext()).Alarm();

        {
        NotificationManager notificationManager = (NotificationManager) MainActivity.this.getSystemService(MainActivity.this.NOTIFICATION_SERVICE);
        Intent intent1 = new Intent(MainActivity.this.getApplicationContext(), MainActivity.class); //인텐트 생성.

        Notification.Builder builder = new Notification.Builder(getApplicationContext());
        intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);//현재 액티비티를 최상으로 올리고, 최상의 액티비티를 제외한 모든 액티비티를 없앤다.

        PendingIntent pendingNotificationIntent = PendingIntent.getActivity(MainActivity.this, 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
        //PendingIntent는 일회용 인텐트 같은 개념입니다.
//        FLAG_UPDATE_CURRENT - > 만일 이미 생성된 PendingIntent가 존재 한다면, 해당 Intent의 내용을 변경함.
//
//                FLAG_CANCEL_CURRENT - .이전에 생성한 PendingIntent를 취소하고 새롭게 하나 만든다.
//
//                FLAG_NO_CREATE -> 현재 생성된 PendingIntent를 반환합니다.
//
//        FLAG_ONE_SHOT - >이 플래그를 사용해 생성된 PendingIntent는 단 한번밖에 사용할 수 없습니다
        builder.setSmallIcon(R.drawable.clickedstar).setTicker("'냉장고를 부탁해'에 오신 걸 환영합니다!").setWhen(System.currentTimeMillis())
                .setNumber(1).setContentTitle("냉장고를 부탁해!").setContentText("환영합니다!")
                .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE).setContentIntent(pendingNotificationIntent).setAutoCancel(true).setOngoing(true);



         /*
            builder.setSmallIcon(R.drawable.clickedstar).setTicker("파의 유통기한이 9일 2시간 10분 남았습니다.").setWhen(System.currentTimeMillis())
                    .setNumber(1).setContentTitle("냉장고를 부탁해!").setContentText("파 0.5개의 유통기한이 9일 2시간 10분 남았습니다.")
                    .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE).setContentIntent(pendingNotificationIntent).setAutoCancel(true).setOngoing(true);
                    */
        //해당 부분은 API 4.1버전부터 작동합니다.

//setSmallIcon - > 작은 아이콘 이미지

//setTicker - > 알람이 출력될 때 상단에 나오는 문구.

//setWhen -> 알림 출력 시간.

//setContentTitle-> 알림 제목

//setConentText->푸쉬내용

        notificationManager.notify(1, builder.build()); // Notification send
    }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MainFragment mainFragment = new MainFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, mainFragment, mainFragment.getTag()).commit();



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);//ser to Add
        toggle.syncState();

     //   NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
     //   navigationView.setNavigationItemSelectedListener(this);

        enableExpandableList();

        //MainDatabase mainDatabase = new MainDatabase(); //메인 데이터베이스
    }

    public class AlarmHATT {
        private Context context;
        public AlarmHATT(Context context) {
            this.context=context;
        }
        public void Alarm() {
            AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(MainActivity.this, BroadcastD.class);

            PendingIntent sender = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);

            Calendar calendar = Calendar.getInstance();
            //알람시간 calendar에 set

            calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 21, 39, 0);

            //알람 예약
            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
        }
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*BUTTON CLICK LISTENER*/
    /*GO SOMEWHERE*/
    public void GoUserInfo(View v){

        UserInfoFragment userInfoFragment = new UserInfoFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, userInfoFragment, userInfoFragment.getTag()).commit();

        DrawerLayout mDrawerLayout;
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.closeDrawers();
    }

    public void GoWeather(View v){

        {
            NotificationManager notificationManager = (NotificationManager) MainActivity.this.getSystemService(MainActivity.this.NOTIFICATION_SERVICE);
            Intent intent1 = new Intent(MainActivity.this.getApplicationContext(), MainActivity.class); //인텐트 생성.

            Notification.Builder builder = new Notification.Builder(getApplicationContext());
            intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);

            PendingIntent pendingNotificationIntent = PendingIntent.getActivity(MainActivity.this, 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT);

            builder.setSmallIcon(R.drawable.clickedstar).setTicker("밥의 유통기한이 4일 2시간 01분 남았습니다.").setWhen(System.currentTimeMillis())
                    .setNumber(1).setContentTitle("냉장고를 부탁해!").setContentText("밥 3개의 유통기한이 4일 2시간 01분 남았습니다.")
                    .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE).setContentIntent(pendingNotificationIntent).setAutoCancel(true).setOngoing(true);

            notificationManager.notify(1, builder.build()); // Notification send
        }


        WeatherFragment userInfoFragment = new WeatherFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, userInfoFragment, userInfoFragment.getTag()).commit();
    }
    public void GoSunnyRecipe(View v){
        weather_sunny_recipe sunnyFragment = new weather_sunny_recipe();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, sunnyFragment, sunnyFragment.getTag()).commit();
    }
    public void GoDustRecipe(View v){
        weather_dust_recipe dustFragment = new weather_dust_recipe();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, dustFragment, dustFragment.getTag()).commit();
    }
    public void GoRainyRecipe(View v){
        weather_rainy_recipe rainyFragment = new weather_rainy_recipe();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, rainyFragment, rainyFragment.getTag()).commit();
    }
    public void GoSnowRecipe(View v){
        weather_snow_recipe snowFragment = new weather_snow_recipe();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, snowFragment, snowFragment.getTag()).commit();
    }
    public void GoAddIngredient(View v){
        AddIngredientFragment addIngredientFragment = new AddIngredientFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, addIngredientFragment, addIngredientFragment.getTag()).commit();
    }



    public void goAdditionalUserInfo(View v){
        AdditionalUserInfoFragment additionalUserInfoFragment = new AdditionalUserInfoFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, additionalUserInfoFragment, additionalUserInfoFragment.getTag()).commit();
    }

    public void goFavoriteRecipe(View v){
        FavoriteRecipeFragment favoriteRecipeFragment = new FavoriteRecipeFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, favoriteRecipeFragment, favoriteRecipeFragment.getTag()).commit();
    }

    public void goShoppingBasket(View v){
        ShoppingBasketFragment shoppingBasketFragment = new ShoppingBasketFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, shoppingBasketFragment, shoppingBasketFragment.getTag()).commit();
    }

    public void goMemo(View v){
        {
            NotificationManager notificationManager = (NotificationManager) MainActivity.this.getSystemService(MainActivity.this.NOTIFICATION_SERVICE);
            Intent intent1 = new Intent(MainActivity.this.getApplicationContext(), MainActivity.class); //인텐트 생성.

            Notification.Builder builder = new Notification.Builder(getApplicationContext());
            intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);

            PendingIntent pendingNotificationIntent = PendingIntent.getActivity(MainActivity.this, 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT);

            builder.setSmallIcon(R.drawable.clickedstar).setTicker("새우 12개의 유통기한이 7일 2시간 10분 남았습니다.").setWhen(System.currentTimeMillis())
                    .setNumber(1).setContentTitle("냉장고를 부탁해!").setContentText("새우 12개의 유통기한이 7일 2시간 10분 남았습니다.")
                    .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE).setContentIntent(pendingNotificationIntent).setAutoCancel(true).setOngoing(true);

            notificationManager.notify(1, builder.build()); // Notification send
        }




        MemoFragment MemoFragment = new MemoFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, MemoFragment, MemoFragment.getTag()).commit();
    }

    public void goAddShoppingBasket(View v){
        AddShoppingBasketFragment addShoppingBasketFragment = new AddShoppingBasketFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, addShoppingBasketFragment, addShoppingBasketFragment.getTag()).commit();
    }

    public void addShoppingBtn(View v){

        try{
            EditText ingredient_n = (EditText)findViewById(R.id.shoppingingredientnameinput);
            EditText ingredient_c = (EditText)findViewById(R.id.shoppingingredientcountinput);

            String name = ingredient_n.getText().toString();    //이름
            String count = ingredient_c.getText().toString();   //갯수

            FileWriter fw_name  = new FileWriter(getFilesDir() + "myshopping_name.txt", true);
            BufferedWriter bw_name = new BufferedWriter(fw_name);
            bw_name.write(name + "\n");
            bw_name.close();

            FileWriter fw_count  = new FileWriter(getFilesDir() + "myshopping_count.txt", true);
            BufferedWriter bw_count = new BufferedWriter(fw_count);
            bw_count.write(count + "\n");
            bw_count.close();



        } catch (IOException e) {
            e.printStackTrace();
        }

        goShoppingBasket(v);
    }
    public void GoJapaneseRecipe1(View v){
        japanese_recipe1 japaneseFragment = new japanese_recipe1();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, japaneseFragment, japaneseFragment.getTag()).commit();
    }

    public void GoSchoolRecipe1(View v){
        school_recipe1 schoolFragment = new school_recipe1();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, schoolFragment, schoolFragment.getTag()).commit();
    }
    public void GoWesternRecipe1(View v){
        western_recipe1 westernFragment = new western_recipe1();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, westernFragment, westernFragment.getTag()).commit();
    }
    public void goAddMemo(View v){
        AddMemoFragment addMemoFragment = new AddMemoFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, addMemoFragment,  addMemoFragment.getTag()).commit();
    }

    public void goUserTypeRecommend(View v){
        recommend_recipe recommend_recipe = new recommend_recipe();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, recommend_recipe, recommend_recipe.getTag()).commit();
    }

    public void GoKoreanRecipe1(View v){
        korean_recipe1 korean_recipe1 = new korean_recipe1();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, korean_recipe1, korean_recipe1.getTag()).commit();
    }


    //////////////////////////////////////////////////////


    /////////
    public void goMakgeolli(View v){
        drink_alchol_makgeolli makgeolliFregment = new drink_alchol_makgeolli();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, makgeolliFregment, makgeolliFregment.getTag()).commit();
    }
    public void goSoju(View v){
        drink_alchol_soju sojuFregment = new drink_alchol_soju();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, sojuFregment, sojuFregment.getTag()).commit();
    }
    public void gobeer(View v){
        drink_alchol_beer beerFregment = new drink_alchol_beer();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, beerFregment, beerFregment.getTag()).commit();
    }
    public void goWine(View v){
        drink_alchol_wine wineFregment = new drink_alchol_wine();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, wineFregment, wineFregment.getTag()).commit();
    }
    public void gobeerRecipe(View v){
        drink_alchol_beer_recipe beer_recipeFregment = new drink_alchol_beer_recipe();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, beer_recipeFregment, beer_recipeFregment.getTag()).commit();
    }
    public void goMakgeolli_Recipe(View v){
        drink_alchol_makgeolli_recipe makgeolli_recipeFregment = new drink_alchol_makgeolli_recipe();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, makgeolli_recipeFregment, makgeolli_recipeFregment.getTag()).commit();
    }
    public void goWine_recipe(View v){
        drink_alchol_wine_recipe wine_recipeFregment = new drink_alchol_wine_recipe();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, wine_recipeFregment, wine_recipeFregment.getTag()).commit();
    }
    public void gosoju_recipe(View v){
        drink_alchol_soju_recipe soju_recipe_Fregment = new drink_alchol_soju_recipe();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, soju_recipe_Fregment, soju_recipe_Fregment.getTag()).commit();
    }
    public void goNonalcholRecipe1(View v){
        drink_nonalchol_recipe juiceFregment = new drink_nonalchol_recipe();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, juiceFregment, juiceFregment.getTag()).commit();
    }

    public void goHealthRecipe1(View v){
        recommend_health_recipe healthRecipeFragment = new recommend_health_recipe();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, healthRecipeFragment, healthRecipeFragment.getTag()).commit();
    }

    public void goRainyRecipe(View v){
        Rainy_recipe1 RainyRecipeFragment = new Rainy_recipe1();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, RainyRecipeFragment, RainyRecipeFragment.getTag()).commit();
    }

    /////////
    public void goStockRecipe1(View v){
        recommend_stock_recipe StockRecipeFragment = new recommend_stock_recipe();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, StockRecipeFragment, StockRecipeFragment.getTag()).commit();
    }

    public void GoRandomRecipe1(View v){
        Random_recipe1 random_recipe1 = new Random_recipe1();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, random_recipe1, random_recipe1.getTag()).commit();
    }
    /////////



    public void GoKoreaRecipe_Favorite(View v){
        Korea_recipe_favorite korea_recipe_favorite = new Korea_recipe_favorite();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, korea_recipe_favorite, korea_recipe_favorite.getTag()).commit();
    }

    public void GoKoreaRecipe_Favorite_Favorite(View v){
        New_favorite korea_recipe_favorite = new New_favorite();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, korea_recipe_favorite, korea_recipe_favorite.getTag()).commit();
    }

    public void GoNewShop(View v){
        New_shopping new_shopping = new New_shopping();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, new_shopping, new_shopping.getTag()).commit();
    }

    public void goRecommend(View v){
        recommned_recipe userInfoFragment = new recommned_recipe();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, userInfoFragment, userInfoFragment.getTag()).commit();
    }

    public void goHealth(View v){
        recommend_health recommend_healthFagment = new recommend_health();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, recommend_healthFagment, recommend_healthFagment.getTag()).commit();
    }
    public void goStock(View v){
        recommend_stock recommend_stockFragment = new recommend_stock();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, recommend_stockFragment, recommend_stockFragment.getTag()).commit();
    }



    //재료를 mystock.txt에 저장
    public void addBtn(View v){
        try{
            EditText ingredient_n = (EditText)findViewById(R.id.ingredientnameinput);
            EditText ingredient_c = (EditText)findViewById(R.id.numberOfIngredientInput);
            EditText ingredient_e = (EditText)findViewById(R.id.expiredateInput);
            Spinner ingredientCategorySpinner = (Spinner)findViewById(R.id.spinner2);

            String name = ingredient_n.getText().toString();    //이름
            String count = ingredient_c.getText().toString();   //갯수
            String expiredDate = ingredient_e.getText().toString(); //유통기한
            String category = ingredientCategorySpinner.getSelectedItem().toString();   //카테고리

            FileWriter fw_name  = new FileWriter(getFilesDir() + "mystock_name.txt", true);
            BufferedWriter bw_name = new BufferedWriter(fw_name);
            bw_name.write(name + "\n");
            bw_name.close();

            FileWriter fw_count  = new FileWriter(getFilesDir() + "mystock_count.txt", true);
            BufferedWriter bw_count = new BufferedWriter(fw_count);
            bw_count.write(count + "\n");
            bw_count.close();

            FileWriter fw_expiredDate  = new FileWriter(getFilesDir() + "mystock_expired.txt", true);
            BufferedWriter bw_expiredDate = new BufferedWriter(fw_expiredDate);
            bw_expiredDate.write(expiredDate + "\n");
            bw_expiredDate.close();

            FileWriter fw_category  = new FileWriter(getFilesDir() + "mystock_category.txt", true);
            BufferedWriter bw_category = new BufferedWriter(fw_category);
            bw_category.write(category + "\n");
            bw_category.close();

            //ingredient에 저장
            StockIngredient new_ingredient = new StockIngredient(name, expiredDate, count);  //새로운 ingredient 객체 생성
            //mainDatabase.myStock.addIngredient(new_ingredient); //myStock에 add

            Toast.makeText(getApplicationContext(), name + " " + count + "개의 유통기한이 12시간 남았습니다", Toast.LENGTH_LONG).show();

        } catch (IOException e) {
            e.printStackTrace();
        }


        UserInfoFragment userInfoFragment = new UserInfoFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, userInfoFragment, userInfoFragment.getTag()).commit();

    }

    public void addmemo_btn(View v){ //새로운 메모를 등록하는 버튼
        try{
            EditText memo = (EditText) findViewById(R.id.editMemoText);
            String memoString  = memo.getText().toString(); //사용자가 입력한 메모를 string으로 저장
//mymemo.txt
            FileWriter fw_memo = new FileWriter(getFilesDir() + "mymemo.txt", true);    //mymemo.txt에 저장
            BufferedWriter bw_memo = new BufferedWriter(fw_memo);
            bw_memo.write(memoString);
            bw_memo.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        MemoFragment memoFragment = new MemoFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, memoFragment, memoFragment.getTag()).commit();

    }

    //재료 상세 페이지, 수정 가능
    //적용X??????????????????????????????????????????????/
    public void goIngredientDetail_1(View v){
/*
        EditText edit_nameInput = (EditText)findViewById(R.id.ingredientnameinput);
        EditText edit_countInput = (EditText)findViewById(R.id.numberOfIngredientInput) ;
        EditText edit_expireDateInput = (EditText)findViewById(R.id.expiredateInput);

        StockIngredient stockIngredient_1 = mainDatabase.myStock.getStockIngredientlist()[0];

        // 기존 데이터를 기반으로 Hint
        edit_nameInput.setHint(stockIngredient_1.getName());
        edit_countInput.setHint(stockIngredient_1.getNumberOfStockIngredient());
        edit_expireDateInput.setHint(stockIngredient_1.getValidationDate());
        */
/*
        Button BtnTxt = (Button) findViewById(R.id.sample1_button); //첫번째 버튼-> 재료 이름, 갯수, 유통기한, 카테고리
        String oldTxt = BtnTxt.toString();  //첫번째 버튼 내용을 String으로 변환
        String[] ingred = oldTxt.split("\n");   //줄바꿈 기준으로 split

        //EditText id를 변수에 연결
        EditText newName = (EditText) findViewById(R.id.ingredientnameinput);
        EditText newCount = (EditText) findViewById(R.id.numberOfIngredientInput);
        EditText newExpiredDate = (EditText) findViewById(R.id.expiredateInput);
        EditText newCategory = (EditText) findViewById(R.id.categorychoose);

        //Set Hint
        if(ingred[0] != null)   newName.setHint(ingred[0]);
        if(ingred[1] != null)   newCount.setHint(ingred[1]);
        if(ingred[2] != null)   newExpiredDate.setHint(ingred[2]);
        if(ingred[3] != null)   newCategory.setHint(ingred[3]);



*/

        IngredientDetailFragment ingredientDetailFragment = new IngredientDetailFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, ingredientDetailFragment, ingredientDetailFragment.getTag()).commit();
    }

    public void submit_ingredientDetail(View v){

/*
        EditText newName = (EditText) findViewById(R.id.ingredientnameinput);
        EditText newCount = (EditText) findViewById(R.id.numberOfIngredientInput);
        EditText newExpiredDate = (EditText) findViewById(R.id.expiredateInput);
        EditText newCategory = (EditText) findViewById(R.id.categorychoose);

        String[] ing = new String[4];

        ing[0] = newName.getHint().toString();
        ing[1] = newCount.getHint().toString();
        ing[2] = newExpiredDate.getHint().toString();
        ing[3] = newCategory.getHint().toString();

        Button BtnTxt = (Button) findViewById(R.id.sample1_button); //첫번째 버튼-> 재료 이름, 갯수, 유통기한, 카테고리
        BtnTxt.setText(ing[0] + "\n" + ing[1] + "\n" + ing[2]  + "\n" + ing[3] );
*/
        UserInfoFragment userInfoFragment = new UserInfoFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.layoutForFragment, userInfoFragment, userInfoFragment.getTag()).commit();
    }



    ///////////////////////////////////////////////////////

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {//Expandable을 쓰면서 필요 없어진 메소드
        // Handle navigation view item clicks here.
       int id = item.getItemId();

        if (id == R.id.nav_recipe) {
        } else if (id == R.id.nav_korean){
            KoreanFragment koreanFragment = new KoreanFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(
                    R.id.layoutForFragment,
                    koreanFragment,
                    koreanFragment.getTag()
            ).commit();

        } else if (id == R.id.nav_japanese){
            JapaneseFragment japaneseFragment = new JapaneseFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(
                    R.id.layoutForFragment,
                    japaneseFragment,
                    japaneseFragment.getTag()
            ).commit();

        } else if (id == R.id.nav_share) {
        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    ///Expandable List-> coCreate에서 직접 호출되는 List Main
    private void enableExpandableList() {
        final ArrayList<String> listDataHeader = new ArrayList<String>();
        final HashMap<String, List<String>> listDataChild = new HashMap<String, List<String>>();
        ExpandableListView expListView = (ExpandableListView) findViewById(R.id.left_drawer);

        prepareListData(listDataHeader, listDataChild);
        ExpandListAdapter listAdapter = new ExpandListAdapter(this, listDataHeader, listDataChild);
        // setting list adapter
        expListView.setAdapter(listAdapter);

        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        // Listview Group expanded listener
        //대분류, Expand와 Collapse toast
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                String item = listDataHeader.get(groupPosition);

                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Child Click Listener
        //소분류-> 실제적인 fragment replace
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                String childCategory = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);

                if(childCategory == "Korean"){

                    //Replace fragment
                    KoreanFragment koreanFragment = new KoreanFragment();
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(
                            R.id.layoutForFragment,
                            koreanFragment,
                            koreanFragment.getTag()
                    ).commit();

                    //close Drawer
                    DrawerLayout mDrawerLayout;
                    mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                    mDrawerLayout.closeDrawers();

                } else if (childCategory == "Western"){
                    WesternFragment westernFragment = new WesternFragment();
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(
                            R.id.layoutForFragment,
                            westernFragment,
                            westernFragment.getTag()
                    ).commit();

                    DrawerLayout mDrawerLayout;
                    mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                    mDrawerLayout.closeDrawers();

                } else if(childCategory == "Japanese"){
                    JapaneseFragment japaneseFragment = new JapaneseFragment();
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(
                            R.id.layoutForFragment,
                            japaneseFragment,
                            japaneseFragment.getTag()
                    ).commit();

                    DrawerLayout mDrawerLayout;
                    mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                    mDrawerLayout.closeDrawers();
                } else if(childCategory == "School"){
                    SchoolFragment schoolFragment = new SchoolFragment();
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(
                            R.id.layoutForFragment,
                            schoolFragment,
                            schoolFragment.getTag()
                    ).commit();

                    DrawerLayout mDrawerLayout;
                    mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                    mDrawerLayout.closeDrawers();
                } else if(childCategory == "Chinese"){
                    ChineseFragment chineseFragment = new ChineseFragment();
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(
                            R.id.layoutForFragment,
                            chineseFragment,
                            chineseFragment.getTag()
                    ).commit();

                    DrawerLayout mDrawerLayout;
                    mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                    mDrawerLayout.closeDrawers();
                } else if(childCategory == "Other"){
                    OtherFragment otherFragment = new OtherFragment();
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(
                            R.id.layoutForFragment,
                            otherFragment,
                            otherFragment.getTag()
                    ).commit();

                    DrawerLayout mDrawerLayout;
                    mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                    mDrawerLayout.closeDrawers();
                }else if(childCategory == "Alchol"){
                    drink_alchol alcholFregment = new drink_alchol();
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(
                            R.id.layoutForFragment,
                            alcholFregment,
                            alcholFregment.getTag()
                    ).commit();


                    DrawerLayout mDrawerLayout;
                    mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                    mDrawerLayout.closeDrawers();
                } else if(childCategory == "Non-Alchol"){
                    drink_nonalchol non_alcholFregment = new drink_nonalchol();
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(
                            R.id.layoutForFragment,
                            non_alcholFregment,
                            non_alcholFregment.getTag()
                    ).commit();


                    DrawerLayout mDrawerLayout;
                    mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                    mDrawerLayout.closeDrawers();
                }

                // if click SubCategory, Toast
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });}

    //Navigation Drawer with Expandable List Adapter 구성
    private void prepareListData(List<String> listDataHeader, Map<String,
            List<String>> listDataChild) {

        // Adding child data
        listDataHeader.add("Traditional");
        listDataHeader.add("Drink");//여기도 변경!

        // Adding child data
        List<String> category_1 = new ArrayList<String>();
        category_1.add("Korean");
        category_1.add("Western");//Japanese로 이름만 변경해줄 것
        category_1.add("Japanese");
        category_1.add("School");
        category_1.add("Chinese");
        category_1.add("Other");//여기서 이름들을 추가해주는 것을 변경

        List<String> category_2 = new ArrayList<String>();
        category_2.add("Alchol");
        category_2.add("Non-Alchol");


        listDataChild.put(listDataHeader.get(0), category_1); // Header, Child data
        listDataChild.put(listDataHeader.get(1), category_2);
    }


}

