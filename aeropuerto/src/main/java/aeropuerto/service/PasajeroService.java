package aeropuerto.service;

import aeropuerto.dto.PasajeroRequest;
import aeropuerto.dto.PasajeroResponse;
import aeropuerto.model.Pasajero;
import aeropuerto.service.BitacoraService;
import aeropuerto.repository.PasajeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasajeroService {

    private final PasajeroRepository repository;
    private final BitacoraService bitacoraService;

    public PasajeroService(PasajeroRepository repository,
                           BitacoraService bitacoraService) {
        this.repository = repository;
        this.bitacoraService = bitacoraService;
    }

    // CREAR PASAJERO
    public String crear(PasajeroRequest request) {

        if (repository.existsByPasaporte(request.getPasaporte())) {
            throw new RuntimeException("Pasaporte ya existe");
        }

        Pasajero p = new Pasajero();
        p.setNombre(request.getNombre());
        p.setPasaporte(request.getPasaporte());
        p.setTelefono(request.getTelefono());
        p.setCorreo(request.getCorreo());
        p.setNacionalidad(request.getNacionalidad());
        p.setEstado("ACTIVO");

        repository.save(p);

        //BITÁCORA
        bitacoraService.registrar("CREAR_PASAJERO", "Pasajero creado: " + p.getNombre() + " - " + p.getPasaporte());

        return "Pasajero creado con éxito";
    }

    //LISTAR SOLO ACTIVOS
    public List<PasajeroResponse> listar() {

        return repository.findByEstado("ACTIVO").stream()
                .map(p -> new PasajeroResponse(
                        p.getId(),
                        p.getNombre(),
                        p.getPasaporte(),
                        p.getTelefono(),
                        p.getCorreo(),
                        p.getNacionalidad(),
                        p.getEstado()
                ))
                .toList();
    }

    // OBTENER POR ID
    public PasajeroResponse obtener(Long id) {

        Pasajero p = repository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Pasajero no encontrado"));

        if (!"ACTIVO".equals(p.getEstado())) {
            throw new RuntimeException("Pasajero inactivo");
        }
        return new PasajeroResponse(
                p.getId(),
                p.getNombre(),
                p.getPasaporte(),
                p.getTelefono(),
                p.getCorreo(),
                p.getNacionalidad(),
                p.getEstado()
        );
    }

    //ACTUALIZAR
    public String actualizar(Long id, PasajeroRequest request) {

        Pasajero p = repository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Pasajero no encontrado"));

        if (!"ACTIVO".equals(p.getEstado())) {
            throw new RuntimeException("No se puede actualizar un Pasajero inactivo");
        }

        p.setNombre(request.getNombre());
        p.setPasaporte(request.getPasaporte());
        p.setTelefono(request.getTelefono());
        p.setCorreo(request.getCorreo());
        p.setNacionalidad(request.getNacionalidad());

        repository.save(p);

        return "Pasajero actualizado";
    }

    //ELIMINAR O INACTIVAR
    public String eliminar(Long id) {

        Pasajero p = repository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Pasajero no encontrado"));

        p.setEstado("INACTIVO");

        repository.save(p);

        return "Pasajero eliminado";
    }

}