package tp.pp2.rpg.generator.gui.view;

import javax.swing.JFrame;


public class VentanaPrincipal extends JFrame{

	private static final long serialVersionUID = 1L;
	private PanelSelectorArchivoHabilidades panelSelectorHabilidades;
	

	public VentanaPrincipal() {
		initialize();
	}

	private void initialize() {
		panelSelectorHabilidades = new PanelSelectorArchivoHabilidades();
		this.setBounds(100, 100, 1000, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setVisible(true);
		this.setPanelInicial();
	}


	public void setPanelInicial() {
		panelSelectorHabilidades.setBounds(51, 29, 1000, 1000);
		panelSelectorHabilidades.setLayout(null);
		panelSelectorHabilidades.setVisible(true);
		this.getContentPane().add(panelSelectorHabilidades);
	}

}
