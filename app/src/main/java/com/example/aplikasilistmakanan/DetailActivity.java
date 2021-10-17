package com.example.aplikasilistmakanan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView namaMakanan;
    TextView info;
    TextView hargaMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        namaMakanan = findViewById(R.id.namaMakanan);
        info = findViewById(R.id.info);
        hargaMakanan = findViewById(R.id.hargaMakanan);

        getIncomingExtra();

    }
    private void  getIncomingExtra() {
        if(getIntent().hasExtra("nama_makanan") && getIntent().hasExtra("info_makanan")) {
            String nama = getIntent().getStringExtra("nama_makanan");
            String harga = getIntent().getStringExtra("harga_makanan");
            String infoMakanan = getIntent().getStringExtra("info_makanan");

            setDataActivity(nama, harga, infoMakanan);
        }
    }
    private void setDataActivity(String nama, String harga, String infoMakanan) {
        namaMakanan.setText(nama);
        info.setText(infoMakanan);
        hargaMakanan.setText(harga);


    }
}