package org.Arch.IsTheBest.Planetarium.Utils.Io;

import com.kibo.pgar.lib.AnsiColors;
import com.kibo.pgar.lib.AnsiWeights;
import com.kibo.pgar.lib.PrettyStrings;

public abstract class ArtTacTac {
    public static final String YES_OR_NO = "Is it okay?";
    public static final String GREETER = PrettyStrings.prettify(
            "Are you ready to create your system?", AnsiColors.CYAN, AnsiWeights.BOLD, null);
    public static final String MESSAGE_NAME_SYSTEM = PrettyStrings.prettify(
            "Input the System Name: ", AnsiColors.CYAN, AnsiWeights.BOLD, null);
    public static final String MESSAGE_MASS_STAR = PrettyStrings.prettify(
            "Input the Star mass: ", AnsiColors.CYAN, AnsiWeights.BOLD, null);
    public static final String MESSAGE_NAME_STAR = PrettyStrings.prettify(
            "Input the Star Name: ", AnsiColors.CYAN, AnsiWeights.BOLD, null);
    //------------------------------------------------------------------------------------------------------------
    public static final String MENU_MAIN_TITLE = PrettyStrings.
            prettify("System Menu", AnsiColors.CYAN, null, null);
    // -----------------------------------------------------------------------------------------------------------
    public static final String MENU_MAIN_1 = PrettyStrings.
            prettify("Add a Planet", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String MENU_MAIN_2 = PrettyStrings.
            prettify("Add a Moon", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String MENU_MAIN_3 = PrettyStrings.
            prettify("Remove a Planet", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String MENU_MAIN_4 = PrettyStrings.
            prettify("Remove a Moon", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String MENU_MAIN_5 = PrettyStrings.
            prettify("Show the System", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String MENU_MAIN_6 = PrettyStrings.
            prettify("Calc cmd", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String MENU_MAIN_7 = PrettyStrings.
            prettify("Calc route", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    // -----------------------------------------------------------------------------------------------------------
    public static final String[] MENU_MAIN_OPTIONS = {MENU_MAIN_1, MENU_MAIN_2, MENU_MAIN_3, MENU_MAIN_4, MENU_MAIN_5, MENU_MAIN_6, MENU_MAIN_7};
    // -----------------------------------------------------------------------------------------------------------
    public static final String MENU_ROUTE_TITLE = PrettyStrings.prettify("Route Menu",AnsiColors.BLUE, AnsiWeights.BOLD, null);
    // -----------------------------------------------------------------------------------------------------------
    public static final String MENU_ROUTE_1 = PrettyStrings.
            prettify("Calc distance", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String MENU_ROUTE_2 = PrettyStrings.
            prettify("Build path", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    // -----------------------------------------------------------------------------------------------------------
    public static final String[] MENU_ROUTE_OPTIONS = {MENU_ROUTE_1, MENU_ROUTE_2};
    // -----------------------------------------------------------------------------------------------------------
    public static final String ADD_PLANET_GREETER = PrettyStrings.
            prettify("Ready to add a Planet...", AnsiColors.CYAN, AnsiWeights.BOLD, null);
    public static final String GOODBYE = PrettyStrings.
            prettify("Goodbye!", AnsiColors.CYAN, AnsiWeights.BOLD, null);
    // -----------------------------------------------------------------------------------------------------------
    public static final String PLANET_ADD = PrettyStrings.
            prettify("Adding a planet...", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String PLANET_NAME = PrettyStrings.
            prettify("Planet Name: ", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String PLANET_MASS = PrettyStrings.
            prettify("Planet Mass: ", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String DISTANCE_SUN_RADIUS = PrettyStrings.
            prettify("Distance from sun (radius): ", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String THETA_IN_RADIUS = PrettyStrings.
            prettify("Theta angle (in degrees): ", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String ADD_PLANET_PRINT = PrettyStrings.
            prettify("Planet %s added successfully!\n", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String MOON_ADD = PrettyStrings.
            prettify("Adding a moon...", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String ERROR_INIT_PANET_FIRST = PrettyStrings.
            prettify("Initialize a planet first", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String ID_PLANET = PrettyStrings.
            prettify("Planet ID: ", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String ID_MOON = PrettyStrings.
            prettify("Moon ID: ", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String PLANET_REMOVE_SUCESS = PrettyStrings.
            prettify("Planet removed successfully.", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String MOON_NAME = PrettyStrings.
            prettify("Moon Name: ", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String MOON_SEARCH = PrettyStrings.
            prettify("Searching for a moon", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String MOON_MASS = PrettyStrings.
            prettify("Moon Mass: ", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String DISTANCE_FROM_PLANET = PrettyStrings.
            prettify("Distance from planet (radius): ", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String ERRORE_INIT_SYSTEM_FIRST = PrettyStrings.
            prettify("Initialize the system first.", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String ERROR_MOON_NOT_FOUND = PrettyStrings.
            prettify("Error: Moon not found.", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String ERROR_PLANET_NOT_FOUND = PrettyStrings.
            prettify("Error: Planet not found.", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String ERROR_PLANET_NOT_OWN_NO_MOON = PrettyStrings.
            prettify("The Planet has no moons.", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String CMD = PrettyStrings.
            prettify("cmd %s\n", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String DO_YOU_WANT_TO_SEARCH_AGAIN = "Do you want to search again?";
    public static final String NO_PLANET_FOUND = "No planet found";
}
