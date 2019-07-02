/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Tom
 */
public class DrawLine {
    private Point from;
    private Point to;
    private Color color;
    
    public DrawLine(Point pFrom,Point pTo,Color pColor){
        from = pFrom;
        to = pTo;
        color = pColor;
    }
    
    public DrawLine(int fromX,int fromY,int toX, int toY, Color pColor){
        from = new Point(fromX,fromY);
        to = new Point(toX,toY);
        color = pColor;
    }
    
    public Point getFrom(){
         return from;
    }
    public void setPoint(Point pTo){
        to = pTo;
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.drawLine(from.x,from.y,to.x,to.y);
    
    }
    
    
}