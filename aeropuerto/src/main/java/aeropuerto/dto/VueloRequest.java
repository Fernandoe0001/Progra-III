package aeropuerto.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class VueloRequest {

    private String numeroVuelo;
    private Long aeropuertoOrigenId;
    private Long aeropuertoDestinoId;
    private LocalDateTime fechaSalida;
    private LocalDateTime fechaLlegada;
    private Long avionId;
    private Long aerolineaId;


}
