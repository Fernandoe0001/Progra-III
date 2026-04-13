package aeropuerto.service;


import aeropuerto.dto.ReservaRequest;
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

    public String crearReserva(ReservaRequest request) {

        boolean ocupado = boletoRepository
                .existsByAsiento_IdAndVuelo_Id(
                        request.getAsientoId(),
                        request.getVueloId()
                );

        if (ocupado) {
            throw new RuntimeException("El asiento ya está ocupado en este vuelo");
        }

        Asiento asiento = asientoRepository.findById(request.getAsientoId())
                .orElseThrow(() -> new RuntimeException("Asiento no encontrado"));

        Vuelo vuelo = vueloRepository.findById(request.getVueloId())
                .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));

        Pasajero pasajero = pasajeroRepository.findById(request.getPasajeroId())
                .orElseThrow(() -> new RuntimeException("Pasajero no encontrado"));

        // 🔥 VALIDACIÓN PRO
        if (!asiento.getAvion().getId().equals(vuelo.getAvion().getId())) {
            throw new RuntimeException("El asiento no pertenece a este vuelo");
        }

        Boleto boleto = new Boleto();
        boleto.setAsiento(asiento);
        boleto.setVuelo(vuelo);
        boleto.setPasajero(pasajero);

        boletoRepository.save(boleto);

        return "Reserva creada exitosamente";
    }
}
