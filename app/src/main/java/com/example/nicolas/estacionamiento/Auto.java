package com.example.nicolas.estacionamiento;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Auto {
    private String  patente , sitio , hora_llegada;
    private int id;

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public long obtenerMinutos(){
        LocalDateTime fecha = LocalDateTime.parse(this.getHora_llegada(),  DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        long minutos = ChronoUnit.MINUTES.between(fecha, LocalDateTime.now());
        return minutos;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public long precioAPagar() {
        if( this.obtenerMinutos() < 10 ) {
            return 500;
        }
        return this.obtenerMinutos() * 50;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String obtenerHoraFormateada() {
        String[] fechaSplit = this.getHora_llegada().replace("T", " ").split(" ");
        String fecha = fechaSplit[1] + " hrs," + " del dia: " +fechaSplit[0];
        return fecha;
    }

    public String getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(String hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
