package com.example.viewholders;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity  implements MyOnItemClick, LifecycleObserver {
    public static List<Producto> productos;
    public static final int TEXTO = 1;
    public static final int IMAGEN = 2;
    public static int positionClicked;
    //public static
    //public Handler handler = new Handler(this);
    public ProductoAdapter adap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productos = new ArrayList<>();
        Producto p1 = new Producto("Martillo",20,350.00);
        Producto p2 = new Producto("Clavo",200000,350.14);
        Producto p3 = new Producto("Destornillador",20,350.12);
        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(new Producto("Caja",10,5.00));
        productos.add(new Producto("Hojas",150,50.00));
        productos.add(new Producto("Calculadora",10,650.00));
        productos.add(new Producto("Celular",10,52033.00));
        productos.add(new Producto("Mouse",4,240.00));
        productos.add(new Producto("Teclado",10,576.30));
        productos.add(new Producto("Monitor",1,5900.00));
        productos.add(new Producto("Tornillos",1000,5.00));
        productos.add(new Producto("Zapatos de seguridad",2,8300.00));


        //PersonaAdapter pAdapter = new PersonaAdapter(personas,this);
        adap = new ProductoAdapter(productos,this);
        RecyclerView rvPersona = super.findViewById(R.id.rvProductos);
        rvPersona.setAdapter(adap);
        rvPersona.setLayoutManager(new LinearLayoutManager(this)); //uno abajo del otro
        /*
        puedo hacerlo de otras formas
        LinearLayout linearLayouut;
        linearLayout.setOrientation(REcyclerView.HORIZONTAL);
         o
         GridLayoutManager glm = new GridLAyoutManager(this,3) //genero con 3 columnas
         */

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("estoy en", "onResume: entro al onresume");
        if(FormularioEditar.productoModif != null){
            //productos.remove(positionClicked);
            productos.set(positionClicked,FormularioEditar.productoModif);
            adap.notifyDataSetChanged();
        }

    }

    @Override
    public void onItemClick(int postion) {

    Log.d("llamando a", "llamando a " + postion);
    Log.d("llamando a", "llamando a "  + productos.get(postion).getNombre());
    positionClicked = postion;
        Intent intent = new Intent(this, FormularioEditar.class);
        super.startActivity(intent);
    }

}
