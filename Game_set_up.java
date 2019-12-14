/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skywar;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class Game_set_up implements Runnable {

    private String title;
    private int weidth;
    private int height;
    private JFrame frame;
    private Canvas canvas;
    private Thread thread;
    private boolean running;
    private Display display;
    private BufferStrategy buffer;
    private Graphics g;
    private int y;
    private Game_manager manager;
    public static final int gameweidth = 400;
    public static final int gameheight = 400;

    public Game_set_up(String title, int weidth, int height) {
        this.title = title;
        this.weidth = weidth;
        this.height = height;

    }

    public void init() {
        display = new Display(title, weidth, height);
        manager = new Game_manager();

        manager.init();

    }

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        if (thread == null) {
            thread = new Thread(this);
            thread.start();

        }
    }

    public synchronized void stop() {
        if (!(running)) {
            return;
        }
        running = false;
        try {
            thread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tick() {
        manager.tick();
        y += 1;
    }

    public void render() {
        buffer = display.getCanvas().getBufferStrategy();
        if (buffer == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = buffer.getDrawGraphics();
        g.clearRect(0, 0, weidth, height);
        g.setColor(Color.blue);
        g.fillRect(50, 60, gameweidth, gameheight);

        manager.render(g);
        buffer.show();
        g.dispose();
    }

    public void run() {
       init();
        int fps = 90;
        double timePerTick = 1000000000/fps;
        double delta = 0;
        long current = System.nanoTime();
        while (running) {
            delta = delta + (System.nanoTime() - current) / timePerTick;
            current = System.nanoTime();
            if (delta >= 1) {
            
                tick();

                render();
                delta--;
            }

        }
    }
}

