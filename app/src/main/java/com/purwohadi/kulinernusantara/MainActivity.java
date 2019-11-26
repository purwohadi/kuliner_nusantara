package com.purwohadi.kulinernusantara;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.purwohadi.kulinernusantara.adapter.ListKulinerAdapter;
import com.purwohadi.kulinernusantara.model.Kuliner;
import com.purwohadi.kulinernusantara.model.KulinerData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHeroes;
    private ArrayList<Kuliner> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvHeroes = findViewById(R.id.rv_kuliner);
        rvHeroes.setHasFixedSize(true);

        list.addAll(KulinerData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        ListKulinerAdapter listHeroAdapter = new ListKulinerAdapter(this,list);
        rvHeroes.setAdapter(listHeroAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    /*Jika diklik menu kanan*/
    public void setMode(int selectedMode) {
        switch (selectedMode) {
            /*case R.id.action_home:
                break;*/
            case R.id.action_about:
                Intent moveIntent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(moveIntent);

                //Toast.makeText(getApplicationContext(),"Ini adalah about",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
