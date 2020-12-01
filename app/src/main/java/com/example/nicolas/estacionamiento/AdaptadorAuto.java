package com.example.nicolas.estacionamiento;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorAuto extends BaseAdapter {
    private Context context;
    private ArrayList<Auto> autos;

    public AdaptadorAuto(Context context, ArrayList<Auto> autos) {
        this.context = context;
        this.autos = autos;
    }

    @Override
    public int getCount() {
        return autos.size();
    }

    @Override
    public Object getItem(int i) {
        return autos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Auto auto = (Auto) getItem(i);
        view = LayoutInflater.from(context).inflate(R.layout.item, null);
        TextView titulo_patente = view.findViewById(R.id.titulo_patente);
        TextView textSitio = view.findViewById(R.id.textSitio);
        TextView textHoraLlegada = view.findViewById(R.id.textHoraLlegada);

        titulo_patente.setText("Patente: "+auto.getPatente());
        textSitio.setText("Ubicado en Sitio: "+ auto.getSitio());
        textHoraLlegada.setText("Hora llegada: "+auto.getHora_llegada());
        return view;
    }
}
