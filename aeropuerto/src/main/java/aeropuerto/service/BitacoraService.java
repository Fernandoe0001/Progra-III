package aeropuerto.service;

import aeropuerto.model.Accion;
import aeropuerto.model.Bitacora;
import aeropuerto.repository.AccionRepository;
import aeropuerto.repository.BitacoraRepository;
import org.springframework.stereotype.Service;

@Service
public class BitacoraService {

    private final BitacoraRepository bitacoraRepository;
    private final AccionRepository accionRepository;

    public BitacoraService(BitacoraRepository bitacoraRepository,
                           AccionRepository accionRepository) {
        this.bitacoraRepository = bitacoraRepository;
        this.accionRepository = accionRepository;
    }

    public void registrar(String accionNombre, String descripcion) {

        Accion accion = accionRepository.findByNombre(accionNombre)
                 .orElseThrow(() -> new RuntimeException("Acción no encontrada: " + accionNombre));

        Bitacora bitacora = new Bitacora();
        bitacora.setAccion(accion);
        bitacora.setDescripcion(descripcion);

        bitacoraRepository.save(bitacora);
        }
}

