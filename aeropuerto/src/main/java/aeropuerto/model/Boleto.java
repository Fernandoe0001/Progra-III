package aeropuerto.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "boleto")
@Data

public class Boleto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pasajero_id")
    private Pasajero pasajero;

    @ManyToOne
    @JoinColumn(name = "id_asiento")
    private Asiento asiento;

    @ManyToOne
    @JoinColumn(name = "vuelo_id")
    private Vuelo vuelo;

}