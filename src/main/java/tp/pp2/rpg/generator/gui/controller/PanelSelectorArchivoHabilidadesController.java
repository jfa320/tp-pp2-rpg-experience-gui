package tp.pp2.rpg.generator.gui.controller;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import tp.pp2.rpg.generator.core.entidades.asignadorHabilidades.AsignadorHabilidades;
import tp.pp2.rpg.generator.gui.view.PanelCombate;
import tp.pp2.rpg.generator.gui.view.PanelSelectorArchivoHabilidades;

public class PanelSelectorArchivoHabilidadesController implements Observer{

	private PanelSelectorArchivoHabilidades panelSelectorArchivoHabilidades;
	private File archivo;
	private AsignadorHabilidades asignadorHabilidades;
	private PanelCombate panel;

	public PanelSelectorArchivoHabilidadesController(PanelSelectorArchivoHabilidades panelSelectorArchivoHabilidades,AsignadorHabilidades asignadorHabilidades, PanelCombate panelCombate) {
		this.panelSelectorArchivoHabilidades = panelSelectorArchivoHabilidades;
		this.asignadorHabilidades=asignadorHabilidades;
		this.panel=panelCombate;
		initialize();
	}

	private void initialize() {
		asignadorHabilidades.addObserver(this);
		
		this.panelSelectorArchivoHabilidades.getBtnCargaArchivo().addActionListener(
				e -> {
					this.panelSelectorArchivoHabilidades.getSelectorArchivos().showOpenDialog(null);
					archivo=this.panelSelectorArchivoHabilidades.getSelectorArchivos().getSelectedFile();
					//TODO: estaria correcto hacer esto?
					asignadorHabilidades.setArchivoLeido(true);
				});
	}

	public File getArchivo() {
		return archivo;
	}

	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}

	@Override
	public void update(Observable o, Object arg) {
		this.panelSelectorArchivoHabilidades.setVisible(false);
		this.panel.setVisible(true);
	}

}
