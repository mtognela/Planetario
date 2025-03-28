package it.unibs.fp.Planetario.Utils;

import com.kibo.pgar.lib.*;
import it.unibs.fp.Planetario.SistemaSolare.CorpoCeleste.Extend.*;
import it.unibs.fp.Planetario.SistemaSolare.SolarSystem;

import static it.unibs.fp.Planetario.SistemaSolare.SolarSystem.showSolarSystem;

public class Io {
    public static String GREETER = PrettyStrings.
            prettify("Are you ready to crete your system?", AnsiColors.CYAN, AnsiWeights.BOLD, null);
    public static String MESSARE_NAME_SYSTEM = PrettyStrings.
            prettify("Input the System Name: ", AnsiColors.CYAN, AnsiWeights.BOLD, null);
    public static String MESSAGE_MASS_STAR = PrettyStrings.
            prettify("Input the Star mass: ", AnsiColors.CYAN, AnsiWeights.BOLD, null);
    public static String MESSAGE_MASS_PLANET = PrettyStrings.
            prettify("Input the Planet mass: ", AnsiColors.CYAN, AnsiWeights.BOLD, null);
    public static String MESSAGE_NAME_STAR = PrettyStrings.
            prettify("Input the Star Name: ", AnsiColors.CYAN, AnsiWeights.BOLD, null);
    public static String MESSAGE_ADD_PLANET = PrettyStrings.
            prettify("Do you want to add a planet to the system?", AnsiColors.CYAN, AnsiWeights.BOLD, null);

    public static void setUpSystem() {
        if (InputData.readYesOrNo(GREETER)) {
            String systemSystem = InputData.readStringNotEmpty(MESSARE_NAME_SYSTEM,true);
            Star.createInstance(
                    InputData.readDoubleWithMinimum(MESSAGE_MASS_STAR, 0),
                    InputData.readStringNotEmpty(MESSAGE_NAME_STAR, true));

            SolarSystem.createInstance(Star.getInstance(), systemSystem);

            while (InputData.readYesOrNo(MESSARE_NAME_SYSTEM)) {
                SolarSystem.addPlanet(
                        InputData.readDoubleWithMinimum(MESSAGE_MASS_PLANET, 0),
                        InputData.readDouble(""),
                        InputData.readDouble(""),
                        InputData.readStringNotEmpty("", true));

            }


        } else {
            System.exit(0);
        }
    }

    public  static void Menu() {
        int scelta;
        do {
            System.out.println("\nMenu: ");
            System.out.println("1. Aggiungi un pianeta");
            System.out.println("2. Aggiungi una luna");
            System.out.println("3. Rimuovi un pianeta");
            System.out.println("4. Rimuovi una luna");
            System.out.println("5. Mostra il sistema solare");
            System.out.println("6. Esci");

            scelta = InputData.readIntegerBetween("Scegli un'opzione: ", 1, 6);


            switch (scelta) {
                case 1:
                    SolarSystem.addPlanet();
                    break;
                case 2:
                    // ziozozozoozozoozozoozoz
                    break;
                case 3:
                    SolarSystem.removePlanet("");
                    break;
                case 4:
                    Planet.removeMoon();
                    break;
                case 5:
                    SolarSystem.showSolarSystem();
                    break;
                case 6:
                    System.out.println("Uscita in corso...");
                    break;
            }


        } while (scelta != 6);
    }

}
