package aeropuerto.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vw_reservas_completo")
@Data
public class VwReserva {

    @Id
    @Column(name ="boleto_id")
    private Long boletoId;

    private String pasajero;

    @Column(name = "numero_vuelo")
    private String numeroVuelo;

    private String origen;
    private String destino;
    private String asiento;
    private String estado;
}
