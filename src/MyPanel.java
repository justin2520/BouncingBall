import javax.swing.*;
import java.awt.*;
import java.sql.SQLOutput;
import java.util.*;

public class MyPanel extends JPanel{
    int xLoc = 200;
    int yLoc = 300;
    int xVel = 2;
    int yVel = 2;
    public static ArrayList<Ball> myBall = new ArrayList<Ball>();

    public MyPanel(){
        setBackground(Color.GREEN);
        for(int i = 0; i < 20; i++){
            myBall.add(new Ball((int)(Math.random() * 500 + 1), (int)(Math.random() * 500 + 1), (int)(Math.random() * 100 + 1), (int)(Math.random() * 10 + 1), (int)(Math.random() * 10 + 1), new Color((int)(Math.random() * 255 + 1), (int)(Math.random() * 255 + 1), (int)(Math.random() * 255 + 1))));
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
//        System.out.println("Hi");
//        g.setColor(new Color(100,128,212));
//        g.fillOval(xLoc, yLoc, 20, 20);
        for(int i = 0; i < myBall.size(); i++) {
            myBall.get(i).draw(g);
            myBall.get(i).move();
            myBall.get(i).hitWall(super.getWidth(), super.getHeight());
          myBall.get(i).bounce(i, super.getWidth(), super.getHeight());
        }





//        g.fillOval(450, 450, 8, 5);
//        g.drawString("Hello everyone", 250, 250);
//
//        g.setColor(Color.BLACK);
//        g.drawLine(225, 225, 225, 275);
//        g.drawLine(225, 225, 275, 225);
//        g.drawLine(225, 275, 275, 275);
//        g.drawLine(275, 225, 275, 275);

        try{
            Thread.sleep(10);
        }
        catch(Exception e){
            System.out.println(e);
        }
        repaint();
    }
}