package com.example.proyectobase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Servicios;

public class Clientes_act extends AppCompatActivity {
    private Spinner spClientes;
    private Spinner spServicios;
    private EditText edMontoCancelar;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);
        spClientes =(Spinner)findViewById(R.id.spn_Clientes);
        spServicios=(Spinner)findViewById(R.id.spn_Servicios);
        edMontoCancelar = (EditText)findViewById(R.id.edt_MontoCancelar);
        texto= (TextView)findViewById(R.id.txt_texto);
        ArrayList<String>listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("Lista Clientes");
        ArrayList<String>listaServicios = (ArrayList<String>) getIntent().getSerializableExtra("Lista Servicios");
        ArrayAdapter<String> adaptClientes = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        ArrayAdapter<String> adaptServicios = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaServicios);
        spClientes.setAdapter(adaptClientes);
        spServicios.setAdapter(adaptServicios);
    }
    public void ONCCalcular (View V){
        String clienteC = spClientes.getSelectedItem().toString();
        String serviciosC = spServicios.getSelectedItem().toString();
        Servicios servicio = new Servicios();
        int saldo =Integer.parseInt(edMontoCancelar.getText().toString());
        int resultCortePCorto =servicio.getCorteCabelloCorto()-saldo;
        int resultCortePlargo = servicio.getCorteCabelloLargo()-saldo ;

        if(clienteC.equals("Roberto")&& serviciosC.equals("Corte de cabello Corto"))
        {
            texto.setText("el precio de su servicio es: "+ resultCortePCorto);
        }
        if(clienteC.equals("Roberto")&& serviciosC.equals("Corte de cabello Largo"))
        {
            texto.setText("el precio de su servicio es: "+ resultCortePlargo);

        }
    }
}