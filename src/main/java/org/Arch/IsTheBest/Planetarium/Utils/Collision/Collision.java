package org.Arch.IsTheBest.Planetarium.Utils.Collision;

import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Moon;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Planet;
import org.Arch.IsTheBest.Planetarium.System.OrbitingSystem;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Utility class that handles collision detection between celestial bodies in the planetary system.
 * Uses Hashset to avoid duplicate removal entries and follows Java naming conventions.
 */
public abstract class Collision {
    /**
     * Checks for collisions between planets and moons and removes those that have collided.
     * Uses Sets to ensure each body is only removed once.
     */
    public static void checkCollisions() {
        List<Planet> planets = OrbitingSystem.getPlanets();
        List<Moon> moons = OrbitingSystem.getMoons();

        HashSet<Planet> planetsToRemove = new HashSet<>();
        HashSet<Moon> moonsToRemove = new HashSet<>();

        checkPlanetCollisions(planets, planetsToRemove);
        checkMoonCollisions(moons, moonsToRemove);
        checkPlanetMoonCollisions(planets, moons, planetsToRemove, moonsToRemove);

        moonsToRemove.forEach(OrbitingSystem::removeMoon);
        planetsToRemove.forEach(OrbitingSystem::removePlanet);
    }

    /**
     * Checks for collisions between planets.
     * @param planets List of planets to check
     * @param planetsToRemove Set to collect collided planets
     */
    private static void checkPlanetCollisions(List<Planet> planets, Set<Planet> planetsToRemove) {
        for (int i = 0; i < planets.size(); i++) {
            for (int j = i + 1; j < planets.size(); j++) {
                Planet p1 = planets.get(i);
                Planet p2 = planets.get(j);
                if (detectCollision(p1, p2)) {
                    planetsToRemove.add(p1);
                    planetsToRemove.add(p2);
                }
            }
        }
    }

    /**
     * Checks for collisions between moons.
     * @param moons List of moons to check
     * @param moonsToRemove Set to collect collided moons
     */
    private static void checkMoonCollisions(List<Moon> moons, Set<Moon> moonsToRemove) {
        for (int i = 0; i < moons.size(); i++) {
            for (int j = i + 1; j < moons.size(); j++) {
                Moon m1 = moons.get(i);
                Moon m2 = moons.get(j);
                if (detectCollision(m1, m2)) {
                    moonsToRemove.add(m1);
                    moonsToRemove.add(m2);
                }
            }
        }
    }

    /**
     * Checks for collisions between planets and moons.
     * @param planets List of planets
     * @param moons List of moons
     * @param planetsToRemove Set to collect collided planets
     * @param moonsToRemove Set to collect collided moons
     */
    private static void checkPlanetMoonCollisions(List<Planet> planets, List<Moon> moons,
                                                  Set<Planet> planetsToRemove, Set<Moon> moonsToRemove) {
        for (Planet planet : planets) {
            for (Moon moon : moons) {
                if (detectCollision(planet, moon)) {
                    // Only remove moon by default (modify if planet should also be removed)
                    moonsToRemove.add(moon);
                }
            }
        }
    }

    /**
     * Detects collision between two planets based on distance and radii.
     * @param p1 First planet
     * @param p2 Second planet
     * @return True if collision detected
     */
    public static boolean detectCollision(Planet p1, Planet p2) {
        return p1.distanceFrom(p2.getCoordinate()) <= (p1.getRadius() + p2.getRadius());
    }

    /**
     * Detects collision between two moons based on distance and radii.
     * @param m1 First moon
     * @param m2 Second moon
     * @return True if collision detected
     */
    public static boolean detectCollision(Moon m1, Moon m2) {
        return m1.distanceFrom(m2.getCoordinate()) <= (m1.getRadius() + m2.getRadius());
    }

    /**
     * Detects collision between a planet and a moon based on distance and radii.
     * @param p Planet
     * @param m Moon
     * @return True if collision detected
     */
    public static boolean detectCollision(Planet p, Moon m) {
        return p.distanceFrom(m.getCoordinate()) <= (p.getRadius() + m.getRadius());
    }
}