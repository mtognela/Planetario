package it.unibs.fp.Planetario.Utils;

import java.util.ArrayList;

import com.kibo.pgar.lib.*;
import it.unibs.fp.Planetario.Data.Coordinate;
import it.unibs.fp.Planetario.SistemaSolare.CorpoCeleste.Extend.*;
import it.unibs.fp.Planetario.SistemaSolare.SolarSystem;

public class Io {
    public static String GREETER = PrettyStrings.
            prettify("Are you ready to crete your system?", AnsiColors.CYAN, AnsiWeights.BOLD, null);
    public static String MESSARE_NAME_SYSTEM = PrettyStrings.
            prettify("Input the System Name: ", AnsiColors.CYAN, AnsiWeights.BOLD, null);
    public static String MESSAGE_MASS_STAR = PrettyStrings.
            prettify("Input the Star mass: ", AnsiColors.CYAN, AnsiWeights.BOLD, null);
    public static String MESSAGE_NAME_STAR = PrettyStrings.
            prettify("Input the Star Name: ", AnsiColors.CYAN, AnsiWeights.BOLD, null);

    public static void setUpSystem() {
        if (InputData.readYesOrNo(GREETER)) {
            String systemSystem = InputData.readStringNotEmpty(MESSARE_NAME_SYSTEM,true);
            Star.createInstance(
                    InputData.readDoubleWithMinimum(MESSAGE_MASS_STAR, 0),
                    InputData.readStringNotEmpty(MESSAGE_NAME_STAR, true));

            SolarSystem.createInstance(Star.getInstance(), systemSystem);



        } else {
            System.exit(0);
        }
    }

}
