//package com.example.clase2;
package com.example.viewholders;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoViewHolder> {

    private List<Producto> productos;
    private MyOnItemClick listener;

    public ProductoAdapter(List<Producto> productos, MyOnItemClick listener ){
        this.productos = productos;
        this.listener = listener;
    }
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_persona,parent,false);
        ProductoViewHolder vh = new ProductoViewHolder(view,listener);
        Log.d("On create", "On create Persona");
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
         Producto p = this.productos.get(position);
        Log.d("persona null", "onBindViewHolder: " + p.toString());
         if(p.getNombre() != null){
             Log.d("persona es", "onBindViewHolder: " + p.toString());
                holder.tvNombre.setText(p.getNombre());
                holder.tvPrecio.setText(p.getPrecio().toString());
                holder.tvCantidad.setText(p.getCantidad().toString());
//             holder.tvNombre.setText(p.getNombre());
//             holder.tvPrecio.setText(p.getPrecio());
                holder.setPosition(position);
         }

//         if(p.getByteImg() != null){
//             //Log.d("el nombre es","es"+p.getByteImg().length);
//             holder.ivImage.setImageBitmap(BitmapFactory.decodeByteArray(p.getByteImg(),0,p.getByteImg().length));
//         }

         Log.d("On bind", "On bind persona en posicion" + position);
    }

    @Override
    public int getItemCount() {
        return this.productos.size();
    }
}
