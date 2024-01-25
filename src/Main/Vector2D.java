package Main;
import TypesOfHero.*;

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

    public float getDistance(Hero hero) {
        Vector2D position = hero.getPosition();
        return (float) Math.sqrt(Math.pow(x - position.x, 2) + Math.pow(y - position.y, 2));
    }

    public Vector2D getDeltas(Hero enemy) {
        return new Vector2D(x - enemy.getPosition().x, y - enemy.getPosition().y);
    }

    public boolean equals(Vector2D positionEnemy) {
        return x == positionEnemy.getX() && y == positionEnemy.getY();
    }
}
