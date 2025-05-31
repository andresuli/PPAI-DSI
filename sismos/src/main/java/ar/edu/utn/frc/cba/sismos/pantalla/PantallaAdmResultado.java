package ar.edu.utn.frc.cba.sismos.pantalla;
import ar.edu.utn.frc.cba.sismos.model.EstadoEvento;
import ar.edu.utn.frc.cba.sismos.model.EventoSismico;
import ar.edu.utn.frc.cba.sismos.model.MuestraSismica;
import ar.edu.utn.frc.cba.sismos.util.FalsaBaseDeDatos;
import ar.edu.utn.frc.cba.sismos.controller.GestorRegistrarResultadoDeRevisionManual;

import org.springframework.ui.Model; 


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping("/ruta")
public class PantallaAdmResultado {
       @GetMapping("/template")
    public String mostrarPantalla(Model model) {


      GestorRegistrarResultadoDeRevisionManual gestor = new GestorRegistrarResultadoDeRevisionManual();
      List<EventoSismico> eventos = gestor.obtenerEventosPendientesRevision();
    model.addAttribute("eventosPendientes", eventos);
        return "template"; // 
    }


        @PostMapping("/tomarDecisionEvento")
    public String tomarDecisionEvento(@RequestParam("decision") String decision , 
                                      @RequestParam("eventoId") int eventoId,
                                      RedirectAttributes redirectAttributes) {
        if(decision.equals("confirmar")) {
            decisionTomada = "confirmado";
            tomarDecisionConfirmarEvento(eventoId);
        } else if(decision.equals("bloquear")) {
            tomarDecisionBloquearEvento(eventoId);
            decisionTomada = "bloqueado";
        } else if(decision.equals("rechazar" )) {
            tomarDecisionRechazarEvento(eventoId);
            decisionTomada = "rechazado";
        }
          redirectAttributes.addFlashAttribute("mensaje", "El evento fue " + decisionTomada + " correctamente.");

       return "redirect:/ruta/template";
    }

    private GestorRegistrarResultadoDeRevisionManual gestor = new GestorRegistrarResultadoDeRevisionManual();

  @PostMapping("/bloquearEvento")
    @ResponseBody
    public ResponseEntity<String> bloquearEvento(@RequestParam("eventoId") int eventoId) {
        System.out.println("Bloquear evento con id pantalla adm: " + eventoId);
        gestor.bloquearEvento(eventoId);
        return ResponseEntity.ok("Evento bloqueado con id: " + eventoId);
    }


   @GetMapping("/traerDatos")
    @ResponseBody
    public ResponseEntity<List<MuestraSismica>> traerDatos() {
        System.out.println("Va a buscar datos al gestor ");
        List<MuestraSismica> muestras = gestor.obtenerDatosEvento();
        System.out.println("Datos obtenidos del evento seleccionado: " + muestras);
        return ResponseEntity.ok(muestras);
    }


        @GetMapping("/inicio")
        public String mostrarTemplateInicio() {
            return "inicio"; 
        }



    
    public void tomarDecisionRechazarEvento(int eventoId) {
        gestor.rechazarEvento(eventoId);
        
    }
    public void tomarDecisionConfirmarEvento(int eventoId) {
        gestor.confirmarEvento(eventoId);
    }
    public void tomarDecisionBloquearEvento(int eventoId) {
        gestor.bloquearEvento(eventoId);
    }


    private EventoSismico eventoSeleccionado;
    private String decisionTomada;
    private List<EventoSismico> grdEventosRevisados;

    // Simulación de los componentes UI
    private String txtMagnitud;
    private String txtAlcance;
    private String txtOrigen;

    public void seleccionarOpcionRegistroResultado() {
        // Acción inicial al entrar al flujo
    }

    public void mostrarEventos(List<EventoSismico> eventos) {
        this.grdEventosRevisados = eventos;
        // Mostrar en tabla
    }

    public void mostrarDatosEvento(EventoSismico evento) {
        this.eventoSeleccionado = evento;
        this.txtMagnitud = String.valueOf(evento.getMagnitud());
        this.txtAlcance = evento.getAlcance();
        this.txtOrigen = evento.getOrigen();
    }

    public void ingresarDatosEditados(String magnitud, String alcance, String origen) {
        this.txtMagnitud = magnitud;
        this.txtAlcance = alcance;
        this.txtOrigen = origen;
    }

  

    public void solicitarMapa() {
        // Acción que activa el componente mapa
    }

    public void mostrarResultado() {
        // Visualiza la decisión aplicada y el estado final
    }

    // Getters para pasar datos al gestor
    public EventoSismico getEventoSeleccionado() { return eventoSeleccionado; }
    public String getMagnitud() { return txtMagnitud; }
    public String getAlcance() { return txtAlcance; }
    public String getOrigen() { return txtOrigen; }
    public String getDecision() { return decisionTomada; }
}
