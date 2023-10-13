package tp.pp2.rpg.experience.gui.view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tp.pp2.rpg.experience.core.entidades.Batalla;


public class VentanaPrincipal extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private PanelBatalla panelCombate;
	private PanelHabilidad panelHabilidad;
	private Batalla batalla;

	public VentanaPrincipal(Batalla batalla) {
		this.batalla=batalla;
		panelCombate=new PanelBatalla(this.batalla);
		panelHabilidad = new PanelHabilidad();
		initialize();
	}

	private void initialize() {
		this.setBounds(100, 100, 1000, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setTitle("RPG Battle Experience");
		this.setPanel(panelHabilidad);
	}

	private void setPanel(JPanel panel) {
		panel.setBounds(30, 1, 1000, 1000);
		panel.setLayout(null);
		panel.setVisible(true);
		this.getContentPane().add(panel);
	}
	public void mostrar() {
		this.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
	}

}
