package tp.pp2.rpg.experience.gui.view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.gui.controller.PanelCombateController;

public class PanelCombate extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;

	private List<JButton> botonesHabilidades;
	private JLabel rivalNombreLabel;
	private JLabel personajeNombreLabel;

	private JProgressBar barraVidaJ1;
	private JProgressBar barraVidaJ2;

	private Batalla batalla;
	private PanelCombateController panelCombateController;
	
	private JLabel resultadoCombate;

	public PanelCombate(Batalla batalla) {
		this.batalla = batalla;
		this.initialize();
		panelCombateController=new PanelCombateController(this,this.batalla);
	}

	private void initialize() {
		batalla.addObserver(this);
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
		
		rpgGenerator.getBatalla().getContexto().getVidas().forEach((personaje, vida) -> {
		    System.out.println("El Personaje " + personaje + " tiene " + vida + " vidas.");
		});
		
		double vidaMostrarJ1=100*((double)rpgGenerator.getBatalla().getContexto().getVidas().get(rpgGenerator.getPersonajes().get(0).getNombre())/rpgGenerator.getBatalla().getContexto().getVidas().get(rpgGenerator.getPersonajes().get(0).getNombre()));
		barraVidaJ1.setValue((int)vidaMostrarJ1);
		barraVidaJ1.setBounds(10, 235, 455, 15);
		barraVidaJ1.setForeground(Color.green);
		barraVidaJ1.setStringPainted(true);
		barraVidaJ1.setString(rpgGenerator.getBatalla().getContexto().getVidas().get(rpgGenerator.getPersonajes().get(0).getNombre())+"/"+rpgGenerator.getBatalla().getContexto().getVidas().get(rpgGenerator.getPersonajes().get(0).getNombre()));
		this.add(barraVidaJ1);
		// VIDAJ2
		//TODO: Es correcto tener este calculo aca? Donde ubicarlo sino?
		double vidaMostrarJ2=100*((double)rpgGenerator.getBatalla().getContexto().getVidas().get(rpgGenerator.getPersonajes().get(1).getNombre())/rpgGenerator.getBatalla().getContexto().getVidas().get(rpgGenerator.getPersonajes().get(1).getNombre()));
		barraVidaJ2.setValue((int)vidaMostrarJ2);
		barraVidaJ2.setBounds(425, 5, 455, 15);
		barraVidaJ2.setForeground(Color.green);
		barraVidaJ2.setStringPainted(true);
		barraVidaJ2.setString(rpgGenerator.getBatalla().getContexto().getVidas().get(rpgGenerator.getPersonajes().get(1).getNombre())+"/"+rpgGenerator.getBatalla().getContexto().getVidas().get(rpgGenerator.getPersonajes().get(1).getNombre()));
		this.add(barraVidaJ2);
		botonesHabilidades.get(0).setBounds(0, 265, 455, 120);
		botonesHabilidades.get(1).setBounds(455, 265, 455, 120);
		botonesHabilidades.get(2).setBounds(0, 385, 455, 120);
		botonesHabilidades.get(3).setBounds(455, 385, 455, 120);
		rivalNombreLabel.setBounds(10, -45, 455, 120);
		personajeNombreLabel.setBounds(500, 180, 455, 120);
		resultadoCombate.setBounds(400, 500, 455, 120);
		
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
		double vidaMostrarJ2=100*((double)rpgGenerator.getBatalla().getContexto().getVidas().get(rpgGenerator.getPersonajes().get(1).getNombre())/100);
		barraVidaJ2.setValue((int)vidaMostrarJ2);
		barraVidaJ2.setString(rpgGenerator.getBatalla().getContexto().getVidas().get(rpgGenerator.getPersonajes().get(1).getNombre())+"/"+100);
		
		/*if(rpgGenerator.getBatalla().getValidadorVictoria()!=-1) {
			String mensajeVictoria;
			mensajeVictoria="Gana "+rpgGenerator.getNombreGanador();
			this.resultadoCombate.setText(mensajeVictoria);
			this.botonesHabilidades.forEach(btn -> btn.setEnabled(false));
		}*/
	}

}
