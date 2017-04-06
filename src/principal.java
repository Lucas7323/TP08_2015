import java.io.File;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class principal {

public static void main(String[] args) {
	String archivoEstadoCocheras="archivos/archivosDeAplicacion/cocheras.txt";
	ArrayList<Cochera> cocheras = new ArrayList<Cochera>();	
	try{
	File archivoLectura= new File(archivoEstadoCocheras);
	Scanner leerArchivo=new Scanner(archivoLectura);
		//inicializo las cocheras en disponible
		
		while(leerArchivo.hasNext()){
			String lineaArchivo = leerArchivo.nextLine();
			String lineaAux[]=lineaArchivo.split(";");
			cocheras.add(new Cochera(Integer.parseInt(lineaAux[0]),Boolean.parseBoolean(lineaAux[1])));
			
		}
	}catch(IOException error){
		System.out.println("error al leer archivo"+archivoEstadoCocheras );
	}
	
	//inicio array de clientes
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		
	SistemaReservasGrafica sisReserva = new SistemaReservasGrafica(cocheras,clientes);
		
	}

}
