package aeropuerto.controller;


import aeropuerto.service.VueloService;
import aeropuerto.dto.VueloRequest;
import aeropuerto.dto.VueloResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vuelos")
public class VueloController {

    private final VueloService service;

    public VueloController(VueloService service) {
        this.service = service;
    }

    @PostMapping
    public String crear(@RequestBody VueloRequest request) {
        return service.crearVuelo(request);
    }

    @GetMapping
    public List<VueloResponse> listar() {
        return service.listarVuelos();
    }

    @GetMapping("/{id}")
    public VueloResponse obtener(@PathVariable Long id) {
        return service.obtenerVuelo(id);
    }
}
