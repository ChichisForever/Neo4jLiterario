package Codigo;

import java.util.ArrayList;
import java.util.Iterator;

public class Modelo {
	static ArrayList<Funciones> vistas=new ArrayList<Funciones>();
	
	public Modelo(){
		this(null);
	}
	public Modelo(Funciones vista) {
		if (vistas !=null){
			vistas.add(vista);
		}
		
	}
	//Funciones de las vistas
	public void addContactView(Funciones view){
		if (!vistas.contains(view)){
			vistas.add(view);
		}
	}
	public void limpiar (){
		vistas.removeAll(vistas);
		System.out.print(vistas.size());
	}
	
	//Funciones de la aplicacion
	public void llamar_Ventana(int tipo){
		Iterator<Funciones> notificar = vistas.iterator();
		while (notificar.hasNext()){
			notificar.next().mostrar_agregar(tipo);
		}
	}
	
}
