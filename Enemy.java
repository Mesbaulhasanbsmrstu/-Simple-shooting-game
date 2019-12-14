/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skywar;

import java.awt.Color;
import java.awt.Graphics;


public class Enemy {
    private int x;
    private int y;
    
    
    public Enemy(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    public void tick()
    {
        y+=1;
    }
    
    public void render(Graphics g)
    {
        g.setColor(Color.green);
        g.fillOval(x, y, 25, 25);
    }
    public int getx()
    {
        return x;
    }
    public int gety()
    {
        return y;
    }
    
    
}

