package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

import Codigo.Controlador;
import Codigo.Funciones;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class agregar extends JFrame implements Funciones {
	private Image fondo;
	
	private JFrame frame;
	private Controlador control;
	public JLabel lbldato;
	public JTextField txtdato;
	public JButton btnAgregar;
	private int opcion;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public agregar(Controlador usar){
		control=usar;
		control.setAgregar(this);
		iniciar();
		addevents();
		
	}
	private void addevents() {
		this.btnAgregar.addActionListener(control);
		
		
	}
	public void iniciar() {
		  frame = new JFrame();
	        frame.setTitle("Inicio");
	        frame.getContentPane().setBackground(new Color(255, 255, 255));
	        frame.getContentPane().setLayout(null);
	        frame.setVisible(false);
	        frame.setBounds(30, 30, 457,328 );

		
		
	     
	      ImagenFondo image=new ImagenFondo("fondo.png");
	      frame.getContentPane().add(image);

	      image.setLayout(null);
	      
	      lbldato = new JLabel("");
	      lbldato.setBounds(25, 21, 305, 14);
	      image.add(lbldato);
	      
	      image.setBounds(0,0,444,288);
	      txtdato = new JTextField();
	      txtdato.setBounds(94, 83, 217, 20);
	      image.add(txtdato);
	      txtdato.setColumns(10);
	      
	      btnAgregar = new JButton("Agregar");
	      btnAgregar.setBounds(184, 150, 89, 23);
	      image.add(btnAgregar);
	     
	      frame.getContentPane().add(image);
	}
	@Override
	public void mostrar_agregar(int tipo) {
		if (tipo==0){
			this.lbldato.setText("Ingrese el nombre del autor");
		}
		if (tipo==1){
			this.lbldato.setText("Ingrese el genero");
		}
		if (tipo==2){
			this.lbldato.setText("Ingrese el tipo");
		}
		opcion=tipo;
		frame.setVisible(true);
		
		
	}
}
