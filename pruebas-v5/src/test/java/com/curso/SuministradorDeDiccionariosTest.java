package com.curso;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
public class SuministradorDeDiccionariosTest {

	private SuministradorDeDiccionarios miSuministrador;

	@BeforeAll
	public void obtenerSuministrador() {
		this.miSuministrador = SuministradorDeDiccionariosFactory.getInstance();
	}
	
    @Test
    @DisplayName("Preguntar por un diccionario existente al suministrador")
    @Order(1)
    public void preguntarDiccionarioExistente() {
    	boolean resultadoObtenido = miSuministrador.tienesDiccionarioDe("ES");
    	Assertions.assertTrue(resultadoObtenido);
    }
    
    @Test
    @DisplayName("Preguntar por un diccionario no existente al suministrador")
    @Order(1)
    public void preguntarDiccionarioInexistente() {
    	boolean resultadoObtenido = miSuministrador.tienesDiccionarioDe("ELFICO");
    	Assertions.assertFalse(resultadoObtenido);
    }

    @Test
    @DisplayName("Recuperar un diccionario existente")
    @Order(2)
    public void recuperarDiccionarioExistente() {
    	String idiomaSolicitado = "ES";
    	Optional<Diccionario> resultadoObtenido = miSuministrador.getDiccionario(idiomaSolicitado);
    	Assertions.assertTrue(resultadoObtenido.isPresent());
    	Assertions.assertEquals(idiomaSolicitado, resultadoObtenido.get().getIdioma());
    }

    @Test
    @DisplayName("Solicitar un diccionario no existente")
    @Order(2)
    public void recuperarDiccionarioInexistente() {
    	Optional<Diccionario> resultadoObtenido = miSuministrador.getDiccionario("ELFICO");
    	Assertions.assertTrue(resultadoObtenido.isEmpty());
    }
    
}
