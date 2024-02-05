import java.awt.*;

public class Ball {
    private int x;
    private int y;
    private int size;
    private int xVel;
    private int yVel;
    private Color color;

    public Ball(int x, int y, int size, int xVel, int yVel, Color color){
        this.x = x;
        this.y = y;
        this.size = size;
        this.xVel = xVel;
        this.yVel = yVel;
        this.color = color;
    }

    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }

    public void move(){
        x += xVel;
        y += yVel;
    }

    public void hitWall(double width, double height){
        if(x >= width - size) {
            xWallAngle();
            xVel = xVel * -1;
            x -= x - (width - size);
        }
      
        if(x <= 0){
            xWallAngle();
            xVel = xVel * -1;
            x -= x;
        }

        if(y >= height - size){
            yWallAngle();
            yVel = yVel * -1;
            y -= y - (height - size);
        }
      
        if(y <= 0){
            yWallAngle();
            yVel = yVel * -1;
            y -= y;
        }
    }

    public void xWallAngle(){
        yVel = (int)(Math.random() * 22 - 11);
    }

    public void yWallAngle(){
        xVel = (int)(Math.random() * 22 - 11);
    }

    public void bounce(int current, double width, double height){
        for(int i = 0; i < 20; i++){
          if(current == i){
            break;
          }
          
          if((x + size) >= MyPanel.myBall.get(i).getX()){
            xVel = xVel * -1;
            MyPanel.myBall.get(i).setXVel(MyPanel.myBall.get(i).getXVel() * 1);
            x -= x - (MyPanel.myBall.get(i).getX() - size);
          }
          else if(x <= (MyPanel.myBall.get(i).getX() + MyPanel.myBall.get(i).getSize())){
            xVel = xVel * -1;
            MyPanel.myBall.get(i).setXVel(MyPanel.myBall.get(i).getXVel() * 1);
            MyPanel.myBall.get(i).setX(MyPanel.myBall.get(i).getX() - (MyPanel.myBall.get(i).getX() - (x - MyPanel.myBall.get(i).getSize())));
          }

          if((y + size) >= MyPanel.myBall.get(i).getY()){
            yVel = yVel * -1;
            MyPanel.myBall.get(i).setYVel(MyPanel.myBall.get(i).getYVel() * 1);
            y -= y - (MyPanel.myBall.get(i).getY() - size);
          }
          else if(y <= (MyPanel.myBall.get(i).getY() + MyPanel.myBall.get(i).getSize())){
            yVel = yVel * -1;
            MyPanel.myBall.get(i).setYVel(            MyPanel.myBall.get(i).getYVel() * 1);
            MyPanel.myBall.get(i).setY(MyPanel.myBall.get(i).getY() - (MyPanel.myBall.get(i).getY() - (y - MyPanel.myBall.get(i).getSize())));
          }
        }
    }

    public int getX(){
      return x;
    }

    public int getY(){
      return y;
    }

    public int getSize(){
      return size;
    }

    public int getXVel(){
        return xVel;
    }

    public int getYVel(){
        return yVel;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }
  
    public void setXVel(int xVel){
        this.xVel = xVel;
    }

    public void setYVel(int yVel){
        this.yVel = yVel;
    }
}