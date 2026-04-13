package aeropuerto.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ReservaRequest {
    private int PasajeroId;
    private Long vueloId;
    private String nombrePasajero;
    private String pasaporte;
    private Long asientoId;
    private Long claseId;


}
