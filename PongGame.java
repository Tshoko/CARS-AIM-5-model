/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

/**
 *
 * @author Boitshoko
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PongGame extends JComponent implements ActionListener {

    private int ballX = 0;
    private int ballY = 510;

    public static void main(String[] args) {
        JFrame window = new JFrame("Pong Game by Aaron");
        PongGame game = new PongGame();
        window.add(game);
        window.pack();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        Timer t = new Timer(100, game);
        t.start();
    }

    public Dimension getPreferredSize() {
        return new Dimension(1000, 1000);
    }
    public void map(Graphics g){
        // draw the sky
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, 1000, 1000);
        
        //draw road
        g.setColor(Color.DARK_GRAY);
        g.fillRect(400, 0, 100, 1000);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 500, 1000, 100);
        

        //road lines
        //horizontal lines
        for(int i=0; i<1050; i=i+25){
            if(i>380&&i<576){
                
                for(int k=510; k<590; k=k+10){

                   g.setColor(Color.WHITE);
                      g.fillRect(362, k, 40, 5);
                   g.setColor(Color.WHITE);
                      g.fillRect(500, k, 40, 5);
                     }
                continue;}
              g.setColor(Color.WHITE);
             g.fillRect(i-35, 545, 15, 5);
             
             g.setColor(Color.WHITE);
             g.fillRect(i-107, 504,140 , 3);
             g.setColor(Color.WHITE);
             g.fillRect(i-107, 593, 140, 3);
         }
        
        //vertiacal lines
        for(int i=0; i<1000; i=i+25){
            if(i>449&&i<630){
               
                for(int k=415; k<490; k=k+10){

                   g.setColor(Color.WHITE);
                      g.fillRect(k, 460, 5, 40);
                     
                   g.setColor(Color.WHITE);
                      g.fillRect(k, 600, 5, 40);
                }
                     
                continue;
            }
              
              g.setColor(Color.WHITE);
            g.fillRect(450, i+12, 5, 15);
            g.setColor(Color.WHITE);
            g.fillRect(405, i-55, 3, 137);
            g.setColor(Color.WHITE);
            g.fillRect(493, i-55, 3, 137);
         }
    }

    @Override
    protected void paintComponent(Graphics g) {
        
         //draw map or traffic intersection
         map(g);
         Graphics2D g2 = (Graphics2D) g;
         Image img1 = Toolkit.getDefaultToolkit().getImage("cars.jpg");
         g2.drawImage(img1, ballX, ballY, this);
         
        // draw the paddle
        //g.setColor(new Color(110, 61, 23));
        //g.fillRect(0, 510, 150, 15);
        
        // draw the rectangle and move
        g.setColor(Color.red);
        g.fillRect(ballX, ballY, 30, 20);
        g.fillArc(ballX, ballY, WIDTH, HEIGHT, ABORT, ballX);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ballX = ballX + 20;
        ballY = ballY;
        repaint();
    }

}
