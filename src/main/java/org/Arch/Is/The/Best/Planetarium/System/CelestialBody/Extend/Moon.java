package org.Arch.Is.The.Best.Planetarium.System.CelestialBody.Extend;

import org.Arch.Is.The.Best.Planetarium.Data.Coordinate;
import org.Arch.Is.The.Best.Planetarium.System.CelestialBody.CelestialBody;

/**
 * Represents a moon celestial body that orbits around a planet.
 * Extends the base CelestialBody class with moon-specific properties and behaviors.
 */
public class Moon extends CelestialBody {
    private final Planet pianetaRif;
    private final String path;
    private final double radiusFromPlanetRif;

    /**
     * Constructs a Moon with specified mass, coordinates, name, and reference planet.
     *
     * @param mass The mass of the moon
     * @param coordinate The relative coordinate position of the moon
     * @param nome The name of the moon
     * @param pianetaRif The planet this moon orbits around
     */
    public Moon(double mass, Coordinate coordinate, String nome, Planet pianetaRif) {
        super(mass, Coordinate.convertToAbsolute(coordinate, pianetaRif), nome);
        this.radiusFromPlanetRif = coordinate.getRadius();
        this.pianetaRif = pianetaRif;
        this.path = buildpath();
    }

    /**
     * Builds the hierarchical path string representing the moon's position in the system.
     *
     * @return The constructed path string
     */
    private String buildpath() {
        return Star.getInstanceName() + " > " + pianetaRif.getName() + " > " + super.getName();
    }

    public double getRadiusFromPlanetRif() {
        return radiusFromPlanetRif;
    }

    /**
     * Gets the hierarchical path of this moon in the system.
     *
     * @return String representing the path (Star > Planet > Moon)
     */
    public String getPath(){
        return path;
    }

    /**
     * Returns a string representation of the moon.
     *
     * @return Formatted string with moon details
     */
    public String toString() {
        return String.format("\tMoon %s %s", super.toString(), path);
    }

    /**
     * Gets the reference planet this moon orbits.
     *
     * @return The parent planet object
     */
    public Planet getPianetaRif() {
        return pianetaRif;
    }

    /**
     * Gets the coordinate position of the reference planet.
     *
     * @return Coordinate of the parent planet
     */
    public Coordinate getPianetaRifCoordinate() {
        return this.pianetaRif.getCOORDINATE();
    }

    /**
     * Gets the absolute distance of the reference planet from origin.
     *
     * @return Absolute distance of parent planet
     */
    public double getPianetaRifDistanceAss() {
        return this.pianetaRif.distanceAss();
    }

    /**
     * Gets the distance between the reference planet and a specified coordinate.
     *
     * @param coordinate The coordinate to measure distance to
     * @return Distance between parent planet and specified coordinate
     */
    public double getPianetaRifDistanceFrom(Coordinate coordinate) {
        return this.pianetaRif.distanceFrom(coordinate);
    }
}