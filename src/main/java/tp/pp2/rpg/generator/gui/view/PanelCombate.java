package tp.pp2.rpg.generator.gui.view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import tp.pp2.rpg.generator.core.entidades.rpg.generator.RpgBattleGenerator;
import tp.pp2.rpg.generator.gui.controller.PanelCombateController;

public class PanelCombate extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;

	private List<JButton> botonesHabilidades;
	private JLabel rivalNombreLabel;
	private JLabel personajeNombreLabel;

	private JProgressBar barraVidaJ1;
	private JProgressBar barraVidaJ2;

	private RpgBattleGenerator rpgGenerator;
	private PanelCombateController panelCombateController;
	
	private JLabel resultadoCombate;

	public PanelCombate(RpgBattleGenerator rpgGenerator) {
		this.rpgGenerator = rpgGenerator;
		this.initialize();
		panelCombateController=new PanelCombateController(this,this.rpgGenerator);
	}

	private void initialize() {
		rpgGenerator.addObserver(this);
		botonesHabilidades=new ArrayList<JButton>();
		
		for(int i=0;i<4;i++) {
			botonesHabilidades.add(new JButton());
		}
		
		personajeNombreLabel = new JLabel();
		personajeNombreLabel.setText(rpgGenerator.getPersonajes().get(0).getNombre());
		rivalNombreLabel = new JLabel();
		rivalNombreLabel.setText(rpgGenerator.getPersonajes().get(1).getNombre());
		resultadoCombate=new JLabel();
		
		barraVidaJ2 = new JProgressBar(0, 100);
		barraVidaJ1 = new JProgressBar(0, 100);

		botonesHabilidades.forEach(btn-> {
			this.add(btn);
		});
		this.add(rivalNombreLabel);
		this.add(personajeNombreLabel);
		this.add(resultadoCombate);
		// VIDAJ1
		//TODO: Es correcto tener este calculo aca? Donde ubicarlo sino?
		double vidaMostrarJ1=100*((double)rpgGenerator.getBatalla().getVidas().get(1)/rpgGenerator.getBatalla().getVidas().get(1));
		barraVidaJ1.setValue((int)vidaMostrarJ1);
		barraVidaJ1.setBounds(10, 235, 455, 15);
		barraVidaJ1.setForeground(Color.green);
		barraVidaJ1.setStringPainted(true);
		barraVidaJ1.setString(rpgGenerator.getBatalla().getVidas().get(1)+"/"+rpgGenerator.getBatalla().getVidas().get(1));
		this.add(barraVidaJ1);
		// VIDAJ2
		//TODO: Es correcto tener este calculo aca? Donde ubicarlo sino?
		double vidaMostrarJ2=100*((double)rpgGenerator.getBatalla().getVidas().get(2)/rpgGenerator.getBatalla().getVidas().get(2));
		barraVidaJ2.setValue((int)vidaMostrarJ2);
		barraVidaJ2.setBounds(425, 5, 455, 15);
		barraVidaJ2.setForeground(Color.green);
		barraVidaJ2.setStringPainted(true);
		barraVidaJ2.setString(rpgGenerator.getBatalla().getVidas().get(2)+"/"+rpgGenerator.getBatalla().getVidas().get(2));
		this.add(barraVidaJ2);
		botonesHabilidades.get(0).setBounds(0, 265, 455, 120);
		botonesHabilidades.get(1).setBounds(455, 265, 455, 120);
		botonesHabilidades.get(2).setBounds(0, 385, 455, 120);
		botonesHabilidades.get(3).setBounds(455, 385, 455, 120);
		rivalNombreLabel.setBounds(10, -45, 455, 120);
		personajeNombreLabel.setBounds(500, 180, 455, 120);
		resultadoCombate.setBounds(400, 500, 455, 120);
		//this.botonesHabilidades.forEach(btn -> btn.setEnabled(false));
	}

	

	public List<JButton> getBotonesHabilidades() {
		return botonesHabilidades;
	}

	public void setBotonesHabilidades(List<JButton> botonesHabilidades) {
		this.botonesHabilidades = botonesHabilidades;
	}

	public JLabel getRivalNombreLabel() {
		return rivalNombreLabel;
	}

	public void setRivalNombreLabel(JLabel rivalNombreLabel) {
		this.rivalNombreLabel = rivalNombreLabel;
	}

	public JLabel getPersonajeNombreLabel() {
		return personajeNombreLabel;
	}

	public void setPersonajeNombreLabel(JLabel personajeNombreLabel) {
		this.personajeNombreLabel = personajeNombreLabel;
	}

	public JProgressBar getBarraVidaJ1() {
		return barraVidaJ1;
	}

	public void setBarraVidaJ1(JProgressBar barraVidaJ1) {
		this.barraVidaJ1 = barraVidaJ1;
	}

	public JProgressBar getBarraVidaJ2() {
		return barraVidaJ2;
	}

	public void setBarraVidaJ2(JProgressBar barraVidaJ2) {
		this.barraVidaJ2 = barraVidaJ2;
	}

	@Override
	public void update(Observable o, Object arg) {
		//TODO idem pregunta arriba
		double vidaMostrarJ2=100*((double)rpgGenerator.getBatalla().getVidas().get(2)/100);
		barraVidaJ2.setValue((int)vidaMostrarJ2);
		barraVidaJ2.setString(rpgGenerator.getBatalla().getVidas().get(2)+"/"+100);
		
		if(rpgGenerator.getBatalla().getPersonajeGanadorId()!=-1) {
			String mensajeVictoria;
			mensajeVictoria=rpgGenerator.getBatalla().getPersonajeGanadorId()==1 ? "Gana J1":"Gana J2";
			this.resultadoCombate.setText(mensajeVictoria);
		}
	}

}
