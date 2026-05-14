package aeropuerto.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "asiento")
public class Asiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int fila;
    private String letra;
    private String tipo; // VENTANA, PASILLO, CENTRO

    @ManyToOne
    @JoinColumn(name = "Avion_id",  nullable = false)
    private Avion avion;

}
