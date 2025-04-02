package org.Arch.IsTheBest.Planetarium.Path;

import com.kibo.pgar.lib.InputData;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.CorpoCeleste;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Moon;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Planet;
import org.Arch.IsTheBest.Planetarium.System.OrbitingSystem;

import java.util.ArrayList;

import static org.Arch.IsTheBest.Planetarium.Utils.Io.ArtTacTac.DO_YOU_WANT_TO_SEARCH_AGAIN;
import static org.Arch.IsTheBest.Planetarium.Utils.Io.ArtTacTac.NO_PLANET_FOUND;

/**
 * The {@code Search} class provides utility methods to search for planets and moons within the orbiting system.
 */
public abstract class Search {

    /**
     * Searches for a planet in the orbiting system based on its ID and name.
     *
     * @param id   The ID of the planet to search for.
     * @param name The name of the planet to search for.
     * @return The {@code Planet} object if found, otherwise {@code null}.
     */
    public static Planet searchPlanet(Integer id, String name) {
        ArrayList<Planet> planets = OrbitingSystem.getPlanets();
        if (planets.isEmpty()) return null;

        for (Planet planet : planets) {
            if (planet.getName().contains(name) &&
                    planet.getIDString().contains(Integer.toString(id))) {
                return planet;
            }
        }
        return null;
    }

    /**
     * Searches for a moon that orbits a given planet based on its ID and name.
     *
     * @param planet The planet around which the moon orbits.
     * @param id     The ID of the moon to search for.
     * @param name   The name of the moon to search for.
     * @return The {@code Moon} object if found, otherwise {@code null}.
     */
    public static Moon searchMoonByPlanet(Planet planet, Integer id, String name) {
        ArrayList<Moon> moons = planet.getMoons();
        if (moons.isEmpty()) return null;

        for (Moon moon : moons) {
            if (moon.getName().contains(name) && moon.getIDString().contains(Integer.toString(id))) {
                return moon;
            }
        }
        return null;
    }

    /**
     * Searches for a moon in the orbiting system based on its ID and name.
     *
     * @param id   The ID of the moon to search for.
     * @param name The name of the moon to search for.
     * @return The {@code Moon} object if found, otherwise {@code null}.
     */
    public static Moon searchMoon(Integer id, String name) {
        ArrayList<Moon> moons = OrbitingSystem.getMoons();
        if (moons.isEmpty()) return null;

        for (Moon moon : moons) {
            if (moon.getName().contains(name) && moon.getIDString().contains(Integer.toString(id))) {
                return moon;
            }
        }
        return null;
    }
    /**
     * Searches for a celestial body (planet or moon) in the orbiting system based on user input.
     * The user is prompted to enter an ID and a name to find either a planet or a moon.
     *
     * @return The found celestial body ({@code Planet} or {@code Moon}), or {@code null} if no match is found.
     */

    public static CorpoCeleste justSearch() {
        ArrayList<Planet> planets = OrbitingSystem.getPlanets();
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
}
