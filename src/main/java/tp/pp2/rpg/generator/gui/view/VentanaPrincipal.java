package tp.pp2.rpg.generator.gui.view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import tp.pp2.rpg.generator.core.entidades.rpg.generator.RpgGenerator;


public class VentanaPrincipal extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private PanelCombate panelCombate;
	private RpgGenerator rpgGenerator;

	public VentanaPrincipal(RpgGenerator rpgGenerator) {
		this.rpgGenerator=rpgGenerator;
		initialize();
	}

	private void initialize() {
		//panelCombate=new PanelCombate(rpgGenerator);
		//panelSelectorHabilidades = new PanelSelectorArchivoHabilidades(rpgGenerator,panelCombate);
		panelCombate=new PanelCombate(this.rpgGenerator);
		this.setBounds(100, 100, 1000, 1000);
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
		// TODO Auto-generated method stub
		
	}

}
