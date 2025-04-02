package org.Arch.IsTheBest.Planetarium.Utils.Io.Main;

import com.kibo.pgar.lib.InputData;
import org.Arch.IsTheBest.Planetarium.Data.Coordinate;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Moon;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Planet;
import org.Arch.IsTheBest.Planetarium.System.OrbitingSystem;
import org.Arch.IsTheBest.Planetarium.Utils.Path.Search;

import static org.Arch.IsTheBest.Planetarium.Utils.Io.ArtTacTac.*;

public abstract class JustKidding {

    protected static void addPlanet() {
        System.out.println(PLANET_ADD);

        String planetName = InputData.readStringNotEmpty(PLANET_NAME, false);
        double mass = InputData.readDoubleWithMinimum(PLANET_MASS, 0);

        double radius = InputData.readDoubleWithMinimum(DISTANCE_SUN_RADIUS, 0);
        double theta = InputData.readDouble(THETA_IN_RADIUS);

        OrbitingSystem.addPlanet(mass, radius, theta, planetName);

        System.out.printf(ADD_PLANET_PRINT, planetName);
    }

    protected static void addMoon() {
            Planet planet;

            if (!OrbitingSystem.getPlanets().isEmpty()) {
                System.out.println(MOON_ADD);
                do {
                    planet = Search.searchPlanet(
                            Integer.parseInt(InputData.readSting(ID_PLANET)),
                            InputData.readStringNotEmpty(PLANET_NAME, false)
                    );

                    if (planet == null) {
                        System.out.println(ERROR_PLANET_NOT_FOUND);
                        return;
                    } else System.out.println(planet.toString());

                } while(!InputData.readYesOrNo("Va bene?"));
            } else {
                System.out.println(ERROR_INIT_PANET_FIRST);
                return;
            }

            String moonName = InputData.readStringNotEmpty(MOON_NAME, false);
            double moonMass = InputData.readDoubleWithMinimum(MOON_MASS, 0);

            double radius = InputData.readDoubleWithMinimum(DISTANCE_FROM_PLANET, 0);
            double theta = InputData.readDouble(THETA_IN_RADIUS);

            Moon moon = new Moon(moonMass, new Coordinate(radius, theta), moonName, planet);
            planet.addMoon(moon);

            System.out.println("Luna " + moonName + " aggiunta con successo a " + planet.getName() + "!");
    }

    protected static void removePlanet() {
        Planet planet;

        if (!OrbitingSystem.getPlanets().isEmpty()) {
            System.out.println(MOON_ADD);
            do {
                planet = Search.searchPlanet(
                        Integer.parseInt(InputData.readSting(ID_PLANET)),
                        InputData.readStringNotEmpty(PLANET_NAME, false)
                );

                if (planet == null) {
                    System.out.println(ERROR_PLANET_NOT_FOUND);
                    return;
                } else System.out.println(planet.toString());

            } while(InputData.readYesOrNo("Va bene?"));
        } else {
            System.out.println(ERROR_INIT_PANET_FIRST);
            return;
        }

        OrbitingSystem.removePlanet(planet);
        System.out.println(PLANET_REMOVE_SUCESS);
    }

    protected static void removeMoon() {
        Planet planet;

        if (!OrbitingSystem.getPlanets().isEmpty()) {
            System.out.println();
            do {
                planet = Search.searchPlanet(
                        Integer.parseInt(InputData.readSting(ID_PLANET)),
                        InputData.readStringNotEmpty(PLANET_NAME, false)
                );

                if (planet == null) {
                    System.out.println(ERROR_PLANET_NOT_FOUND);
                    return;
                } else System.out.println(planet.toString());

            } while(InputData.readYesOrNo(YES_OR_NO));
        } else {
            System.out.println(ERROR_INIT_PANET_FIRST);
            return;
        }

        Moon moon = null;

        if (!planet.getMoons().isEmpty()) {
            System.out.println(MOON_SEARCH);
            do {
                moon = Search.searchMoonByPlanet(
                        planet,
                        Integer.parseInt(InputData.readSting(ID_MOON)),
                        InputData.readStringNotEmpty(MOON_NAME, false)
                );

                if(moon == null) {
                    System.out.println(ERROR_MOON_NOT_FOUND);
                    return;
                } else System.out.println(moon.toString());

            } while (InputData.readYesOrNo(YES_OR_NO));
        } else {
            System.out.println(ERROR_PLANET_NOT_OWN_NO_MOON);
        }

        OrbitingSystem.removeMoon(moon);
        System.out.println(MOON_ADD);
    }

    protected static void cmd(){
        Coordinate cmd = OrbitingSystem.calcCDM();
        System.out.printf(CMD, cmd.toString());
    }

    protected static void showSystem() {
        System.out.println(OrbitingSystem.showSystem());
    }
}
