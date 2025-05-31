# Proyecto Sistema de Eventos Sísmicos
---

## Requisitos

- Java 17+ (o versión compatible con Spring Boot del proyecto)
- Maven 3.6+
- IDE o editor de texto (IntelliJ, VSCode, Eclipse, etc.)
- Navegador web para acceder a la aplicación

---

## Cómo iniciar el proyecto


Ejecutar la aplicación con Maven:

mvn spring-boot:run

Abrir en el navegador la siguiente URL para acceder a la aplicación:

http://localhost:8080/ruta/inicio
para el CU =>
http://localhost:8080/ruta/template
Estructura y datos iniciales

La clase FalsaBaseDeDatos contiene una lista de objetos EventoSismico con datos hardcodeados para facilitar pruebas.

Los estados (EstadoEvento) se definen con atributos de nombre y descripción dentro de cada evento, sin necesidad de subclases específicas para cada estado.

En la vista Thymeleaf, el <select> muestra los eventos pendientes usando su id como valor, que luego se pasa al backend para identificar el evento sobre el cual se tomará alguna decisión.

Consideraciones
La lógica de negocio para confirmar, bloquear o rechazar eventos está implementada en métodos dentro de la clase EventoSismico.

Se utiliza Thymeleaf para renderizar las vistas HTML y mostrar la lista de eventos dinámicamente.

Cómo agregar nuevos eventos o estados
Modificar la lista de eventos en la clase FalsaBaseDeDatos para agregar nuevos objetos EventoSismico con sus respectivos estados.

Asegurarse de que cada evento tenga un id único para su correcta identificación en la interfaz y el backend.

Ejemplo de agregado del campo id en EventoSismico

public class EventoSismico {
    private Integer id;
    private LocalDateTime fechaHoraOcurrencia;
    private float latitud;
    private float longitud;
    private float magnitud;
    private EstadoEvento estado;

    // Constructor, getters y setters incluyendo id

    public EventoSismico(Integer id, LocalDateTime fechaHoraOcurrencia, float latitud, float longitud, float magnitud, EstadoEvento estado) {
        this.id = id;
        this.fechaHoraOcurrencia = fechaHoraOcurrencia;
        this.latitud = latitud;
        this.longitud = longitud;
        this.magnitud = magnitud;
        this.estado = estado;
    }

    // otros métodos relevantes
}