package tp.pp2.rpg.experience.gui.controller;

import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JProgressBar;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;
import tp.pp2.rpg.experience.core.entidades.rpg.experience.ObtenedorGanador;
import tp.pp2.rpg.experience.gui.view.PanelBatalla;

public class PanelBatallaController implements Observer {
	private PanelBatalla panelCombate;
	private Batalla batalla;

	public PanelBatallaController(PanelBatalla panelCombate, Batalla batalla) {
		this.panelCombate = panelCombate;
		this.batalla = batalla;
		this.initialize();
	}

	private void initialize() {
		batalla.addObserver(this);
		asignarNombreHabilidadesBotones();
		asignarFuncionalidadHabilidadesBotones();
		bloquearBotonesSinHabilidad();
	}

	private void asignarNombreHabilidadesBotones() {
		for (int i = 0; i < this.panelCombate.getBotonesHabilidades().size(); i++) {
			if (batalla.getHabilidades().size() > i) {
				this.panelCombate.getBotonesHabilidades().get(i)
						.setText(batalla.getHabilidades().get(i).getNombre()+" | "+batalla.getHabilidades().get(i).getDescripcion());
			}
		}
	}

	private void clearHabilidades(){
		panelCombate.getBotonesHabilidades().forEach(b -> {
			
			for(ActionListener a : b.getActionListeners())
				b.removeActionListener(a);
			
			b.setText("");
		});
	}

	private void asignarFuncionalidadHabilidadesBotones() {
		for (int i = 0; i < this.panelCombate.getBotonesHabilidades().size(); i++) {
			final int index = i;
			if (index < batalla.getHabilidades().size()) {
				this.panelCombate.getBotonesHabilidades().get(index).addActionListener(e -> {
					try {
						botonesHabilidadVisible(false);
						panelCombate.getBotonesHabilidades().get(index).setEnabled(false);
						batalla.jugar(batalla.getHabilidades().get(index).getNombre());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				});
			}
		}
	}

	private void bloquearBotonesSinHabilidad() {
		this.panelCombate.getBotonesHabilidades().forEach(btn->{
			if(btn.getActionListeners().length==0) {
				btn.setEnabled(false);
			}
		});
	}

	private void botonesHabilidadVisible(boolean b) {
		this.panelCombate.getBotonesHabilidades().forEach(btn->{
			if(btn.getActionListeners().length>0) {
				btn.setEnabled(b);
			}
		});
	}

	private void actualizarVidas(){
		String personaje1=batalla.getPersonajes().get(0);
		double vidaMostrar=100*(Double.parseDouble(batalla.getCaracteristicasPersonaje(personaje1).getProperty("vida"))/100);
		actualizarVidasAux(panelCombate.getBarraVidaJ1(), vidaMostrar, 0);

		String personaje2=batalla.getPersonajes().get(1);
		vidaMostrar=100*(Double.parseDouble(batalla.getCaracteristicasPersonaje(personaje2).getProperty("vida"))/100);

		actualizarVidasAux(panelCombate.getBarraVidaJ2(), vidaMostrar, 1);
	}

	private void actualizarVidasAux(JProgressBar bararVida, double nuevaVida,int indexPersonaje){
		bararVida.setValue((int)nuevaVida);
		String personaje1=batalla.getPersonajes().get(indexPersonaje);
		bararVida.setString(batalla.getCaracteristicasPersonaje(personaje1).getProperty("vida")+"/"+ 100);
	}

	private void transicionTurno(){

		if (panelCombate.getImgEnemigo().getIcon().equals(panelCombate.getTrasEnemigo()))
			panelCombate.getImgEnemigo().setIcon(panelCombate.getFrenteEnemigo());	
		else
			panelCombate.getImgEnemigo().setIcon(panelCombate.getTrasEnemigo());
		
		if (panelCombate.getImgPersonaje().getIcon().equals(panelCombate.getTrasPj()))
			panelCombate.getImgPersonaje().setIcon(panelCombate.getFrentePj());
		else
			panelCombate.getImgPersonaje().setIcon(panelCombate.getTrasPj());

		Rectangle nombreAux = panelCombate.getPersonajeNombreLabel().getBounds();
		panelCombate.getPersonajeNombreLabel().setBounds(panelCombate.getRivalNombreLabel().getBounds());
		panelCombate.getRivalNombreLabel().setBounds(nombreAux);

		Rectangle barraAux = panelCombate.getBarraVidaJ1().getBounds();
		panelCombate.getBarraVidaJ1().setBounds(panelCombate.getBarraVidaJ2().getBounds());
		panelCombate.getBarraVidaJ2().setBounds(barraAux);
	}

	private void transicion(){
		Timer timer = new Timer();
	
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
               transicionTurno();
			   botonesHabilidadVisible(true);
            }
        }, 1500);
	}

	@Override
	public void update(Observable o, Object arg) {
		
		if (batalla.getEstado().equals(EstadoBatalla.INICIADA)){
			clearHabilidades();
			asignarNombreHabilidadesBotones();
			asignarFuncionalidadHabilidadesBotones();
			botonesHabilidadVisible(true);
		}

		if(batalla.getEstado().equals(EstadoBatalla.EN_PROGRESO)){
			actualizarVidas();
			transicion();
		}
		
		if(batalla.getEstado().equals(EstadoBatalla.FINALIZADA)) {
			actualizarVidas();
			String ganador=new ObtenedorGanador().obtenerGanador(batalla);
			String mensajeVictoria="Gana " + ganador;
			this.panelCombate.setResultadoCombate(mensajeVictoria);
			this.panelCombate.getBotonesHabilidades().forEach(btn -> btn.setEnabled(false));
		}
	}
}
