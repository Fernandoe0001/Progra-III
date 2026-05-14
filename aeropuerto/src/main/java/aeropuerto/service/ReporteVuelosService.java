package aeropuerto.service;


import aeropuerto.model.VwVuelos;
import aeropuerto.repository.ReporteVuelosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReporteVuelosService {

    @Autowired
    private ReporteVuelosRepository repo;

    public Page<VwVuelos> filtrar(String estado, String origen, String destino, Pageable pageable) {
        return repo.filtrar(estado, origen, destino, pageable);
    }
}
