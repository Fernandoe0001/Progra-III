package aeropuerto.repository;

import aeropuerto.model.Aerolinea;
import aeropuerto.model.Aeropuerto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AerolineaRepository extends JpaRepository<Aerolinea, Long> {
}
