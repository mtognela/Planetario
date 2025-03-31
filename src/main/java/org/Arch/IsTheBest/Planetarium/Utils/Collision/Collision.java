package org.Arch.IsTheBest.Planetarium.Utils.Collision;

import org.Arch.IsTheBest.Planetarium.Data.Coordinate;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Moon;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Planet;
import org.Arch.IsTheBest.Planetarium.System.OrbitingSystem;
import java.util.ArrayList;
import java.util.HashSet;

public abstract class Collision {
    public static boolean isCoordinateUnique(ArrayList<Planet> planets, Coordinate coordinate) {
        for (Planet planet : planets) {
            for (Moon moon : planet.getMoons()) {
                if (planet.getCoordinate().equals(coordinate) || moon.getCoordinate().equals(coordinate)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCoordinateUnique(ArrayList<Planet> planets, Planet planetInput) {
        for (Planet planet : planets) {
            for (Moon moon : planet.getMoons()) {
                if (planet.getCoordinate().equals(planetInput.getCoordinate()) || moon.getCoordinate().equals(planetInput.getCoordinate())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCoordinateUnique(ArrayList<Planet> planets, Moon moon) {
        for (Planet planet : planets) {
            for (Moon moons : planet.getMoons()) {
                if (planet.getCoordinate().equals(moon.getCoordinate()) || moons.getCoordinate().equals(moon.getCoordinate())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void checkCollisions() {
        ArrayList<Planet> planets = OrbitingSystem.getInstancePlanets();
        ArrayList<Moon> moons = OrbitingSystem.getMoons();

        HashSet<Moon> removeMoons = new HashSet<>();
        HashSet<Planet> removePlanets = new HashSet<>();

        for (int i = 0; i < planets.size(); i++) {
            for (int j=i+1; j<planets.size(); j++) {
                if (detectCollision(planets.get(i), planets.get(j))) {
                    removePlanets.add(planets.get(i));
                    removeMoons.add(moons.get(j));
                }
            }
        }

        for (int k = 0; k < moons.size(); k++) {
            for (int l = k+1; l < moons.size() && moons.get(k).getPianetaRif().getID() != moons.get(l).getPianetaRif().getID(); l++) {
                if (detectCollision(moons.get(k), moons.get(l))) {
                    removePlanets.add(planets.get(k));
                    removeMoons.add(moons.get(l));
                }
            }
        }

        for (Planet planet : planets) {
            for (int i = 0; i < moons.size() && planet.getID() != moons.get(i).getPianetaRif().getID(); i++ ) {
                if (detectCollision(planet, moons.get(i))) {
                    removePlanets.add(planet);
                    removeMoons.add(moons.get(i));
                }
            }
        }
    }

    private static boolean detectCollision(Planet p1, Planet p2) {
        return p1.getCoordinate().distanceFrom(p2.getCoordinate()) > (p1.getCoordinate().getRADIUS() + p2.getCoordinate().getRADIUS());
    }

    private static boolean detectCollision(Moon m1, Moon m2) {
        return m1.getCoordinate().distanceFrom(m2.getCoordinate()) > (m1.getCoordinate().getRADIUS() + m2.getCoordinate().getRADIUS());
    }

    private static boolean detectCollision(Planet p, Moon m) {
        return p.getCoordinate().distanceFrom(m.getCoordinate()) > (p.getCoordinate().getRADIUS() + m.getCoordinate().getRADIUS());
    }
}
