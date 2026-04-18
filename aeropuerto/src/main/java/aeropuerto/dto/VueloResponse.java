package aeropuerto.dto;

import lombok.Getter;

@Getter
public class VueloResponse {

    private Long id;
    private String numeroVuelo;
    private String origen;
    private String destino;
    private String fechaSalida;
    private String fechaLlegada;

    public VueloResponse(Long id, String numeroVuelo, String origen, String destino, String fechaSalida, String fechaLlegada) {
        this.id = id;
        this.numeroVuelo = numeroVuelo;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
    }
}
