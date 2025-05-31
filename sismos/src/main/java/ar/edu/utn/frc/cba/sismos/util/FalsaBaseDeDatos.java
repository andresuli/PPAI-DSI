package ar.edu.utn.frc.cba.sismos.util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ar.edu.utn.frc.cba.sismos.model.EstadoEvento;
import ar.edu.utn.frc.cba.sismos.model.EventoSismico;
import ar.edu.utn.frc.cba.sismos.model.MuestraSismica;
import ar.edu.utn.frc.cba.sismos.model.SerieTemporal;

public class FalsaBaseDeDatos {

    private List<EventoSismico> eventos;
    private List<EstadoEvento> estados;
    private static FalsaBaseDeDatos instancia;

    private FalsaBaseDeDatos() {

        estados = new ArrayList<>();
        estados.add(new EstadoEvento("Pendiente", "Evento pendiente de revisión"));
        estados.add(new EstadoEvento("Confirmado", "Evento confirmado por el usuario"));
        estados.add(new EstadoEvento("Rechazado", "Evento rechazado por el usuario"));

        EstadoEvento pendiente = estados.stream()
                                       .filter(e -> e.esEstado("Pendiente"))
                                       .findFirst()
                                       .orElse(null);


        List<MuestraSismica> muestras1 = new ArrayList<>();
        muestras1.add(new MuestraSismica(1.2f, LocalDateTime.of(2023, 9, 10, 14, 30), 3.5f, 1.1f, 0.5f));
        muestras1.add(new MuestraSismica(0.8f, LocalDateTime.of(2023, 9, 10, 14, 31), 3.4f, 1.0f, 0.6f));
        SerieTemporal serie1 = new SerieTemporal(muestras1);

        List<MuestraSismica> muestras2 = new ArrayList<>();
        muestras2.add(new MuestraSismica(2.1f, LocalDateTime.of(2023, 9, 12, 9, 15), 3.8f, 1.2f, 0.7f));
        SerieTemporal serie2 = new SerieTemporal(muestras2);

        List<MuestraSismica> muestras3 = new ArrayList<>();
        muestras3.add(new MuestraSismica(3.5f, LocalDateTime.of(2023, 9, 15, 18, 45), 4.0f, 1.5f, 0.8f));
        SerieTemporal serie3 = new SerieTemporal(muestras3);

        List<MuestraSismica> muestras4 = new ArrayList<>();
        muestras4.add(new MuestraSismica(1.0f, LocalDateTime.of(2023, 9, 20, 11, 0), 2.5f, 0.9f, 0.4f));
        SerieTemporal serie4 = new SerieTemporal(muestras4);
        // Crear lista hardcodeada de eventos sísmicos
       eventos = new ArrayList<>(List.of(
        new EventoSismico(1,
            LocalDateTime.of(2023, 9, 10, 14, 30),
            -16.5f,
            -68.1f,
            4.5f,
            pendiente,
            serie1,
            "Alcance 1",
            "Origen volcánico",
            12.5f, 
            63.1f  
        ),
        new EventoSismico(2,
            LocalDateTime.of(2023, 9, 12, 9, 15),
            -17.0f,
            -67.8f,
            5.1f,
            pendiente,
            serie2,
            "Alcance 2",
            "Origen tectónico",
            47.0f,
            57.8f  
        ),
        new EventoSismico(3,
            LocalDateTime.of(2023, 9, 15, 18, 45),
            -15.0f,
            -70.0f,
            6.2f,
            pendiente,
            serie3,
            "Alcance 3",
            "Origen sísmico",
            12.0f,
            72.0f
        ),
        new EventoSismico(4,
            LocalDateTime.of(2023, 9, 20, 11, 0),
            -18.0f,
            -69.5f,
            3.8f,
            pendiente,
            serie4,
            "Alcance 4",
            "Origen tectónico",
            19.0f,
            68.5f
        )
    ));
        // Podés agregar más eventos
    }

    public static FalsaBaseDeDatos getInstance() {
        if (instancia == null) {
            instancia = new FalsaBaseDeDatos();
        }
        return instancia;
    }

    public List<EventoSismico> mostrarEventos() {
    return eventos;
}


   
}
