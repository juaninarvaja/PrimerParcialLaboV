package com.example.viewholders;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class FormularioEditar extends AppCompatActivity implements View.OnClickListener {
    //Handler hand = new Handler(this);
    public static Producto productoModif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        productoModif = null;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alta_pantalla);
        ActionBar toolbar = getSupportActionBar();
        toolbar.setDisplayHomeAsUpEnabled(true);
//        Producto model = new Producto();
//        EditController controller = new EditController(model);
//        EditView view = new EditView(this,controller,model);
//        controller.setView(view);

        Button button = (Button)findViewById(R.id.botonGuardar);
        button.setOnClickListener(this);
        EditText etNombre = super.findViewById(R.id.etNombre);
        EditText etCantidad = super.findViewById(R.id.etCantidad);
        EditText etPrecio = super.findViewById(R.id.etPrecio);
        etNombre.setText(MainActivity.productos.get(MainActivity.positionClicked).getNombre());
        etCantidad.setText(MainActivity.productos.get(MainActivity.positionClicked).getCantidad().toString());
        etPrecio.setText(MainActivity.productos.get(MainActivity.positionClicked).getPrecio().toString());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu m){
        super.getMenuInflater().inflate(R.menu.menu, m);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== android.R.id.home){
            Intent i = new Intent(this,MainActivity.class);
            super.finish();//tengo q cerrar el activity y vuelve al home pq nunca se cerro
        }
        return true;
    }


    @Override
    public void onClick(View view) {
        EditText etNombre = super.findViewById(R.id.etNombre);
        EditText etCantidad = super.findViewById(R.id.etCantidad);
        EditText etPrecio = super.findViewById(R.id.etPrecio);
        Log.d("clickeo en el alta", "onClick: hizo click");
        Integer in = Integer.parseInt(etCantidad.getText().toString());
        Double db = Double.parseDouble(etPrecio.getText().toString());
        Producto p = new Producto(etNombre.getText().toString(), in,db);
        if(p != null){
            productoModif = p;
        }
        super.finish();
        Log.d("la persona es", "onClick: " +p.toString());
    }


}
