package aeropuerto.controller;


import aeropuerto.model.VwBitacora;
import aeropuerto.service.ReporteBitacoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reportes/bitacora")
public class ReporteBitacoraController {

    @Autowired
    private ReporteBitacoraService service;

    @GetMapping
    public ResponseEntity<Page<VwBitacora>> get(Pageable pageable) {
        return ResponseEntity.ok(service.listar(pageable));
    }
}
