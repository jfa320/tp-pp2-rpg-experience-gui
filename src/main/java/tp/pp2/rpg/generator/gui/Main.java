package tp.pp2.rpg.generator.gui;

import tp.pp2.rpg.experience.core.entidades.rpg.experience.RpgBattleExperience;
import tp.pp2.rpg.generator.gui.view.VentanaPrincipal;

public class Main {
    public static void main(String[] args) {
    	RpgBattleExperience rpgGenerator= new RpgBattleExperience(args[0]);
    	VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(rpgGenerator);
    	ventanaPrincipal.mostrar();
    }
}
