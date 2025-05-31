
package ar.edu.utn.frc.cba.sismos.controller;

import ar.edu.utn.frc.cba.sismos.model.EventoSismico;
import ar.edu.utn.frc.cba.sismos.model.MuestraSismica;
import ar.edu.utn.frc.cba.sismos.model.SerieTemporal;
import ar.edu.utn.frc.cba.sismos.model.Sismografo;
import ar.edu.utn.frc.cba.sismos.util.FalsaBaseDeDatos;
import ar.edu.utn.frc.cba.sismos.model.ServicioNotificacion;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class GestorRegistrarResultadoDeRevisionManual {

    private EventoSismico eventoSeleccionado;
    private List<EventoSismico> eventosPendientes;
    private Map<String, String> datosEditados = new HashMap<>();
    private String decisionTomada;

    public List<EventoSismico> obtenerEventosPendientesRevision() {
        // Consulta al modelo para obtener eventos pendientes
        this.eventosPendientes = EventoSismico.obtenerEventosPendientesRevision();
        return this.eventosPendientes; 
    }

    public void iniciarRegistroRevision(List<EventoSismico> pendientes) {
        this.eventosPendientes = pendientes;
    }

    public void validarEventoSeleccionado(EventoSismico evento) {
        // Validación lógica de selección
        this.eventoSeleccionado = evento;
    }

    public List<MuestraSismica> obtenerDatosEvento() {
        System.out.println("Obteniendo datos del evento seleccionado al model...");
        return this.eventoSeleccionado.obtenerDatosDeEvento();
    }


    

    public void editarDatosEvento(String magnitud, String alcance, String origen) {
        this.datosEditados.put("magnitud", magnitud);
        this.datosEditados.put("alcance", alcance);
        this.datosEditados.put("origen", origen);
        this.eventoSeleccionado.actualizarDatos(
            Float.parseFloat(magnitud),
            alcance,
            origen
        );
    }


    
    public void bloquearEvento(int eventoId) {
        

           // Buscar evento en la base de datos falsa
    this.eventoSeleccionado = FalsaBaseDeDatos.getInstance().mostrarEventos()
        .stream()
        .filter(e -> e.getId() == eventoId)
        .findFirst()
        .orElse(null);

    if (eventoSeleccionado != null) {
        eventoSeleccionado.bloquear();  // Cambiar estado a bloqueado
    } else {
        System.out.println("No se encontró evento con id: " + eventoId);
    }
    }

    public void tomarDecisionEvento(String decision) {
        this.decisionTomada = decision;
    }

    public void actualizarEstadoEvento() {
        switch (decisionTomada) {
            case "Confirmar":
                eventoSeleccionado.confirmar();
                break;
            case "Rechazar":
                eventoSeleccionado.rechazar();
                break;
            case "Derivar":
                //eventoSeleccionado.derivar(); 
                break;
        }
    }

    public void rechazarEvento(int id){
        eventoSeleccionado.rechazar();
    }
    public void confirmarEvento(int id) {
        eventoSeleccionado.confirmar();
    }

    public void generarSismograma() {
        new Sismografo().generar(eventoSeleccionado);
    }

    public void mostrarMapa() {
        // Muestra las coordenadas del evento y estaciones asociadas
    }

    public void notificarResultado() {
        new ServicioNotificacion().enviarNotificacion(eventoSeleccionado);
    }
}
