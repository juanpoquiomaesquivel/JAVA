package prueba_maven_jar;

import com.google.gson.JsonObject;
import com.juanp.clases.Impresora;
import com.juanp.principal.ConvertidorJson;

public class Principal {

	public static void main(String[] args) {
		String str = ConvertidorJson.convertirObjetoAString(new Carro("python"));
		System.out.println(str);
		JsonObject obj = ConvertidorJson.convertirObjectoAJsonObject(new Impresora("AX1", 2005, 4.56));
		System.out.println(obj);
	}
}

class Carro {
	
	private String nombre;
	
	public Carro(String nombre) {
		this.nombre = nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
}

// Funciona bien importandolo en el Classpath (no funciona en module Path)