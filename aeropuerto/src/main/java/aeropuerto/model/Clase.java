package aeropuerto.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clase")
public class Clase {

    @Id
    private Long id;

    private String nombre;

}
