package aeropuerto.controller;

import aeropuerto.dto.AsientoResponse;
import aeropuerto.service.AsientoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AsientoController {

    private final AsientoService service;

    public AsientoController(AsientoService service) {
        this.service = service;
    }

    @GetMapping("/vuelos/{id}/asientos")
    public List<AsientoResponse> obtener(@PathVariable Long id) {
        return service.obtenerAsientosPorVuelo(id);
    }
}
