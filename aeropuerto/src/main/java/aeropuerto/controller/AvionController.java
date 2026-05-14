package aeropuerto.controller;

import aeropuerto.dto.AvionRequest;
import aeropuerto.model.Avion;
import aeropuerto.repository.AvionRepository;
import aeropuerto.service.AvionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/aviones")
public class AvionController {

    private final AvionService avionService;

    public AvionController(AvionService avionService) {
        this.avionService = avionService;
    }

    @PostMapping
    public String crear(@RequestBody AvionRequest request) {
        return avionService.crearAvion(request);
    }
}
