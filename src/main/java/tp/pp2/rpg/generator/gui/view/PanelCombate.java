package tp.pp2.rpg.generator.gui.view;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import tp.pp2.rpg.generator.core.entidades.rpg.generator.RpgGenerator;
import tp.pp2.rpg.generator.gui.controller.PanelCombateController;

public class PanelCombate extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnHabilidad1;
	private JButton btnHabilidad2;
	private JButton btnHabilidad3;
	private JButton btnHabilidad4;
	private JLabel rivalNombreLabel;
	private JLabel personajeNombreLabel;

	private JProgressBar barraVidaJ1;
	private JProgressBar barraVidaJ2;

	private RpgGenerator rpgGenerator;
	private PanelCombateController panelCombateController;

	public PanelCombate(RpgGenerator rpgGenerator) {
		this.rpgGenerator = rpgGenerator;
		this.initialize();
		panelCombateController=new PanelCombateController(this,this.rpgGenerator);
	}

	private void initialize() {
		rpgGenerator.addObserver(this);

		btnHabilidad1 = new JButton();
		btnHabilidad2 = new JButton();
		btnHabilidad3 = new JButton();
		btnHabilidad4 = new JButton();
		rivalNombreLabel = new JLabel();
		personajeNombreLabel = new JLabel();
		barraVidaJ2 = new JProgressBar(0, 100);
		barraVidaJ1 = new JProgressBar(0, 100);

		this.add(btnHabilidad1);
		this.add(btnHabilidad2);
		this.add(btnHabilidad3);
		this.add(btnHabilidad4);
		this.add(rivalNombreLabel);
		this.add(personajeNombreLabel);
		// VIDAJ1
		barraVidaJ1.setValue(100);
		barraVidaJ1.setBounds(10, 235, 455, 15);
		barraVidaJ1.setForeground(Color.green);
		barraVidaJ1.setStringPainted(true);
		barraVidaJ1.setString(rpgGenerator.getJugador1().getVida() + "/100");
		this.add(barraVidaJ1);
		// VIDAJ2
		barraVidaJ2.setValue(100);
		barraVidaJ2.setBounds(425, 5, 455, 15);
		barraVidaJ2.setForeground(Color.green);
		barraVidaJ2.setStringPainted(true);
		barraVidaJ2.setString(rpgGenerator.getJugador2().getVida()  + "/100");
		this.add(barraVidaJ2);
		btnHabilidad1.setBounds(0, 265, 455, 120);
		btnHabilidad2.setBounds(455, 265, 455, 120);
		btnHabilidad3.setBounds(0, 385, 455, 120);
		btnHabilidad4.setBounds(455, 385, 455, 120);
		rivalNombreLabel.setBounds(400, -45, 455, 120);
		personajeNombreLabel.setBounds(500, 190, 455, 120);

	}

	public JButton getBtnHabilidad1() {
		return btnHabilidad1;
	}

	public void setBtnHabilidad1(JButton btnHabilidad1) {
		this.btnHabilidad1 = btnHabilidad1;
	}

	public JButton getBtnHabilidad2() {
		return btnHabilidad2;
	}

	public void setBtnHabilidad2(JButton btnHabilidad2) {
		this.btnHabilidad2 = btnHabilidad2;
	}

	public JButton getBtnHabilidad3() {
		return btnHabilidad3;
	}

	public void setBtnHabilidad3(JButton btnHabilidad3) {
		this.btnHabilidad3 = btnHabilidad3;
	}

	public JButton getBtnHabilidad4() {
		return btnHabilidad4;
	}

	public void setBtnHabilidad4(JButton btnHabilidad4) {
		this.btnHabilidad4 = btnHabilidad4;
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
		barraVidaJ2.setValue(rpgGenerator.getJugador2().getVida());
		barraVidaJ2.setString(rpgGenerator.getJugador2().getVida() + "/100");
	}

}
