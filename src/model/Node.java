package model;

import java.util.LinkedList;
import javax.swing.JLabel;

public class Node {
	public int id;
	public LinkedList<Edge> edges = new LinkedList<>();
        public JLabel icon;
        public int posx;
        public int posy;
        
        public int getId(){
            return id;
        }
        
        public LinkedList<Edge> getEdges(){
            return edges;
         }
        
        public JLabel getIcon(){
            return icon;
         }
        
         public int getPosX(){
             return posx;
         }
         
         public int getPosY(){
             return posy;
         }
         
        public void setId(int id_){
            id = id_;
        }
        
        public void setIcon(JLabel icon_){
            icon = icon_;
        }
        
        public void setPosX(int posx_){
            posx = posx_;
        }
        
         public void setPosY(int posy_){
            posy = posy_;
        }
        
}
