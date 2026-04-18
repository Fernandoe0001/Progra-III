package aeropuerto.repository;

import aeropuerto.model.Accion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccionRepository extends JpaRepository<Accion, Long> {

    Optional<Accion> findByNombre(String nombre);
}
