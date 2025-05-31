/* package ar.edu.utn.frc.cba.sismos.dominio;

import ar.edu.utn.frc.cba.sismos.model.EstadoEvento;
import ar.edu.utn.frc.cba.sismos.model.EventoSismico;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final EventoSismico eventoRepo;
    private final EstadoEvento estadoRepo;

    public DataLoader(EventoSismico eventoRepo, EstadoEvento estadoRepo) {
        this.eventoRepo = eventoRepo;
        this.estadoRepo = estadoRepo;
    }

    @Override
    public void run(String... args) {

        // Crear estados si no existen
        EstadoEvento detectado = new EstadoEvento("Detectado", "Evento sísmico detectado automáticamente");
        EstadoEvento confirmado = new EstadoEvento("Confirmado", "Evento confirmado por un analista");
        EstadoEvento rechazado = new EstadoEvento("Rechazado", "Evento rechazado tras revisión");

        estadoRepo.save(detectado);
        estadoRepo.save(confirmado);
        estadoRepo.save(rechazado);

        // Crear eventos sísmicos
        EventoSismico e1 = new EventoSismico();
        e1.setFechaHoraOcurrencia(LocalDateTime.of(2025, 5, 1, 14, 30));
        e1.setLatitudEpicentro(-31.4f);
        e1.setLongitudEpicentro(-64.2f);
        e1.setMagnitud(4.5f);
        e1.setAlcance("Moderado");
        e1.setOrigen("Natural");
        e1.setEstado(detectado);

        EventoSismico e2 = new EventoSismico();
        e2.setFechaHoraOcurrencia(LocalDateTime.of(2025, 5, 2, 9, 10));
        e2.setLatitudEpicentro(-32.9f);
        e2.setLongitudEpicentro(-68.8f);
        e2.setMagnitud(5.2f);
        e2.setAlcance("Alto");
        e2.setOrigen("Artificial");
        e2.setEstado(detectado);

        EventoSismico e3 = new EventoSismico();
        e3.setFechaHoraOcurrencia(LocalDateTime.of(2025, 5, 3, 17, 45));
        e3.setLatitudEpicentro(-24.7f);
        e3.setLongitudEpicentro(-65.4f);
        e3.setMagnitud(3.9f);
        e3.setAlcance("Bajo");
        e3.setOrigen("Indeterminado");
        e3.setEstado(confirmado);

        eventoRepo.save(e1);
        eventoRepo.save(e2);
        eventoRepo.save(e3);
    }
}
 */