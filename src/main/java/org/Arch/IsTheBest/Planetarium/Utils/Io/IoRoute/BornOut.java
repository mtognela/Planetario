package org.Arch.IsTheBest.Planetarium.Utils.Io.IoRoute;

import com.kibo.pgar.lib.InputData;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Moon;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Planet;
import org.Arch.IsTheBest.Planetarium.System.OrbitingSystem;
import org.Arch.IsTheBest.Planetarium.Utils.Path.Search;
import static org.Arch.IsTheBest.Planetarium.Utils.Io.ArtTacTac.*;
import static org.Arch.IsTheBest.Planetarium.Utils.Path.Route.*;
import java.util.ArrayList;

public abstract class BornOut {

    public static void fromToInterface() {
        if (!OrbitingSystem.getPlanets().isEmpty()) {
            double distance = rebusFromTo();

            System.out.println("Distance: " + distance);
        } else {
            System.out.println(ERROR_INIT_PANET_FIRST);
        }
    }

    public static void BuildPathFromTo() {
        if (!OrbitingSystem.getPlanets().isEmpty()) {
            String path =  rebusBuildPathFromTo();

            System.out.println("Path: " + path);
        } else {
            System.out.println(ERROR_INIT_PANET_FIRST);
        }
    }

    private static double rebusFromTo() {
        ArrayList<Planet> planets = OrbitingSystem.getPlanets();
        ArrayList<Moon> moons = OrbitingSystem.getMoons();

        if (InputData.readYesOrNo("Do you want to do a mix research?")) {
            Planet planet = null;
            Moon moon = null;
            do {
                planet = getPlanet();
                moon = getMoon();
            } while(!InputData.readYesOrNo(DO_YOU_WANT_TO_SEARCH_AGAIN));

            assert moon != null;
            assert planet != null;

            return fromTo(moon, planet);
        } else if (InputData.readYesOrNo("Do you want to search planets or moons (Y for Planet and n for moon)?")) {
            Planet planet1 = null;
            Planet planet2 = null;

            planet1 = getPlanet();

            planet2 = getPlanet();

            return fromTo(planet1, planet2);
        } else {
            Moon moon1 = null;
            Moon moon2 = null;

            moon1 = getMoon();

            moon2 = getMoon();

            return fromTo(moon1, moon2);
        }
    }

    private static Moon getMoon() {
        Moon moon = null;
        do {
            int id2 = Integer.parseInt(InputData.readString("Please enter an Moon ID: ", true));
            String nome2 = InputData.readString("Please enter a Moon name ", true);
            moon = Search.searchMoon(id2, nome2);

            System.out.println(moon);
        } while ((moon != null) && !InputData.readYesOrNo(DO_YOU_WANT_TO_SEARCH_AGAIN));

        return moon;
    }

    private static Planet getPlanet() {
        Planet planet = null;
        do {
            int id2 = Integer.parseInt(InputData.readString("Please enter an Planet ID: ", true));
            String nome2 = InputData.readString("Please enter a Planet name ", true);
            planet = Search.searchPlanet(id2, nome2);

            System.out.println(planet);
        } while ((planet != null) && !InputData.readYesOrNo(DO_YOU_WANT_TO_SEARCH_AGAIN));

        return planet;
    }

    private static String rebusBuildPathFromTo() {
        ArrayList<Planet> planets = OrbitingSystem.getPlanets();
        ArrayList<Moon> moons = OrbitingSystem.getMoons();

        if (InputData.readYesOrNo("Do you want to do a mix research?")) {
            Planet planet = null;
            Moon moon = null;

            do {
                planet = getPlanet();
                moon = getMoon();
            } while(!InputData.readYesOrNo(DO_YOU_WANT_TO_SEARCH_AGAIN));

            return buildPathFromTo(moon, planet);
        } else if (InputData.readYesOrNo("Do you want to search planets or moons (Y for Planet and n for moon)?")) {
            Planet planet1 = null, planet2 = null;

            planet1 = getPlanet();

            planet2 = getPlanet();

            return buildPathFromTo(planet1, planet2);
        } else {
            Moon moon1 = null, moon2 = null;

            moon1 = getMoon();

            moon2 = getMoon();

            return buildPathFromTo(moon1, moon2);
        }
    }
}
