package aeropuerto.repository;

import aeropuerto.model.VwVuelos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReporteVuelosRepository extends JpaRepository<VwVuelos, Long> {

    @Query("""
    SELECT v
    FROM VwVuelos v
    WHERE (:estado IS NULL OR v.estado = :estado)
    AND (:origen IS NULL OR v.origen = :origen)
    AND (:destino IS NULL OR v.destino = :destino)
""")
    Page<VwVuelos> filtrar(
            @Param("estado") String estado,
            @Param("origen") String origen,
            @Param("destino") String destino,
            Pageable pageable
    );
}
