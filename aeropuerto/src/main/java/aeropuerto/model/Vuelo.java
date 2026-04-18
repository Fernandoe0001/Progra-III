package aeropuerto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "vuelo")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroVuelo;

    private LocalDateTime fechaSalida;
    private LocalDateTime fechaLlegada;

    @ManyToOne
    @JoinColumn(name = "aeropuerto_origen_id")
    private Aeropuerto aeropuertoOrigen;

    @ManyToOne
    @JoinColumn(name = "aeropuerto_destino_id")
    private Aeropuerto aeropuertoDestino;

    @ManyToOne
    @JoinColumn(name = "avion_id")
    private Avion avion;

    @ManyToOne
    @JoinColumn(name = "aerolinea_id")
    private Aerolinea aerolinea;

    @ManyToOne
    @JoinColumn(name = "estado_vuelo_id")
    private EstadoVuelo estado;
}
