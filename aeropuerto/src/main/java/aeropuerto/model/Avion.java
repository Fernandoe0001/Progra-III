package aeropuerto.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "avion")
public class Avion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String modelo;
    private String marca;
    private Integer filas;
    private Integer columnas;
    private Integer capacidad;


    @ManyToOne
    @JoinColumn(name = "estado_avion_id")
    private EstadoAvion estadoAvion;

    @ManyToOne
    @JoinColumn(name = "aerolinea_id")
    private Aerolinea aerolinea;


    }

