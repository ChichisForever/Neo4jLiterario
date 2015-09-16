package Codigo;

import java.util.ArrayList;
import java.util.Iterator;

public class Modelo {
	//Array con las vistas
	static ArrayList<Funciones> vistas=new ArrayList<Funciones>();
	//Base de datos
	public Base b;
	
	public Modelo(){
		this(null);
		
	}
	//Agrega las  vistas y inicializa la base
	public Modelo(Funciones vista) {
		if (vistas !=null){
			vistas.add(vista);
		}
		b=new Base("C:\\Users\\LATITUDE\\Documents\\Neo4j\\default.graphdb");
		
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
	//Llama la base para inicializar los combobox
	public void llenar_combobox(){
		ArrayList <String> genero = b.consultas_Simples("match (g:GeneroLiterario) return g.nombre");
		ArrayList <String> autor=b.consultas_Simples("match (g:Escritor) return g.nombre");
		
		Iterator<Funciones> notificar = vistas.iterator();
		while (notificar.hasNext()){
			notificar.next().llenar(genero, autor);
		}
		
		
		
	}

	
	//Funciones de la aplicacion
	public void llamar_Ventana(int tipo){
		Iterator<Funciones> notificar = vistas.iterator();
		while (notificar.hasNext()){
			notificar.next().mostrar_agregar(tipo);
		}
	}
	
	public void CrearObra(String nombre,String autorc,String generoc){
		b.CrearObra(nombre, autorc, generoc);
		
	}
	public void agregar(int  tipo,String dato){
		b.crearNodos(tipo, dato);
		llenar_combobox();
		
	}
	public void Consultas(String A,String G,String O){
		//Realiza la consulta segun sean los datos
		ArrayList<Nodos> obras= new ArrayList<Nodos>();
		System.out.print(A+G+O);
		String consulta=" ";
		if (A==null && G==null && O==null){
			consulta= "match (E)-[:Escribio]-(O)-[:es_una]-(G) return E.nombre,O.nombre,G.nombre";
		}
		if (A==null && G!=null && O!=null){
			consulta=" match (E)-[:Escribio]-(O{nombre:\""+O+"\"})-[:es_una]-(G{nombre:\""+G+"\"}) return E.nombre,O.nombre,G.nombre";
		}
		if (A!=null && G==null && O!=null){
			consulta= " match (E{nombre:\""+A+"\"})-[:Escribio]-(O{nombre:\""+O+"\"})-[:es_una]-(G) return E.nombre,O.nombre,G.nombre" ;
		}
		if (A!=null && G!=null && O==null){
			consulta=" match (E{nombre:\""+A+"\"})-[:Escribio]-(O)-[:es_una]-(G{nombre:\""+G+"\"}) return E.nombre,O.nombre,G.nombre";
		}
		if (A!=null && G==null && O==null){
			consulta= "match (E{nombre:\""+A+"\"})-(O)-[:es_una]-(G) return E.nombre,O.nombre,G.nombre";
		}
		if (A==null && G!=null && O==null){
			consulta=" match (E)-[:Escribio]-(O)-[:es_una]-(G{nombre:\""+G+"\"}) return E.nombre,O.nombre,G.nombre";
		}
		if (A==null && G==null && O!=null){
			consulta="match (E)-[:Escribio]-(O{nombre:\""+O+"\"})-[:es_una]-(G) return E.nombre,O.nombre,G.nombre";
		}
		if (A!=null && G!=null && O!=null){
			consulta=" match (E{nombre:\""+A+"\"})-[:Escribio]-(O{nombre:\""+O+"\"})-[:es_una]-(G{nombre:\""+G+"\"}) return E.nombre,O.nombre,G.nombre";
		}
		
		obras = b.Consultas(consulta);
		Iterator<Funciones> notificar = vistas.iterator();
		while (notificar.hasNext()){
			notificar.next().llenar_tabla(obras);	
		}
		
		}
		
	}
	
	

