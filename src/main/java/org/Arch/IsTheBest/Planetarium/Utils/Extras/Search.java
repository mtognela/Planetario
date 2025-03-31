package org.Arch.IsTheBest.Planetarium.Utils.Extras;

import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Moon;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Planet;
import org.Arch.IsTheBest.Planetarium.System.OrbitingSystem;

import java.util.ArrayList;

public abstract class Search {
    public static Planet searchPlanet(Integer id, String name) {
        ArrayList<Planet> planets = OrbitingSystem.getInstancePlanets();
        if (planets == null) return null;

        for(Planet planet : planets) {
            if (planet.getName().contains(name)
                    && planet.getIDString().contains(Integer.toString(id))) {
                return planet;
            }

        }
        return null;
    }

    public static Moon searchMoonByPlanet(Planet planet, Integer id, String name) {
        ArrayList<Moon> moons = planet.getMoons();
        if (moons == null) return null;

        for(Moon moon : moons) {
            if (moon.getName().contains(name) && moon.getIDString().contains(Integer.toString(id))) {
                return moon;
            }
        }
        return null;
    }

    public static Moon searchMoon(Integer id, String name) {
        ArrayList<Moon> moons = OrbitingSystem.getMoons();
        if (moons == null) return null;

        for(Moon moon : moons) {
            if (moon.getName().contains(name) && moon.getIDString().contains(Integer.toString(id))) {
                return moon;
            }
        }
        return null;
    }
}
