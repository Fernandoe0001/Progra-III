package aeropuerto.controller;


import aeropuerto.model.VwVuelos;
import aeropuerto.service.ReporteReservasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reportes/reservas")
public class ReporteReservasController {

    @Autowired
    private ReporteReservasService service;

    @GetMapping
    public ResponseEntity<Page<VwVuelos>> get(
            @RequestParam(required = false) String estado,
            @RequestParam(required = false) String vuelo,
            @RequestParam(required = false) String pasajero,
            Pageable pageable
    ) {
        return ResponseEntity.ok(service.filtrar(estado, vuelo, pasajero, pageable));
    }
}
