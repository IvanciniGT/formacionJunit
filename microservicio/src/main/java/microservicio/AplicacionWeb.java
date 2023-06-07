package microservicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AplicacionWeb {

	public static void main(String[] args) {
		SpringApplication.run(AplicacionWeb.class, args);
		// Springboot buscará en es paquete y subpaquetes las cosas que tengo definidas en autom.
		// Yo podría incluso pedirle que las busque en otros paquetes...
	}
	
}
