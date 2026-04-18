package aeropuerto.controller;


import aeropuerto.dto.ReservaRequest;
import aeropuerto.dto.ReservaResponse;
import aeropuerto.service.ReservaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService service;

    public ReservaController(ReservaService service) {
        this.service = service;
    }

    @PostMapping
    public String crear(@RequestBody ReservaRequest request) {
        return service.crearReserva(request);
    }

    @GetMapping
    public List<ReservaResponse> listar() {
        return service.listarReservas();
    }

    @DeleteMapping("/{id}")
    public String cancelar(@PathVariable Long id) {
        return service.cancelarReserva(id);
    }
}
