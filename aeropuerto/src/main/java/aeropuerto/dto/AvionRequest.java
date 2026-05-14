package aeropuerto.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvionRequest {

    private String modelo;
    private String marca;
    private int filas;
    private int columnas;
    private Long aerolineaId;
}
