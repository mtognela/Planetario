package org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend;

import com.kibo.pgar.lib.AnsiColors;
import com.kibo.pgar.lib.PrettyStrings;
import org.Arch.IsTheBest.Planetarium.Data.Coordinate;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.CorpoCeleste;
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
        StringBuffer moonsString = new StringBuffer();
        for (Moon moon : moons) {
            moonsString.append(moon.toString()).append("\n");
        }
        return PrettyStrings.
                prettify(String.format("%s { %s }",super.toString(), moonsString), AnsiColors.CYAN, null, null);
    }

    public Coordinate getPosition() {
        return super.getCoordinate();
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
