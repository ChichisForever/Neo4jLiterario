package Codigo;
import Interfaz.*;

public class Inicio {
	public static void main (String [] args){
		Modelo m = new Modelo();
		Controlador control= new Controlador(m);
		m.limpiar();
		
		Principal principal = new Principal(control);
		m.addContactView(principal);
		
		agregar agregar = new agregar(control);
		m.addContactView(agregar);
		
		
	}
}
