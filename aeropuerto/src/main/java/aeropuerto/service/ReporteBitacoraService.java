package aeropuerto.service;


import aeropuerto.model.VwBitacora;
import aeropuerto.repository.ReporteBitacoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReporteBitacoraService {

    @Autowired
    private ReporteBitacoraRepository repo;

    public Page<VwBitacora> listar(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
