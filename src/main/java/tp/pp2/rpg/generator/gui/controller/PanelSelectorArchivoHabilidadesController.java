package tp.pp2.rpg.generator.gui.controller;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

import tp.pp2.rpg.generator.core.entidades.asignadorHabilidades.AsignadorHabilidades;
import tp.pp2.rpg.generator.gui.view.PanelSelectorArchivoHabilidades;

public class PanelSelectorArchivoHabilidadesController implements Observer{

	private PanelSelectorArchivoHabilidades panelSelectorArchivoHabilidades;
	private File archivo;
	private AsignadorHabilidades asignadorHabilidades;

	public PanelSelectorArchivoHabilidadesController(PanelSelectorArchivoHabilidades panelSelectorArchivoHabilidades,AsignadorHabilidades asignadorHabilidades) {
		this.panelSelectorArchivoHabilidades = panelSelectorArchivoHabilidades;
		this.asignadorHabilidades=asignadorHabilidades;
		System.out.println("constructor:"+asignadorHabilidades.getSeLeyoArchivo());
		initialize();
	}

	private void initialize() {
		this.panelSelectorArchivoHabilidades.getBtnCargaArchivo().addActionListener(
				e -> {
					this.panelSelectorArchivoHabilidades.getSelectorArchivos().showOpenDialog(null);
					archivo=this.panelSelectorArchivoHabilidades.getSelectorArchivos().getSelectedFile();
					//TODO: estaria correcto hacer esto?
					System.out.println(asignadorHabilidades.getSeLeyoArchivo());
					asignadorHabilidades.setArchivoLeido(true);
					System.out.println("despues de asignar"+asignadorHabilidades.getSeLeyoArchivo());
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
		//aca definir el cambio	
		//mostrar un cartel de se leyó o algo asi
		System.out.println("cambio desde controller");
	}

}
