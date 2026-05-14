package aeropuerto.repository;

import aeropuerto.model.EstadoAvion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoAvionRepository extends JpaRepository<EstadoAvion, Long> {
}
