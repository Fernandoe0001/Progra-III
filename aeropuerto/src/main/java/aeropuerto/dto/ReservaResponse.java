package aeropuerto.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservaResponse {
    private Long boletoId;
    private String pasajero;
    private String vuelo;
    private String asiento;

    public ReservaResponse(Long boletoId, String pasajero, String vuelo, String asiento) {
        this.boletoId = boletoId;
        this.pasajero = pasajero;
        this.vuelo = vuelo;
        this.asiento = asiento;
    }

}
