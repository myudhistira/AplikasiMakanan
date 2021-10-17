package com.example.aplikasilistmakanan;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class menuAdapter extends RecyclerView.Adapter<menuAdapter.viewHolder>{

    private ArrayList<String> imgFoto = new ArrayList<>();
    private ArrayList<String> nama = new ArrayList<>();
    private ArrayList<String> harga = new ArrayList<>();
    private ArrayList<String> infoMakanan = new ArrayList<>();
    private Context context;

    public menuAdapter(ArrayList<String> imgFoto, ArrayList<String> nama, ArrayList<String> harga,ArrayList<String> infoMakanan, Context context) {
        this.imgFoto = imgFoto;
        this.nama = nama;
        this.harga = harga;
        this.infoMakanan = infoMakanan;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        viewHolder holder = new viewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Glide.with(context).asBitmap().load(imgFoto.get(position)).into(holder.imgFoto);
        holder.nama.setText(nama.get(position));
        holder.harga.setText(harga.get(position));

        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, nama.get(position), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra("nama_makanan", nama.get(position));
                intent.putExtra("harga_makanan", harga.get(position));
                intent.putExtra("info_makanan", infoMakanan.get(position));

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return nama.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imgFoto;
        TextView nama;
        TextView harga;
        ConstraintLayout itemLayout;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgFoto);
            nama = itemView.findViewById(R.id.namaMakanan);
            harga = itemView.findViewById(R.id.harga);
            itemLayout = itemView.findViewById(R.id.itemLayout);

        }
    }
}