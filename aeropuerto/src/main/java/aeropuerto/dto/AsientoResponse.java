package aeropuerto.dto;

import lombok.Getter;

@Getter
public class AsientoResponse {

    private Long id;
    private int fila;
    private String letra;
    private String tipo;
    private String estado; //DISPONIBLE / OCUPADO

    public AsientoResponse(Long id, int fila, String letra, String tipo, String estado) {
        this.id = id;
        this.fila = fila;
        this.letra = letra;
        this.tipo = tipo;
        this.estado = estado;
    }
}
