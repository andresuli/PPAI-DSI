package ar.edu.utn.frc.cba.sismos.model;

import java.time.LocalDateTime;

public class Sismografo {
    private LocalDateTime fechaAdquisicion;
    private String identificadorSismografo;
    private String nroSerie;

    public void generar(EventoSismico evento) {
        // lógica para generar sismograma
    }

    public Object getImagen() {
        // retornar imagen del sismograma
        return null;
    }

    public void asociarEvento(EventoSismico evento) {
        // lógica para asociación
    }
}