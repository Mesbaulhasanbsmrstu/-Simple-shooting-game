/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skywar;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Display {

    private String title;
    private int weidth;
    private int height;

    public static JFrame frame;
    public static Canvas canvas;

    public Display(String title, int weidth, int height) {
        this.title = title;
        this.weidth = weidth;
        this.height = height;
        creatDisplay();
    }

    public void creatDisplay() {
        frame = new JFrame(title);
        frame.setSize(weidth, height);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(weidth, height));
        canvas.setBackground(Color.black);
        canvas.setFocusable(false);
        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas() {
        return canvas;
    }

 
}
