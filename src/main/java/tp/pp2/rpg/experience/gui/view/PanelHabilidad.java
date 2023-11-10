package tp.pp2.rpg.experience.gui.view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.gui.BotonListener;
import tp.pp2.rpg.experience.gui.controller.PanelHabilidadController;

public class PanelHabilidad extends JPanel implements Observer {

    private PanelHabilidadController panelHabilidadController;
    private JButton botonCargaHabilidad;
    private JButton iniciarBatalla;
    private JTextArea campoTexto;
    private JTextArea mensajeError;
    private JLabel fondo;
    private JLabel mensaje;
    private Batalla batalla;

    public PanelHabilidad(Batalla batalla){
        initialize();
        this.batalla=batalla;
        panelHabilidadController = new PanelHabilidadController(this,batalla);
    }

    private void initialize(){
        fondo = new JLabel(new ImageIcon(this.getClass().getClassLoader().getResource("images\\fondo.jpg")));
        mensaje = new JLabel();
        botonCargaHabilidad = new JButton();
        iniciarBatalla = new JButton();
        campoTexto = new JTextArea();
        campoTexto.setEditable(false);
        mensajeError = new JTextArea();
        mensajeError.setEditable(false);

        fondo.setBounds(0,0,1000,700);

        botonCargaHabilidad.setBounds(600, 265, 300, 100);
        botonCargaHabilidad.setContentAreaFilled(false);
        botonCargaHabilidad.setForeground(Color.WHITE);
        botonCargaHabilidad.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
        
        iniciarBatalla.setBounds(600, 500, 300, 100);
        iniciarBatalla.setContentAreaFilled(false); 
        iniciarBatalla.setForeground(Color.WHITE);
        iniciarBatalla.setFont(new Font(Font.DIALOG, Font.BOLD, 24));

        mensaje.setText("HABILIDADES CARGADAS");
        mensaje.setBounds(100,215,200,50);
        mensaje.setOpaque(false);
        mensaje.setForeground(Color.BLACK);

        campoTexto.setBounds(100, 265, 400, 350);
        campoTexto.setOpaque(false);
        campoTexto.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
        campoTexto.setForeground(Color.BLACK);
        
        mensajeError.setBounds(220, 100,600, 30);
        mensajeError.setOpaque(false);
        mensajeError.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
        mensajeError.setForeground(Color.RED);
       
        this.add(botonCargaHabilidad);
        this.add(campoTexto);
        this.add(mensaje);
        this.add(mensajeError);
        this.add(iniciarBatalla);
        this.add(fondo);
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

	@Override
	public void update(Observable o, Object arg) {
		this.getCampoTexto().setText("");
        batalla.getHabilidades().forEach(h-> this.getCampoTexto().append( "* " + h.getNombre()+ "\n"));
	}
    
}
