package microservicio;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ServicioUsuarios {

	private RepositorioUsuarios repositorioUsuarios; // Inversión de dependencias. 
														// Solo quiero un objeto de TIPO Repositorio de usuarios...
														// Me da igual la implementación... 
	
	public ServicioUsuarios(RepositorioUsuarios repositorioUsuarios) { // Inyección de dependencias
		this.repositorioUsuarios=repositorioUsuarios;
	}

	public List<Usuario> recuperarUsuarios(){
		// Podría meter comprobaciones de permisos a quien lo pide...
		return repositorioUsuarios.findAll();
	}
	public Usuario crearUsuario(Usuario usuario){
		// Podría meter comprobaciones de permisos a quien lo pide...
		// Mandar un email
		// Darlo de alta en varias BBDD
		return repositorioUsuarios.save(usuario);
	}
	
}
