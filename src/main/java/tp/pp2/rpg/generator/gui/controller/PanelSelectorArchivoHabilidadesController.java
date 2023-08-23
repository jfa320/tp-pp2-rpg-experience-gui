package tp.pp2.rpg.generator.gui.controller;

import java.io.File;

import tp.pp2.rpg.generator.gui.view.PanelSelectorArchivoHabilidades;

public class PanelSelectorArchivoHabilidadesController {

	PanelSelectorArchivoHabilidades panelSelectorArchivoHabilidades;
	File archivo;

	public PanelSelectorArchivoHabilidadesController(PanelSelectorArchivoHabilidades panelSelectorArchivoHabilidades) {
		this.panelSelectorArchivoHabilidades = panelSelectorArchivoHabilidades;
		initialize();
	}

	private void initialize() {
		this.panelSelectorArchivoHabilidades.getBtnCargaArchivo().addActionListener(
				e -> {
					this.panelSelectorArchivoHabilidades.getSelectorArchivos().showOpenDialog(null);
					archivo=this.panelSelectorArchivoHabilidades.getSelectorArchivos().getSelectedFile();
				});
	}

	public File getArchivo() {
		return archivo;
	}

	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}

}
