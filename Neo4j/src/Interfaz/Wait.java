package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import Codigo.Controlador;
import Codigo.Funciones;

import java.awt.GridBagLayout;
import java.util.ArrayList;

public class Wait extends JFrame implements Funciones {

	private JPanel contentPane;
	private JFrame frame;
	private Controlador control;



	/**
	 * Create the frame.
	 */
	
	public Wait(Controlador c){
		control=c;
		c.setEspere(this);
		iniciar();
	}
	public void iniciar() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Wait.class.getResource("/Interfaz/espere.png")));
        lblNewLabel.setBounds(0, 0, 450, 155);
        frame.getContentPane().add(lblNewLabel);
        frame.setVisible(true);
        frame.setBounds(30, 30, 466,194 );
        frame.setVisible(true);
		//frame.setUndecorated(true);
		
		
		
	}
	@Override
	public void mostrar_agregar(int tipo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void llenar(ArrayList<String> g, ArrayList<String> t,
			ArrayList<String> e) {
		frame.setVisible(false);
		
	}
	@Override
	public void cerrar_vista(int tipo) {
		// TODO Auto-generated method stub
		
	}
}
