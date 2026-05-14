package aeropuerto.repository;

import aeropuerto.model.VwBitacora;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReporteBitacoraRepository extends JpaRepository<VwBitacora, Long> {

    Page<VwBitacora> findAll(Pageable pageable);
}
