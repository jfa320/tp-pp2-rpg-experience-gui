package tp.pp2.rpg.experience.gui.view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.gui.BotonListener;
import tp.pp2.rpg.experience.gui.controller.PanelHabilidadController;

public class PanelHabilidad extends JPanel {

    private PanelHabilidadController panelHabilidadController;
    private JButton botonCargaHabilidad;
    private JButton iniciarBatalla;
    private JTextArea campoTexto;
    private JTextArea mensajeError;

    public PanelHabilidad(Batalla batalla){
        initialize();
        panelHabilidadController = new PanelHabilidadController(this,batalla);
    }

    private void initialize(){
        botonCargaHabilidad = new JButton();
        iniciarBatalla = new JButton();
        campoTexto = new JTextArea();
        campoTexto.setEditable(false);
        mensajeError = new JTextArea();
        mensajeError.setEditable(false);

        botonCargaHabilidad.setBounds(0, 265, 455, 120);
        iniciarBatalla.setBounds(0, 500, 455, 120);     
        campoTexto.setBounds(500, 265, 500, 520);
        mensajeError.setBounds(220, 100,600, 30);      

        this.add(botonCargaHabilidad);
        this.add(campoTexto);
        this.add(mensajeError);
        this.add(iniciarBatalla);
    }

    public JButton getBotonCarga(){
        return botonCargaHabilidad;
    }

    public JButton getBotonInicioBatalla(){
        return iniciarBatalla;
    }

    public JTextArea getCampoTexto(){
        return campoTexto; 
    }

    public JTextArea getMensajeError(){
        return mensajeError; 
    }

    public void registerListener(BotonListener b){
        panelHabilidadController.registerListener(b);
    }
    
}
