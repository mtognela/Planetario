package it.unibs.fp.Planetario.Data;

public class Coordinate {
    private final double RADIUS;
    private final double THETA;

    public Coordinate(double radius, double theta) {
        this.RADIUS = radius;
        this.THETA = theta;
    }

    Coordinate() {
        this.RADIUS = 0;
        this.THETA = 0;
    }

    public double getRADIUS() {
        return RADIUS;
    }

    public double getTHETA() {
        return THETA;
    }

    public double distanceAss(){
        return Math.sqrt(Math.pow(RADIUS * Math.cos(THETA), 2) + Math.pow(RADIUS * Math.sin(THETA), 2));
    }

    public double distanceFrom(Coordinate c){
        return Math.sqrt(Math.pow(this.RADIUS, 2) + Math.pow(c.getRADIUS(), 2) - 2 * this.RADIUS * c.getRADIUS() * Math.cos(this.THETA - c.getTHETA()));
    }
}
