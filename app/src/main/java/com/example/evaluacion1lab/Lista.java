package com.example.evaluacion1lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import static com.example.evaluacion1lab.MainActivity.listaestudiantes;
import adaptador.adaptadore;

public class Lista extends AppCompatActivity {

    ListView milista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        milista = findViewById(R.id.lista);
        this.milista.setAdapter(new adaptadore(this,
                R.layout.personalizada,listaestudiantes));

    }
}
