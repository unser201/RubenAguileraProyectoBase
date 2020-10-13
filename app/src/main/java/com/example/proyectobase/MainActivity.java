package com.example.proyectobase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText usuario;
    private EditText password;
    private CheckBox opcionMostrar;
    private ProgressBar progressLogin;
    private Button botonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = (EditText) findViewById(R.id.edtxt_LoginUsuario);
        password = (EditText) findViewById(R.id.edtxt_LoginContraseña);
        opcionMostrar =(CheckBox)findViewById(R.id.ckb_MostrarContraseñaL);
        progressLogin = (ProgressBar) findViewById(R.id.pgb_LoginProgress);
        progressLogin.setVisibility(View.INVISIBLE); // hace invisible el progress bar
        botonLogin = (Button)findViewById(R.id.btn_LoginIniciar);
        botonLogin.setOnClickListener(new View.OnClickListener() // hace inversa la funcion del onclick
        {
            @Override
            public void onClick(View view) {
                new Task().execute(); // ejecuta la tarea asincrona
            }
        });
    }
    class Task extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            progressLogin.setVisibility(View.VISIBLE); // se hace visible el progress baar
        }

        @Override
        protected String doInBackground(String... strings) {
            for (int i =1 ; i<3; i++)
            {
                try
                {
                    Thread.sleep(1000); //tarea pesada o hilo
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s)
        {
            progressLogin.setVisibility(View.INVISIBLE);
            String user = usuario.getText().toString().trim();
            String pass = password.getText().toString().trim();
            if (user.equals("Android") && pass.equals("123"))
            {
                Toast.makeText(getApplicationContext(),"Ha iniciado sesión correctamente",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getBaseContext(), Menu_act.class);
                startActivity(i);
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Nombre o contraseña incorrectos",Toast.LENGTH_SHORT).show();
            }
        }
    }

    /*public void ONCiniciar(View V)
    {
        String user = usuario.getText().toString().trim();
        String pass = password.getText().toString().trim();
        if (user.equals("Android") && pass.equals("123"))
        {

            Toast.makeText(getApplicationContext(),"Ha iniciado sesión correctamente",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, Menu_act.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Nombre o contraseña incorrectos",Toast.LENGTH_SHORT).show();
        }
    }*/
    public void ONCOpcionMostrar(View V)
    {
        if (opcionMostrar.isChecked() == true)
        {
            password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        }
        else
        {
            password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }
}