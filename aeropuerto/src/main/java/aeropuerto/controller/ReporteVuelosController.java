package aeropuerto.controller;


import aeropuerto.model.VwVuelos;
import aeropuerto.service.ReporteVuelosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reportes/vuelos")
public class ReporteVuelosController {

    @Autowired
    private ReporteVuelosService service;

    @GetMapping
    public ResponseEntity<Page<VwVuelos>> get(
            @RequestParam(required = false) String estado,
            @RequestParam(required = false) String origen,
            @RequestParam(required = false) String destino,
            Pageable pageable
    ) {
        return ResponseEntity.ok(service.filtrar(estado, origen, destino, pageable));
    }
}
