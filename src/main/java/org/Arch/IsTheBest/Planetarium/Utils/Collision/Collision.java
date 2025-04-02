package org.Arch.IsTheBest.Planetarium.Utils.Collision;

import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Moon;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Planet;
import org.Arch.IsTheBest.Planetarium.System.OrbitingSystem;
import java.util.ArrayList;

public abstract class Collision {

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

    private static void extractedPlanet(ArrayList<Planet> planets, ArrayList<Planet> removePlanets) {
        for(int i = 0; i < planets.size(); i++)
            for (int j = i + 1; j < planets.size(); j++) {
                if (!detectCollision(planets.get(i), planets.get(j))) {
                    removePlanets.add(planets.get(i));
                    removePlanets.add(planets.get(j));
                }
            }
    }

    private static void extractedMoon(ArrayList<Moon> moons, ArrayList<Moon> removeMoons) {
        for (int k = 0; k < moons.size(); k++)
            for (int l = k + 1; l < moons.size(); l++) {
                if (!detectCollision(moons.get(k), moons.get(l))) {
                    removeMoons.add(moons.get(k));
                    removeMoons.add(moons.get(l));
                }
            }
    }

    private static boolean detectCollision(Planet p1, Planet p2) {
        return p1.distanceFrom(p2.getCoordinate()) <= (p1.getRADIUS() + p2.getRADIUS());
    }

    private static boolean detectCollision(Moon m1, Moon m2) {
        return m1.distanceFrom(m2.getCoordinate()) <= (m1.getRADIUS() + m2.getRADIUS());
    }

    private static boolean detectCollision(Planet p, Moon m) {
        return p.distanceFrom(m.getCoordinate()) <= (p.getRADIUS() + m.getRADIUS());
    }
}