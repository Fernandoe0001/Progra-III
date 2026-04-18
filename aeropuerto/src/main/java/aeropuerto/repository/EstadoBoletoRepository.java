package aeropuerto.repository;

import aeropuerto.model.EstadoBoleto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoBoletoRepository extends JpaRepository<EstadoBoleto, Long> {
}
