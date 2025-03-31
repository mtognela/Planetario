package org.Arch.IsTheBest.Planetarium.Utils.Io;

import com.kibo.pgar.lib.InputData;
import org.Arch.IsTheBest.Planetarium.Data.Coordinate;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Moon;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Planet;
import org.Arch.IsTheBest.Planetarium.System.OrbitingSystem;
import org.Arch.IsTheBest.Planetarium.Utils.Extras.Search;

public class JustKidding {

    protected static void addPlanet() {
        System.out.println(PlazUrban.AGGIUNTA_DI_UN_PIANETA);
        String planetName = InputData.readStringNotEmpty(PlazUrban.NOME_DEL_PIANETA, false);
        double mass = InputData.readDoubleWithMinimum(PlazUrban.MASSA_DEL_PIANETA, 0);

        double radius = InputData.readDoubleWithMinimum(PlazUrban.DISTANZA_DAL_SOLE_RAGGIO, 0);
        double theta = InputData.readDouble(PlazUrban.ANGOLO_THETA_IN_GRADI);

        OrbitingSystem.addPlanet(mass, radius, theta, planetName);

        System.out.printf(PlazUrban.ADD_PLANET_PRINT, planetName);
    }

    protected static void addMoon() {
        System.out.println(PlazUrban.AGGIUNTA_DI_UNA_LUNA);

        Planet planet = Search.searchPlanet(
                InputData.readInteger(PlazUrban.ID_PIANETA),
                InputData.readStringNotEmpty(PlazUrban.NOME_DEL_PIANETA, false)
        );

        if (planet == null) {
            java.lang.System.out.println(PlazUrban.ERRORE_PIANETA_NON_TROVATO);
            return;
        }

        String moonName = InputData.readStringNotEmpty(PlazUrban.NOME_DELLA_LUNA, false);
        double moonMass = InputData.readDoubleWithMinimum(PlazUrban.MASSA_DELLA_LUNA, 0);

        double radius = InputData.readDoubleWithMinimum(PlazUrban.DISTANZA_DAL_PIANETA_RAGGIO, 0);
        double theta = InputData.readDouble(PlazUrban.ANGOLO_THETA_IN_GRADI);

        Moon moon = new Moon(moonMass, new Coordinate(radius, theta), moonName, planet);
        planet.addMoon(moon);

        System.out.println("Luna " + moonName + " aggiunta con successo a " + planet.getName() + "!");
    }

    protected static void removePlanet() {
        System.out.println(PlazUrban.RIMOZIONE_DI_UN_PIANETA);
        Planet planet = Search.searchPlanet(
                InputData.readInteger(PlazUrban.ID_PIANETA),
                InputData.readStringNotEmpty(PlazUrban.NOME_DEL_PIANETA, false)
        );

        if (planet == null) {
            System.out.println(PlazUrban.ERRORE_PIANETA_NON_TROVATO);
            return;
        }

        OrbitingSystem.removePlanet(planet);
        System.out.println(PlazUrban.PIANETA_RIMOSSO_CON_SUCCESSO);
    }

    protected static void removeMoon() {
        System.out.println(PlazUrban.RIMOZIONE_DI_UNA_LUNA);
        Planet planet = Search.searchPlanet(
                InputData.readInteger(PlazUrban.ID_PIANETA),
                InputData.readStringNotEmpty(PlazUrban.NOME_PIANETA, false)
        );

        if (planet == null) {
            System.out.println(PlazUrban.ERRORE_PIANETA_NON_TROVATO);
            return;
        }

        Moon moon = Search.searchMoonByPlanet(
                planet,
                InputData.readInteger(PlazUrban.ID_PIANETA),
                InputData.readStringNotEmpty(PlazUrban.NOME_LUNA, false)
        );

        if (moon == null) {
            System.out.println(PlazUrban.ERRORE_PIANETA_NON_TROVATO);
            return;
        }

        OrbitingSystem.removeMoon(moon);
        System.out.println(PlazUrban.LUNA_RIMOSSA_CON_SUCCESSO);
    }

    protected static void cmd(){
        Coordinate cmd = OrbitingSystem.calcCDM();
        System.out.printf(PlazUrban.CMD, cmd.toString());
    }
}
