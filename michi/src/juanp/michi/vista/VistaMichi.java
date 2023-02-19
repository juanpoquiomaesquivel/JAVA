package juanp.michi.vista;

import java.awt.Dimension;

import javax.swing.JFrame;

public class VistaMichi extends JFrame {

	public VistaMichi() {
		setTitle("Juego MICHI");
		setSize(400, 600);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().setPreferredSize(new Dimension(400, 600));
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(panelMenu);
		add(panelMichi);
	}

	public PanelMenu panelMenu = new PanelMenu();
	public PanelMichi panelMichi = new PanelMichi();
}
