package aeropuerto.service;


import aeropuerto.model.VwReserva;
import aeropuerto.model.VwVuelos;
import aeropuerto.repository.ReporteReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReporteReservasService {

    @Autowired
    private ReporteReservasRepository repo;

    public Page<VwVuelos> filtrar(String estado, String vuelo, String pasajero, Pageable pageable) {
        return repo.filtrar(estado, vuelo, pasajero, pageable);
    }
}
