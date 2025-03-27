package it.unibs.fp.Planetario.Utils;

import it.unibs.fp.Planetario.Data.Coordinate;
import it.unibs.fp.Planetario.SistemaSolare.CorpoCeleste.Extend.*;

import java.util.ArrayList;

public class Util {
    private Star returnStar(double mass, String nome) {
        return Star.createInstance(mass, nome);
    }

    private Planet returnPlanet(double mass, Coordinate coordinate, String nome, ArrayList<Moon> moons) {
        ArrayList<Moon> moonsList = new ArrayList<>();

        return new Planet(mass, coordinate, nome, moons);
    }

    private Moon returnMoon(double mass, Coordinate coordinate, String nome, Planet pianetaRif) {
        return new Moon(mass, coordinate, nome, pianetaRif);
    }


}