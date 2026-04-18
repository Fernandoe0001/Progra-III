package aeropuerto.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Bitacora")
public class Bitacora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "accion_id")
    private Accion accion;

    /*@ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;*/

    public Bitacora() {
        this.fecha = LocalDate.now();
    }


}
