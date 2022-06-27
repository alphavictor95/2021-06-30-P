package it.polito.tdp.genes.model;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.genes.db.GenesDao;

public class Model {

	GenesDao dao = new GenesDao();
	Graph<String, DefaultWeightedEdge> grafo;
	
	public String creaGrafo() {
		String result="";
		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		Graphs.addAllVertices(this.grafo, dao.getLocations());
		// aggiungo archi
		List<Edge> archi = new ArrayList<Edge>();
		dao.getArchi(archi);
		for(String l : this.grafo.vertexSet()) {
			for(Edge e : archi) {
				if(e.getL1().compareTo(l)==0 && !this.grafo.containsEdge(e.l1, e.l2)) {
					Graphs.addEdgeWithVertices(this.grafo, e.getL1(), 
							e.getL2(), e.getPeso());
				}
				
			}
		}
		
		result = "Grafo creato con: "+this.grafo.vertexSet().size()+
				" vertici e "+this.grafo.edgeSet().size()+ " archi\n";
		return result;
	}

	public List<String> getLocalizzazioni() {
		// TODO Auto-generated method stub
		return dao.getLocations();
	}

	public String getConnesse(String selezionata) {
		String ret="";
		for(String v : Graphs.neighborListOf(this.grafo, selezionata)) {
			ret = ret+v+" "+
		this.grafo.getEdgeWeight(this.grafo.getEdge(selezionata, v))+"\n";
		}
		return ret;
	}

}