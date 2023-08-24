package tp.pp2.rpg.generator.gui;

import tp.pp2.rpg.generator.gui.view.VentanaPrincipal;
import tp.pp2.rpg.generator.core.entidades.asignadorHabilidades.AsignadorHabilidades;

public class Main {
    public static void main(String[] args) {
    	AsignadorHabilidades asignadorHabilidades= new AsignadorHabilidades();
    	VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(asignadorHabilidades);
    	ventanaPrincipal.setPanelInicial();
    }
}
