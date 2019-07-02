package controller;

import java.util.ArrayList;

import model.Graph;
import model.Edge;
import model.Node;




public class GraphND {
	public Graph g;
	
	
	public void GraphND() {
		g = new Graph();
	}
        
        public Graph getGraphND(){
            return g;
        }
		
		
	public void add_node(Node node){
		if(exist_node(node.getId())==false)
			g.getGraph().add(node);
                else{
			System.out.println("El nodo ya existe");
                }
		
		
	}
	
	public void add_edge(Node from,Node to,int weight){ 

		if(from != null && to != null ) {
			Edge newEdgeAt = new Edge();
			Edge newEdgeFrom = new Edge();
			newEdgeAt.setId(to.getId());
			newEdgeAt.setWeight(weight);
			
			newEdgeFrom.setId(from.getId());
			newEdgeFrom.setWeight(weight);

			if(!exist_edge(from,to)) {
				from.getEdges().addFirst(newEdgeAt);
				to.getEdges().addFirst(newEdgeFrom);
				System.out.println("Se añadio arista: ("+from.getId()+","+to.getId()+") y"+"("+to.getId()+","+from.getId()+")");
			}else
				System.out.println("La arista ya existe");
			
		}
		
	}
        
        public void remove_node(Node node) {
            for (Node n : g.getGraph()){
                if(node.getId() != n.getId()){
                    remove_node_edges(n,node);
                }
            }
            g.getGraph().remove(node);	
	}

	public void remove_node_edges(Node from, Node to){
                for(Edge e : from.getEdges()){
                    if (e.getId() == to.getId()) 
                        from.getEdges().remove(e);		
                }		
	}
	
	
	public void remove_edge(Node from, Node to) {
            
		for(int i=0;i < from.edges.size();i++) {
			Edge edge = from.edges.get(i);
			
			if (to.getId() == edge.getId()) {
				from.edges.remove(i);	
				
			}
		}
		
		for (int i=0;i< to.edges.size();i++){
			Edge edge = to.edges.get(i);
			
			if (from.getId() == edge.getId()) {
				to.edges.remove(i);	
				
			}
			
			
		}
		
	}
	
	public boolean exist_node(int id) {
		
			for(int i=0;i<g.getGraph().size();i++) {
				Node nodeCurrent = g.getGraph().get(i);
				if(nodeCurrent.id == id ) {
					return true;		
				}	
			}
			return false;
	}
	
	public boolean exist_edge(Node from,Node to) {
            for(int i=0;i < from.getEdges().size();i++) {
                Edge edge = from.getEdges().get(i);	
                if (to.getId() == edge.getId()) 
                    return true;		
		}
            return false;
}
        
 
	public ArrayList<Node> adj_nodes (Node nodeSearch) {
		ArrayList <Node> adjList = new ArrayList<Node>();
		Edge edge = new Edge();
		
		for(int i=0;i<nodeSearch.edges.size();i++) {
			edge = nodeSearch.edges.get(i);
			 adjList.add((search_node(edge.id)));
		}
		System.out.print("Nodos Adjacentes a "+nodeSearch.id +": [ ");
		for(int i=0;i<adjList.size();i++) {
			System.out.print(adjList.get(i).id+" ");
			
		}
		System.out.print("]");
		System.out.println("");
		return adjList;
	}
	
	public int weight_edge(Node from, Node to) {
            for(Edge e : from.getEdges()){
                if (to.getId() == e.getId()) {
                   int weightEdge = e.getWeight();
                    System.out.println("Peso:"+e.getWeight());
                    return weightEdge;
                }  
            }
            return -1;
	}
	
	public void print_graph(){
		Node node = new Node();
		Edge edge = new Edge();
		System.out.println(" ");
		
		for(int i=0;i < g.getGraph().size();i++ ) {
			node = g.getGraph().get(i);
			System.out.print("NODO: "+node.id+" ARISTAS: [");
			
			for(int j=0;j < node.edges.size();j++) {
				edge = node.edges.get(j);
				System.out.print(" (ID: "+edge.id+" PESO: "+edge.weight+") ");
			}
			System.out.print(" ] ");
			System.out.println(" ");
			
			
		}
    }
	
	public boolean is_empty() {
		return g.getGraph().isEmpty();
		
	}
	
	//EXTRA
	
	public Node search_node(int id) {
		Node node = new Node();
		
		for(int i=0;i<g.getGraph().size();i++) {
			Node nodeCurrent = g.getGraph().get(i);
			if(nodeCurrent.id == id ) {
				node = nodeCurrent;
				
			}	
		}
			return node;
	}
	
	
	public int[][] adjacency_matrix() {
		int N = g.getGraph().size();
		int [][] AdjMatrix = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				AdjMatrix[i][j]= 0;
			}
		}
	
		for(int i=0;i<N;i++) {
			Node nodeF = g.getGraph().get(i);
			for(int j=0;j<N;j++) {
				Node nodeS = g.getGraph().get(j);
				if(exist_edge(nodeF,nodeS))
					AdjMatrix[i][j]= 1;
			}
		}
                return AdjMatrix;
	}
   
	
}
