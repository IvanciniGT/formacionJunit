package microservicio;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;
import org.hamcrest.collection.IsCollectionWithSize;
import org.json.JSONObject;

// Levantame un servidor de pruebas(tomcat), con mi app instalada y en ejecución
// Y eso en paralelo a las pruebas
@SpringBootTest( classes = AplicacionWeb.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// ME genera un mock para conectarme
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// Fuerza a JUNIT a que delegue la creación de la instancia a Spring, para que se realice la inyección de depdendcias
@ExtendWith(SpringExtension.class)
public class ServicioUsuariosRestTest {

	private MockMvc cliente;
	
	// En este caso, como JUNIT sigue por medio, forzamos con la anotación AUTOWIRED a que Springboot inyecte esos datos.
	// JUNit en ocasiones suministra parametros en el constructor de las clases con test: PARAMETERIZED TEST
	@Autowired
	public ServicioUsuariosRestTest(MockMvc cliente) {
		this.cliente=cliente;
	}
	
	@Test
	@Order(1)
	public void probarARecuperarUsuarios() throws Exception {
		cliente.perform(MockMvcRequestBuilders.get("/api/v1/usuarios"))	
										      .andExpect(status().isOk()) // Assert JUnit
										      .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
										      .andExpect(jsonPath("$.*", IsCollectionWithSize.hasSize(0)));
	}
	@Test
	@Order(2)
	public void probarACrearUsuario() throws Exception {
		
		JSONObject datosUsuario=new JSONObject();
		datosUsuario.put("nombre","Ivan");
		datosUsuario.put("apellidos","Osuna");
		datosUsuario.put("edad",44);
		
		cliente.perform(MockMvcRequestBuilders.post("/api/v1/usuarios")
											  .contentType(MediaType.APPLICATION_JSON)
											  .content(datosUsuario.toString())
						)	
										      .andExpect(status().isCreated()) // Assert JUnit
										      .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
										      .andExpect(jsonPath("$.nombre", Matchers.is("Ivan")))
										      .andExpect(jsonPath("$.apellidos", Matchers.is("Osuna")))
										      .andExpect(jsonPath("$.edad", Matchers.is(44)));
	}

	@Test
	@Order(3)
	public void probarARecuperarUsuariosDespuesAlta() throws Exception {
		cliente.perform(MockMvcRequestBuilders.get("/api/v1/usuarios"))	
										      .andExpect(status().isOk()) // Assert JUnit
										      .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
										      .andExpect(jsonPath("$.*", IsCollectionWithSize.hasSize(1)))
										      .andExpect(jsonPath("$[0].nombre", Matchers.is("Ivan")));
	}
}
