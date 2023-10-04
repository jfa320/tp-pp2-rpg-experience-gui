package tp.pp2.rpg.experience.gui.controller;

import java.util.Observable;
import java.util.Observer;

import tp.pp2.rpg.experience.core.entidades.rpg.experience.RpgBattleExperience;
import tp.pp2.rpg.experience.gui.view.PanelCombate;

public class PanelCombateController implements Observer {
	private PanelCombate panelCombate;
	private RpgBattleExperience rpgGenerator;

	public PanelCombateController(PanelCombate panelCombate, RpgBattleExperience rpgGenerator) {
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
					try {
						rpgGenerator.jugar(rpgGenerator.getHabilidades().get(index));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
			}
		}
	}

	private void bloquearBotonesSinUso() {
		// TODO Auto-generated method stub
		this.panelCombate.getBotonesHabilidades().forEach(btn->{
			if(btn.getActionListeners().length==0) {
				btn.setEnabled(false);
			}
		});
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}

}
