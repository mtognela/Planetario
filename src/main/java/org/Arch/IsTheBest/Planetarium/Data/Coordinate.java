package org.Arch.IsTheBest.Planetarium.Data;

import com.kibo.pgar.lib.AnsiColors;
import com.kibo.pgar.lib.PrettyStrings;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Planet;

public class Coordinate {
    private final double X;
    private final double Y;
    private final double RADIUS;
    private final double THETA;

    public Coordinate(double radius, double theta) {
        this.RADIUS = radius;
        this.THETA = Math.toDegrees(theta);
        this.X=this.RADIUS * Math.cos(this.THETA);
        this.Y=this.RADIUS * Math.sin(this.THETA);
    }

    public Coordinate(Coordinate coordinate) {
        this.X = coordinate.X;
        this.Y = coordinate.Y;
        this.RADIUS = coordinate.RADIUS;
        this.THETA = coordinate.THETA;
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

    public double distanceFrom(Coordinate coordinate){
        return Math.sqrt(Math.pow(this.X, 2) + Math.pow(coordinate.getX(), 2)
                - 2 * this.X * coordinate.getX() * Math.cos(this.Y - coordinate.getY()));
    }

    public static Coordinate convertToAbsolute(Coordinate relativeCoordinate, Planet pianetaRif) {
        double xAbs = pianetaRif.getX() + relativeCoordinate.getRADIUS() * Math.cos(relativeCoordinate.getTHETA());
        double yAbs = pianetaRif.getY() + relativeCoordinate.getRADIUS() * Math.sin(relativeCoordinate.getTHETA());

        return new Coordinate(Math.sqrt(Math.pow(xAbs, 2) + Math.pow(yAbs, 2)), Math.atan2(yAbs, xAbs));
    }

    public static Coordinate convertToPolar(double x, double y) {
        return new Coordinate(Math.sqrt(Math.pow(x, 2) + Math.pow(y,  2)), Math.atan2(x, y));
    }

    @Override
    public String toString() {
        return String.format("{ x = %f, y = %f }",  X, Y);
    }
}
