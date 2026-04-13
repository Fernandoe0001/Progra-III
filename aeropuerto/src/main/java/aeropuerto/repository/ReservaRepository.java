package aeropuerto.repository;


import aeropuerto.model.ReservaView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<ReservaView, String> {
}
