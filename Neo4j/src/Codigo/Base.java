package Codigo;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class Base {
	    //Variables para realizar las consultas
		String path;
		String resultString;
	    String columnsString;
	    String nodeResult;
	    String rows = "";
	    
	
	    
	public Base(String p){
		path=p;
	}
	//Crear tipos de nodos
	 public enum NodeType implements Label{
	       GeneroLiterario,Clase,Escritor,Obra
	    }
	 //Crea relaciones
	 public enum RelationType implements RelationshipType{
	        es_de,es_una,Escribio
	    }
	 
	
	public ArrayList<String> consultas_Simples (String c){
	//Devuelven solo un valor,que es un String.Creada principalmente para llenar los combobox
		ArrayList<String> devolver =new ArrayList();
		GraphDatabaseService db = new GraphDatabaseFactory().newEmbeddedDatabase("C:\\Users\\LATITUDE\\Documents\\Neo4j\\default.graphdb");
		  try ( Transaction ignored = db.beginTx();
	                Result result = db.execute(c) )
	          {
	            while ( result.hasNext() )
	            {
	                Map<String,Object> row = result.next();
	                for ( Entry<String,Object> column : row.entrySet() )
	                {
	                    rows = (String) column.getValue();
	                    devolver.add(rows);
	                    
	                }
	                
	            }
	            db.shutdown();
	            return devolver;
		
	}
		  
	    
}
	//Crear nodos
	public void crearNodos(int tipo,String valor){
		GraphDatabaseService db = new GraphDatabaseFactory().newEmbeddedDatabase("C:\\Users\\LATITUDE\\Documents\\Neo4j\\default.graphdb");
		//Tipo 0,ingresar autor
		try(Transaction tx = db.beginTx()){
		if (tipo==0){
			Node Autor = db.createNode(NodeType.Escritor);
			Autor.setProperty("nombre",valor);
		}
		if (tipo==1){
			Node Genero = db.createNode(NodeType.GeneroLiterario);
			Genero.setProperty("nombre",valor);
		}
		if (tipo==2){
			Node t=db.createNode(NodeType.Clase);
			t.setProperty("nombre",valor);
		}
		tx.success();
		}
		db.shutdown();
	}
	public void CrearObra(String nombre,String autorc,String generoc,String tipoc){
		GraphDatabaseService db = new GraphDatabaseFactory().newEmbeddedDatabase("C:\\Users\\LATITUDE\\Documents\\Neo4j\\default.graphdb");
		try(Transaction tx = db.beginTx()){
		Node Obra= db.createNode(NodeType.Obra);
		Obra.setProperty("nombre",nombre);
		Result autor=  db.execute("match (a:Escritor), (b:Obra) where a.nombre ="+"\""+autorc +"\" "+"and b.nombre ="+"\""+nombre+"\" "+ "create (a)-[r:Escribio]->(b) return r");
		Result Genero=db.execute("match (a:Obra), (b:Genero) where a.nombre ="+"\""+nombre +"\" "+"and b.nombre ="+"\""+generoc+"\" "+ "create (a)-[r:es_una]->(b) return r");
		Result Tipo=db.execute("match (a:Obra), (b:Clase) where a.nombre ="+"\""+nombre +"\" "+"and b.nombre ="+"\""+tipoc+"\" "+ "create (a)-[r:es_de]->(b) return r");
		
		
		tx.success();
		
		}
		db.shutdown();
	}
	}


