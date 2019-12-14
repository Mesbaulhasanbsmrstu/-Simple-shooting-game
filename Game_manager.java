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
import java.util.ArrayList;
import java.util.Random;

public class Game_manager implements KeyListener {

    private Player player;
    public static ArrayList<Bullet> bullet;
    private ArrayList<Enemy> enemies;
    private long current;
    private long delay;
    private int health;
    private boolean start;
    private int score;

    public Game_manager() {

    }

    public void init() {
        Display.frame.addKeyListener(this);
        player = new Player((Game_set_up.gameweidth / 2) + 50, (Game_set_up.gameheight - 30) + 60);
        player.init();
        bullet = new ArrayList<Bullet>();
        enemies = new ArrayList<Enemy>();
        current = System.nanoTime();
        delay = 800;
        health = player.gethealth();
        score = 0;

    }

    public void tick() {
        if (start) {
            player.tick();
            for (int i = 0; i < bullet.size(); i++) {
                bullet.get(i).tick();
            }
            long breaks = (System.nanoTime() - current) / 1000000;
            if (breaks > delay) {
                for (int i = 0; i < 1; i++) {
                    Random rand = new Random();
                    int randx = rand.nextInt(430);
                    int randy = rand.nextInt(340);
                    enemies.add(new Enemy(randx, randy));
                }
                current = System.nanoTime();
            }
            for (int i = 0; i < enemies.size(); i++) {
                enemies.get(i).tick();
            }

        }
      
        
    }

    public void render(Graphics g) {
        if (start) {
            player.render(g);
            for (int i = 0; i < bullet.size(); i++) {
                bullet.get(i).render(g);
            }
            for (int i = 0; i < bullet.size(); i++) {
                if (bullet.get(i).gety() <= 60) {
                    bullet.remove(i);
                }
            }

            for (int i = 0; i < enemies.size(); i++) {
                if (!(enemies.get(i).getx() <= 50 || enemies.get(i).getx() >= 410 || enemies.get(i).gety() >= 436 || enemies.get(i).gety() <= 60)) {
                    enemies.get(i).render(g);
                }
            }
            for (int i = 0; i < enemies.size(); i++) {
                int ex = enemies.get(i).getx();
                int ey = enemies.get(i).gety();
                int px = player.getx();
                int py = player.gety();
                if (ex < px + 30 && ex + 25 > px && ey < py + 30 && ey + 25 > py) {
                    enemies.remove(i);
                    i--;
                    health--;
                    player.sethealth(health);

                }
                for (int j = 0; j < bullet.size(); j++) {
                    int bx = bullet.get(j).getx();
                    int by = bullet.get(j).gety();
                    if (ex < bx + 4 && ex + 25 > bx && ey < by + 6 && ey + 25 > by) {
                        enemies.remove(i);
                        i--;
                        bullet.remove(j);
                        j--;
                        score = score + 5;
                    }

                }
                g.setColor(Color.red);
                g.drawString("Score :" + score, 300, 550);
            }
        }
     else
        {
            g.setColor(Color.red);
            g.drawString("PRESS ENTER TO START GAME",100,550);
        }
    }


    public void keyTyped(KeyEvent e) {
        
    }

    
    public void keyPressed(KeyEvent e) {
         int source = e.getKeyCode();
        if (source == KeyEvent.VK_ENTER) {
            start = true;
            init();
        }//To change body of generated methods, choose Tools | Templates.
    }

   
    public void keyReleased(KeyEvent e) {
         //To change body of generated methods, choose Tools | Templates.
    }

}
