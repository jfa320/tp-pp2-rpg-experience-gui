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
		bloquearBotonesSinUso();
	}

	private void asignarNombreHabilidadesBotones() {
		for (int i = 0; i < this.panelCombate.getBotonesHabilidades().size(); i++) {
			if (rpgGenerator.getHabilidades().size() > i) {
				this.panelCombate.getBotonesHabilidades().get(i)
						.setText(rpgGenerator.getHabilidades().get(i).getDescripcion());
			}
		}
	}

	private void asignarFuncionalidadHabilidadesBotones() {
		for (int i = 0; i < this.panelCombate.getBotonesHabilidades().size(); i++) {
			final int index = i;
			if (index < rpgGenerator.getHabilidades().size()) {
				this.panelCombate.getBotonesHabilidades().get(index).addActionListener(e -> {
					rpgGenerator.jugar(rpgGenerator.getHabilidades().get(index), rpgGenerator.getPersonajes().get(0),
							rpgGenerator.getPersonajes().get(1));
				});
			}
		}
	}

	private void bloquearBotonesSinUso() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}

}
