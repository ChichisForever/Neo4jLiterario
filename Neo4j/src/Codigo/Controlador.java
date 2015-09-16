package Codigo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Interfaz.Principal;

public class Controlador implements ActionListener {
	private Modelo modelo;
	private Principal princ;
	private Interfaz.agregar agregar;
	private Interfaz.Wait espere;
	
	public Controlador(Modelo m){
		modelo = m;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		Object source = evt.getSource();
		if (source==princ.btnAgregar){
			modelo.CrearObra(princ.txtagregarnombre.getText(), (String)princ.cboxautor.getSelectedItem(),(String) princ.cboxgenero.getSelectedItem());
		}
		if (source==princ.btnBuscar){
			princ.lblmensaje.setText("Procesando su consulta");
			String A=null;
			String G=null;
			String O=null;
			
			if (princ.cboxautorc.getSelectedIndex()!= 0){
				A= (String)princ.cboxautorc.getSelectedItem();
				
			}
			if (princ.cboxgeneroc.getSelectedIndex()!=0){
				G=(String)princ.cboxgeneroc.getSelectedItem();
			}
			
			if (princ.txtconnombre.getText()== null){
				O=princ.txtconnombre.getText();
			}
			
			modelo.Consultas(A, G, O);
	
		}
		if (source==princ.btngenroNoEncontrado){
			modelo.llamar_Ventana(1);
		}

		if (source==princ.btnAutor){
			modelo.llamar_Ventana(0);
		}
		if (source==agregar.btnAgregar){
			modelo.agregar(agregar.actual,agregar.txtdato.getText() );
			
		}
		}

		
	
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public Principal getPrinc() {
		return princ;
	}
	public void setPrinc(Principal princ) {
		this.princ = princ;
	}
	public Interfaz.agregar getAgregar() {
		return agregar;
	}
	public void setAgregar(Interfaz.agregar agregar) {
		this.agregar = agregar;
	}

	public Interfaz.Wait getEspere() {
		return espere;
	}

	public void setEspere(Interfaz.Wait espere) {
		this.espere = espere;
	}
	

}
