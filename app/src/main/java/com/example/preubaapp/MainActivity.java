package com.example.preubaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);
    }

    public void empezarJuego(View vista){

        Intent i=new Intent(this,PantallaInicio.class);
        startActivity(i);
    }

}