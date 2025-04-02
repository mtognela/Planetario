package org.Arch.IsTheBest.Planetarium.System.CelestialBody;

import org.Arch.IsTheBest.Planetarium.Data.Coordinate;

import java.util.Objects;

/**
 * Abstract base class representing a celestial body in a planetary system.
 * Provides common properties and methods for all types of celestial bodies.
 */

public abstract class CelestialBody {
    private String NAME;
    private final double MASS;
    private final Coordinate COORDINATE;
    private final int ID;

    /**
     * Constructs a celestial body with specified mass, coordinate, and name.
     *
     * @param MASS The mass of the celestial body
     * @param COORDINATE The coordinate position of the celestial body
     * @param NAME The name of the celestial body
     */
    public CelestialBody(double MASS, Coordinate COORDINATE, String NAME) {
        this.MASS = MASS;
        this.NAME = NAME;
        this.COORDINATE = COORDINATE;
        this.ID = hashCode();
    }

    /**
     * Constructs a celestial body with specified mass, polar coordinates, and name.
     *
     * @param MASS The mass of the celestial body
     * @param radius The radial distance from the reference point
     * @param theta The angular position in radians
     * @param NAME The name of the celestial body
     */
    public CelestialBody(double MASS, double radius, double theta, String NAME) {
        this.MASS = MASS;
        this.COORDINATE = new Coordinate(radius, theta);
        this.NAME = NAME;
        this.ID = hashCode();
    }

    /**
     * Gets the name of the celestial body.
     *
     * @return The name of the celestial body
     */
    public String getName() {
        return NAME;
    }

    /**
     * Gets the mass of the celestial body.
     *
     * @return The mass of the celestial body
     */
    public double getMASS() {
        return MASS;
    }

    /**
     * Gets the coordinate position of the celestial body.
     *
     * @return The coordinate object representing the position
     */
    public Coordinate getCOORDINATE() {
        return COORDINATE;
    }

    /**
     * Calculates the absolute distance of the celestial body from the origin.
     *
     * @return The absolute distance from the origin
     */
    public double distanceAss() {
        return COORDINATE.distanceAss();
    }

    /**
     * Calculates the distance from this celestial body to another coordinate.
     *
     * @param c The coordinate to measure distance to
     * @return The distance between this body and the specified coordinate
     */
    public double distanceFrom(Coordinate c) {
        return COORDINATE.distanceFrom(c);
    }

    /**
     * Gets the X coordinate in Cartesian system.
     *
     * @return The X coordinate value
     */
    public double getX() {
        return COORDINATE.getX();
    }

    /**
     * Gets the Y coordinate in Cartesian system.
     *
     * @return The Y coordinate value
     */
    public double getY() {
        return COORDINATE.getY();
    }

    /**
     * Gets the radius in polar coordinate system.
     *
     * @return The radial distance
     */
    public double getRadius(){
        return COORDINATE.getRadius();
    }

    /**
     * Gets the theta angle in polar coordinate system.
     *
     * @return The angular position in radians
     */
    public double getTheta() {
        return COORDINATE.getRadius();
    }

    /**
     * Gets the unique ID of the celestial body.
     *
     * @return The ID of the celestial body
     */
    public int getID() {
        return ID;
    }

    /**
     * Gets the unique ID of the celestial body as a string.
     *
     * @return The ID as a string
     */
    public String getIDString() {
        return Integer.toString(ID);
    }

    /**
     * Returns a string representation of the celestial body.
     *
     * @return String containing mass, coordinates, name, and ID
     */
    @Override
    public String toString() {
        return String.format("Mass = %f, %s, Name = %s, ID = %d", MASS, COORDINATE.toString(), NAME, this.ID);
    }
    @Override
    public int  hashCode() {
        return Objects.hash(MASS, NAME, COORDINATE);
    }
}