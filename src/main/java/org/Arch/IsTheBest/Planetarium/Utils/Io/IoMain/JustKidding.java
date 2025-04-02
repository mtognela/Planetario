package org.Arch.IsTheBest.Planetarium.Utils.Io.IoMain;

import com.kibo.pgar.lib.InputData;
import org.Arch.IsTheBest.Planetarium.Data.Coordinate;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Moon;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Planet;
import org.Arch.IsTheBest.Planetarium.System.OrbitingSystem;
import org.Arch.IsTheBest.Planetarium.Path.Search;

import static org.Arch.IsTheBest.Planetarium.Utils.Io.ArtTacTac.*;

/**
 * Utility class for managing planetary and lunar systems.
 * This class provides methods to add and remove planets and moons,
 * as well as display system information.
 */
public abstract class JustKidding {

    /**
     * Adds a new planet to the orbiting system.
     */
    protected static void addPlanet() {
        System.out.println(PLANET_ADD);

        String planetName = setupPlanet();

        System.out.printf(ADD_PLANET_PRINT, planetName);
    }

    /**
     * Sets up a new planet with user input data.
     *
     * @return The name of the newly added planet.
     */
    private static String setupPlanet() {
        String planetName = InputData.readStringNotEmpty(PLANET_NAME, false);
        double mass = InputData.readDoubleWithMinimum(PLANET_MASS, 0);

        double radius = InputData.readDoubleWithMinimum(DISTANCE_SUN_RADIUS, 0);
        double theta = InputData.readDouble(THETA_IN_RADIUS);

        OrbitingSystem.addPlanet(mass, radius, theta, planetName);
        return planetName;
    }

    /**
     * Sets up a new moon with user input data.
     *
     * @param planet The planet around which the moon orbits.
     * @return The name of the newly added moon.
     */
    private static String setupMoon(Planet planet) {
        String moonName = InputData.readStringNotEmpty(MOON_NAME, false);
        double mass = InputData.readDoubleWithMinimum(MOON_MASS, 0);

        double radius = InputData.readDoubleWithMinimum(DISTANCE_FROM_PLANET, 0);
        double theta = InputData.readDouble(THETA_IN_RADIUS);

        OrbitingSystem.addMoon(mass, radius, theta, moonName, planet);
        return moonName;
    }

    /**
     * Adds a moon to an existing planet.
     */
    protected static void addMoon() {
        Planet planet = null;

        planet = getPlanet();
        if (planet == null) return;

        String moonName = setupMoon(planet);

        System.out.println("Luna " + moonName + " aggiunta con successo a " + planet.getName() + "!");
    }

    /**
     * Retrieves a planet based on user input.
     *
     * @return The selected planet, or null if not found.
     */
    private static Planet getPlanet() {
        Planet planet = null;
        if (!OrbitingSystem.getPlanets().isEmpty()) {
            System.out.println("Getting Planet");
            do {
                planet = Search.searchPlanet(
                        InputData.readInteger(ID_PLANET),
                        InputData.readStringNotEmpty(PLANET_NAME, false)
                );

                if (planet == null) {
                    System.out.println(ERROR_PLANET_NOT_FOUND);
                    return null;
                } else System.out.println(planet.toString());

            } while (!InputData.readYesOrNo(YES_OR_NO));
        } else {
            System.out.println(ERROR_INIT_PANET_FIRST);
            return null;
        }
        return planet;
    }

    /**
     * Retrieves a moon belonging to a given planet based on user input.
     *
     * @param planet The planet whose moon is being searched.
     * @return The selected moon, or null if not found.
     */
    public static Moon getMoon(Planet planet) {
        Moon moon = null;
        if (!planet.getMoons().isEmpty()) {
            System.out.println(MOON_SEARCH);
            do {
                moon = Search.searchMoonByPlanet(
                        planet,
                        InputData.readInteger(ID_MOON),
                        InputData.readStringNotEmpty(MOON_NAME, false)
                );

                if(moon == null) {
                    System.out.println(ERROR_MOON_NOT_FOUND);
                    return null;
                } else System.out.println(moon.toString());

            } while (!InputData.readYesOrNo(YES_OR_NO));
        } else {
            System.out.println(ERROR_PLANET_NOT_OWN_NO_MOON);
            return null;
        }
        return null;
    }

    /**
     * Removes a planet from the orbiting system.
     */
    protected static void removePlanet() {
        Planet planet = null;

        planet = getPlanet();
        if (planet == null) return;

        OrbitingSystem.removePlanet(planet);
        System.out.println(PLANET_REMOVE_SUCESS);
    }

    /**
     * Removes a moon from its planet in the orbiting system.
     */
    protected static void removeMoon() {
        Planet planet = null;

        planet = getPlanet();

        Moon moon = null;

        assert planet != null;

        moon = getMoon(planet);

        assert moon != null;

        OrbitingSystem.removeMoon(moon);
        System.out.println(MOON_ADD);
    }

    /**
     * Calculates and displays the center of mass of the planetary system.
     */
    protected static void cmd(){
        Coordinate cmd = OrbitingSystem.calcCDM();
        System.out.printf(CMD, cmd.toString());
    }

    /**
     * Displays the current state of the orbiting system.
     */
    protected static void showSystem() {
        System.out.println(OrbitingSystem.showSystem());
    }
}
