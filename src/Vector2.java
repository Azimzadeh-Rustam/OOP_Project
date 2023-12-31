public class Vector2 {
    int x, y;
    boolean isFree;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public float getDistance(Vector2 positionEnemy) {
        return (float) Math.sqrt(Math.pow(x - positionEnemy.x, 2) + Math.pow(y - positionEnemy.y, 2));
    }
}
