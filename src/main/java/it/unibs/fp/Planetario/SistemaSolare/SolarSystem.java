package it.unibs.fp.Planetario.SistemaSolare;

import it.unibs.fp.Planetario.Data.Coordinate;
import it.unibs.fp.Planetario.SistemaSolare.CorpoCeleste.Extend.*;
import java.util.ArrayList;

public class SolarSystem {
    private static SolarSystem instance = null;
    private static ArrayList<Planet> planets;
    private static Star star;
    private static String systemName;

    private SolarSystem(Star star, String systemName) {
        SolarSystem.star = star;
        planets = null;
        SolarSystem.systemName = systemName;
    }

    public static SolarSystem createInstance(Star star, String systemName)  {
        if (instance == null) instance = new SolarSystem(star, systemName);

        return instance;
    }

    public static SolarSystem getInstance() {
        return instance;
    }

    public static ArrayList<Planet> getInstancePlanets() {
        return planets;
    }

    public static String getInstanceName() {
        return systemName;
    }

    public static void addPlanet(double mass, double radius, double theta, String name) {
        planets.add(new Planet(mass, new Coordinate(radius, theta), name));
    }

    public static void removePlanet(Planet planet) {
        planets.remove(planet);
    }

    public static void showSolarSystem() {
        return
    }
}
