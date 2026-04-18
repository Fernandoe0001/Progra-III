package aeropuerto.controller;

import aeropuerto.model.Bitacora;
import aeropuerto.repository.BitacoraRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bitacora")
public class BitacoraController {

    private final BitacoraRepository repository;

    public BitacoraController(BitacoraRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Bitacora> listar() {
        return repository.findAll();
    }
}
