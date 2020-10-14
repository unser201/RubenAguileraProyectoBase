package com.example.proyectobase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Menu_act extends AppCompatActivity {
    private ViewFlipper vF;
    private int [] image ={R.drawable.a, R.drawable.b, R.drawable.c};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);
        vF = (ViewFlipper)findViewById(R.id.slider_Menu);
        for (int i=0; i<image.length; i++)
        {
            flip_image(image[i]);
        }
    }
    public void flip_image(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);
        vF.addView(view);
        vF.setFlipInterval(2800);
        vF.setAutoStart(true);
        vF.setInAnimation(this, android.R.anim.slide_in_left);
        vF.setOutAnimation(this, android.R.anim.slide_out_right);
    }
    public void ONCMaps(View V)
    {
        Intent i = new Intent(this, Maps_act.class);
        startActivity(i);
    }
    public void ONCInfo(View V)
    {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }
    public void ONCClientes(View V)
    {
        ArrayList<String> arregloClientes = new ArrayList<String>();
        ArrayList<String> arregloServicios = new ArrayList<String>();
        arregloClientes.add("Ivan");
        arregloClientes.add("Roberto");
        arregloServicios.add("Corte de cabello Corto");
        arregloServicios.add("Corte de cabello Largo");
        Intent i = new Intent(this, Clientes_act.class);
        i.putExtra("Lista Clientes", arregloClientes);
        i.putExtra("Lista Servicios", arregloServicios);
        startActivity(i);
    }
}