/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skywar;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {

    private int x;
    private int y;
    private int speed;

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
        speed = 10;
    }

    public void tick() {
        
            y -= speed;
            
        
    }
    public int getx()
    {
        return x;
    }
    public int gety()
    {
        return y;
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 4, 6);
    }
}
