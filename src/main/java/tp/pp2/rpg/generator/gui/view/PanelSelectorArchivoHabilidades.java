package tp.pp2.rpg.generator.gui.view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelSelectorArchivoHabilidades extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btnCargaArchivo;
	private JLabel labelCargaArchivo;

	public PanelSelectorArchivoHabilidades() {
		initialize();
	}

	private void initialize() {
		// construyo componentes
		btnCargaArchivo = new JButton("Cargar Archivo");
		labelCargaArchivo = new JLabel("Carga de habilidades:");

		// ajusto tamaño y seteo absolute layout
		setPreferredSize(new Dimension(884, 133));
		setLayout(null);

		// seteo tamaños componentes
		btnCargaArchivo.setBounds(345, 50, 140, 25);
		labelCargaArchivo.setBounds(95, 45, 235, 35);

		// agrego componentes
		add(btnCargaArchivo);
		add(labelCargaArchivo);
	}
}
