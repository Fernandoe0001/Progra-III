package aeropuerto.repository;

import aeropuerto.model.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoletoRepository extends JpaRepository<Boleto,Long> {
    boolean existsByAsiento_IdAndVuelo_IdAndEstado_IdNot(Long asientoId, Long vueloId, Long estadoId);
}
