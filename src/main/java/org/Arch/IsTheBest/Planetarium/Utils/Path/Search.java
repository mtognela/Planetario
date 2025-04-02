package org.Arch.IsTheBest.Planetarium.Utils.Path;

import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Moon;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Planet;
import org.Arch.IsTheBest.Planetarium.System.OrbitingSystem;

import java.util.ArrayList;

public abstract class Search {

    public static Planet searchPlanet(Integer id, String name) {
        ArrayList<Planet> planets = OrbitingSystem.getPlanets();
        if (planets.isEmpty()) return null;

        for(Planet planet : planets) {
            if (planet.getName().contains(name) &&
                    planet.getIDString().contains(Integer.toString(id))) {
                return planet;
            }

        }
        return null;
    }

    public static Moon searchMoonByPlanet(Planet planet, Integer id, String name) {
        ArrayList<Moon> moons = planet.getMoons();
        if (moons.isEmpty()) return null;

        for(Moon moon : moons) {
            if (moon.getName().contains(name) && moon.getIDString().contains(Integer.toString(id))) {
                return moon;
            }
        }
        return null;
    }

    public static Moon searchMoon(Integer id, String name) {
        ArrayList<Moon> moons = OrbitingSystem.getMoons();
        if (moons.isEmpty()) return null;

        for(Moon moon : moons) {
            if (moon.getName().contains(name) && moon.getIDString().contains(Integer.toString(id))) {
                return moon;
            }
        }
        return null;
    }

    /*
    public static CorpoCeleste justSearch() {
        ArrayList<Planet> planets = OrbitingSystem.getInstancePlanets();
        ArrayList<Moon> moons = OrbitingSystem.getMoons();
        Planet planetToSearch = null;
        Moon moonToSearch = null;
        if (planets.isEmpty() && moons.isEmpty()) return null;

        do {
            int id = Integer.parseInt(InputData.readString("Please enter an ID: ", true));
            String nome = InputData.readString("Please enter a name ", true);

            planetToSearch = searchPlanet(id, nome);
            moonToSearch = searchMoon(id, nome);

            if (planetToSearch == null && moonToSearch == null) System.out.println(NO_PLANET_FOUND);
            else if (planetToSearch == null) System.out.println(moonToSearch.toString());
            else if (moonToSearch == null) System.out.println(planetToSearch.toString());
            else {
                System.out.println(moonToSearch.toString());
                System.out.println(planetToSearch.toString());
            }
        } while(!InputData.readYesOrNo(DO_YOU_WANT_TO_SEARCH_AGAIN) && (planetToSearch != null || moonToSearch != null));

        if (planetToSearch == null) return moonToSearch;
        else if (moonToSearch == null) return planetToSearch;
        else {
            if (InputData.readYesOrNo("What do you want Y for planet n for moon: ")) {
                return planetToSearch;
            } else return moonToSearch;
        }
    }
     */
}
