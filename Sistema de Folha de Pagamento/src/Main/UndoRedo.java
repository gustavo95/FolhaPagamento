package Main;

import java.util.ArrayList;
import java.util.List;

import Empregados.Assalariados;
import Empregados.Comissionados;
import Empregados.Empregados;
import Empregados.Horistas;

public class UndoRedo {
	
	private List<List<Empregados>> lista;
	int indiceAtual;
	int indiceMaximo;
	
	public UndoRedo(){
		this.lista = new ArrayList<List<Empregados>>();
		lista.add(new ArrayList<Empregados>());
		this.indiceAtual = 0;
		this.indiceMaximo = 0;
	}
	
	public static List<Empregados> clonarLista(List<Empregados> lista) {
	    ArrayList<Empregados> clone = new ArrayList<Empregados>();
	    for(Empregados item: lista){
	    	if(item instanceof Horistas){
	    		Horistas h = new Horistas((Horistas) item);
	    		clone.add(h);
	    	}else if(item instanceof Comissionados){
	    		Comissionados c = new Comissionados((Comissionados) item);
	    		clone.add(c);
	    	}else if(item instanceof Assalariados){
	    		Assalariados a = new Assalariados((Assalariados) item);
	    		clone.add(a);
	    	}
	  
	    }
	    return clone;
	}
	
	public void add(List<Empregados> listaEmpregados){
		indiceMaximo = ++indiceAtual;
		lista.add(indiceAtual, clonarLista(listaEmpregados));
	}
	
	public List<Empregados> undo(){
		if(indiceAtual > 0){
			indiceAtual--;
			System.out.println("Ação desfeita");
			return clonarLista(lista.get(indiceAtual));
		}else{
			System.out.println("Não há ação para ser desfeita");
			return clonarLista(lista.get(0));
		}
	}
	
	public List<Empregados> redo(){
		if(indiceAtual < indiceMaximo){
			indiceAtual++;
			System.out.println("Ação refeita");
			return clonarLista(lista.get(indiceAtual));
		}else{
			System.out.println("Não há ação para ser refeita");
			return clonarLista(lista.get(indiceMaximo));
		}
	}

}
