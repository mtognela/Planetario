package it.unibs.fp.Planetario.SistemaSolare.CorpoCeleste.Extend;

import it.unibs.fp.Planetario.Data.Coordinate;
import it.unibs.fp.Planetario.SistemaSolare.CorpoCeleste.CorpoCeleste;
import java.util.ArrayList;

public class Planet extends CorpoCeleste {
    private ArrayList<Moon> moons;

    public Planet(double mass, Coordinate coordinate, String nome) {
        super(mass, coordinate, nome);
        this.moons = new ArrayList<>();
    }

    public Planet(Planet planet) {
        super(planet.getMass(), planet.getCoordinate(), planet.getName());
        this.moons = planet.getMoons();
    }

    public ArrayList<Moon> getMoons() {
        return moons;
    }

    public String toString() {
        return super.toString() + "Planet{" + "Moons=" + moons.toString() + '}';
    }

    public Coordinate getPosition() {
        return super.getCoordinate();
    }

    public StringBuffer moonAround(){
        StringBuffer listMoon = new StringBuffer();
        for (Moon m : moons) {
            listMoon.append(m.toString()).append("\n");
        }
        return listMoon;
    }

    public void addMoon(double mass, double radius, double theta, String nome, Planet planet) {
        moons.add(new Moon(mass, new Coordinate(radius , theta), nome, planet));
    }

    public void addMoon(Moon moon) {
        moons.add(moon);
    }

    public void removeMoon(Moon moon) {
        moons.remove(moon);
    }
}
