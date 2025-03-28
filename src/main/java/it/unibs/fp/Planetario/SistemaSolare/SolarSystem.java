package it.unibs.fp.Planetario.SistemaSolare;

import it.unibs.fp.Planetario.SistemaSolare.CorpoCeleste.Extend.*;
import java.util.ArrayList;

public class SolarSystem {
    private static SolarSystem instance = null;
    ArrayList<Planet> planets;
    Star star;
    String systemName;

    private SolarSystem(Star star, String systemName) {
        this.star = star;
        this.planets = null;
        this.systemName = systemName;
    }

    public static SolarSystem createInstance(Star star, String systemName)  {
        if (instance == null) instance = new SolarSystem(star, systemName);

        return instance;
    }

    public static SolarSystem getInstance() {
        return instance;
    }

    public static ArrayList<Planet> getInstancePlanets() {
        return instance.planets;
    }

    public static String getInstanceName() {
        return instance.systemName;
    }

    public static void addPlanet(Planet planet) {
        instance.planets.add(planet);
    }
}
