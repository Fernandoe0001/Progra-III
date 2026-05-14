package aeropuerto.controller;

import aeropuerto.dto.LoginRequest;
import aeropuerto.model.Usuario;
import aeropuerto.repository.UsuarioRepository;
import aeropuerto.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest request) {

        Usuario usuario = usuarioRepository
                .findByCorreo(request.getCorreo())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!usuario.getPassword().equals(request.getPassword())) {

            throw new RuntimeException("Contraseña incorrecta");
        }

        String token =
                jwtService.generarToken(usuario.getCorreo());
        return ResponseEntity.ok(
                Map.of(
                        "token", token,
                        "usuario", usuario.getNombre(),
                        "rol", usuario.getRol().getNombre()
                )
        );
    }
}
