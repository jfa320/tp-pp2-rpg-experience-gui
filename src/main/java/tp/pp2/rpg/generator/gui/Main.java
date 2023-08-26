package tp.pp2.rpg.generator.gui;

import tp.pp2.rpg.generator.gui.view.VentanaPrincipal;
import tp.pp2.rpg.generator.core.entidades.rpg.generator.RpgGenerator;

public class Main {
    public static void main(String[] args) {
    	RpgGenerator rpgGenerator= new RpgGenerator();
    	VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(rpgGenerator);
    	ventanaPrincipal.mostrar();
    }
}
