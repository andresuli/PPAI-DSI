package ar.edu.utn.frc.cba.sismos.model;

import java.time.LocalDateTime;
import java.util.List;

import ar.edu.utn.frc.cba.sismos.util.FalsaBaseDeDatos;

public class EventoSismico {
    private int id;
    private LocalDateTime fechaHoraFin;
    private LocalDateTime fechaHoraOcurrencia;
    private float latitudEpicentro;
    private float longitudEpicentro;
    private float latitudHipocentro;
    private float longitudHipocentro;
    private float magnitud;
    private String alcance; 
    private String origen; 
    private float valorRiesgo;
    private EstadoEvento estado;
    private SerieTemporal serieTemporal;

    public EventoSismico(int id , LocalDateTime fechaHoraOcurrencia, float latitudEpicentro, float longitudEpicentro, float magnitud, EstadoEvento estado, SerieTemporal serieTemporal, String alcance, String origen, 
    float latitudHipocentro, float longitudHipocentro) {
        this.fechaHoraOcurrencia = fechaHoraOcurrencia;
        this.latitudEpicentro = latitudEpicentro;
        this.longitudEpicentro = longitudEpicentro;
        this.magnitud = magnitud;
        this.estado = estado;
        this.id = id;
        this.serieTemporal = serieTemporal;
        this.alcance = alcance;
        this.origen = origen;
        this.latitudHipocentro = latitudHipocentro;
        this.longitudHipocentro = longitudHipocentro;

    }


    public static List<EventoSismico> obtenerEventosPendientesRevision() {
        List<EventoSismico> eventosPendientes;
        eventosPendientes = FalsaBaseDeDatos.getInstance().mostrarEventos()
          .stream()
          .filter(evento -> evento.getEstado().esEstado("Pendiente"))
          .toList();
        return eventosPendientes;
    }


    public List<MuestraSismica> obtenerDatosDeEvento() {
        System.out.println("Obteniendo datos del evento seleccionado a la serie...");
        return this.serieTemporal.obtenerSerie();
    }

    public void actualizarDatos(float magnitud, String alcance, String origen){
        this.magnitud = magnitud;
        // Aquí deberiamos actualizar otros atributos como alcance y origen si los tuvieramos
        // Por ejemplo, si tuvieramos atributos para alcance y origen:
        // this.alcance = alcance;
        // this.origen = origen;
    } 

    public void alianza(String origen) {
        // lógica de alianza con el origen
    }

   public void confirmar() {
        this.estado = new EstadoEvento("Confirmado", "Evento confirmado por el usuario");
    }

   public MuestraSismica getMuestraSismica() {
    if (this.serieTemporal != null && this.serieTemporal.getListaDeMuestras() != null
            && !this.serieTemporal.getListaDeMuestras().isEmpty()) {
        return this.serieTemporal.getListaDeMuestras().get(0); 
    } else {
        return null; 
    }
}

    public void bloquear() {
        this.estado = new EstadoEvento("Bloqueado", "Evento bloqueado por el usuario");
    }

    public void rechazar() {
        this.estado = new EstadoEvento("Rechazado", "Evento rechazado por el usuario");
    }

    public void eliminar() {
        // lógica para eliminar evento
    }

    public String getAlcance() {
        return this.alcance; 
    }
    public String getOrigen() {
        return this.origen;
    }

   

    // Getters y setters (opcional, pero recomendable)
    public int getId() {
        return id;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }
    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }
    public LocalDateTime getFechaHoraOcurrencia() {
        return fechaHoraOcurrencia;
    }
    public void setFechaHoraOcurrencia(LocalDateTime fechaHoraOcurrencia) {
        this.fechaHoraOcurrencia = fechaHoraOcurrencia;
    }
    public float getLatitudEpicentro() {
        return latitudEpicentro;
    }
    public void setLatitudEpicentro(float latitudEpicentro) {
        this.latitudEpicentro = latitudEpicentro;
    }
    public float getLongitudEpicentro() {
        return longitudEpicentro;
    }
    public void setLongitudEpicentro(float longitudEpicentro) {
        this.longitudEpicentro = longitudEpicentro;
    }
    public float getLatitudHipocentro() {
        return latitudHipocentro;
    }
    public void setLatitudHipocentro(float latitudHipocentro) {
        this.latitudHipocentro = latitudHipocentro;
    }
    public float getLongitudHipocentro() {
        return longitudHipocentro;
    }
    public void setLongitudHipocentro(float longitudHipocentro) {
        this.longitudHipocentro = longitudHipocentro;
    }
    public float getMagnitud() {
        return this.magnitud;
    }
    public void setMagnitud(float magnitud) {
        this.magnitud = magnitud;
    }
    public float getValorRiesgo() {
        return valorRiesgo;
    }
    public void setValorRiesgo(float valorRiesgo) {
        this.valorRiesgo = valorRiesgo;
    }
    public EstadoEvento getEstado() {
        System.out.println("Estado del evento: " + estado.getNombre() + "Estado completo: " + estado);
        return estado;
    }
    public void setEstado(EstadoEvento estado) {
        this.estado = estado;
    }


}
