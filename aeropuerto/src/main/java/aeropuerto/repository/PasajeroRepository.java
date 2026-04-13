package aeropuerto.repository;

import aeropuerto.model.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasajeroRepository extends JpaRepository<Pasajero,Integer> {
    Optional<Pasajero> findByPasaporte(String pasaporte);
}
