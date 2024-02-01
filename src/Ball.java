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

    public void hitWall(){
        if(x >= 500 - size) {
            xVel = xVel * -1;
            x -= x - (500 - size);
        }
        if(x <= 0){
            xVel = xVel * -1;
            x -= x;
        }

        if(y >= 500 - size){
            yVel = yVel * -1;
            y -= y - (500 - size);
        }
        if(y <= 0){
            yVel = yVel * -1;
            y -= y;
        }
    }
}
