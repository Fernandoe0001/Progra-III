package aeropuerto.repository;

import aeropuerto.model.Aeropuerto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AeropuertoRepository extends JpaRepository<Aeropuerto, Long> {
}
