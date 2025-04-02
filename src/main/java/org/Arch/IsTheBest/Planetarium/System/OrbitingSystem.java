package org.Arch.IsTheBest.Planetarium.System;

import org.Arch.IsTheBest.Planetarium.Data.Coordinate;
import org.Arch.IsTheBest.Planetarium.System.CelestialBody.Extend.*;
import org.Arch.IsTheBest.Planetarium.Utils.Collision.Collision;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Represents an orbiting system containing a star and its planets with moons.
 * This class follows the singleton pattern to ensure only one instance exists.
 */
public class OrbitingSystem {
    private static OrbitingSystem instance;
    private static ArrayList<Planet> planets;
    private static Star star;
    private static String systemName;

    /**
     * Private constructor for creating an OrbitingSystem instance.
     *
     * @param star The star at the center of the system
     * @param systemName The name of the orbiting system
     */
    private OrbitingSystem(Star star, String systemName) {
        OrbitingSystem.star = star;
        OrbitingSystem.planets = new ArrayList<>();
        OrbitingSystem.systemName = systemName;
    }

    /**
     * Creates a singleton instance of the OrbitingSystem.
     *
     * @param star The star at the center of the system
     * @param systemName The name of the orbiting system
     */
    public static void createInstance(Star star, String systemName)  {
        if (instance == null) instance = new OrbitingSystem(star, systemName);
    }

    /**
     * Gets the singleton instance of the OrbitingSystem.
     *
     * @return The singleton instance
     */
    public static OrbitingSystem getInstance() {
        return instance;
    }

    /**
     * Gets the list of planets in the system.
     *
     * @return ArrayList of planets
     */
    public static ArrayList<Planet> getPlanets() {
        return planets;
    }

    /**
     * Gets the name of the orbiting system.
     *
     * @return The system name
     */
    public static String getInstanceName() {
        return systemName;
    }

    /**
     * Adds a new planet to the system with specified parameters.
     *
     * @param mass The mass of the planet
     * @param radius The orbital radius of the planet
     * @param theta The angular position of the planet
     * @param name The name of the planet
     */
    public static void addPlanet(double mass, double radius, double theta, String name) {
        planets.add(new Planet(mass, new Coordinate(radius, theta), name));
        Collision.checkCollisions();
    }

    /**
     * Adds a planet to the system by copying an existing planet.
     *
     * @param planet The planet to be added
     */
    public static void addPlanet(Planet planet) {
        planets.add(new Planet(planet));
        Collision.checkCollisions();
    }

    /**
     * Removes a planet from the system.
     *
     * @param planet The planet to be removed
     */
    public static void removePlanet(Planet planet) {
        planets.remove(planet);
    }

    /**
     * Adds a moon to a specified planet in the system.
     *
     * @param mass The mass of the moon
     * @param radius The orbital radius of the moon
     * @param theta The angular position of the moon
     * @param nome The name of the moon
     * @param planet The planet to which the moon will be added
     */
    public static void addMoon(double mass, double radius, double theta, String nome, Planet planet) {
        planet.addMoon(mass, radius , theta, nome, planet);
        Collision.checkCollisions();
    }

    /**
     * Adds a moon to a specified planet in the system.
     *
     * @param moon the moon itself to add
     */
    public static void addMoon(Moon moon) {
        moon.getPianetaRif().addMoon(moon);
        Collision.checkCollisions();
    }

    /**
     * Removes a moon from its parent planet.
     *
     * @param moon The moon to be removed
     */
    public static void removeMoon(Moon moon) {
        moon.getPianetaRif().removeMoon(moon);
    }

    /**
     * Calculates the center of mass of the entire system.
     *
     * @return Coordinate object representing the center of mass in polar coordinates
     */
    public static Coordinate calcCDM() {
        double totalWeight = 0;
        double totalXMass = 0;
        double totalYMass = 0;

        if (planets.isEmpty()) {
            return new Coordinate(0.0, 0.0);
        }

        for (Planet planet : planets) {
            totalWeight += planet.getMASS();
            totalXMass += planet.getPosition().getX() * planet.getMASS();
            totalYMass += planet.getPosition().getY() * planet.getMASS();
            for (Moon moon : planet.getMoons()) {
                totalWeight += moon.getMASS();
                totalXMass += moon.getCOORDINATE().getX() * moon.getMASS();
                totalYMass += moon.getCOORDINATE().getY() * moon.getMASS();
            }
        }

        double cdmX = (totalWeight != 0) ? totalXMass / totalWeight : 0;
        double cdmY = (totalWeight != 0) ? totalYMass / totalWeight : 0;

        return new Coordinate(Coordinate.convertToPolar(cdmX, cdmY));
    }

    /**
     * Gets all coordinates of celestial bodies in the system.
     *
     * @return HashSet of Coordinate objects
     */
    public static HashSet<Coordinate> getCoordinates() {
        HashSet<Coordinate> coordinates = new HashSet<>();
        for (Planet planet : getPlanets()) {
            coordinates.add(new Coordinate(planet.getCOORDINATE()));
        }
        for (Moon moons : getMoons()) {
            coordinates.add(new Coordinate(moons.getCOORDINATE()));
        }
        return coordinates;
    }

    /**
     * Gets all moons in the system across all planets.
     *
     * @return ArrayList of all moons in the system
     */
    public static ArrayList<Moon> getMoons() {
        ArrayList<Planet> planets = getPlanets();

        ArrayList<Moon> moons = new ArrayList<>();

        for (Planet planet : planets) {
            moons.addAll(planet.getMoons());
        }

        return moons;
    }

    /**
     * Generates a string representation of the entire system.
     *
     * @return StringBuffer containing the system's string representation
     */
    public static StringBuffer showSystem() {
        StringBuffer systemString = new StringBuffer();

        systemString.append("\n").append(Star.getInstanceToString());
        if (!OrbitingSystem.getPlanets().isEmpty()) {
            systemString.append("\n");
            for (int i = 0; i < OrbitingSystem.getPlanets().size()-1; i++) {
                systemString.append(OrbitingSystem.getPlanets().get(i).toString()).append("\n");
            }
            systemString.append(OrbitingSystem.getPlanets().getLast().toString());
        }

        return systemString;
    }
}