package tp.pp2.rpg.experience.gui.view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import tp.pp2.rpg.experience.gui.controller.PanelHabilidadController;

public class PanelHabilidad extends JPanel {

    private PanelHabilidadController panelHabilidadController;
    private JButton botonCargaHabilidad;
    private JButton iniciarBatalla;
    private JTextArea campoTexto;

    public PanelHabilidad(){
        initialize();
        panelHabilidadController = new PanelHabilidadController(this);
    }

    private void initialize(){
        botonCargaHabilidad = new JButton();
        iniciarBatalla = new JButton();
        campoTexto = new JTextArea();
        campoTexto.setEditable(false);

        botonCargaHabilidad.setBounds(0, 265, 455, 120);
        iniciarBatalla.setBounds(0, 500, 455, 120);     
        campoTexto.setBounds(500, 265, 500, 520);      

        this.add(botonCargaHabilidad);
        this.add(campoTexto);
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
    
}
