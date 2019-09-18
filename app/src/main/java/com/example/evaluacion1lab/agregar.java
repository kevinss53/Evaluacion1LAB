package com.example.evaluacion1lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;

import Estudiante.Estudiante;
import static com.example.evaluacion1lab.MainActivity.listaestudiantes;

public class agregar extends AppCompatActivity implements View.OnClickListener {

    EditText nombre,codigo,materia,p1,p2,p3;
    Button guardar;
    String n,c,m,par1,par2,par3;
    int contador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        Bundle ag = getIntent().getExtras();

        this.nombre = findViewById(R.id.txtnombre);
        this.codigo = findViewById(R.id.txtcodigo);
        this.materia = findViewById(R.id.txtmateria);
        this.p1 = findViewById(R.id.txtprimerparcial);
        this.p2 = findViewById(R.id.txtsegundoparcial);
        this.p3 = findViewById(R.id.txttercerparcial);
        this.guardar = findViewById(R.id.btnguardar);

        c = nombre.getText().toString();
        n = codigo.getText().toString();
        m = materia.getText().toString();
        par1 = p1.getText().toString();
        par2 = p2.getText().toString();
        par3 = p3.getText().toString();
        contador = ag.getInt("contador");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnguardar:
            {
             //   if(c.isEmpty() || n.isEmpty() || m.isEmpty() || par1.isEmpty() || par2.isEmpty() || par3.isEmpty())
              //  {


                //    Toast.makeText(getApplicationContext(),"Inserte todos los datos",Toast.LENGTH_SHORT).show();

               // }
               // else
               // {

                    String cod = codigo.getText().toString();
                    String no = nombre.getText().toString();
                    String mater = materia.getText().toString();
                    Double parcial1 = Double.parseDouble( p1.getText().toString());
                    Double parcial2 = Double.parseDouble(p2.getText().toString()) ;
                    Double parcial3 = Double.parseDouble(p3.getText().toString()) ;

                    Estudiante e = new Estudiante();
                    e.setCodigo(cod);
                    e.setMateria(mater);
                    e.setNombre(no);
                    e.setParcial1(parcial1);
                    e.setParcial2(parcial2);
                    e.setParcial3(parcial3);
                    e.setPromedio( (parcial1+parcial2+parcial3)/3 );
                    listaestudiantes.add(e);

                    Intent principal = new Intent(this,MainActivity.class);
                    contador++;
                    principal.putExtra("contador",contador);
                    Toast.makeText(this,"agregado con exito! "+parcial1,Toast.LENGTH_SHORT).show();
                    finish();
                    //startActivity(principal);
               // }
                break;
            }
        }
    }
}
