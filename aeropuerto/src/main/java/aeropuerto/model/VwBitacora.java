package aeropuerto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vw_bitacora")
public class VwBitacora {

    @Id
    private Long id;

    private String accion;
    private String descripcion;
    private String fecha;
}
