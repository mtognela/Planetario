package org.Arch.Is.The.Best.Planetarium.Data;

import org.Arch.Is.The.Best.Planetarium.System.CelestialBody.Extend.Planet;

/**
 * Represents a coordinate in both Cartesian (X,Y) and polar (radius,theta) coordinate systems.
 * Provides conversion methods between coordinate systems and distance calculations.
 */
public class Coordinate {
    private final double X;
    private final double Y;
    private final double RADIUS;
    private final double THETA;

    /**
     * Constructs a Coordinate from polar coordinates (radius and angle).
     *
     * @param radius The radial distance from origin
     * @param theta The angle in radians from the reference direction
     */
    public Coordinate(double radius, double theta) {
        this.RADIUS = radius;
        this.THETA = Math.toDegrees(theta);
        this.X = this.RADIUS * Math.cos(this.THETA);
        this.Y = this.RADIUS * Math.sin(this.THETA);
    }

    /**
     * Copy constructor that creates a new Coordinate from an existing one.
     *
     * @param coordinate The Coordinate object to copy
     */
    public Coordinate(Coordinate coordinate) {
        this.X = coordinate.X;
        this.Y = coordinate.Y;
        this.RADIUS = coordinate.RADIUS;
        this.THETA = coordinate.THETA;
    }

    /**
     * Gets the X coordinate in Cartesian system.
     *
     * @return The X coordinate value
     */
    public double getX() {
        return X;
    }

    /**
     * Gets the Y coordinate in Cartesian system.
     *
     * @return The Y coordinate value
     */
    public double getY() {
        return Y;
    }

    /**
     * Gets the radius in polar coordinate system.
     *
     * @return The radial distance from origin
     */
    public double getRadius() {
        return RADIUS;
    }

    /**
     * Gets the theta angle in polar coordinate system.
     *
     * @return The angular position in degrees
     */
    public double getTheta() {
        return THETA;
    }

    /**
     * Calculates the absolute distance from origin (0,0).
     *
     * @return The distance from origin
     */
    public double distanceAss() {
        return Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2));
    }

    /**
     * Calculates the distance between this coordinate and another coordinate.
     *
     * @param coordinate The other coordinate to measure distance to
     * @return The distance between coordinates
     */
    public double distanceFrom(Coordinate coordinate) {
        return Math.sqrt(Math.pow(this.X, 2) + Math.pow(coordinate.getX(), 2)
                - 2 * this.X * coordinate.getX() * Math.cos(this.Y - coordinate.getY()));
    }

    /**
     * Converts a relative coordinate to absolute coordinates based on a reference planet.
     *
     * @param relativeCoordinate The coordinate relative to the reference planet
     * @param pianetaRif The reference planet
     * @return New Coordinate in absolute terms
     */
    public static Coordinate convertToAbsolute(Coordinate relativeCoordinate, Planet pianetaRif) {
        double xAbs = pianetaRif.getX() + relativeCoordinate.getRadius() * Math.cos(relativeCoordinate.getRadius());
        double yAbs = pianetaRif.getY() + relativeCoordinate.getRadius() * Math.sin(relativeCoordinate.getRadius());

        return new Coordinate(Math.sqrt(Math.pow(xAbs, 2) + Math.pow(yAbs, 2)), Math.atan2(yAbs, xAbs));
    }

    /**
     * Converts Cartesian coordinates (x,y) to polar coordinates.
     *
     * @param x The X coordinate value
     * @param y The Y coordinate value
     * @return New Coordinate in polar terms
     */
    public static Coordinate convertToPolar(double x, double y) {
        return new Coordinate(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)), Math.atan2(x, y));
    }

    /**
     * Returns a string representation of the coordinate in Cartesian form.
     *
     * @return Formatted string showing X and Y coordinates
     */
    @Override
    public String toString() {
        return String.format("{ x = %f, y = %f }", X, Y);
    }
}