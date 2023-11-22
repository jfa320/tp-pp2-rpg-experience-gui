package tp.pp2.rpg.experience.gui;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.rpg.experience.BatallaFactory;
import tp.pp2.rpg.experience.gui.view.VentanaPrincipal;

public class Main {
    public static void main(String[] args){
		BatallaFactory batallaInitializer = new BatallaFactory();
		Batalla batalla = batallaInitializer.generarBatalla(args[0]);
    	VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(batalla);
    	ventanaPrincipal.mostrar();
    }
}
