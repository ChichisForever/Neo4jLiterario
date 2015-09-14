package Interfaz;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.ImageIcon;

import Codigo.Controlador;
import Codigo.Funciones;

public class Principal extends JFrame implements Funciones {

    public JPanel contentPane;
    public Controlador control;
    public JFrame frmInicio;
    public JComboBox cboxautor;
    public JComboBox cboxgenero;
    public JComboBox cboxtipo;
    public JButton btnAgregar;
    public JButton btntipoNoEncontrado;
    public JButton btngenroNoEncontrado;
    public JComboBox cboxautorc;
    public JComboBox cboxgeneroc;
    public JComboBox cboxtipoc;
    public JButton btnBuscar;
    public JTextField txtagregarnombre;
    public JButton btnAutor;



    /**
     * Launch the application.

     */


    /**
     * Create the frame.
     */
    public Principal(Controlador usar){
        control=usar;
        control.setPrinc(this);
        iniciar();
        addevents();
    }


    private void addevents() {
		this.btnAgregar.addActionListener(control);
		this.btngenroNoEncontrado.addActionListener(control);
		this.btntipoNoEncontrado.addActionListener(control);
		this.btnBuscar.addActionListener(control);
		this.btnAutor.addActionListener(control);
	}


	public void iniciar() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }

        frmInicio = new JFrame();
        frmInicio.setTitle("Inicio");
        frmInicio.getContentPane().setBackground(new Color(255, 255, 255));
        frmInicio.getContentPane().setLayout(null);
        frmInicio.setVisible(true);
        frmInicio.setBounds(30, 30, 638,332 );
        frmInicio.setVisible(false);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 622, 306);
        frmInicio.getContentPane().add(panel);
        panel.setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(6, 6, 607, 289);
        panel.add(tabbedPane);


        JPanel panel_agregar = new JPanel();
        panel_agregar.setBackground(new Color(51, 204, 255));
        tabbedPane.addTab("Agregar Obras", null, panel_agregar, null);
        panel_agregar.setLayout(null);

        JLabel lblCompleteTodosLos = new JLabel("Complete todos los campos para poder ingresar una obra");
        lblCompleteTodosLos.setBounds(35, 5, 450, 14);
        panel_agregar.add(lblCompleteTodosLos);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(10, 44, 65, 14);
        panel_agregar.add(lblNombre);

        txtagregarnombre = new JTextField();
        txtagregarnombre.setBounds(86, 41, 184, 20);
        panel_agregar.add(txtagregarnombre);
        txtagregarnombre.setColumns(10);

        JLabel lblGenro = new JLabel("Gen\u00E9ro");
        lblGenro.setBounds(10, 120, 46, 14);
        panel_agregar.add(lblGenro);

        cboxgenero = new JComboBox();
        cboxgenero.setBounds(86, 117, 184, 20);
        panel_agregar.add(cboxgenero);

        JLabel lblTipo = new JLabel("Tipo");
        lblTipo.setBounds(10, 171, 46, 14);
        panel_agregar.add(lblTipo);

        cboxtipo = new JComboBox();
        cboxtipo.setBounds(86, 168, 184, 20);
        panel_agregar.add(cboxtipo);

        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(218, 229, 89, 23);
        panel_agregar.add(btnAgregar);

        btngenroNoEncontrado = new JButton("\u00BFGen\u00E9ro no encontrado");
        btngenroNoEncontrado.setBounds(306, 116, 206, 23);
        panel_agregar.add(btngenroNoEncontrado);

        btntipoNoEncontrado = new JButton("\u00BFTipo no encontrado");
        btntipoNoEncontrado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btntipoNoEncontrado.setBounds(306, 167, 206, 23);
        panel_agregar.add(btntipoNoEncontrado);

        JLabel lblAutor = new JLabel("Autor");
        lblAutor.setBounds(10, 81, 46, 14);
        panel_agregar.add(lblAutor);

        cboxautor = new JComboBox();
        cboxautor.setBounds(86, 72, 184, 20);
        panel_agregar.add(cboxautor);
        
        btnAutor = new JButton("\u00BFAutor no encontrado");
        btnAutor.setBounds(306, 72, 206, 23);
        panel_agregar.add(btnAutor);

        JPanel panel_consulta = new JPanel();
        panel_consulta.setBackground(new Color(0, 204, 255));
        tabbedPane.addTab("Consulta de Obras", null, panel_consulta, null);
        panel_consulta.setLayout(null);

        JLabel lblRealiceSuConsulta = new JLabel("Realice su consulta");
        lblRealiceSuConsulta.setBounds(173, 6, 220, 14);
        panel_consulta.add(lblRealiceSuConsulta);

        JLabel label = new JLabel("");
        label.setBounds(10, 61, 46, 14);
        panel_consulta.add(label);

        JLabel label_1 = new JLabel("Nombre");
        label_1.setBounds(20, 60, 65, 14);
        panel_consulta.add(label_1);

        JLabel label_2 = new JLabel("Autor");
        label_2.setBounds(20, 97, 46, 14);
        panel_consulta.add(label_2);

        JLabel label_3 = new JLabel("Gen\u00E9ro");
        label_3.setBounds(20, 136, 46, 14);
        panel_consulta.add(label_3);

        JLabel label_4 = new JLabel("Tipo");
        label_4.setBounds(20, 187, 46, 14);
        panel_consulta.add(label_4);

        cboxgeneroc = new JComboBox();
        cboxgeneroc.setBounds(98, 133, 186, 20);
        panel_consulta.add(cboxgeneroc);

        cboxtipoc = new JComboBox();
        cboxtipoc.setBounds(98, 184, 186, 20);
        panel_consulta.add(cboxtipoc);

        cboxautorc = new JComboBox();
        cboxautorc.setBounds(98, 94, 186, 20);
        panel_consulta.add(cboxautorc);

        JTextField txtconnombre = new JTextField();
        txtconnombre.setBounds(95, 55, 189, 20);
        panel_consulta.add(txtconnombre);
        txtconnombre.setColumns(10);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(230, 227, 89, 23);
        panel_consulta.add(btnBuscar);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/Interfaz/Imagen1.png")));
        lblNewLabel.setBounds(365, 148, 121, 118);
        panel_consulta.add(lblNewLabel);
    }


	@Override
	public void mostrar_agregar(int tipo) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void llenar(ArrayList<String> g, ArrayList<String> t,
			ArrayList<String> e) {
	//	vaciar_Combobox();
		this.cboxgenero.addItem("Seleccione uno");
		this.cboxgeneroc.addItem("Seleccione uno");
		this.cboxtipo.addItem("Seleccione uno");
		this.cboxtipoc.addItem("Seleccione uno");
		this.cboxautor.addItem("Seleccione uno");
		this.cboxautorc.addItem("Seleccione uno");
		for (String x:g){
			this.cboxgenero.addItem(x);
			this.cboxgeneroc.addItem(x);
		}
		for (String x:t){
			this.cboxtipo.addItem(x);
			this.cboxtipoc.addItem(x);
		}
		for (String x:e){
			this.cboxautor.addItem(x);
			this.cboxautorc.addItem(x);
		}
		this.frmInicio.setVisible(true);
	}

	public void vaciar_Combobox(){
		this.cboxautor.removeAll();
	}
	@Override
	public void cerrar_vista(int tipo) {
		// TODO Auto-generated method stub
		
	}
}
