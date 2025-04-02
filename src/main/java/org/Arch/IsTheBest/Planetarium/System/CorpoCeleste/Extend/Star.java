package org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend;

import com.kibo.pgar.lib.AnsiColors;
import com.kibo.pgar.lib.PrettyStrings;
import org.Arch.IsTheBest.Planetarium.Data.Coordinate;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.CorpoCeleste;

/**
 * Represents a star celestial body that serves as the center of a planetary system.
 * Implements the singleton pattern to ensure only one star instance exists per system.
 * Extends the base CorpoCeleste class with star-specific properties and behaviors.
 */
public class Star extends CorpoCeleste {
    private static Star instance = null;

    /**
     * Private constructor for creating a Star instance.
     *
     * @param mass The mass of the star
     * @param nome The name of the star
     */
    private Star(double mass, String nome) {
        super(mass, new Coordinate(0, 0), nome);
    }

    /**
     * Creates the singleton instance of the Star if it doesn't exist.
     *
     * @param mass The mass of the star
     * @param nome The name of the star
     */
    public static void createInstance(double mass, String nome) {
        if (instance == null) instance = new Star(mass, nome);
    }

    /**
     * Gets the singleton instance of the Star.
     *
     * @return The Star singleton instance
     * @throws IllegalStateException if the instance hasn't been created
     */
    public static Star getInstance() {
        return instance;
    }

    /**
     * Gets the string representation of the star instance.
     *
     * @return Formatted string representation of the star
     */
    public static String getInstanceToString() {
        return instance.toString();
    }

    /**
     * Gets the name of the star instance.
     *
     * @return The name of the star
     */
    public static String getInstanceName() {
        return instance.getName();
    }

    /**
     * Gets the mass of the star instance.
     *
     * @return The mass of the star
     */
    public static double getInstanceMass() {
        return instance.getMass();
    }

    /**
     * Returns a formatted string representation of the star.
     *
     * @return Formatted string with star details
     */
    @Override
    public String toString() {
        return PrettyStrings.prettify("Star: " + super.toString(), AnsiColors.RED, null, null);
    }
}