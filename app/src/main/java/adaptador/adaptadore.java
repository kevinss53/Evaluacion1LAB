package adaptador;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.evaluacion1lab.R;

import java.util.List;

import Estudiante.Estudiante;

public class adaptadore extends BaseAdapter {

    private List<Estudiante> datasource;
    private Context cntx;
    private int IdLayoutPlantilla;

    public List<Estudiante> GetData(){
        return this.datasource;
    }

    public adaptadore(Context context, int IdPlantilla, List<Estudiante> sources){
        //Inicializamos las variables
        this.cntx = context;
        this.IdLayoutPlantilla = IdPlantilla;
        this.datasource = sources;
    }



    @Override
    public int getCount() {
        return this.datasource.size();
    }

    @Override
    public Object getItem(int position) {
        return this.datasource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Validamos que no exista un formato
        if(convertView == null){
            //Creamos el Administrador de Layout
            LayoutInflater inflater = (LayoutInflater) this.cntx.getSystemService(this.cntx.LAYOUT_INFLATER_SERVICE);
            //Le damos vida al archivo xml ahora es un Layout
            convertView = inflater.inflate(this.IdLayoutPlantilla,null);

            //Buscamos los controles de nuestra plantilla
            TextView lblnombre = convertView.findViewById(R.id.txtnombre);
            TextView lblcodigo = convertView.findViewById(R.id.txtcodigo);
            TextView lblmateria = convertView.findViewById(R.id.txtmateria);
            TextView lblcorrelativo = convertView.findViewById(R.id.txtcorre);

            //Obtenemos el dato a mostrar
            lblnombre.setText(this.datasource.get(position).getNombre());
            lblmateria.setText(this.datasource.get(position).getMateria()+ ": "+ this.datasource.get(position).getPromedio());
            lblcodigo.setText(this.datasource.get(position).getCodigo() );
            String posicion = Integer.toString(position+1);
            lblcorrelativo.setText(posicion);
        }
        return convertView;
    }
}
