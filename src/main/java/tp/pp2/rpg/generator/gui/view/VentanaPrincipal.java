package tp.pp2.rpg.generator.gui.view;

import javax.swing.JFrame;

import tp.pp2.rpg.generator.core.entidades.asignadorHabilidades.AsignadorHabilidades;


public class VentanaPrincipal extends JFrame{

	private static final long serialVersionUID = 1L;
	private PanelSelectorArchivoHabilidades panelSelectorHabilidades;
	private PanelCombate panelCombate;
	private AsignadorHabilidades asignadorHabilidades;

	public VentanaPrincipal(AsignadorHabilidades asignadorHabilidades) {
		this.asignadorHabilidades=asignadorHabilidades;
		initialize();
	}

	private void initialize() {
		panelCombate=new PanelCombate(asignadorHabilidades);
		panelSelectorHabilidades = new PanelSelectorArchivoHabilidades(asignadorHabilidades,panelCombate);
		this.setBounds(100, 100, 1000, 1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setVisible(true);
		this.setPanelInicial();
		this.setPanelCombate();
	}

	public void setPanelInicial() {
		panelSelectorHabilidades.setBounds(51, 29, 1000, 1000);
		panelSelectorHabilidades.setLayout(null);
		panelSelectorHabilidades.setVisible(true);
		this.getContentPane().add(panelSelectorHabilidades);
	}

	private void setPanelCombate() {
		panelCombate.setBounds(30, 1, 1000, 1000);
		panelCombate.setLayout(null);
		panelCombate.setVisible(false);
		this.getContentPane().add(panelCombate);
		
	}


}
