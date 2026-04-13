package aeropuerto.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vw_reservas_completo")
@Data
public class ReservaView {

    @Id
    private String pasaporte; //campo único

    private String usuario;
    private String pasajero;
    private String numero_vuelo;
    private String origen;
    private String destino;
    private String asiento;
    private String clase;
    private String estado;
}
