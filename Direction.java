public enum Direction {
    UP, DOWN, LEFT, RIGHT;
    
    public boolean isX() {
        return this == LEFT || this == RIGHT;
    }
    
    public boolean isY() {
        return this == UP || this == DOWN;
    }
    public boolean isRight(){
        return this == RIGHT;
    }
    public boolean isLeft(){
        return this == LEFT;
    }
    public boolean isUp(){
        return this == UP;
    }
    public boolean isDown(){
        return this == DOWN;
    }
}
