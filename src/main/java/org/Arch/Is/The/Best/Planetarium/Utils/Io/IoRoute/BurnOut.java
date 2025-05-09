package org.Arch.Is.The.Best.Planetarium.Utils.Io.IoRoute;

import com.kibo.pgar.lib.InputData;
import org.Arch.Is.The.Best.Planetarium.System.CelestialBody.Extend.Moon;
import org.Arch.Is.The.Best.Planetarium.System.CelestialBody.Extend.Planet;
import org.Arch.Is.The.Best.Planetarium.System.OrbitingSystem;
import org.Arch.Is.The.Best.Planetarium.Path.Search;

import static org.Arch.Is.The.Best.Planetarium.Path.Route.buildPathFromTo;
import static org.Arch.Is.The.Best.Planetarium.Path.Route.fromTo;
import static org.Arch.Is.The.Best.Planetarium.Utils.Io.ArtTacTac.*;

import java.util.ArrayList;

/**
 * Abstract class responsible for handling planetary navigation and pathfinding.
 */
public abstract class BurnOut {
    /**
     * Computes and displays the distance between celestial bodies based on user input.
     */
    public static void fromToInterface() {
        if (!OrbitingSystem.getPlanets().isEmpty()) {
            double distance = rebusFromTo();
            System.out.println("Distance: " + distance);
        } else {
            System.out.println(ERROR_INIT_PANET_FIRST);
        }
    }

    /**
     * Computes and displays the path between celestial bodies based on user input.
     */
    public static void BuildPathFromTo() {
        if (!OrbitingSystem.getPlanets().isEmpty()) {
            String path = rebusBuildPathFromTo();
            System.out.println("Path: " + path);
        } else {
            System.out.println(ERROR_INIT_PANET_FIRST);
        }
    }

    /**
     * Determines the distance between selected celestial bodies based on user input.
     *
     * @return The computed distance between the selected celestial bodies.
     */
    private static double rebusFromTo() {
        ArrayList<Planet> planets = OrbitingSystem.getPlanets();
        ArrayList<Moon> moons = OrbitingSystem.getMoons();

        if (InputData.readYesOrNo(DO_YOU_WANT_TO_DO_A_MIX_RESEARCH)) {
            Planet planet;
            Moon moon;
            do {
                planet = getPlanet();
                moon = getMoon();
            } while (!InputData.readYesOrNo(DO_YOU_WANT_TO_SEARCH_AGAIN));

            assert moon != null;
            assert planet != null;
            return fromTo(moon, planet);
        } else if (InputData.readYesOrNo(Y_FOR_PLANET_AND_N_FOR_MOON)) {
            Planet planet1 = getPlanet();
            Planet planet2 = getPlanet();
            return fromTo(planet1, planet2);
        } else {
            Moon moon1 = getMoon();
            Moon moon2 = getMoon();
            return fromTo(moon1, moon2);
        }
    }

    /**
     * Retrieves a Moon object based on user input.
     *
     * @return The selected Moon object.
     */
    private static Moon getMoon() {
        Moon moon;
        do {
            int id2 = Integer.parseInt(InputData.readString(PLEASE_ENTER_A_MOON_ID, true));
            String nome2 = InputData.readString(PLEASE_ENTER_A_MOON_NAME, true);
            moon = Search.searchMoon(id2, nome2);
            System.out.println(moon);
        } while ((moon != null) && !InputData.readYesOrNo(DO_YOU_WANT_TO_SEARCH_AGAIN));
        return moon;
    }

    /**
     * Retrieves a Planet object based on user input.
     *
     * @return The selected Planet object.
     */
    private static Planet getPlanet() {
        Planet planet;
        do {
            int id2 = Integer.parseInt(InputData.readString(PLEASE_ENTER_A_PLANET_ID, true));
            String nome2 = InputData.readString(PLEASE_ENTER_A_MOON_NAME, true);
            planet = Search.searchPlanet(id2, nome2);
            System.out.println(planet);
        } while ((planet != null) && !InputData.readYesOrNo(DO_YOU_WANT_TO_SEARCH_AGAIN));
        return planet;
    }

    /**
     * Determines the path between selected celestial bodies based on user input.
     *
     * @return The computed path between the selected celestial bodies as a string.
     */
    private static String rebusBuildPathFromTo() {
        ArrayList<Planet> planets = OrbitingSystem.getPlanets();
        ArrayList<Moon> moons = OrbitingSystem.getMoons();

        if (InputData.readYesOrNo(DO_YOU_WANT_TO_DO_A_MIX_RESEARCH)) {
            Planet planet;
            Moon moon;
            do {
                planet = getPlanet();
                moon = getMoon();
            } while (!InputData.readYesOrNo(DO_YOU_WANT_TO_SEARCH_AGAIN));
            return buildPathFromTo(moon, planet);
        } else if (InputData.readYesOrNo(Y_FOR_PLANET_AND_N_FOR_MOON)) {
            Planet planet1 = getPlanet();
            Planet planet2 = getPlanet();
            return buildPathFromTo(planet1, planet2);
        } else {
            Moon moon1 = getMoon();
            Moon moon2 = getMoon();
            return buildPathFromTo(moon1, moon2);
        }
    }
}
