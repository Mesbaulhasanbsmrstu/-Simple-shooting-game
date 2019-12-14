/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skywar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements KeyListener {

    private int x;
    private int y;
    private boolean left;
    private boolean right;
    private boolean fire;
    private long current;
    private long delay;
    private int health;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void init() {
        Display.frame.addKeyListener(this);
        current = System.nanoTime();
        delay = 100;
        health=5;

    }

    public void tick() {

        if(!(health<=0)){
        if (left) {
            if (x >= 50) {

                x -= 8;
            }
        }
        if (right) {
            if (x < (450 - 30)) {
                x += 8;
            }
        }
        if (fire) {
            long breaks = (System.nanoTime() - current) / 1000000;
            if (breaks > delay) {
                Game_manager.bullet.add(new Bullet(x + 15, y));
            }
        }

      // tick();
    }
    }

    public void render(Graphics g) {
        if(!(health<=0)){
        g.setColor(Color.white);
        g.fillRect(x, y, 30, 30);
    }
    }
    

  

    public void keyTyped(KeyEvent e) {

    }

   
    public void keyReleased(KeyEvent e) {
         int source = e.getKeyCode();

        if (source == KeyEvent.VK_LEFT) {
            left = false;

        }
        if (source == KeyEvent.VK_RIGHT) {
            right = false;

        }
        if (source == KeyEvent.VK_B) {
            fire = false;
        }//To change body of generated methods, choose Tools | Templates.
    }
    public int getx()
    {
        return x;
    }
    public int gety()
    {
        return y;
    }
    public int gethealth()
    {
        return health;
    }
public void sethealth(int health)
{
    this.health=health;
}

   
    public void keyPressed(KeyEvent e) {
        int source = e.getKeyCode();

        if (source == KeyEvent.VK_LEFT) {
            left = true;
        }
        if (source == KeyEvent.VK_RIGHT) {
            right = true;
        }
        if (source == KeyEvent.VK_B) {
            fire = true;
        } //To change body of generated methods, choose Tools | Templates.
    }
}
