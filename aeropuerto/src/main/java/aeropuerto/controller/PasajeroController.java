package aeropuerto.controller;


import aeropuerto.dto.PasajeroRequest;
import aeropuerto.dto.PasajeroResponse;
import aeropuerto.model.Pasajero;
import aeropuerto.service.PasajeroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pasajeros")
public class PasajeroController {

    private final PasajeroService service;

    public PasajeroController(PasajeroService service) {
        this.service = service;
    }

    @PostMapping
    public String crear(@RequestBody PasajeroRequest pasajero) {
        return service.crear(pasajero);
    }

    @GetMapping
    public List<PasajeroResponse> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public PasajeroResponse obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PutMapping("/{id}")
    public String actualizar(@PathVariable Long id, @RequestBody PasajeroRequest request) {
        return service.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        return service.eliminar(id);
    }

}
