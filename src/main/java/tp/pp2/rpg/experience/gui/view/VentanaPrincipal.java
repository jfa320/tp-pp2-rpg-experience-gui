package tp.pp2.rpg.experience.gui.view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import tp.pp2.rpg.experience.core.entidades.Batalla;


public class VentanaPrincipal extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private PanelCombate panelCombate;
	private Batalla batalla;

	public VentanaPrincipal(Batalla batalla) {
		this.batalla=batalla;
		panelCombate=new PanelCombate(this.batalla);
		initialize();
	}

	private void initialize() {
		this.setBounds(100, 100, 1000, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setPanelCombate();
	}

	private void setPanelCombate() {
		panelCombate.setBounds(30, 1, 1000, 1000);
		panelCombate.setLayout(null);
		panelCombate.setVisible(true);
		this.getContentPane().add(panelCombate);
	}
	public void mostrar() {
		this.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
	}

}
