package com.curso;


import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

@TestInstance(Lifecycle.PER_CLASS)
public class DiccionarioTest {

	private Diccionario miDiccionario;

	
	//@AfterAll
	//@AfterEach
	//@BeforeEach
	@BeforeAll
	public void obtenerSuministrador() {
		this.miDiccionario = SuministradorDeDiccionariosFactory.getInstance().getDiccionario("ES").get();
	}

	@ParameterizedTest
	@DisplayName("Preguntar a un diccionario por una palabra que tiene definida")
	@ValueSource(strings = {"manzana", "MANZANA", "Manzana"})
	public void preguntarPorPalabraExistente(String palabra) {
		boolean existe = this.miDiccionario.existe(palabra);
		Assertions.assertTrue(existe);
	}

	@ParameterizedTest
	@DisplayName("Preguntar a un diccionario por una palabra que tiene no definida")
	@ValueSource(strings = {"manana", "MANANA", "Manana"})
	public void preguntarPorPalabraInexistente(String palabra) {
		boolean existe = this.miDiccionario.existe(palabra);
		Assertions.assertFalse(existe);
	}

	@ParameterizedTest
	@DisplayName("Solicitar las definiciones de una palabra que existe en el diccionario")
	@CsvSource({"manzana,1,Fruta del manzano", "Perro,2,Animal de compañía"})
	public void definicionesDePalabraExistente(String palabra, int numeroDeSignificados, String primeraDefinicion) {
		Optional<List<String>> definiciones = this.miDiccionario.getDefiniciones(palabra);
		Assertions.assertTrue(definiciones.isPresent());
		Assertions.assertEquals(numeroDeSignificados, definiciones.get().size());
		Assertions.assertEquals(primeraDefinicion, definiciones.get().get(0));
	}
	@ParameterizedTest
	@DisplayName("Solicitar las definiciones de una palabra que existe en el diccionario")
	@CsvFileSource(resources = "/palabrasExistentes.csv", numLinesToSkip = 1)
	public void definicionesDePalabraExistenteDesdeFichero(String palabra, int numeroDeSignificados, String primeraDefinicion) {
		Optional<List<String>> definiciones = this.miDiccionario.getDefiniciones(palabra);
		Assertions.assertTrue(definiciones.isPresent());
		Assertions.assertEquals(numeroDeSignificados, definiciones.get().size());
		Assertions.assertEquals(primeraDefinicion, definiciones.get().get(0));
	}

}
