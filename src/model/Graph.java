package model;

import java.util.ArrayList;

public class Graph {
	public ArrayList <Node> graph = new ArrayList<Node>();

        public ArrayList<Node> getGraph(){
            return graph;
        }
        public void setGraph(ArrayList<Node> graph_){
            graph = graph_;
        }
         
        public void clear_graph(){
            graph.clear();
        }
        
        public boolean is_empty() {
            return graph.isEmpty();
		
	}
        
        public int graph_size() {
            return  getGraph().size();
		
	}
	

}
