package com.example.aplikasilistmakanan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> imgFoto = new ArrayList<>();
    private  ArrayList<String> nama = new ArrayList<>();
    private  ArrayList<String> harga = new ArrayList<>();
    private  ArrayList<String> infoMakanan = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDatafromInternet();
    }
    private void prosesmenuAdapater() {
        RecyclerView recyclerView = findViewById(R.id.menu);
        menuAdapter adapter = new menuAdapter(imgFoto, nama, harga, infoMakanan,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getDatafromInternet() {
        nama.add("Sate Bumbon");
        imgFoto.add("https://ramahtraveler.com/wp-content/uploads/2019/06/Sate-Bumbon-makanan-khas-kendal-@ny.rempong.jpg");
        harga.add("Rp. 20.000");
        infoMakanan.add("Sate yang diberi rempah bumbu khas Kendal");

        nama.add("Mangut Lele");
        imgFoto.add("https://ramahtraveler.com/wp-content/uploads/2019/06/Mangut-Lele-jatenglive.com_.jpg");
        harga.add("Rp. 12.000");
        infoMakanan.add("Lele dengan olahan bumbu mangut");

        nama.add("Rica - rica Menthog");
        imgFoto.add("https://ramahtraveler.com/wp-content/uploads/2019/06/Rica-Rica-Mentok-harianresep.blogspot.com_.jpg");
        harga.add("Rp. 20.000");
        infoMakanan.add("Enthok dengan bumbu rica");

        nama.add("Bandeng Tanpa Duri");
        imgFoto.add("https://ramahtraveler.com/wp-content/uploads/2019/06/Bandeng-Tanpa-Duri-Kendal-riamuriati.blogspot.com_.jpg");
        harga.add("Rp. 18.000");
        infoMakanan.add("Ikan bandeng bakar yang tidak ada durinya");

        nama.add("Brongkos");
        imgFoto.add("https://ramahtraveler.com/wp-content/uploads/2019/06/Brongkos-@tiwukdapoer.jpg");
        harga.add("Rp. 15.000");
        infoMakanan.add("Masakan sapi yang diberi bumbu khas dan kuah santan");


        prosesmenuAdapater();

    }
}