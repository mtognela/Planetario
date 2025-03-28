package it.unibs.fp.Planetario.SistemaSolare.CorpoCeleste.Extend;

import it.unibs.fp.Planetario.Data.Coordinate;
import it.unibs.fp.Planetario.SistemaSolare.CorpoCeleste.CorpoCeleste;

import java.util.ArrayList;

public class Star extends CorpoCeleste {
    private static Star instance = null;
    private ArrayList<Planet> listPianeti = new ArrayList<>();
    private String nomeSistema;

    public Star(double mass, String nome, String nomeSistema) {
        super(mass, new Coordinate(0, 0), nome);
        this.nomeSistema = nomeSistema;
        
    }

   // public static Star createInstance(double mass, String nome, ArrayList<Planet> listaPianeti, String systemName) {
   //     if (instance == null) instance = new Star(mass, nome, listaPianeti);

   //     return instance;
   // }

    public static String getInstanceName() {
        return instance.getName();
    }

    public ArrayList<Planet> getListPianeti() {
        return instance.listPianeti;
    }

    public static double getInstanceMass() {
        return instance.getMass();
    }

    @Override
    public String toString() {
        return super.toString() + "Star{" +
                "listPianeti=" + listPianeti +
                '}';
    }

	public void addPlanet(Planet planet) {
		// TODO Auto-generated method stub
		
	}
}
