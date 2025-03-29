package it.unibs.fp.Planetario.Utils;

import com.kibo.pgar.lib.*;
import it.unibs.fp.Planetario.Data.Coordinate;
import it.unibs.fp.Planetario.SistemaSolare.CorpoCeleste.Extend.*;
import it.unibs.fp.Planetario.SistemaSolare.SolarSystem;

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
            String systemName = InputData.readStringNotEmpty(MESSAGE_NAME_SYSTEM, true);
            Star.createInstance(
                    InputData.readDoubleWithMinimum(MESSAGE_MASS_STAR, 0),
                    InputData.readStringNotEmpty(MESSAGE_NAME_STAR, true)
            );

            SolarSystem.createInstance(Star.getInstance(), systemName);

            showMenu();
        } else {
            System.out.println("Goodbye!");
            System.exit(0);
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
                    SolarSystem.showSolarSystem();
                    break;
                case 6:
                    cmd();
                    break;
            }
        } while (choice != 0);
    }

    private static void addPlanet() {
        System.out.println("Aggiunta di un pianeta...");
        String planetName = InputData.readStringNotEmpty("Nome del pianeta: ", true);
        double mass = InputData.readDoubleWithMinimum("Massa del pianeta: ", 0);

        double radius = InputData.readDoubleWithMinimum("Distanza dal sole (raggio): ", 0);
        double theta = InputData.readDouble("Angolo theta (in gradi): ");

        SolarSystem.addPlanet(mass, radius, theta, planetName);

        System.out.println("Pianeta " + planetName + " aggiunto con successo!");
    }

    private static void addMoon() {
        System.out.println("Aggiunta di una luna...");

        // Trova il pianeta di riferimento
        Planet planet = Search.searchPlanet(
                InputData.readInteger("ID pianeta: "),
                InputData.readStringNotEmpty("Nome pianeta: ", true)
        );

        if (planet == null) {
            System.out.println("Errore: Pianeta non trovato.");
            return;
        }

        String moonName = InputData.readStringNotEmpty("Nome della luna: ", true);
        double moonMass = InputData.readDoubleWithMinimum("Massa della luna: ", 0);

        // Input per coordinate polari
        double radius = InputData.readDoubleWithMinimum("Distanza dal pianeta (raggio): ", 0);
        double theta = InputData.readDouble("Angolo theta (in gradi): ");

        // Creazione coordinate polari
        Coordinate coordinate = new Coordinate(radius, theta);

        Moon moon = new Moon(moonMass, coordinate, moonName, planet);
        planet.addMoon(moon);

        System.out.println("Luna " + moonName + " aggiunta con successo a " + planet.getName() + "!");
    }

    private static void removePlanet() {
        System.out.println("Rimozione di un pianeta...");
        Planet planet = Search.searchPlanet(
                InputData.readInteger("ID pianeta: "),
                InputData.readStringNotEmpty("Nome pianeta: ", true)
        );

        if (planet == null) {
            System.out.println("Errore: Pianeta non trovato.");
            return;
        }

        SolarSystem.removePlanet(planet);
        System.out.println("Pianeta rimosso con successo.");
    }

    private static void removeMoon() {
        System.out.println("Rimozione di una luna...");
        Planet planet = Search.searchPlanet(
                InputData.readInteger("ID pianeta: "),
                InputData.readStringNotEmpty("Nome pianeta: ", true)
        );

        if (planet == null) {
            System.out.println("Errore: Pianeta non trovato.");
            return;
        }

        Moon moon = Search.searchMoonByPlanet(
                planet,
                InputData.readInteger("ID luna: "),
                InputData.readStringNotEmpty("Nome luna: ", true)
        );

        if (moon == null) {
            System.out.println("Errore: Luna non trovata.");
            return;
        }

        SolarSystem.removeMoon(planet, moon);
        System.out.println("Luna rimossa con successo.");
    }

    private static void cmd(){
        Coordinate cmd = SolarSystem.calcCDM();
        if (cmd == null) {
            System.out.println("Ahhhh volevi");
        }
        else {
            System.out.println("cmd " + cmd.toString());
        }
    }
}
