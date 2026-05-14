package aeropuerto.service;

import aeropuerto.dto.AvionRequest;
import aeropuerto.model.Aerolinea;
import aeropuerto.model.Avion;
import aeropuerto.model.EstadoAvion;
import aeropuerto.repository.AerolineaRepository;
import aeropuerto.repository.AvionRepository;
import aeropuerto.repository.EstadoAvionRepository;
import org.springframework.stereotype.Service;

@Service
public class AvionService {
    private final AvionRepository avionRepository;
    private final AsientoService asientoService;
    private final EstadoAvionRepository estadoAvionRepository;
    private final AerolineaRepository aerolineaRepository;

    public AvionService(AvionRepository avionRepository,
                        AsientoService asientoService,
                        EstadoAvionRepository estadoAvionRepository, AerolineaRepository aerolineaRepository) {
        this.avionRepository = avionRepository;
        this.asientoService = asientoService;
        this.estadoAvionRepository = estadoAvionRepository;
        this.aerolineaRepository = aerolineaRepository;
    }

    public String crearAvion(AvionRequest request) {

        EstadoAvion estado = estadoAvionRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));

        Aerolinea aerolinea = aerolineaRepository.findById(request.getAerolineaId())
                .orElseThrow(() -> new RuntimeException("Aerolinea no encontrada"));

        Avion avion = new Avion();
        avion.setModelo(request.getModelo());
        avion.setMarca(request.getMarca());
        avion.setFilas(request.getFilas());
        avion.setColumnas(request.getColumnas());
        avion.setAerolinea(aerolinea);
        avion.setEstadoAvion(estado);
        avion.setCapacidad(request.getFilas()* request.getColumnas());
        Avion nuevo = avionRepository.save(avion);

        //Genera asientos automáticos
        asientoService.generarAsientos(nuevo);

        return  "Avion creado con asientos completos";
    }


}
