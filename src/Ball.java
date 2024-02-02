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
            angle();
            xVel = xVel * -1;
            x -= x - (width - size);
        }
        if(x <= 0){
            angle();
            x -= x;
        }

        if(y >= height - size){
            angle();
            yVel = yVel * -1;
            y -= y - (height - size);
        }
        if(y <= 0){
            angle();
            y -= y;
        }
    }

    public void angle(){
        xVel = (int)(Math.random() * 10 + 1);
        yVel = (int)(Math.random() * 10 + 1);
    }
}
