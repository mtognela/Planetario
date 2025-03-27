package it.unibs.fp.Planetario.Data;

public class Coordinate {
    private final double X;
    private final double Y;
    private final double RADIUS;
    private final double THETA;

    public Coordinate(double radius, double theta) {
        this.RADIUS = radius;
        this.THETA = theta;
        this.X=this.RADIUS * Math.cos(theta);
        this.Y=this.RADIUS * Math.sin(theta);
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }


    public double getRADIUS() {
        return RADIUS;
    }

    public double getTHETA() {
        return THETA;
    }

    public double distanceAss(){
        return Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2));
    }

    public double distanceFrom(Coordinate c){
        return Math.sqrt(Math.pow(this.X, 2) + Math.pow(c.getX(), 2) - 2 * this.X * c.getX() * Math.cos(this.Y - c.getY()));
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "X=" + X +
                ", Y=" + Y +
                ", RADIUS=" + RADIUS +
                ", THETA=" + THETA +
                '}';
    }
}
