package it.unibs.fp.Planetario.SistemaSolare;

import it.unibs.fp.Planetario.Data.Coordinate;
import it.unibs.fp.Planetario.SistemaSolare.CorpoCeleste.Extend.*;
import java.util.ArrayList;
import java.util.Objects;

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

    public static void addMoon(double mass, double radius, double theta, String nome, Planet planet) {
        planet.addMoon(mass, radius , theta, nome, planet);
    }

    public void removeMoon(Moon moon,Planet planet) {
        planet.removeMoon(moon);
    }

    public static Coordinate calcCDM() {
        double totalWeight = 0;
        double totalRadiusMass = 0;

        for (Planet planet : planets) {
            double mass = planet.getMass();
            double radius = planet.getPosition().getX(); // Assuming X represents the radius

            totalWeight += mass;
            totalRadiusMass += radius * mass;
        }

        // Avoid division by zero
        double cdmX = (totalWeight != 0) ? totalRadiusMass / totalWeight : 0;

        return new Coordinate(cdmX, 0); // Assuming Y is not needed or is 0
    }


    public static void showSolarSystem() {
        // TO DO IS NOT THAT DIFFICULT
    }
}
