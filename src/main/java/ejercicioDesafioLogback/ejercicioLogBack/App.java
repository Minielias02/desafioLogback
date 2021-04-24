package ejercicioDesafioLogback.ejercicioLogBack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Hello world!
 *
 */
public class App {
	final static Logger LOGGER = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		LOGGER.info("Comienza el metodo con un info");

		for (int i=0; i<5000;i++) {
			LOGGER.debug("Esto es un debug");
			LOGGER.error("Esto es un error");
		}
		LOGGER.trace("Este no se muestra porque esta por encima ");
		LOGGER.warn("Esto es un warning");
		

	}
}
