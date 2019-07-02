package controller;

import java.util.ArrayList;

import model.Graph;
import model.Edge;
import model.Node;



public class GraphD {
	public Graph g;

	public void GraphD() {
		g = new Graph();
	}
        
        public Graph getGraphD(){
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
            if (from != to){	
               
		if(from != null ) {
			Edge newEdge = new Edge();
			newEdge.setId(to.getId()); 
			newEdge.setWeight(weight);

			if(!exist_edge(from,to)) {
				from.getEdges().addFirst(newEdge);
				System.out.println("Se añadio arista: ("+from.getId()+","+to.getId()+")");
			}else
				System.out.println("La arista ya existe");
			
		}
            }else{
                System.out.println("No se puede ingresar arista");
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
            for(Edge e : from.getEdges()){
                if (to.getId() == e.getId()) 
                    from.getEdges().remove(e);	
            }	
	}
	
	public boolean exist_node(int id) {
            for(Node n : g.getGraph()){
                if(n.getId() == id ) {
                    return true;		
                }	
            }
            return false;
	}
	
	public boolean exist_edge(Node from,Node to) {
            for(Edge e : from.getEdges()){
                if (to.getId() == e.getId()) {
                    return true;
                }
            }	
            return false;
}

	public ArrayList<Node> adj_nodes (Node node) {
            ArrayList <Node> adjList = new ArrayList<>();
          
            for(Edge e : node.getEdges()){
                adjList.add(search_node(e.getId()));
            }
            
            for(Node n : g.getGraph()){
               if(exist_edge(n,node))
                   adjList.add(n);
               
            }
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
	
	
	
	//EXTRA
	
	public Node search_node(int id) {
            Node node = new Node();
		
           for(Node n : g.getGraph()){
               if(n.getId() == id ) 
                    return n;
           }
           return null;
	}
}
