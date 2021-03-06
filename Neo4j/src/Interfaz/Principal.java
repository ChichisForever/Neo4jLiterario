package Interfaz;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
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
import Codigo.Nodos;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Principal extends JFrame implements Funciones {

    public JPanel contentPane;
    public Controlador control;
    public JFrame frmInicio;
    public JComboBox cboxautor;
    public JComboBox cboxgenero;
    public JButton btnAgregar;
    public JButton btngenroNoEncontrado;
    public JComboBox cboxautorc;
    public JComboBox cboxgeneroc;
    public JButton btnBuscar;
    public JTextField txtagregarnombre;
    public JButton btnAutor;
    public JTextField txtconnombre;
    private JPanel panel_consulta;
    public JLabel lblmensaje;
    private JTable table;



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
        frmInicio.setBounds(30, 30, 800,332 );
        frmInicio.setVisible(false);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 784, 306);
        frmInicio.getContentPane().add(panel);
        panel.setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(6, 6, 778, 289);
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

        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(218, 229, 89, 23);
        panel_agregar.add(btnAgregar);

        btngenroNoEncontrado = new JButton("\u00BFGen\u00E9ro no encontrado");
        btngenroNoEncontrado.setBounds(306, 116, 206, 23);
        panel_agregar.add(btngenroNoEncontrado);

        JLabel lblAutor = new JLabel("Autor");
        lblAutor.setBounds(10, 81, 46, 14);
        panel_agregar.add(lblAutor);

        cboxautor = new JComboBox();
        cboxautor.setBounds(86, 72, 184, 20);
        panel_agregar.add(cboxautor);
        
        btnAutor = new JButton("\u00BFAutor no encontrado");
        btnAutor.setBounds(306, 72, 206, 23);
        panel_agregar.add(btnAutor);

        panel_consulta = new JPanel();
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

        cboxgeneroc = new JComboBox();
        cboxgeneroc.setBounds(98, 133, 186, 20);
        panel_consulta.add(cboxgeneroc);

        cboxautorc = new JComboBox();
        cboxautorc.setBounds(98, 94, 186, 20);
        panel_consulta.add(cboxautorc);

        txtconnombre = new JTextField();
        txtconnombre.setBounds(95, 55, 189, 28);
        panel_consulta.add(txtconnombre);
        txtconnombre.setColumns(10);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(237, 178, 89, 23);
        panel_consulta.add(btnBuscar);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/Interfaz/Imagen1.png")));
        lblNewLabel.setBounds(365, 148, 121, 118);
        panel_consulta.add(lblNewLabel);
        
        lblmensaje = new JLabel("");
        lblmensaje.setBounds(10, 231, 345, 14);
        panel_consulta.add(lblmensaje);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 204, 255));
        panel_1.setBounds(496, 41, 267, 183);
        panel_consulta.add(panel_1);
        
        JScrollPane scrollPane = new JScrollPane();
        panel_1.add(scrollPane);
        
        table = new JTable();
        scrollPane.add(table);
        
       
        
    }


	@Override
	public void mostrar_agregar(int tipo) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void llenar(ArrayList<String> g, 
			ArrayList<String> e) {
	//	vaciar_Combobox();
		vaciar_Combobox();
		DefaultComboBoxModel genero = new DefaultComboBoxModel();
		genero.addElement("Seleccione uno");
		DefaultComboBoxModel autor = new DefaultComboBoxModel();
		autor.addElement("Seleccione uno");
		
		
		for (String x:g){
			genero.addElement(x);
		}
		
		for (String x:e){
			autor.addElement(x);
			
		}
		this.cboxautor.setModel(autor);
		this.cboxautorc.setModel(autor);
		this.cboxgenero.setModel(genero);
		this.cboxgeneroc.setModel(genero);
		this.frmInicio.setVisible(true);
	}

	public void vaciar_Combobox(){
		this.cboxgenero.removeAllItems();
		this.cboxgeneroc.removeAllItems();
		this.cboxautor.removeAll();
		this.cboxautorc.removeAll();
	}
	@Override
	public void cerrar_vista(int tipo) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void llenar_tabla(ArrayList<Nodos> N) {
		 DefaultTableModel model = new DefaultTableModel();
		 model.addColumn("Autor");
		 model.addColumn("Obra");
		 model.addColumn("Genero Literario");
		 
		 for (Nodos x:N){
			 model.addRow(new Object[]{x.Actor,x.Obra,x.GeneroLiterario});
			 
		 }
		 table.setModel(model);
		 table.setVisible(true);
		 this.lblmensaje.setText("Consulta Terminada");
		 
		 }
	}

