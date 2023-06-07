package com.curso.pruebasv4;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {
    @Test
    public void probarLaFuncionSumarNumerosPositivos() {
    	int resultadoObtenido = App.sumar(10, 20);
    	int resultadoEsperado = 30;
    	Assert.assertEquals( resultadoEsperado, resultadoObtenido);
    }    
    @Test
    public void probarLaFuncionSumarNumerosNegativos() {
    	int resultadoObtenido = App.sumar(-10, -20);
    	int resultadoEsperado = -30;
    	Assert.assertEquals( resultadoEsperado, resultadoObtenido);
    }
    @Test
    public void probarLaFuncionSumarCero() {
    	int resultadoObtenido = App.sumar(10, 0);
    	int resultadoEsperado = 10;
    	Assert.assertEquals( resultadoEsperado, resultadoObtenido);
    }
    @Test
    public void probarLaFuncionRestarNumerosPositivos() {
    	int resultadoObtenido = App.restar(10, 20);
    	int resultadoEsperado = -10;
    	Assert.assertEquals( resultadoEsperado, resultadoObtenido);
    }    
}
