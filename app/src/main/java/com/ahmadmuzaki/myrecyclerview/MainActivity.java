package com.ahmadmuzaki.myrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ahmadmuzaki.myrecyclerview.adapter.CardViewHeroAdapter;
import com.ahmadmuzaki.myrecyclerview.adapter.GridHeroAdapter;
import com.ahmadmuzaki.myrecyclerview.adapter.ListHeroAdapter;
import com.ahmadmuzaki.myrecyclerview.halamandetail.AhmadDahlanActivity;
import com.ahmadmuzaki.myrecyclerview.halamandetail.AhmadYaniActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHeroes;
    private ArrayList<Hero> list = new ArrayList<>();
    private String title = "Mode List";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHeroes = findViewById(R.id.rv_heroes);
        rvHeroes.setHasFixedSize(true);

        list.addAll(HeroesData.getListData());
        showRecyclerList();
        setActionBarTitle(title);
    }

    private void showRecyclerList() {
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        ListHeroAdapter listHeroAdapter = new ListHeroAdapter(list);
        rvHeroes.setAdapter(listHeroAdapter);

        listHeroAdapter.setOnItemClickCallback(new ListHeroAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hero data) {
                showSelectedHero(data);
            }
        });
    }

    private void showRecyclerGrid() {
        rvHeroes.setLayoutManager(new GridLayoutManager(this, 2));
        GridHeroAdapter gridHeroAdapter = new GridHeroAdapter(list);
        rvHeroes.setAdapter(gridHeroAdapter);

        gridHeroAdapter.setOnItemClickCallback(new GridHeroAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hero data) {
                showSelectedHero(data);
            }
        });
    }

    private void showRecycleCardView(){
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        CardViewHeroAdapter cardViewHeroAdapter = new CardViewHeroAdapter(list);
        rvHeroes.setAdapter(cardViewHeroAdapter);
    }

    //Digunakan untuk menganti Title aplikasi saat berganti mode
    private void setActionBarTitle(String title){
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:
                showRecyclerList();
                title = "Mode List";
                break;
            case R.id.action_grid:
                showRecyclerGrid();
                title = "Mode Grid";
                break;
            case R.id.action_cardview:
                title = "Mode CardView";
                showRecycleCardView();
                break;
        }
        setActionBarTitle(title);
    }

    private void showSelectedHero(Hero hero){
        if (hero.getName() == "Ahmad Yani"){
            Toast.makeText(this, "Kamu Memilih " +hero.getName(), Toast.LENGTH_SHORT).show();
            Intent intentAhmadYani = new Intent(MainActivity.this, AhmadYaniActivity.class);
            startActivity(intentAhmadYani);
        }else if (hero.getName() == "Ahmad Dahlan"){
            Toast.makeText(this, "Kamu Memilih " +hero.getName(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, AhmadDahlanActivity.class);
            startActivity(intent);
        }else if (hero.getName() == "Sutomo"){
            Toast.makeText(this, "Kamu Memilih " +hero.getName(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, AhmadDahlanActivity.class);
            startActivity(intent);
        }
    }
}