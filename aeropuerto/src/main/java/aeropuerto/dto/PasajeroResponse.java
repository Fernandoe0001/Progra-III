package aeropuerto.dto;

import lombok.Getter;

@Getter
public class PasajeroResponse {
    private Long id;
    private String nombre;
    private String pasaporte;
    private String telefono;
    private String correo;
    private String nacionalidad;
    private String estado;

    public PasajeroResponse(Long id, String nombre,
                            String pasaporte, String telefono,
                            String correo, String nacionalidad, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.pasaporte = pasaporte;
        this.telefono = telefono;
        this.correo = correo;
        this.nacionalidad = nacionalidad;
        this.estado = estado;
    }
}
