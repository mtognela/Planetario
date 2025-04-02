package org.Arch.IsTheBest.Planetarium.Path;

import com.kibo.pgar.lib.AnsiColors;
import com.kibo.pgar.lib.PrettyStrings;
import org.Arch.IsTheBest.Planetarium.System.CelestialBody.Extend.Moon;
import org.Arch.IsTheBest.Planetarium.System.CelestialBody.Extend.Planet;
import org.Arch.IsTheBest.Planetarium.System.CelestialBody.Extend.Star;

/**
 * The {@code Route} class provides utility methods to calculate distances and generate
 * paths between celestial bodies such as planets and moons.
 */
public abstract class Route {

    /**
     * Calculates the distance between two planets.
     *
     * @param p1 The first planet.
     * @param p2 The second planet.
     * @return The sum of their distances from the central star.
     */
    public static double fromTo(Planet p1, Planet p2) {
        return p1.distanceAss() + p2.distanceAss();
    }

    /**
     * Calculates the distance between two moons.
     * If both moons orbit the same planet, the distance is calculated based on their
     * respective distances from the planet.
     * Otherwise, the distance is calculated via their respective planets and their distance from the star.
     *
     * @param m1 The first moon.
     * @param m2 The second moon.
     * @return The calculated distance between the two moons.
     */
    public static double fromTo(Moon m1, Moon m2) {
        if (m1.getPianetaRif().getID() == m2.getPianetaRif().getID()) {
            return (
                    m1.distanceFrom(m1.getPianetaRifCoordinate()) +
                            m2.distanceFrom(m1.getPianetaRifCoordinate())
            );
        } else {
            return (
                    m1.distanceFrom(m1.getPianetaRifCoordinate()) + m1.getPianetaRifDistanceAss() +
                            m2.distanceFrom(m2.getPianetaRifCoordinate()) + m2.getPianetaRifDistanceAss()
            );
        }
    }

    /**
     * Calculates the distance between a moon and a planet.
     * If the moon orbits the given planet, the direct distance is returned.
     * Otherwise, the distance is calculated via the moon's reference planet and the central star.
     *
     * @param m The moon.
     * @param p The planet.
     * @return The calculated distance between the moon and the planet.
     */
    public static double fromTo(Moon m, Planet p) {
        if (m.getPianetaRif().getID() == p.getID()) {
            return (
                    m.distanceFrom(p.getCOORDINATE())
            );
        } else {
            return (
                    m.distanceFrom(m.getPianetaRifCoordinate()) +
                            m.getPianetaRifDistanceAss() + p.distanceAss()
            );
        }
    }

    /**
     * Builds a textual representation of the path between two planets.
     *
     * @param p1 The starting planet.
     * @param p2 The destination planet.
     * @return A formatted string representing the path between the two planets via the central star.
     */
    public static String buildPathFromTo(Planet p1, Planet p2) {
        return PrettyStrings.
                prettify(String.format("%s > %s > %s", p1.getName(), Star.getInstanceName(), p2.getName()),
                        AnsiColors.CYAN, null, null);
    }

    /**
     * Builds a textual representation of the path between a moon and a planet.
     *
     * @param m The moon.
     * @param p The planet.
     * @return A formatted string representing the path.
     */
    public static String buildPathFromTo(Moon m, Planet p) {
        if (m.getPianetaRif().getID() == p.getID()) {
            return PrettyStrings.prettify(String.format("%s > %s", p.getName(), m.getName()),
                    AnsiColors.CYAN, null, null);
        } else {
            return PrettyStrings.prettify(String.format("%s > %s > %s > %s", p.getName(), Star.getInstanceName(), m.getPianetaRif().getName(), m.getName()),
                    AnsiColors.CYAN, null, null);
        }
    }

    /**
     * Builds a textual representation of the path between two moons.
     * If the moons orbit the same planet, the path is direct.
     * Otherwise, the path is calculated via their respective planets and the central star.
     *
     * @param m1 The first moon.
     * @param m2 The second moon.
     * @return A formatted string representing the path between the two moons.
     */
    public static String buildPathFromTo(Moon m1, Moon m2) {
        if (m1.getPianetaRif().getIDString().equals(m2.getPianetaRif().getIDString())) {
            return PrettyStrings.
                    prettify(String.format("%s > %s > %s", m1.getName(), m1.getPianetaRif().getName(), m2.getName()),
                            AnsiColors.CYAN, null, null);
        } else {
            return PrettyStrings.prettify(
                    String.format("%s > %s > %s > %s > %s",
                            m1.getName(), m1.getPianetaRif().getName(), Star.getInstanceName(), m2.getPianetaRif().getName(), m2.getName()),
                    AnsiColors.CYAN, null, null);
        }
    }
}
