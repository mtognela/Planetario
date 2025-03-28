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

    public ArrayList<Moon> getMoons() {
        return moons;
    }

    public String toString() {
        return super.toString() + "Planet{" + "Moons=" + moons.toString() + '}';
    }

    public StringBuffer moonAround(){
        StringBuffer listMoon = new StringBuffer();
        for (Moon m : moons) {
            listMoon.append(m.toString()).append("\n");
        }
        return listMoon;
    }

	public void addMoon(Moon moon) {
		// TODO Auto-generated method stub
		
	}
}
