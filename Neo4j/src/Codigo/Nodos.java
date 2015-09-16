package Codigo;

public class Nodos {
	public String Actor;
	public String Obra;
	public String GeneroLiterario;
	public String Clase;


public Nodos(String A,String O,String G){
	this.Actor=A;
	this.GeneroLiterario=G;
	this.Obra=O;
}


public String getActor() {
	return Actor;
}


public void setActor(String actor) {
	Actor = actor;
}


public String getObra() {
	return Obra;
}


public void setObra(String obra) {
	Obra = obra;
}


public String getGeneroLiterario() {
	return GeneroLiterario;
}


public void setGeneroLiterario(String generoLiterario) {
	GeneroLiterario = generoLiterario;
}


public String getClase() {
	return Clase;
}


public void setClase(String clase) {
	Clase = clase;
}

public void Mostrar(){
	System.out.print("Autor" + this.Actor +"\n"+"Titulo" + this.Obra+"\n" + "Genero"+this.GeneroLiterario);
}

}