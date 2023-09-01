package tp.pp2.rpg.generator.gui;

import tp.pp2.rpg.generator.gui.view.VentanaPrincipal;

import java.util.Arrays;

import tp.pp2.rpg.generator.core.entidades.Habilidad;
import tp.pp2.rpg.generator.core.entidades.Personaje;
import tp.pp2.rpg.generator.core.entidades.rpg.generator.RpgBattleGenerator;

public class Main {
    public static void main(String[] args) {
    	Personaje personaje1=new Personaje("N1", "T1", 500, 200,90,120, 30,50, Arrays.asList(
				new Habilidad(1, "H1", 600, "E"), 
				new Habilidad(2, "H3", 50000, "F")));
    	Personaje personaje2=new Personaje("N2", "T2", 1400, 500, 70, 60, 60, 70, Arrays.asList(
				new Habilidad(3, "H2", 10, "F")));
    	RpgBattleGenerator rpgGenerator= new RpgBattleGenerator(personaje1, personaje2);
    	
    	VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(rpgGenerator);
    	ventanaPrincipal.mostrar();
    }
}
