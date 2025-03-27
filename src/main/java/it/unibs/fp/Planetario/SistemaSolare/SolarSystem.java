package it.unibs.fp.Planetario.SistemaSolare;

import it.unibs.fp.Planetario.SistemaSolare.CorpoCeleste.Extend.*;
import java.util.ArrayList;

public class SolarSystem {
    private static SolarSystem instance = null;
    ArrayList<Planet> planets;
    Star star;
    String systemName;

    private SolarSystem(Star star, ArrayList<Planet> planets, String systemName) {
        this.star = star;
        this.planets = planets;
        this.systemName = systemName;
    }

    public static SolarSystem createInstance(Star star, ArrayList<Planet> listaPianeti, String systemName)  {
        if (instance == null) instance = new SolarSystem(star, listaPianeti, systemName);

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
}
