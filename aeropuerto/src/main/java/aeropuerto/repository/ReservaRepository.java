package aeropuerto.repository;


import aeropuerto.model.VwReserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<VwReserva, String> {
}
