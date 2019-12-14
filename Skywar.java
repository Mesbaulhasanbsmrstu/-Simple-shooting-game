/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skywar;

/**
 *
 * @author Mesbaul
 */
public class Skywar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Game_set_up game;
        game = new Game_set_up("sky_force",500,600);
  game.start();
    }
    
}
