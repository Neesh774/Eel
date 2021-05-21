import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.util.*;

public class Snake {
    private Direction direction;
    private Point head;
    private ArrayList<Point> tail;
    
    public Snake(int x, int y) {
        this.head = new Point(x, y);
        this.direction = Direction.RIGHT;
        this.tail = new ArrayList<Point>();
        
        this.tail.add(new Point(0, 0));
        this.tail.add(new Point(0, 0));
        this.tail.add(new Point(0, 0));
    }

    public void move() {
        ArrayList newTail = new ArrayList<Point>();
        
        for (int i = 0, size = tail.size(); i < size; i++) {
            Point current = tail.get(i);
            Point previous = i == 0 ? head : tail.get(i - 1);

            newTail.add(new Point(previous.getX(), previous.getY()));
        }
        
        this.tail = newTail;
        
        this.head.move(this.direction, 10);
    }
    
    public void addTail() {
        Point last = this.tail.get(this.tail.size() - 1);
        
        this.tail.add(new Point(-10, -10));
    }
    
    public void turn(Direction d) {       
        if (d.isX() && direction.isY() || d.isY() && direction.isX()) {
           direction = d; 
        }       
    }
    public void invert(){
        int headX = head.getX();
        int headY = head.getY();
        head.setX(tail.get(tail.size()-1).getX());
        head.setY(tail.get(tail.size()-1).getY());
        tail.remove(tail.size()-1);
        Collections.reverse(tail);
        tail.add(new Point(headX, headY));
        if(direction.isLeft()) {
            System.out.println("Changed from left to right");
            direction = Direction.RIGHT;
        }
        else if(direction.isRight()) {
            System.out.println("Changed from right to left");
            direction = Direction.LEFT;
        }
        else if(direction.isUp()) {
            System.out.println("Changed from up to down");
            direction = Direction.DOWN;
        }
        else if(direction.isDown()) {
            System.out.println("Changed from down to up");
            direction = Direction.UP;
        }
    }
    public ArrayList<Point> getTail() {
        return this.tail;
    }
    
    public Point getHead() {
        return this.head;
    }
}
