package tp.pp2.rpg.generator.gui;

import tp.pp2.rpg.generator.core.entidades.rpg.generator.RpgBattleGenerator;
import tp.pp2.rpg.generator.gui.view.VentanaPrincipal;

public class Main {
    public static void main(String[] args) {
    	RpgBattleGenerator rpgGenerator= new RpgBattleGenerator(args[0]);
    	VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(rpgGenerator);
    	ventanaPrincipal.mostrar();
    }
}
