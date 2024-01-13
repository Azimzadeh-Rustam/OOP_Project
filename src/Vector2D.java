public class Vector2D {
    int x, y;

    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public float getDistance(Vector2D positionEnemy) {
        return (float) Math.sqrt(Math.pow(x - positionEnemy.x, 2) + Math.pow(y - positionEnemy.y, 2));
    }
}
