/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neo4j_prueba;


//import javax.management.relation.RelationType;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
/**
 *
 * @author Administrador
 */
//Agregar libreria neo4j-desktop-2.2.5.jar (clic derecho en la carpeta Libraries ADD JAR/Folder)
public class Neo4j_Prueba {

    //Creacion de etiquetas para los nodos(tipos)
    public enum NodeType implements Label{
        Person,Course
    }
    //Creacion de etiquetaas para las relaciones entre los nodos
    public enum RelationType implements RelationshipType{
        Knows,BelongsTo
    }
    
    public static void main(String[] args) {
     GraphDatabaseFactory neodb = new  GraphDatabaseFactory();
     //Direccion de la Base de datos Neo4j
     GraphDatabaseService graphDb = neodb.newEmbeddedDatabase("C:\\Users\\Administrador\\Documents\\Neo4j\\default.graphdb");

     try(Transaction tx = graphDb.beginTx()){
         //Creacion de nodos con sus propiedades
       Node bobNode = graphDb.createNode(NodeType.Person);// Tipo del nodo Person
       bobNode.setProperty("Pid", 5001);
       bobNode.setProperty("Name", "Bob");
       bobNode.setProperty("Age",23);
       
       Node aliceNode = graphDb.createNode(NodeType.Person);
       aliceNode.setProperty("Pid", 5002);
       aliceNode.setProperty("Name", "Eve");
       
       Node eveNode = graphDb.createNode(NodeType.Person);
       eveNode.setProperty("Name","Eve");
       
       Node itNode = graphDb.createNode(NodeType.Course);//TIpo del nodo Course
       itNode.setProperty("Id",1);
       itNode.setProperty("Name", "IT Beginners");
       itNode.setProperty("Location","Room 153");
       
       Node electronicNode = graphDb.createNode(NodeType.Course);
       electronicNode.setProperty("Name", "Electronics Advanced");
       
       //Creacion de relaciones entre los nodos
       bobNode.createRelationshipTo(aliceNode,RelationType.Knows);//Tipo de relacion Knows
       
       Relationship bobRelIt = bobNode.createRelationshipTo(itNode, RelationType.BelongsTo);//Tipo de relacion BelongsTo
       bobRelIt.setProperty("Function", "Student");
       
       Relationship bobRelElectronics = bobNode.createRelationshipTo(electronicNode, RelationType.BelongsTo);
       bobRelElectronics.setProperty("Function", "Supply Teacher");
       
         Relationship aliceRelIt = aliceNode.createRelationshipTo(itNode, RelationType.BelongsTo);
         aliceRelIt.setProperty("Function", "Teacher");
         
         tx.success(); //Proceso termino de forma exitosa
         
    }
     graphDb.shutdown();//Cerrar base
    }
        
}
