package com.example.programdasar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TempatData extends AppCompatActivity {
    //deklasi EXTRA_AGE berupa string statis
    public static final String EXTRA_AGE = "extra_age";
    //deklasi EXTRA_NAME berupa string statis
    public static final String EXTRA_NAME = "extra_name";
    //deklasi EXTRA_YEAR berupa string statis
    public static final String EXTRA_YEAR = "extra_year";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempat_data);

        //inisialisasi TextView bernama tvNama dengan id tv_nama
        TextView tvNama = findViewById(R.id.tv_nama);
        //inisialisasi TextView bernama tvUmur dengan id tv_umur
        TextView tvUmur = findViewById(R.id.tv_umur);

        //deklarsi String name dari EXTRA_NAME yang berupa String
        String name = getIntent().getStringExtra(EXTRA_NAME);
        //deklarsi int age dari EXTRA_AGE yang berupa int dengan nilai default 0
        int age = getIntent().getIntExtra(EXTRA_AGE, 0);
        //deklarsi int tahun dari EXTRA_YEAR yang berupa int dengan nilai default 0
        int tahun = getIntent().getIntExtra(EXTRA_YEAR, 0);

        //menge-set agar tvName berisi text yang ada di dalam kurung
        tvNama.setText("Halo "+name+"!");
        //menge-set agar tvUmur berisi text yang ada di dalam kurung
        tvUmur.setText("Sekarang, tahun "+tahun+", umurmu "+age+"." +
                "\nJangan lupa untuk terus semangat dan tersenyum, ya!");
    }
}