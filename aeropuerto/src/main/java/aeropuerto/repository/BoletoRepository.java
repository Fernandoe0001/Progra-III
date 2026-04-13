package aeropuerto.repository;

import aeropuerto.model.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoletoRepository extends JpaRepository<Boleto,Integer> {
    boolean existsByAsiento_IdAndVuelo_Id(Long asientoId, Long vueloId);
}
