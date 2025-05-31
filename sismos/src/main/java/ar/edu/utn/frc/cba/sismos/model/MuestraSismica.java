package ar.edu.utn.frc.cba.sismos.model;

import java.time.LocalDateTime;

public class MuestraSismica {
    private float valor;
    private LocalDateTime fechaHora;
    private float velocidadOnda;
    private float frecuenciaOnda;
    private float longitudOnda;

     public MuestraSismica(float valor, LocalDateTime fechaHora, float velocidadOnda, float frecuenciaOnda, float longitudOnda) {
        this.valor = valor;
        this.fechaHora = fechaHora;
        this.velocidadOnda = velocidadOnda;
        this.frecuenciaOnda = frecuenciaOnda;
        this.longitudOnda = longitudOnda;
    }

    public MuestraSismica obtenerMuestra(EventoSismico evento) {
        // lógica para obtener muestra
        return this;
    }

    @Override
public String toString() {
    return "MuestraSismica{" +
           "valor=" + valor +
           ", fechaHora=" + fechaHora +
           ", velocidadOnda=" + velocidadOnda +
           ", frecuenciaOnda=" + frecuenciaOnda +
           ", longitudOnda=" + longitudOnda +
           '}';
}



  public float getValor() {
        return valor;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public float getVelocidadOnda() {
        return velocidadOnda;
    }

    public float getFrecuenciaOnda() {
        return frecuenciaOnda;
    }

    public float getLongitudOnda() {
        return longitudOnda;
    }
}
