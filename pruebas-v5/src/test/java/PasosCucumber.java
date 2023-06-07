import java.util.Optional;

import org.junit.jupiter.api.Assertions;

import com.curso.Diccionario;
import com.curso.SuministradorDeDiccionarios;
import com.curso.SuministradorDeDiccionariosFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

// Esto le indica a JUnit que lo que hay definido en este fichero son pruebas
@Suite
// Aqui indicamos que las pruebas deben ejecuatrse con Cucumber
@IncludeEngines("cucumber")
// Donde están los test??? En la carpeta features
@SelectClasspathResource("features")
public class PasosCucumber {

	private SuministradorDeDiccionarios miSuministrador;
	private boolean respuestaObtenida;
	private Optional<Diccionario> diccionario;
	
	@Given("un suministrador que tiene idioma {string}")
	public void un_suministrador_que_tiene_idioma(String idioma) {
		this.miSuministrador=SuministradorDeDiccionariosFactory.getInstance();
	}
	
	@Dado("un suministrador que no tiene idioma {string}")
	public void un_suministrador_que_no_tiene_idioma(String idioma) {
		this.miSuministrador=SuministradorDeDiccionariosFactory.getInstance();
	} 

	
	@Cuando("le pregunto si tiene un diccionario de idioma {string}")
	public void le_pregunto_si_tiene_un_diccionario_de_idioma(String idioma) {
		respuestaObtenida = this.miSuministrador.tienesDiccionarioDe(idioma);
	}
	
	@Entonces("me tiene que contestar que {string}")
	public void me_tiene_que_contestar_que(String respuesta) {  // si | no 
		boolean respuestaEsperada ;
		if(respuesta.equalsIgnoreCase("si"))
			respuestaEsperada = true;
		else
			respuestaEsperada = false;
		Assertions.assertEquals(respuestaEsperada,respuestaObtenida);
													// False
	}
	
	
	@Cuando("le pido un diccionario de idioma {string}")
	public void le_pido_un_diccionario_de_idioma(String idioma) {
		diccionario = this.miSuministrador.getDiccionario(idioma);
	}
	
	@Entonces("no me tiene que devolver NADA")
	public void no_me_tiene_que_devolver_nada() {
		Assertions.assertTrue(diccionario.isEmpty());
	}
	
	@Entonces("me tiene que devolver el diccionario de idioma {string}")
	public void me_tiene_que_devolver_el_diccionario_de_idioma(String idioma) {
		Assertions.assertTrue(diccionario.isPresent());
		Assertions.assertEquals(idioma, diccionario.get().getIdioma());
	}
}
