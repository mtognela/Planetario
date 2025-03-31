package org.Arch.IsTheBest.Planetarium.Utils.Io;

import com.kibo.pgar.lib.AnsiColors;
import com.kibo.pgar.lib.AnsiWeights;
import com.kibo.pgar.lib.PrettyStrings;

public abstract class ArtTacTac {
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
    public static final String MENU_ROUTE_TITLE = PrettyStrings.prettify("",AnsiColors.CYAN, AnsiWeights.BOLD, null);
    // -----------------------------------------------------------------------------------------------------------
    public static final String MENU_ROUTE_1 = PrettyStrings.
            prettify("", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String MENU_ROUTE_2 = PrettyStrings.
            prettify("", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String MENU_ROUTE_3 = PrettyStrings.
            prettify("", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String MENU_ROUTE_4 = PrettyStrings.
            prettify("", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String MENU_ROUTE_5 = PrettyStrings.
            prettify("", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String MENU_ROUTE_6 = PrettyStrings.
            prettify("", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    ;
    // -----------------------------------------------------------------------------------------------------------
    public static final String[] MENU_ROUTE_OPTIONS = {MENU_ROUTE_1, MENU_ROUTE_2, MENU_ROUTE_3, MENU_ROUTE_4, MENU_ROUTE_5, MENU_ROUTE_6};
    // -----------------------------------------------------------------------------------------------------------
    public static final String ADD_PLANET_GREETER = PrettyStrings.
            prettify("Ready to add a Planet...", AnsiColors.CYAN, AnsiWeights.BOLD, null);
    public static final String ADD_PLANET_NAME = PrettyStrings.
            prettify("", AnsiColors.CYAN, AnsiWeights.BOLD, null);
    public static final String ADD_PLANET_MASS = PrettyStrings.
            prettify("", AnsiColors.CYAN, AnsiWeights.BOLD, null);
    public static final String ADD_PLANET_RADIUS = PrettyStrings.
            prettify("", AnsiColors.CYAN, AnsiWeights.BOLD, null);
    public static final String ADD = PrettyStrings.
            prettify("", AnsiColors.CYAN, AnsiWeights.BOLD, null);
    public static final String GOODBYE = PrettyStrings.
            prettify("Goodbye!", AnsiColors.CYAN, AnsiWeights.BOLD, null);
    // -----------------------------------------------------------------------------------------------------------
    public static final String AGGIUNTA_DI_UN_PIANETA = PrettyStrings.
            prettify("Aggiunta di un pianeta...", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String NOME_DEL_PIANETA = PrettyStrings.
            prettify("Nome del pianeta: ", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String MASSA_DEL_PIANETA = PrettyStrings.
            prettify("Massa del pianeta: ", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String DISTANZA_DAL_SOLE_RAGGIO = PrettyStrings.
            prettify("Distanza dal sole (raggio): ", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String ANGOLO_THETA_IN_GRADI = PrettyStrings.
            prettify("Angolo theta (in gradi): ", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String ADD_PLANET_PRINT = PrettyStrings.
            prettify("Pianeta %s aggiunto con successo!\n", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String AGGIUNTA_DI_UNA_LUNA = PrettyStrings.
            prettify("Aggiunta di una luna...", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String INIZIALIZZA_PRIMA_PIANETA = PrettyStrings.
            prettify("Inizializza prima un pianeta ", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String ID_PIANETA = PrettyStrings.
            prettify("ID pianeta: ", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String NOME_PIANETA = PrettyStrings.
            prettify("Nome pianeta: ", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String PIANETA_RIMOSSO_CON_SUCCESSO = PrettyStrings.
            prettify("Pianeta rimosso con successo.", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String NOME_DELLA_LUNA = PrettyStrings.
            prettify("Nome della luna: ", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String MASSA_DELLA_LUNA = PrettyStrings.
            prettify("Massa della luna: ", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String DISTANZA_DAL_PIANETA_RAGGIO = PrettyStrings.
            prettify("Distanza dal pianeta (raggio): ", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String RIMOZIONE_DI_UN_PIANETA = PrettyStrings.
            prettify("Rimozione di un pianeta...", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String RIMOZIONE_DI_UNA_LUNA = PrettyStrings.
            prettify("Rimozione di una luna...", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String ID_LUNA = PrettyStrings.
            prettify("ID luna: ", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String NOME_LUNA = PrettyStrings.
            prettify("Nome luna: ", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String LUNA_RIMOSSA_CON_SUCCESSO = PrettyStrings.
            prettify("Luna rimossa con successo.", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String CMD = PrettyStrings.
            prettify("cmd %s\n", AnsiColors.CYAN, AnsiWeights.ITALIC, null);

    // -----------------------------------------------------------------------------------------------------------
    public static final String ERRORE_SISTEMA_NON_INIZIALIZZATO = PrettyStrings.
            prettify("Inizializza il prima sistema.", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String ERRORE_LUNA_NON_TROVATA = PrettyStrings.
            prettify("Errore: Luna non trovata.", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String ERRORE_PIANETA_NON_TROVATO = PrettyStrings.
            prettify("Errore: Pianeta non trovato.", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
    public static final String ERRORE_PIANETA_NON_POSSIDE_LUNE = PrettyStrings.
            prettify("Il Pianeta non possiede lune.", AnsiColors.CYAN, AnsiWeights.ITALIC, null);
}
