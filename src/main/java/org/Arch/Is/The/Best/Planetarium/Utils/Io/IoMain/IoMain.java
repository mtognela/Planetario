package org.Arch.Is.The.Best.Planetarium.Utils.Io.IoMain;

import com.kibo.pgar.lib.*;
import org.Arch.Is.The.Best.Planetarium.System.CelestialBody.Extend.Star;
import org.Arch.Is.The.Best.Planetarium.System.OrbitingSystem;
import org.Arch.Is.The.Best.Planetarium.Utils.Io.IoRoute.IoRoute;

import static org.Arch.Is.The.Best.Planetarium.Utils.Io.ArtTacTac.*;

public abstract class IoMain {
    public static void setUpSystem() {
        if (InputData.readYesOrNo(GREETER)) {
            String systemName = InputData.readStringNotEmpty(MESSAGE_NAME_SYSTEM, true);

            String name = InputData.readStringNotEmpty(MESSAGE_NAME_STAR, true);
            double mass  = InputData.readDoubleWithMinimum(MESSAGE_MASS_STAR, 0);

            Star.createInstance(mass, name);

            OrbitingSystem.createInstance(Star.getInstance(), systemName);

            showMenu();
        } else {
            System.out.println(GOODBYE);
            System.exit(0);
        }
    }

    private static void showMenu() {
        Menu menu = new Menu(MENU_MAIN_TITLE, MENU_MAIN_OPTIONS, true);

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
                    JustKidding.showSystem();
                    break;
                case 6:
                    JustKidding.cmd();
                    break;
                case 7:
                    IoRoute.showMenu();
                    break;
            }
        } while (choice != 0);
        System.out.println(GOODBYE);
    }
}
