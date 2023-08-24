package tp.pp2.rpg.generator.gui.view;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tp.pp2.rpg.generator.core.entidades.asignadorHabilidades.AsignadorHabilidades;
import tp.pp2.rpg.generator.gui.controller.PanelSelectorArchivoHabilidadesController;

import javax.swing.JFileChooser;

public class PanelSelectorArchivoHabilidades extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	private JButton btnCargaArchivo;
	private JLabel labelCargaArchivo;
	private JFileChooser selectorArchivos;
	private AsignadorHabilidades asignadorHabilidades;
	private PanelSelectorArchivoHabilidadesController panelSelectorArchivoHabilidadesController;

	public PanelSelectorArchivoHabilidades(AsignadorHabilidades asignadorHabilidades) {
		initialize();
		this.asignadorHabilidades=asignadorHabilidades;
	}

	private void initialize() {
		// construyo componentes
		btnCargaArchivo = new JButton("Cargar Archivo");
		labelCargaArchivo = new JLabel("Carga de habilidades:");
		selectorArchivos = new JFileChooser();
		
		//instancio el controlador del panel selector archivos
		panelSelectorArchivoHabilidadesController=new PanelSelectorArchivoHabilidadesController(this, asignadorHabilidades);
		
		// ajusto tamano y seteo absolute layout
		setPreferredSize(new Dimension(884, 133));
		setLayout(null);

		// seteo tamanos componentes
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

	@Override
	public void update(Observable o, Object arg) {
		//aca definir el cambio	
		
		//mostrar un cartel de se leyó o algo asi
	}
	
}
