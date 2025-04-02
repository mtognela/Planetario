package org.Arch.IsTheBest.Planetarium.Utils.Collision;

import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Moon;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Planet;
import org.Arch.IsTheBest.Planetarium.System.OrbitingSystem;
import java.util.ArrayList;

/**
 * Abstract class that handles collision detection between celestial bodies in the planetary system.
 */
public abstract class Collision {

    /**
     * Checks for collisions between planets and moons and removes those that have collided.
     */
    public static void checkCollisions() {
        ArrayList<Planet> planets = OrbitingSystem.getPlanets();
        ArrayList<Moon> moons = OrbitingSystem.getMoons();

        ArrayList<Moon> removeMoons = new ArrayList<>();
        ArrayList<Planet> removePlanets = new ArrayList<>();

        extractedPlanet(planets, removePlanets);
        extractedMoon(moons, removeMoons);
        extractedMix(planets, moons, removePlanets, removeMoons);

        for (Moon removeMoon : removeMoons) {
            OrbitingSystem.removeMoon(removeMoon);
        }
        for (Planet removePlanet : removePlanets) {
            OrbitingSystem.removePlanet(removePlanet);
        }
    }

    /**
     * Checks for collisions between planets and moons and marks them for removal if they collide.
     *
     * @param planets List of planets.
     * @param moons List of moons.
     * @param removePlanets List of planets to be removed.
     * @param removeMoons List of moons to be removed.
     */
    private static void extractedMix(ArrayList<Planet> planets, ArrayList<Moon> moons, ArrayList<Planet> removePlanets, ArrayList<Moon> removeMoons) {
        for (Planet planet : planets) {
            for (Moon moon : moons) {
                if (!detectCollision(planet, moon)) {
                    removePlanets.add(planet);
                    removeMoons.add(moon);
                }
            }
        }
    }

    /**
     * Checks for collisions between planets and marks them for removal if they collide.
     *
     * @param planets List of planets.
     * @param removePlanets List of planets to be removed.
     */
    private static void extractedPlanet(ArrayList<Planet> planets, ArrayList<Planet> removePlanets) {
        for(int i = 0; i < planets.size(); i++)
            for (int j = i + 1; j < planets.size(); j++) {
                if (!detectCollision(planets.get(i), planets.get(j))) {
                    removePlanets.add(planets.get(i));
                    removePlanets.add(planets.get(j));
                }
            }
    }

    /**
     * Checks for collisions between moons and marks them for removal if they collide.
     *
     * @param moons List of moons.
     * @param removeMoons List of moons to be removed.
     */
    private static void extractedMoon(ArrayList<Moon> moons, ArrayList<Moon> removeMoons) {
        for (int k = 0; k < moons.size(); k++)
            for (int l = k + 1; l < moons.size(); l++) {
                if (!detectCollision(moons.get(k), moons.get(l))) {
                    removeMoons.add(moons.get(k));
                    removeMoons.add(moons.get(l));
                }
            }
    }

    /**
     * Detects collision between two planets.
     *
     * @param p1 First planet.
     * @param p2 Second planet.
     * @return True if the planets collide, false otherwise.
     */
    private static boolean detectCollision(Planet p1, Planet p2) {
        return p1.distanceFrom(p2.getCoordinate()) <= (p1.getRADIUS() + p2.getRADIUS());
    }

    /**
     * Detects collision between two moons.
     *
     * @param m1 First moon.
     * @param m2 Second moon.
     * @return True if the moons collide, false otherwise.
     */
    private static boolean detectCollision(Moon m1, Moon m2) {
        return m1.distanceFrom(m2.getCoordinate()) <= (m1.getRADIUS() + m2.getRADIUS());
    }

    /**
     * Detects collision between a planet and a moon.
     *
     * @param p Planet.
     * @param m Moon.
     * @return True if the planet and moon collide, false otherwise.
     */
    private static boolean detectCollision(Planet p, Moon m) {
        return p.distanceFrom(m.getCoordinate()) <= (p.getRADIUS() + m.getRADIUS());
    }
}