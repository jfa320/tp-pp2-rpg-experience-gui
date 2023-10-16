package tp.pp2.rpg.experience.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFileChooser;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.extensible.CargadorHabilidades;
import tp.pp2.rpg.experience.gui.BotonListener;
import tp.pp2.rpg.experience.gui.view.PanelHabilidad;

public class PanelHabilidadController implements Observer {

    private PanelHabilidad panelHabilidad;
    private JFileChooser fileChooser;
    private List<BotonListener> listeners;
    private Batalla batalla;
    private CargadorHabilidades cargadorHabilidades;

    public PanelHabilidadController(PanelHabilidad panelHabilidad, Batalla batalla){
        this.panelHabilidad = panelHabilidad;
        this.batalla = batalla;
        batalla.addObserver(this);
        cargadorHabilidades = new CargadorHabilidades();
        listeners = new ArrayList<>();
        fileChooser  = new JFileChooser();
        initialize();
    }

    private void initialize(){

        panelHabilidad.getBotonCarga().setText("Cargar Habilidad");

        panelHabilidad.getBotonCarga().addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                panelHabilidad.getMensajeError().setText("");
                int operacion = fileChooser.showOpenDialog(null);
                if(operacion == JFileChooser.APPROVE_OPTION){
                    try {                    
                        cargadorHabilidades.cargar(batalla, fileChooser.getSelectedFile().getAbsolutePath());
                    } catch (Exception e1) {
                        panelHabilidad.getMensajeError().setText(e1.getMessage());
                    }      
                }
             }
        });
        
        panelHabilidad.getBotonInicioBatalla().setText("Iniciar Batalla");

        panelHabilidad.getBotonInicioBatalla().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                panelHabilidad.setVisible(false);
                listeners.forEach(l -> l.botonEjecutado());
            }
        });

        mostrarHabilidadesCargadas();
    }

    public void mostrarHabilidadesCargadas(){
        panelHabilidad.getCampoTexto().setText("");
        batalla.getHabilidades().forEach(h-> panelHabilidad.getCampoTexto().append( "* " + h.getNombre()+ "\n"));
    }

    public void registerListener(BotonListener b){
        listeners.add(b);
    }

    @Override
    public void update(Observable o, Object arg) {
        mostrarHabilidadesCargadas();
    }
}
