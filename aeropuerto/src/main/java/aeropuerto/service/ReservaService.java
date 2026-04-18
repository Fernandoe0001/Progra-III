package aeropuerto.service;


import aeropuerto.dto.ReservaRequest;
import aeropuerto.dto.ReservaResponse;
import aeropuerto.service.BitacoraService;
import aeropuerto.model.*;
import aeropuerto.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private AsientoRepository asientoRepository;

    @Autowired
    private PasajeroRepository pasajeroRepository;

    @Autowired
    private BoletoRepository boletoRepository;

    @Autowired
    private VueloRepository vueloRepository;

    @Autowired
    private ClaseRepository claseRepository;

    @Autowired
    private EstadoBoletoRepository estadoBoletoRepository;
    @Autowired
    private EstadoBoletoRepository estadoRepo;

    @Autowired
    private BitacoraService bitacoraService;

    //CREAR RESERVA
    public String crearReserva(ReservaRequest request) {
        //VALIDAR ASIENTO OCUPADO
        boolean ocupado = boletoRepository
                .existsByAsiento_IdAndVuelo_Id(
                        request.getAsientoId(),
                        request.getVueloId()
                );

        if (ocupado) {
            throw new RuntimeException("El asiento ya está ocupado en este vuelo");
        }
        //OBTENER ASIENTO
        Asiento asiento = asientoRepository.findById(request.getAsientoId())
                .orElseThrow(() -> new RuntimeException("Asiento no encontrado"));
        //OBTENER VUELO
        Vuelo vuelo = vueloRepository.findById(request.getVueloId())
                .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));
        //VALIDAR QUE ASIENTO TENGA AVION
        if (asiento.getAvion() == null) {
            throw new RuntimeException("El asiento no tiene un avión asignado");
        }
        //VALIDAR QUE ASIENTO PERTENECE A MISMO AVION
        if (!asiento.getAvion().getId().equals(vuelo.getAvion().getId())) {
            throw new RuntimeException("El asiento no pertenece al avión de este vuelo");
        }
        //CREAR PASAJERO (EVITAR DUPLICADO POR PASAPORTE)
        Pasajero pasajero = pasajeroRepository
                .findByPasaporte(request.getPasaporte())
                .orElseGet(() -> {
                    Pasajero nuevo = new Pasajero();
                    nuevo.setNombre(request.getNombrePasajero());
                    nuevo.setPasaporte(request.getPasaporte());
                    nuevo.setNacionalidad(request.getNacionalidad());
                    return pasajeroRepository.save(nuevo);
                });

        // 🔥 VALIDACION
        if (!asiento.getAvion().getId().equals(vuelo.getAvion().getId())) {
            throw new RuntimeException("El asiento no pertenece a este vuelo");
        }

        Boleto boleto = new Boleto();
        boleto.setAsiento(asiento);
        boleto.setVuelo(vuelo);
        boleto.setPasajero(pasajero);

        EstadoBoleto estado = estadoRepo.findById(1L)
                        .orElseThrow(() -> new RuntimeException("Estado no encontrado"));
        Clase clase = claseRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));
        boleto.setEstado(estado);
        boleto.setClase(clase);

        boletoRepository.save(boleto);


        // BITÁCORA
        bitacoraService.registrar(
                "CREAR_RESERVA",
                "Reserva creada ID: " + boleto.getId()
        );

        return "Reserva creada exitosamente";
    }

    //LISTAR RESERVAS
    public List<ReservaResponse> listarReservas() {

        return boletoRepository.findAll().stream().map(b ->

                new ReservaResponse(
                        b.getId(),
                        b.getPasajero().getNombre(),
                        b.getVuelo().getNumeroVuelo(),
                        b.getAsiento().getFila() + b.getAsiento().getLetra()
                )
        ).toList();
    }

    //CANCELAR RESERVA
    public String cancelarReserva(Long id) {

        Boleto boleto = boletoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Boleto no encontrado"));

        boletoRepository.delete(boleto);

        //registrarBitacora("CANCELAR_RESERVA", "Reserva cancelada ID: " + id);

        return "Reserva cancelada exitosamente";
    }


}
