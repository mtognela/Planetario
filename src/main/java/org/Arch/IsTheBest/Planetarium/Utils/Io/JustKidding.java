package org.Arch.IsTheBest.Planetarium.Utils.Io;

import com.kibo.pgar.lib.InputData;
import org.Arch.IsTheBest.Planetarium.Data.Coordinate;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Moon;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Planet;
import org.Arch.IsTheBest.Planetarium.System.OrbitingSystem;
import org.Arch.IsTheBest.Planetarium.Utils.Extras.Search;
import static org.Arch.IsTheBest.Planetarium.Utils.Io.ArtTacTac.*;

public abstract class JustKidding {

    protected static void addPlanet() {
        System.out.println(AGGIUNTA_DI_UN_PIANETA);

        String planetName = InputData.readStringNotEmpty(NOME_DEL_PIANETA, false);
        double mass = InputData.readDoubleWithMinimum(MASSA_DEL_PIANETA, 0);

        double radius = InputData.readDoubleWithMinimum(DISTANZA_DAL_SOLE_RAGGIO, 0);
        double theta = InputData.readDouble(ANGOLO_THETA_IN_GRADI);

        OrbitingSystem.addPlanet(mass, radius, theta, planetName);

        System.out.printf(ADD_PLANET_PRINT, planetName);
    }

    protected static void addMoon() {
            Planet planet;

            if (!OrbitingSystem.getInstancePlanets().isEmpty()) {
                System.out.println(AGGIUNTA_DI_UNA_LUNA);
                planet = Search.searchPlanet(
                        InputData.readInteger(ID_PIANETA),
                        InputData.readStringNotEmpty(NOME_DEL_PIANETA, false)
                );

                if (planet == null) {
                    System.out.println(ERRORE_PIANETA_NON_TROVATO);
                    return;
                }
            } else {
                System.out.println(INIZIALIZZA_PRIMA_PIANETA);
                return;
            }

            String moonName = InputData.readStringNotEmpty(NOME_DELLA_LUNA, false);
            double moonMass = InputData.readDoubleWithMinimum(MASSA_DELLA_LUNA, 0);

            double radius = InputData.readDoubleWithMinimum(DISTANZA_DAL_PIANETA_RAGGIO, 0);
            double theta = InputData.readDouble(ANGOLO_THETA_IN_GRADI);

            Moon moon = new Moon(moonMass, new Coordinate(radius, theta), moonName, planet);
            planet.addMoon(moon);

            // to do
            System.out.println("Luna " + moonName + " aggiunta con successo a " + planet.getName() + "!");
    }

    protected static void removePlanet() {
        Planet planet;

        if (!OrbitingSystem.getInstancePlanets().isEmpty()) {
            System.out.println(RIMOZIONE_DI_UN_PIANETA);

            planet = Search.searchPlanet(
                    InputData.readInteger(ID_PIANETA),
                    InputData.readStringNotEmpty(NOME_DEL_PIANETA, false)
            );

            if (planet == null) {
                System.out.println(ERRORE_PIANETA_NON_TROVATO);
                return;
            }
        } else {
            System.out.println(INIZIALIZZA_PRIMA_PIANETA);
            return;
        }

        OrbitingSystem.removePlanet(planet);
        System.out.println(PIANETA_RIMOSSO_CON_SUCCESSO);
    }

    protected static void removeMoon() {
        Planet planet;

        if (!OrbitingSystem.getInstancePlanets().isEmpty()) {
            System.out.println(RIMOZIONE_DI_UNA_LUNA);

            planet = Search.searchPlanet(
                    InputData.readInteger(ID_PIANETA),
                    InputData.readStringNotEmpty(NOME_DEL_PIANETA, false)
            );

            if (planet == null) {
                System.out.println(ERRORE_PIANETA_NON_TROVATO);
                return;
            } else if (planet.getMoons().isEmpty()) {
                System.out.println();
                return;
            }
        } else {
            System.out.println(INIZIALIZZA_PRIMA_PIANETA);
            return;
        }


        Moon moon = Search.searchMoonByPlanet(
                planet,
                InputData.readInteger(ID_PIANETA),
                InputData.readStringNotEmpty(NOME_LUNA, false)
        );

        if (moon == null) {
            System.out.println(ERRORE_PIANETA_NON_TROVATO);
            return;
        }

        OrbitingSystem.removeMoon(moon);
        System.out.println(LUNA_RIMOSSA_CON_SUCCESSO);
    }



    protected static void cmd(){
        Coordinate cmd = OrbitingSystem.calcCDM();
        System.out.printf(ArtTacTac.CMD, cmd.toString());
    }

    protected static void showSystem() {
        if (!OrbitingSystem.getInstancePlanets().isEmpty()) {
            System.out.println(OrbitingSystem.showSystem());
        } else {
            System.out.println(ERRORE_SISTEMA_NON_INIZIALIZZATO);
        }
    }

    public static void route() {
        if (!OrbitingSystem.getInstancePlanets().isEmpty()) {
            Search search;
        } else {
            System.out.println(ERRORE_SISTEMA_NON_INIZIALIZZATO);
        }
    }
}
