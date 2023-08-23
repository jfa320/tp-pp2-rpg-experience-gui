package tp.pp2.rpg.generator.gui.view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tp.pp2.rpg.generator.gui.controller.PanelSelectorArchivoHabilidadesController;

import javax.swing.JFileChooser;

public class PanelSelectorArchivoHabilidades extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btnCargaArchivo;
	private JLabel labelCargaArchivo;
	private JFileChooser selectorArchivos;
	private PanelSelectorArchivoHabilidadesController panelSelectorArchivoHabilidadesController;

	public PanelSelectorArchivoHabilidades() {
		initialize();
	}

	private void initialize() {
		// construyo componentes
		btnCargaArchivo = new JButton("Cargar Archivo");
		labelCargaArchivo = new JLabel("Carga de habilidades:");
		selectorArchivos = new JFileChooser();
		
		//instancio el panel selector
		panelSelectorArchivoHabilidadesController=new PanelSelectorArchivoHabilidadesController(this);
		
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

	public JButton getBtnCargaArchivo() {
		return btnCargaArchivo;
	}

	public void setBtnCargaArchivo(JButton btnCargaArchivo) {
		this.btnCargaArchivo = btnCargaArchivo;
	}

	public JLabel getLabelCargaArchivo() {
		return labelCargaArchivo;
	}

	public void setLabelCargaArchivo(JLabel labelCargaArchivo) {
		this.labelCargaArchivo = labelCargaArchivo;
	}

	public JFileChooser getSelectorArchivos() {
		return selectorArchivos;
	}

	public void setSelectorArchivos(JFileChooser selectorArchivos) {
		this.selectorArchivos = selectorArchivos;
	}
	
}
