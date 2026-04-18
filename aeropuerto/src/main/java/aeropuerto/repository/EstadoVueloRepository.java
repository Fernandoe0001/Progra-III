package aeropuerto.repository;

import aeropuerto.model.EstadoVuelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoVueloRepository extends JpaRepository<EstadoVuelo, Long> {
}
