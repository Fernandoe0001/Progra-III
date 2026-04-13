package aeropuerto.controller;


import aeropuerto.dto.ReservaRequest;
import aeropuerto.model.ReservaView;
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

    /*@GetMapping
    public List<ReservaView> listar() {
        return service.obtenerReservas();
    }*/

    @PostMapping
    public String crear(@RequestBody ReservaRequest request) {
        return service.crearReserva(request);
    }
}
