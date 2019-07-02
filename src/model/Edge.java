package model;

import java.awt.Point;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.JMenuItem;

public class Edge {
	public int id;
	public int weight;
        public Point p1;
        public Point p2;
        public Line2D edge_arrow;
   
      
        
        public int getId(){
            return id;
        }
        
        public int getWeight(){
            return weight;
        }
        
        
        public Point getPoint1(){
            return p1;
        }
        
        public Point getPoint2(){
            return p2;
        }
        
        public Line2D getEdgeArrow(){
            return edge_arrow;
        }
        
        public void setId(int id_){
            id = id_;
        }
        
        public void setWeight(int weight_){
            weight = weight_;
        }
        
        public void setPoint1(Point p1_){
            p1 = p1_;
        }
        
        public void setPoint2(Point p2_){
            p2 = p2_;
        }
        
        public void setEdgeArrow(Line2D edgeArrow_){
            edge_arrow = edgeArrow_;
        }
        
}
