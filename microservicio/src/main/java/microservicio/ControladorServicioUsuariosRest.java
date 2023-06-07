package microservicio;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ControladorServicioUsuariosRest {

	private ServicioUsuarios servicioUsuarios;

	public ControladorServicioUsuariosRest( ServicioUsuarios servicioUsuarios ) {
		this.servicioUsuarios = servicioUsuarios;
	}

	// Cuando alguien llame por HTTP a http://miservidor.com:8080/api/v1/usuarios
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> recuperarUsuarios(){
		return new ResponseEntity<>(servicioUsuarios.recuperarUsuarios(), HttpStatus.OK);
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario){
		return new ResponseEntity<>(servicioUsuarios.crearUsuario(usuario), HttpStatus.OK);
	}
}
