package com.curso.pruebasv5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.curso.pruebasv5.App;

public class AppTest {
    @Test
    public void probarLaFuncionSumarNumerosPositivos() {
    	int resultadoObtenido = App.sumar(10, 20);
    	int resultadoEsperado = 30;
    	Assertions.assertEquals( resultadoEsperado, resultadoObtenido);
    }    
    @Test
    public void probarLaFuncionSumarNumerosNegativos() {
    	int resultadoObtenido = App.sumar(-10, -20);
    	int resultadoEsperado = -30;
    	Assertions.assertEquals( resultadoEsperado, resultadoObtenido);
    }
    @Test
    public void probarLaFuncionSumarCero() {
    	int resultadoObtenido = App.sumar(10, 0);
    	int resultadoEsperado = 10;
    	Assertions.assertEquals( resultadoEsperado, resultadoObtenido);
    }
    @Test
    public void probarLaFuncionRestarNumerosPositivos() {
    	int resultadoObtenido = App.restar(10, 20);
    	int resultadoEsperado = -10;
    	Assertions.assertEquals( resultadoEsperado, resultadoObtenido);
    }    
}
