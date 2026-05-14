package aeropuerto.service;

import aeropuerto.dto.AsientoResponse;
import aeropuerto.model.Asiento;
import aeropuerto.model.Avion;
import aeropuerto.model.Vuelo;
import aeropuerto.repository.AsientoRepository;
import aeropuerto.repository.BoletoRepository;
import aeropuerto.repository.VueloRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsientoService {
    private final AsientoRepository asientoRepository;
    private final VueloRepository vueloRepository;
    private final BoletoRepository boletoRepository;

    public AsientoService(AsientoRepository asientoRepository,
                          VueloRepository vueloRepository,
                          BoletoRepository boletoRepository) {
        this.asientoRepository = asientoRepository;
        this.vueloRepository = vueloRepository;
        this.boletoRepository = boletoRepository;
    }

    public void generarAsientos(Avion avion) {

        int filas = 30;
        String[] letras = {"A", "B", "C", "D", "E", "F"};

        for (int i = 1; i <= filas; i++) {
            for (String letra  : letras) {

                Asiento a = new Asiento();
                a.setAvion(avion);
                a.setFila(i);
                a.setLetra(letra);

                //lógica tipo asiento
                if (letra.equals("A") || letra.equals("F")) {
                    a.setTipo("VENTANA");
                } else if (letra.equals("C") || letra.equals("D")) {
                    a.setTipo("PASILLO");
                } else {
                    a.setTipo("CENTRO");
                }
                asientoRepository.save(a);
            }
        }
    }

    public List<AsientoResponse> obtenerAsientosPorVuelo(Long vueloId){

        Vuelo vuelo = vueloRepository.findById(vueloId)
                .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));

        List<Asiento> asientos = asientoRepository
                .findByAvion_Id(vuelo.getAvion().getId());

        return asientos.stream().map(a -> {

            boolean ocupado = boletoRepository
                    .existsByAsiento_IdAndVuelo_IdAndEstado_IdNot(a.getId(), vueloId, 1L);

            String estado = ocupado ? "OCUPADO" : "DISPONIBLE";

            return new AsientoResponse(
                    a.getId(),
                    a.getFila(),
                    a.getLetra(),
                    a.getTipo(),
                    estado
            );

        }).toList();
    }
}
