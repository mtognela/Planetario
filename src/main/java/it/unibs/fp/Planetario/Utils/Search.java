package it.unibs.fp.Planetario.Utils;

import it.unibs.fp.Planetario.SistemaSolare.CorpoCeleste.Extend.Moon;
import it.unibs.fp.Planetario.SistemaSolare.CorpoCeleste.Extend.Planet;
import it.unibs.fp.Planetario.SistemaSolare.SolarSystem;

import java.util.ArrayList;

public class Search {
    public static Planet searchPlanet(Integer id, String name) {
        ArrayList<Planet> planets = SolarSystem.getInstancePlanets();
        if (planets == null) return null;

        for(Planet planet : planets) {
            if (planet.getName().contains(name)
                    && planet.getIDString().contains(Integer.toString(id))) {
                return planet;
            }

        }
        return null;
    }

    public Moon searchMoonByPlanet(Planet planet, Integer id, String name) {
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
        ArrayList<Moon> moons = SolarSystem.getMoons();
        if (moons == null) return null;

        for(Moon moon : moons) {
            if (moon.getName().contains(name) && moon.getIDString().contains(Integer.toString(id))) {
                return moon;
            }
        }
        return null;
    }
}
