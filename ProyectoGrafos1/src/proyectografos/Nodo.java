/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectografos;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author basti
 */
public class Nodo {
    private int x,y;
    private String nombre;
    public static final int d = 30; 

    public Nodo(int x, int y, String nombre) {
        this.x = x;
        this.y = y;
        this.nombre =nombre;
    }
    
    public void pintar(Graphics g){
        
        g.setColor(Color.red);   
        g.drawOval(this.x - d/2, this.y - d/2, d, d);
       // g.drawString(nombre, x, y);
        g.drawString(nombre.substring(0,1), x, y);
        
    }
   

    public int getX() {
        return x;
    }
    
    public String getNombre(){
        //return nombre;
        return nombre.substring(0, 1);
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
    
    
}