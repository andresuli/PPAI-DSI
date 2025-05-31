package ar.edu.utn.frc.cba.sismos.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SerieTemporal {
    private LocalDateTime fechaInicioRegistroMuestras;
    private LocalDateTime fechaHoraRegistro;
    private float frecuenciaMuestreo;
    private List<MuestraSismica> listaDeMuestras;
    private Sensor sensor;

    public SerieTemporal obtenerSerie(EventoSismico evento) {
        // lógica para obtener serie
        return this;
    }


      public SerieTemporal() {
        this.listaDeMuestras = new ArrayList<>(); // inicializo la lista vacía
    }

    public SerieTemporal(List<MuestraSismica> listaDeMuestras) {
        this.listaDeMuestras = listaDeMuestras;
    }

    public List<MuestraSismica> getListaDeMuestras() {
        return listaDeMuestras;
    }

    public void setListaDeMuestras(List<MuestraSismica> listaDeMuestras) {
        this.listaDeMuestras = listaDeMuestras;
    }

    public List<MuestraSismica> obtenerSerie() {
        System.out.println("Obteniendo serie de muestras sismicas..." + this.listaDeMuestras);
        return this.listaDeMuestras;
    }

    public void agregarMuestra(MuestraSismica muestra) {
        this.listaDeMuestras.add(muestra);
    }
    

@Override
public String toString() {
    return "SerieTemporal{" +
           "fechaInicioRegistroMuestras=" + fechaInicioRegistroMuestras +
           ", fechaHoraRegistro=" + fechaHoraRegistro +
           ", frecuenciaMuestreo=" + frecuenciaMuestreo +
           ", listaDeMuestras=" + listaDeMuestras +
           '}';
}


    
   
}