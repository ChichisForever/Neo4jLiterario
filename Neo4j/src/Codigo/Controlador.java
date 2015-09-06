package Codigo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Interfaz.Principal;

public class Controlador implements ActionListener {
	private Modelo modelo;
	private Principal princ;
	private Interfaz.agregar agregar;
	
	public Controlador(Modelo m){
		modelo = m;
		
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		Object source = evt.getSource();
		if (source==princ.btnAgregar){
			System.out.print("yeah");
		}
		if (source==princ.btnBuscar){
			System.out.print("#perreacomolaica");
		}
		if (source==princ.btngenroNoEncontrado){
			modelo.llamar_Ventana(1);
		}
		if (source==princ.btntipoNoEncontrado){
			modelo.llamar_Ventana(2);
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

}
