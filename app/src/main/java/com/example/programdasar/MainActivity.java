package com.example.programdasar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //deklarasi EditText yang diberi nama edtNama
    private EditText edtNama;

    //deklarasi EditText yang diberi nama edtTLahir
    private EditText edtTLahir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //membuat edtNama diisi oleh komponen dangan id edt_nama dan edt_tlahir
        edtNama = findViewById(R.id.edt_nama);

        //membuat edtTLahir diisi oleh komponen dangan id edt_tlahir
        edtTLahir = findViewById(R.id.edt_tlahir);

        //variabel yang dibuat untuk mengontrol tombol btn_submit
        Button btnSub = findViewById(R.id.btn_submit);

        //membuat btnSub bisa menjalankan program lain saat di tekan dengan click listener.
        btnSub.setOnClickListener(this);

    }

    //ini adalah block code yang akan bekerja jika layar disentuh / ditekan
    @Override
    public void onClick(View v) {
        //jika komponen dengan id btn_submit ditekan, maka program dibawah ini akan berjalan
        if (v.getId() == R.id.btn_submit){
            //membuat variabel nama dengan mengambil edtNama yang sudah diubah ke string
            String nama = edtNama.getText().toString();
            //membuat variabel lahir dengan mengambil edtTLahir yang sudah diubah ke string dan di trim
            String lahir = edtTLahir.getText().toString().trim();

            //block dibawah ini adalah validasi input
            //ini adalah variabel boolean yang akan menentukan apakah salah satu input kosong atau tidak dengan nilai true atau false
            boolean isEmptyFields = false;
            //jika variabel nama kosong, maka akan mengubah variabel isEmptyFields jadi true
            if (TextUtils.isEmpty(nama)) {
                isEmptyFields = true;
                //edtNama akan memunculkan peringatan "Field ini tidak boleh kosong"
                edtNama.setError("Field ini tidak boleh kosong");
            }

            //jika variabel lahir kosong, maka akan mengubah variabel isEmptyFields jadi true
            if (TextUtils.isEmpty(lahir)) {
                isEmptyFields = true;
                //edtTlahir akan memunculkan peringatan "Field ini tidak boleh kosong"
                edtTLahir.setError("Field ini tidak boleh kosong");
            }

            //jika isEmptyFields false, maka akan menjalankan kode di dalam blok
            if (!isEmptyFields) {
                //mendeklarasi Intent bernama moveWithDataIntent dengan MainActivity sebagai tempat awal dan TempatData sebagai tempat berpindah
                Intent moveWithDataIntent = new Intent(MainActivity.this, TempatData.class);
                //mengatur agar variabel konstan EXTRA_NAME yang ada di TempatData diisi oleh variabel nama
                moveWithDataIntent.putExtra(TempatData.EXTRA_NAME, nama);
                //mengatur agar variabel konstan EXTRA_AGE yang ada di TempatData diisi oleh tahun sekarang dan dikurangi dengan variabel lahir yang sudah diubah ke string
                moveWithDataIntent.putExtra(TempatData.EXTRA_AGE, Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(lahir));
                //mengatur agar variabel konstan EXTRA_YEAR yang ada di TempatData diisi oleh tahun sekarang
                moveWithDataIntent.putExtra(TempatData.EXTRA_YEAR, Calendar.getInstance().get(Calendar.YEAR));
                //ini akan memindahkan activity dari MainActivity ke TempatData
                startActivity(moveWithDataIntent);

            }
        }
    }
}