package aeropuerto.service;

import aeropuerto.dto.VueloRequest;
import aeropuerto.dto.VueloResponse;
import aeropuerto.model.*;
import aeropuerto.service.BitacoraService;
import aeropuerto.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VueloService {

    private final VueloRepository vueloRepository;
    private final AeropuertoRepository aeropuertoRepository;
    private final AvionRepository avionRepository;
    private final AerolineaRepository aerolineaRepository;
    private final BitacoraService bitacoraService;
    private final EstadoVueloRepository estadoVueloRepository;

    public VueloService(VueloRepository vueloRepository,
                        AeropuertoRepository aeropuertoRepository,
                        AvionRepository avionRepository,
                        AerolineaRepository aerolineaRepository,
                        BitacoraService bitacoraService,
                        EstadoVueloRepository estadoVueloRepository) {
        this.vueloRepository = vueloRepository;
        this.aeropuertoRepository = aeropuertoRepository;
        this.avionRepository = avionRepository;
        this.aerolineaRepository = aerolineaRepository;
        this.bitacoraService = bitacoraService;
        this.estadoVueloRepository = estadoVueloRepository;
    }

    //CREAR VUELO
    public String crearVuelo(VueloRequest request) {

        if (request.getAeropuertoOrigenId().equals(request.getAeropuertoDestinoId())) {
            throw new RuntimeException("Origen y destino no pueden ser iguales");
        }

        if (request.getFechaSalida().isAfter(request.getFechaLlegada())) {
            throw new RuntimeException("La fecha de salida no puede ser posterior a la fecha de llegada");
        }

        Aeropuerto origen = aeropuertoRepository.findById(request.getAeropuertoOrigenId())
                .orElseThrow(() -> new RuntimeException("Origen no encontrado"));

        Aeropuerto destino = aeropuertoRepository.findById(request.getAeropuertoDestinoId())
                .orElseThrow(() -> new RuntimeException("Destino no encontrado"));

        Avion avion = avionRepository.findById(request.getAvionId())
                .orElseThrow(() -> new RuntimeException("Avión no encontrado"));

        Aerolinea aerolinea = aerolineaRepository.findById(request.getAerolineaId())
                .orElseThrow(() -> new RuntimeException("Aerolinea no encontrada"));

        Vuelo vuelo = new Vuelo();
        vuelo.setNumeroVuelo(request.getNumeroVuelo());
        vuelo.setAeropuertoOrigen(origen);
        vuelo.setAeropuertoDestino(destino);
        vuelo.setFechaSalida(request.getFechaSalida());
        vuelo.setFechaLlegada(request.getFechaLlegada());
        vuelo.setAvion(avion);
        vuelo.setAerolinea(aerolinea);

        EstadoVuelo estado = estadoVueloRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));
        vuelo.setEstado(estado);
        vueloRepository.save(vuelo);

        // BITÁCORA
        bitacoraService.registrar(
                "CREAR_VUELO",
                "Vuelo creado: " + vuelo.getNumeroVuelo()
        );
        return "Vuelo creado correctamente";
    }

    // LISTAR VUELOS
        public List<VueloResponse> listarVuelos() {

            return vueloRepository.findAll().stream().map(v ->

                    new VueloResponse(
                            v.getId(),
                            v.getNumeroVuelo(),
                            v.getAeropuertoOrigen().getNombre(),
                            v.getAeropuertoDestino().getNombre(),
                            v.getFechaSalida().toString(),
                            v.getFechaLlegada().toString()
                    )
            ).toList();
        }

        //OBTENER POR ID
        public VueloResponse obtenerVuelo(Long id) {

            Vuelo v = vueloRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));

            return new VueloResponse(
                    v.getId(),
                    v.getNumeroVuelo(),
                    v.getAeropuertoOrigen().getNombre(),
                    v.getAeropuertoDestino().getNombre(),
                    v.getFechaSalida().toString(),
                    v.getFechaLlegada().toString()
            );
        }

        //BITÁCORA
        /*private void registrarBitacora(String accionNombre, String descripcion) {
            Accion accion = accionRepository.findByNombre(accionNombre)
                    .orElseThrow(() -> new RuntimeException("Acción no encontrada"));

            Bitacora b = new Bitacora();
            b.setAccion(accionEntity);
            b.setDescripcion(descripcion);
            b.setFechaHora(LocalDateTime.now());

            bitacoraRepository.save(b);
        }*/
}
