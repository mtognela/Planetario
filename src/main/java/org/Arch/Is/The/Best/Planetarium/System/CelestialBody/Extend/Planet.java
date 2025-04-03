package org.Arch.Is.The.Best.Planetarium.System.CelestialBody.Extend;

import com.kibo.pgar.lib.AnsiColors;
import com.kibo.pgar.lib.PrettyStrings;
import org.Arch.Is.The.Best.Planetarium.Data.Coordinate;
import org.Arch.Is.The.Best.Planetarium.System.CelestialBody.CelestialBody;
import java.util.ArrayList;

/**
 * Represents a planet celestial body that can have moons orbiting around it.
 * Extends the base CelestialBody class with planet-specific properties and behaviors.
 */
public class Planet extends CelestialBody {
    private ArrayList<Moon> moons;

    /**
     * Constructs a Planet with specified mass, coordinates, and name.
     *
     * @param mass The mass of the planet
     * @param coordinate The coordinate position of the planet
     * @param nome The name of the planet
     */
    public Planet(double mass, Coordinate coordinate, String nome) {
        super(mass, coordinate, nome);
        this.moons = new ArrayList<>();
    }

    /**
     * Copy constructor that creates a new Planet based on an existing one.
     *
     * @param planet The planet to copy
     */
    public Planet(Planet planet) {
        super(planet.getMASS(), planet.getCOORDINATE(), planet.getName());
        this.moons = planet.getMoons();
    }

    /**
     * Gets the list of moons orbiting this planet.
     *
     * @return ArrayList of Moon objects
     */
    public ArrayList<Moon> getMoons() {
        return moons;
    }

    /**
     * Returns a formatted string representation of the planet and its moons.
     *
     * @return Formatted string with planet details and moon list
     */
    public String toString() {
        StringBuilder moonToString = new StringBuilder();
        if (!moons.isEmpty()) {
            for (int i = 0; i < moons.size(); i++) {
                moonToString.append("\n").append(moons.get(i).toString());
                if (i < moons.size() - 1) {
                    moonToString.append("\n");
                }
            }
        }

        return PrettyStrings.prettify(
                String.format("%s%s", super.toString(), moonToString.toString()),
                AnsiColors.GREEN, null, null
        );
    }

    /**
     * Gets the coordinate position of the planet.
     *
     * @return Coordinate object representing the planet's position
     */
    public Coordinate getPosition() {
        return super.getCOORDINATE();
    }

    /**
     * Adds a new moon to this planet with specified parameters.
     *
     * @param mass The mass of the moon
     * @param radius The orbital radius of the moon
     * @param theta The angular position of the moon
     * @param nome The name of the moon
     * @param planet The reference planet (typically this planet)
     */
    public void addMoon(double mass, double radius, double theta, String nome, Planet planet) {
        moons.add(new Moon(mass, new Coordinate(radius , theta), nome, planet));
    }

    /**
     * Adds an existing moon to this planet.
     *
     * @param moon The moon object to add
     */
    public void addMoon(Moon moon) {
        moons.add(moon);
    }

    /**
     * Removes a moon from this planet.
     *
     * @param moon The moon object to remove
     */
    public void removeMoon(Moon moon) {
        moons.remove(moon);
    }
}