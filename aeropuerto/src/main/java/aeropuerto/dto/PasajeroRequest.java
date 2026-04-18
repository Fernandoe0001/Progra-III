package aeropuerto.dto;

import lombok.*;

@Getter
@Setter
public class PasajeroRequest {

    private String nombre;
    private String pasaporte;
    private String telefono;
    private String correo;
    private String nacionalidad;
    private String estado;

}
