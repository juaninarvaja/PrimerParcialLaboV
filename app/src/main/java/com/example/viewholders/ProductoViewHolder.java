package com.example.viewholders;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

public class ProductoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public View view;


    TextView tvNombre;
    TextView tvPrecio;
    TextView tvCantidad;
    MyOnItemClick listener;
    int position;


    public ProductoViewHolder(@NonNull View itemView, MyOnItemClick listener)  {
        super(itemView);
        this.view = itemView;
        this.tvNombre = view.findViewById(R.id.tvItemNombre);
        this.tvPrecio = view.findViewById(R.id.tvPrecio);
        this.tvCantidad = view.findViewById(R.id.tvCantidad);

        itemView.setOnClickListener(this);
        this.listener = listener;

    }
    public void setPosition(int position){
        this.position = position;
    }
    @Override
    public void onClick(View view) {
        //Log.d("llamando a", "ENTRO A ONclICK EN pERSONA vIEW HOLDER");
        listener.onItemClick(position);
    }
}
