package it.unibs.fp.Planetario.CorpoCeleste;


import it.unibs.fp.Planetario.Data.Coordinate;

import java.util.ArrayList;

public class Planet extends CorpoCeleste {
    ArrayList<Moon> Moons;

    public Planet(double mass, Coordinate coordinate, String nome, ArrayList<Moon> moons) {
        super(mass, coordinate, nome);
        this.Moons = moons;
    }

    public String toString() {
        return super.toString() + "Planet{" + "Moons=" + Moons.toString() + '}';
    }

}
