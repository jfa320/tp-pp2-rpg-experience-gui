package tp.pp2.rpg.generator.gui.controller;

import java.util.Observable;
import java.util.Observer;

import tp.pp2.rpg.generator.core.entidades.rpg.generator.RpgBattleGenerator;
import tp.pp2.rpg.generator.gui.view.PanelCombate;

public class PanelCombateController implements Observer {
	private PanelCombate panelCombate;
	private RpgBattleGenerator rpgGenerator;

	public PanelCombateController(PanelCombate panelCombate, RpgBattleGenerator rpgGenerator) {
		this.panelCombate = panelCombate;
		this.rpgGenerator = rpgGenerator;
		this.initialize();
	}

	private void initialize() {
		rpgGenerator.addObserver(this);
		asignarNombreHabilidadesBotones();
		asignarFuncionalidadHabilidadesBotones();
	}

	private void asignarNombreHabilidadesBotones() {
		rpgGenerator.getEnfrentamiento().getPersonaje1().getHabilidades().stream().forEach(e->System.out.println(e.getNombre()));
		//TODO mejorar esto para evitar repeticion de codigo
		this.panelCombate.getBtnHabilidad1().setText(rpgGenerator.getEnfrentamiento().getPersonaje1().getHabilidades().get(0).getNombre()+" (da�o: "+rpgGenerator.getEnfrentamiento().getPersonaje1().getHabilidades().get(0).getDanio()+")");
		this.panelCombate.getBtnHabilidad2().setText(rpgGenerator.getEnfrentamiento().getPersonaje1().getHabilidades().get(1).getNombre()+" (da�o: "+rpgGenerator.getEnfrentamiento().getPersonaje1().getHabilidades().get(1).getDanio()+")");
	}

	private void asignarFuncionalidadHabilidadesBotones() {
		//TODO: DRY mejorar para evitar repiticion
		this.panelCombate.getBtnHabilidad1().addActionListener(e->{ 
			rpgGenerator.ejecutarHabilidad(rpgGenerator.getEnfrentamiento().getPersonaje1().getHabilidades().get(0));
			rpgGenerator.validarCombate();
		});
		this.panelCombate.getBtnHabilidad2().addActionListener(e->{ 
			rpgGenerator.ejecutarHabilidad(rpgGenerator.getEnfrentamiento().getPersonaje1().getHabilidades().get(1));
			rpgGenerator.validarCombate();
		});
		this.panelCombate.getBtnHabilidad3().addActionListener(e->{ 
			rpgGenerator.ejecutarHabilidad(rpgGenerator.getEnfrentamiento().getPersonaje1().getHabilidades().get(2));
			rpgGenerator.validarCombate();
		});
		this.panelCombate.getBtnHabilidad4().addActionListener(e->{ 
			rpgGenerator.ejecutarHabilidad(rpgGenerator.getEnfrentamiento().getPersonaje1().getHabilidades().get(3));
			rpgGenerator.validarCombate();
		});
	}

	@Override
	public void update(Observable o, Object arg) {
		//TODO
	}

}
