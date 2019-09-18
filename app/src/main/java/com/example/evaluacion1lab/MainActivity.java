package com.example.evaluacion1lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Estudiante.Estudiante;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

public static List<Estudiante> listaestudiantes;
public static List<String> listaauxiliar = new ArrayList<String>();
static int contador =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaestudiantes = new ArrayList<>();

        Bundle ag = getIntent().getExtras();
        if(ag==null)
        {

        }
        else
        {
            contador = ag.getInt("contador");
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnnuevo:
            {
                Intent as = new Intent(this,agregar.class);
                as.putExtra("contador",contador);
                startActivity(as);
                break;
            }
            case R.id.btnlista:
            {
               if(listaestudiantes.size() ==0 || listaestudiantes == null )
               {
                   Toast.makeText(this,"no hay estudiantes",Toast.LENGTH_SHORT).show();
               } else
               {
                   Intent hy = new Intent(this,Lista.class);
                   startActivity(hy);
               }



                break;
            }

        }
    }
}
