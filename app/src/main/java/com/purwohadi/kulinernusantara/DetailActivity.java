package com.purwohadi.kulinernusantara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.purwohadi.kulinernusantara.model.Kuliner;

import java.text.NumberFormat;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Kuliner c = (Kuliner) getIntent().getSerializableExtra("objKuliner");
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Kuliner Detail");
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*Menampilkan nama judul*/
        TextView tvName = findViewById(R.id.tvName);
        tvName.setText(c.getName());

        /*Menampilkan isi*/
        TextView tvContent = findViewById(R.id.tvContent);
        tvContent.setText(c.getContent());

        /*Menampilkan gambar*/
        ImageView imageView = findViewById(R.id.imageView);
        GlideApp.with(this)
                .load(c.getPhoto())
                .apply(new RequestOptions().override(80, 80).centerCrop())
                .into(imageView);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
