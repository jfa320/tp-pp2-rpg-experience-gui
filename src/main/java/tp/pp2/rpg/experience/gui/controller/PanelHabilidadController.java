package tp.pp2.rpg.experience.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import tp.pp2.rpg.experience.gui.view.PanelHabilidad;

public class PanelHabilidadController {

    private PanelHabilidad panelHabilidad;
    private JFileChooser fileChooser;

    public PanelHabilidadController(PanelHabilidad panelHabilidad){
        this.panelHabilidad = panelHabilidad;
        fileChooser  = new JFileChooser();
        initialize();
    }

    private void initialize(){

        panelHabilidad.getBotonCarga().setText("Boton para cargar habilidad");

        panelHabilidad.getBotonCarga().addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                int operacion = fileChooser.showOpenDialog(null);
                
                if(operacion == JFileChooser.APPROVE_OPTION){
                    panelHabilidad.getCampoTexto().append("* " + fileChooser.getSelectedFile().getName() + "\n");      
                }
             }
        }); 
    }
}
