package org.Arch.IsTheBest.Planetarium.Utils.Io;

import com.kibo.pgar.lib.*;
import org.Arch.IsTheBest.Planetarium.SistemaSolare.CorpoCeleste.Extend.Star;
import org.Arch.IsTheBest.Planetarium.SistemaSolare.OrbitingSystem;

public abstract class Io {
    public static void setUpSystem() {
        if (InputData.readYesOrNo(PlazUrban.GREETER)) {
            String systemName = InputData.readStringNotEmpty(PlazUrban.MESSAGE_NAME_SYSTEM, false);
            Star.createInstance(
                    InputData.readDoubleWithMinimum(PlazUrban.MESSAGE_MASS_STAR, 0),
                    InputData.readStringNotEmpty(PlazUrban.MESSAGE_NAME_STAR, false)
            );

            OrbitingSystem.createInstance(Star.getInstance(), systemName);

            showMenu();
        } else {
            System.out.println(PlazUrban.GOODBYE);
            System.exit(0);
        }
    }

    private static void showMenu() {
        Menu menu = new Menu(PlazUrban.MENU_TITLE, PlazUrban.MENU_OPTIONS, true, true, true);

        int choice;

        do {
            choice = menu.choose();

            switch (choice) {
                case 1:
                    JustKidding.addPlanet();
                    break;
                case 2:
                    JustKidding.addMoon();
                    break;
                case 3:
                    JustKidding.removePlanet();
                    break;
                case 4:
                    JustKidding.removeMoon();
                    break;
                case 5:
                    OrbitingSystem.showSolarSystem();
                    break;
                case 6:
                    JustKidding.cmd();
                    break;
            }
        } while (choice != 0);
    }
}
