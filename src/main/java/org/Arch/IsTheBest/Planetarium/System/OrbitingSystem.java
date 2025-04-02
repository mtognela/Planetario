package org.Arch.IsTheBest.Planetarium.System;

import org.Arch.IsTheBest.Planetarium.Data.Coordinate;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.*;
import org.Arch.IsTheBest.Planetarium.Utils.Collision.Collision;

import java.util.ArrayList;
import java.util.HashSet;

public class OrbitingSystem {
    private static OrbitingSystem instance;
    private static ArrayList<Planet> planets;
    private static Star star;
    private static String systemName;

    private OrbitingSystem(Star star, String systemName) {
        OrbitingSystem.star = star;
        OrbitingSystem.planets = new ArrayList<>();
        OrbitingSystem.systemName = systemName;
    }

    public static void createInstance(Star star, String systemName)  {
        if (instance == null) instance = new OrbitingSystem(star, systemName);
    }

    public static OrbitingSystem getInstance() {
        return instance;
    }

    public static ArrayList<Planet> getPlanets() {
        return planets;
    }

    public static String getInstanceName() {
        return systemName;
    }

    public static void addPlanet(double mass, double radius, double theta, String name) {
        planets.add(new Planet(mass, new Coordinate(radius, theta), name));
        Collision.checkCollisions();
    }

    public static void addPlanet(Planet planet) {
        planets.add(new Planet(planet));
        Collision.checkCollisions();
    }

    public static void removePlanet(Planet planet) {
        planets.remove(planet);
    }

    public static void addMoon(double mass, double radius, double theta, String nome, Planet planet) {
        planet.addMoon(mass, radius , theta, nome, planet);
        Collision.checkCollisions();
    }

    public static void removeMoon(Moon moon) {
        moon.getPianetaRif().removeMoon(moon);
    }

    public static Coordinate calcCDM() {
        double totalWeight = 0;
        double totalXMass = 0;
        double totalYMass = 0;

        if (planets.isEmpty()) {
            return new Coordinate(0.0, 0.0);
        }

        for (Planet planet : planets) {
            totalWeight += planet.getMass();
            totalXMass += planet.getPosition().getX() * planet.getMass();
            totalYMass += planet.getPosition().getY() * planet.getMass();
            for (Moon moon : planet.getMoons()) {
                totalWeight += moon.getMass();
                totalXMass += moon.getCoordinate().getX() * moon.getMass();
                totalYMass += moon.getCoordinate().getY() * moon.getMass();
            }
        }

        double cdmX = (totalWeight != 0) ? totalXMass / totalWeight : 0;
        double cdmY = (totalWeight != 0) ? totalYMass / totalWeight : 0;

        return new Coordinate(Coordinate.convertToPolar(cdmX, cdmY));
    }

    public static HashSet<Coordinate> getCoordinates() {
        HashSet<Coordinate> coordinates = new HashSet<>();
        for (Planet planet : getPlanets()) {
            coordinates.add(new Coordinate(planet.getCoordinate()));
        }
        for (Moon moons : getMoons()) {
            coordinates.add(new Coordinate(moons.getCoordinate()));
        }
        return coordinates;
    }

    public static ArrayList<Moon> getMoons() {
        ArrayList<Planet> planets = getPlanets();

        ArrayList<Moon> moons = new ArrayList<>();

        for (Planet planet : planets) {
            moons.addAll(planet.getMoons());
        }

        return moons;
    }

    public static StringBuffer showSystem() {
        StringBuffer systemString = new StringBuffer();

        systemString.append("\n").append(Star.getInstanceToString());
        if (!OrbitingSystem.getPlanets().isEmpty()) {
            systemString.append("\n");
            for (int i = 0; i < OrbitingSystem.getPlanets().size()-1; i++) {
                systemString.append(OrbitingSystem.getPlanets().get(i).toString()).append("\n");
            }
            systemString.append(OrbitingSystem.getPlanets().getLast().toString());
        }

        return systemString;
    }
}
