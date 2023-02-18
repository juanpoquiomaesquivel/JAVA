package juanp.michi;

import juanp.michi.controlador.ControladorMichi;
import juanp.michi.modelo.ModeloMichi;
import juanp.michi.vista.VistaMichi;

public class Principal {

	public static void main(String[] args) {
		var modeloMichi = new ModeloMichi(null, null);
		var vistaMichi = new VistaMichi();
		var controladorMichi = new ControladorMichi(modeloMichi, vistaMichi);
		controladorMichi.iniciar();
		vistaMichi.setVisible(true);
	}
}
