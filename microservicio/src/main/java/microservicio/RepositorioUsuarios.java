package microservicio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioUsuarios extends JpaRepository<Usuario, Long>{

	List<Usuario> findByEdadGreaterThan(Integer edadMinima);	
	
}

// YA ESTA !
// delete, save, update, find...getById