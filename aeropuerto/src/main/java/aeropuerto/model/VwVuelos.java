package aeropuerto.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vw_vuelos")
@Data
public class VwVuelos {

    @Id
    private Long id;

    @Column(name = "numero_vuelo")
    private String numeroVuelo;

    private String origen;
    private String destino;
    private String estado;
}