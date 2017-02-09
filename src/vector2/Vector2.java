package vector2;

/**
 * Created by teacher on 09.02.17.
 */
public class Vector2 {
    private double X;
    private double Y;

    Vector2(double x, double y) {
        X = x;
        Y = y;
    }

    public Vector2() {
        X = 0;
        Y = 0;
    }

    protected Vector2(Vector2 v) {
        this(v.X, v.Y);
    }

    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }


    Vector2 plus(Vector2 v) {
        return new Vector2(
                this.X + v.X,
                this.Y + v.Y);
    }

    public Vector2 minus(Vector2 v) {
        return new Vector2(
                this.X - v.X,
                this.Y - v.Y);
    }

    private static double len(Vector2 v) {
        return Math.sqrt(v.X * v.X + v.Y * v.Y);
    }

    public Vector2 norm() {
        return new Vector2(this.X / len(this), this.Y / len(this));
    }

    Vector2 mult(double d) {
        return new Vector2(this.X * d, this.Y * d);
    }

    double mult(Vector2 v) {
        return this.X * v.X + this.Y * v.Y;
    }

    public static Vector2 rotate(Vector2 v, double a) {
        return new Vector2(v.X * Math.cos(a) - v.Y * Math.sin(a),
                v.X * Math.sin(a) + v.Y * Math.cos(a));
    }

    private Vector2 rotated(double d) {
        return rotate(this, d);
    }

    public boolean equals(Vector2 v) {
        return v.X == this.X && v.Y == this.Y;
    }


    @Override
    public String
    toString() {
        return "(" + X +
                "," + Y + ")";
    }

    Vector2 ort() {
        return this.rotated(Math.PI).norm();
    }

    public static Vector2 sum(Vector2 v1, Vector2 v2) {
        return v1.plus(v2);
    }

    static double phi(Vector2 v){
        return  Math.atan2(v.X,v.Y);
    }

    public static final Vector2 normalize(Vector2 v){
        return new Vector2(v).norm();
    }
}
