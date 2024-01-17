public class Vector2D {
    protected int x, y;

    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {return x;}

    public int getY() {return y;}

    public void setX(int newX) {x = newX;}

    public void setY(int newY) {y = newY;}

    public float getDistance(Vector2D positionEnemy) {
        return (float) Math.sqrt(Math.pow(x - positionEnemy.x, 2) + Math.pow(y - positionEnemy.y, 2));
    }

    public Vector2D getDeltas(Vector2D positionEnemy) {
        return new Vector2D(x - positionEnemy.x, y - positionEnemy.y);
    }

    public boolean equals(Vector2D positionEnemy) {
        return x == positionEnemy.getX() && y == positionEnemy.getY();
    }
}
