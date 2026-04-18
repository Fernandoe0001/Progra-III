package aeropuerto.repository;

import aeropuerto.model.Asiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.LongToDoubleFunction;

@Repository
public interface AsientoRepository extends JpaRepository<Asiento, Long> {

    List<Asiento> findByAvion_Id(Long avionId);
}
