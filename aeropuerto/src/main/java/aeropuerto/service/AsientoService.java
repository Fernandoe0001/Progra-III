package aeropuerto.service;

import aeropuerto.dto.AsientoResponse;
import aeropuerto.model.Asiento;
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

    public List<AsientoResponse> obtenerAsientosPorVuelo(Long vueloId){

        Vuelo vuelo = vueloRepository.findById(vueloId)
                .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));

        List<Asiento> asientos = asientoRepository
                .findByAvion_Id(vuelo.getAvion().getId());

        return asientos.stream().map(a -> {

            boolean ocupado = boletoRepository
                    .existsByAsiento_IdAndVuelo_Id(a.getId(), vueloId);

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
