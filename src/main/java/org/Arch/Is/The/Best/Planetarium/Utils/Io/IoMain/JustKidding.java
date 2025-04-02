package org.Arch.Is.The.Best.Planetarium.Utils.Io.IoMain;

import com.kibo.pgar.lib.InputData;
import org.Arch.Is.The.Best.Planetarium.Data.Coordinate;
import org.Arch.Is.The.Best.Planetarium.System.CelestialBody.Extend.Moon;
import org.Arch.Is.The.Best.Planetarium.System.CelestialBody.Extend.Planet;
import org.Arch.Is.The.Best.Planetarium.System.OrbitingSystem;
import org.Arch.Is.The.Best.Planetarium.Path.Search;

import static org.Arch.Is.The.Best.Planetarium.Utils.Io.ArtTacTac.*;

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

        Planet planet = setupPlanet();

        System.out.printf(ADD_PLANET_PRINT, planet.getName(),  planet.getID());
    }

    /**
     * Sets up a new planet with user input data.
     *
     * @return The new planet itself.
     */
    private static Planet setupPlanet() {
        Planet planet;

        String planetName = InputData.readStringNotEmpty(PLANET_NAME, false);
        double mass = InputData.readDoubleWithMinimum(PLANET_MASS, 0.1);

        double radius = InputData.readDoubleWithMinimum(DISTANCE_SUN_RADIUS, 0.1);
        double theta = InputData.readDouble(THETA_IN_RADIUS);

        planet = new Planet(mass, new Coordinate(radius, theta), planetName);

        OrbitingSystem.addPlanet(planet);

        return planet;
    }

    /**
     * Sets up a new moon with user input data.
     *
     * @param planet The planet around which the moon orbits.
     * @return The name of the newly added moon.
     */
    private static Moon setupMoon(Planet planet) {
        Moon moon;

        String moonName = InputData.readStringNotEmpty(MOON_NAME, false);
        double mass = InputData.readDoubleWithMinimum(MOON_MASS, 0);

        double radius = InputData.readDoubleWithMinimum(DISTANCE_FROM_PLANET, 0);
        double theta = InputData.readDouble(THETA_IN_RADIUS);

        moon = new Moon(mass, new Coordinate(radius, theta), moonName, planet);

        OrbitingSystem.addMoon(moon);

        return moon;
    }

    /**
     * Adds a moon to an existing planet.
     */
    protected static void addMoon() {
        Planet planet = null;
        Moon moon;

        planet = getPlanet();
        if (planet == null) return;

        moon = setupMoon(planet);

        System.out.printf(ADDING_A_MOON_WITH_NAME_S_ID_D_TO_THE_PLANET_S_AND_D, moon.getName(), moon.getID(), planet.getName(), moon.getID());
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
