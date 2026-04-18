package aeropuerto.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pasajero")
@Data
public class Pasajero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String pasaporte;
    private String telefono;
    private String correo;
    private String nacionalidad;
    private String estado = "ACTIVO";
}
