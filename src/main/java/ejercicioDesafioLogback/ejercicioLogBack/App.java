package ejercicioDesafioLogback.ejercicioLogBack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Hello world!
 *
 */
public class App {
	final static Logger LOGGER = LoggerFactory.getLogger(App.class);
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Este metodo escribe todas las lineas que quieras, si quieres que haga
		// archivos zip deberas de poner mas 1.000 repeticiones
		try (FileWriter lineWritter= new FileWriter("muchasLineas.txt");	                
				Scanner op=new Scanner(System.in)) {
	            LOGGER.info("Comienzo del programa");
	            System.out.println("Escriba cuantos numeros quiere escribir");
	            int repetitions=op.nextInt();
	            //Este es el escritor en un archivo
	            for (int i=0; i<repetitions;i++) {
		            lineWritter.write(i+"\n");
	    		}
	        } catch (FileNotFoundException e) {
	            LOGGER.error("No encuentra el fichero 1");

	        } catch (IOException e1) {
	            LOGGER.error("Error padre de File");

	        }
			//Aqui leo el archivo y luego lo mando todo a las trazas
			//Hay sysouts para comprobar por consola como iba
		  try(FileReader in = new FileReader("muchasLineas.txt");
	                BufferedReader reader = new BufferedReader(in);
	                Scanner op2=new Scanner(System.in)
	                ) {

	            String texto= reader.readLine();
	            // counter de las paginas
	            int counter=0;
	            //Lee 100 lineas cada vez hasta que no encuentre mas nada
	            while(texto!=null) {
	                String fileNumbers="";
	                for(int i=0;i<=100;i++) {
	                    // Mira si queda texto o no.
	                    if(texto!=null) {
	                        fileNumbers =fileNumbers+"\n"+texto;
	                        texto=reader.readLine();
	                        counter++;
	                    }
	                }
	                LOGGER.debug(fileNumbers);
	                LOGGER.info("Se han leido: "+(counter)+" lineas");
	                LOGGER.info("-----------------------------------------------");
	                System.out.println(fileNumbers);
	                System.out.println("Se han leido: "+(counter)+" lineas");
	                System.out.println("-----------------------------------------------");
	            }
	            LOGGER.info("Fin del programa Tellez");
	        } catch (FileNotFoundException e) {
	            LOGGER.error("No encuentra el fichero 1");
	        } catch (IOException e) {
	            LOGGER.error("Error padre de File");
	        }
	    }
	}

