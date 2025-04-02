package org.Arch.IsTheBest.Planetarium.System.CorpoCeleste;

import org.Arch.IsTheBest.Planetarium.Data.Coordinate;

/**
 * Abstract base class representing a celestial body in a planetary system.
 * Provides common properties and methods for all types of celestial bodies.
 */

public abstract class CorpoCeleste {
    private String nome;
    private double mass;
    private Coordinate coordinate;
    private final int ID;

    /**
     * Constructs a celestial body with specified mass, coordinate, and name.
     *
     * @param mass The mass of the celestial body
     * @param coordinate The coordinate position of the celestial body
     * @param nome The name of the celestial body
     */
    public CorpoCeleste(double mass, Coordinate coordinate, String nome) {
        this.mass = mass;
        this.nome = nome;
        this.coordinate = coordinate;
        this.ID = hashCode();
    }

    /**
     * Constructs a celestial body with specified mass, polar coordinates, and name.
     *
     * @param mass The mass of the celestial body
     * @param radius The radial distance from the reference point
     * @param theta The angular position in radians
     * @param nome The name of the celestial body
     */
    public CorpoCeleste(double mass, double radius, double theta, String nome) {
        this.mass = mass;
        this.coordinate = new Coordinate(radius, theta);
        this.nome = nome;
        this.ID = hashCode();
    }

    /**
     * Gets the name of the celestial body.
     *
     * @return The name of the celestial body
     */
    public String getName() {
        return nome;
    }

    /**
     * Gets the mass of the celestial body.
     *
     * @return The mass of the celestial body
     */
    public double getMass() {
        return mass;
    }

    /**
     * Updates the mass of the celestial body by adding the specified value.
     *
     * @param update The value to add to the current mass
     */
    public void updateMass(double update) {
        this.mass += update;
    }

    /**
     * Gets the coordinate position of the celestial body.
     *
     * @return The coordinate object representing the position
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * Calculates the absolute distance of the celestial body from the origin.
     *
     * @return The absolute distance from the origin
     */
    public double distanceAss() {
        return coordinate.distanceAss();
    }

    /**
     * Calculates the distance from this celestial body to another coordinate.
     *
     * @param c The coordinate to measure distance to
     * @return The distance between this body and the specified coordinate
     */
    public double distanceFrom(Coordinate c) {
        return coordinate.distanceFrom(c);
    }

    /**
     * Gets the X coordinate in Cartesian system.
     *
     * @return The X coordinate value
     */
    public double getX() {
        return coordinate.getX();
    }

    /**
     * Gets the Y coordinate in Cartesian system.
     *
     * @return The Y coordinate value
     */
    public double getY() {
        return coordinate.getY();
    }

    /**
     * Gets the radius in polar coordinate system.
     *
     * @return The radial distance
     */
    public double getRADIUS() {
        return coordinate.getRADIUS();
    }

    /**
     * Gets the theta angle in polar coordinate system.
     *
     * @return The angular position in radians
     */
    public double getTHETA() {
        return coordinate.getTHETA();
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
        return String.format("Mass = %f, %s, Name = %s, ID = %d", mass, coordinate.toString(), nome, this.ID);
    }
}