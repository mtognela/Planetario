package org.Arch.IsTheBest.Planetarium.Utils;

import com.kibo.pgar.lib.*;
import org.Arch.IsTheBest.Planetarium.Data.Coordinate;
import org.Arch.IsTheBest.Planetarium.SistemaSolare.CorpoCeleste.Extend.Moon;
import org.Arch.IsTheBest.Planetarium.SistemaSolare.CorpoCeleste.Extend.Planet;
import org.Arch.IsTheBest.Planetarium.SistemaSolare.CorpoCeleste.Extend.Star;
import org.Arch.IsTheBest.Planetarium.SistemaSolare.OrbitingSystem;

public abstract class Io {
    public static final String GREETER = PrettyStrings.prettify(
            "Are you ready to create your system?", AnsiColors.CYAN, AnsiWeights.BOLD, null);
    public static final String MESSAGE_NAME_SYSTEM = PrettyStrings.prettify(
            "Input the System Name: ", AnsiColors.CYAN, AnsiWeights.BOLD, null);
    public static final String MESSAGE_MASS_STAR = PrettyStrings.prettify(
            "Input the Star mass: ", AnsiColors.CYAN, AnsiWeights.BOLD, null);
    public static final String MESSAGE_NAME_STAR = PrettyStrings.prettify(
            "Input the Star Name: ", AnsiColors.CYAN, AnsiWeights.BOLD, null);

    public static void setUpSystem() {
        if (InputData.readYesOrNo(GREETER)) {
            String systemName = InputData.readStringNotEmpty(MESSAGE_NAME_SYSTEM, false);
            Star.createInstance(
                    InputData.readDoubleWithMinimum(MESSAGE_MASS_STAR, 0),
                    InputData.readStringNotEmpty(MESSAGE_NAME_STAR, false)
            );

            OrbitingSystem.createInstance(Star.getInstance(), systemName);

            showMenu();
        } else {
            java.lang.System.out.println("Goodbye!");
            java.lang.System.exit(0);
        }
    }

    private static void showMenu() {
        String[] options = {
                "Aggiungi un pianeta",
                "Aggiungi una luna",
                "Rimuovi un pianeta",
                "Rimuovi una luna",
                "Mostra il sistema solare",
                "Calcola centro di massa",
        };

        Menu menu = new Menu("System Menu", options, true, true, true);

        int choice;

        do {
            choice = menu.choose();

            switch (choice) {
                case 1:
                    addPlanet();
                    break;
                case 2:
                    addMoon();
                    break;
                case 3:
                    removePlanet();
                    break;
                case 4:
                    removeMoon();
                    break;
                case 5:
                    OrbitingSystem.showSolarSystem();
                    break;
                case 6:
                    cmd();
                    break;
            }
        } while (choice != 0);
    }

    private static void addPlanet() {
        java.lang.System.out.println("Aggiunta di un pianeta...");
        String planetName = InputData.readStringNotEmpty("Nome del pianeta: ", false);
        double mass = InputData.readDoubleWithMinimum("Massa del pianeta: ", 0);

        double radius = InputData.readDoubleWithMinimum("Distanza dal sole (raggio): ", 0);
        double theta = InputData.readDouble("Angolo theta (in gradi): ");

        OrbitingSystem.addPlanet(mass, radius, theta, planetName);

        java.lang.System.out.println("Pianeta " + planetName + " aggiunto con successo!");
    }

    private static void addMoon() {
        java.lang.System.out.println("Aggiunta di una luna...");

        // Trova il pianeta di riferimento
        Planet planet = Search.searchPlanet(
                InputData.readInteger("ID pianeta: "),
                InputData.readStringNotEmpty("Nome pianeta: ", false)
        );

        if (planet == null) {
            java.lang.System.out.println("Errore: Pianeta non trovato.");
            return;
        }

        String moonName = InputData.readStringNotEmpty("Nome della luna: ", false);
        double moonMass = InputData.readDoubleWithMinimum("Massa della luna: ", 0);

        // Input per coordinate polari
        double radius = InputData.readDoubleWithMinimum("Distanza dal pianeta (raggio): ", 0);
        double theta = InputData.readDouble("Angolo theta (in gradi): ");

        // Creazione coordinate polari
        Coordinate coordinate = new Coordinate(radius, theta);

        Moon moon = new Moon(moonMass, coordinate, moonName, planet);
        planet.addMoon(moon);

        java.lang.System.out.println("Luna " + moonName + " aggiunta con successo a " + planet.getName() + "!");
    }

    private static void removePlanet() {
        java.lang.System.out.println("Rimozione di un pianeta...");
        Planet planet = Search.searchPlanet(
                InputData.readInteger("ID pianeta: "),
                InputData.readStringNotEmpty("Nome pianeta: ", false)
        );

        if (planet == null) {
            java.lang.System.out.println("Errore: Pianeta non trovato.");
            return;
        }

        OrbitingSystem.removePlanet(planet);
        java.lang.System.out.println("Pianeta rimosso con successo.");
    }

    private static void removeMoon() {
        java.lang.System.out.println("Rimozione di una luna...");
        Planet planet = Search.searchPlanet(
                InputData.readInteger("ID pianeta: "),
                InputData.readStringNotEmpty("Nome pianeta: ", false)
        );

        if (planet == null) {
            java.lang.System.out.println("Errore: Pianeta non trovato.");
            return;
        }

        Moon moon = Search.searchMoonByPlanet(
                planet,
                InputData.readInteger("ID luna: "),
                InputData.readStringNotEmpty("Nome luna: ", false)
        );

        if (moon == null) {
            java.lang.System.out.println("Errore: Luna non trovata.");
            return;
        }

        OrbitingSystem.removeMoon(moon);
        java.lang.System.out.println("Luna rimossa con successo.");
    }

    private static void cmd(){
        Coordinate cmd = OrbitingSystem.calcCDM();
        java.lang.System.out.println("cmd " + cmd.toString());
    }
}
