package tp.pp2.rpg.experience.gui.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.gui.BotonListener;


public class VentanaPrincipal extends JFrame implements BotonListener{

	private static final long serialVersionUID = 1L;
	private PanelBatalla panelCombate;
	private PanelHabilidad panelHabilidad;
	private Batalla batalla;
	

	public VentanaPrincipal(Batalla batalla) {
		this.batalla=batalla;
		panelCombate=new PanelBatalla(this.batalla);
		panelHabilidad = new PanelHabilidad(this.batalla);
		panelHabilidad.registerListener(this);
		initialize();
	}

	private void initialize() {
		this.setBounds(100, 100, 1000, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setTitle("RPG Battle Experience");
		Image icono = new ImageIcon(this.getClass().getClassLoader().getResource("images\\iconoApp.png")).getImage();
		this.setIconImage(icono);
		this.setPanel(panelHabilidad);
	}

	private void setPanel(JPanel panel) {
		panel.setBounds(0, 0, 1000, 1000);
		panel.setLayout(null);
		panel.setVisible(true);
		this.getContentPane().add(panel);
	}
	public void mostrar() {
		this.setVisible(true);
	}

	@Override
	public void botonEjecutado() {
		this.setPanel(panelCombate);
	}
}
