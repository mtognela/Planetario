package org.Arch.IsTheBest.Planetarium.Utils.Io;

import com.kibo.pgar.lib.*;
import org.Arch.IsTheBest.Planetarium.System.CorpoCeleste.Extend.Planet;

import static org.Arch.IsTheBest.Planetarium.Utils.Io.ArtTacTac.*;

public abstract class IoRoute {
        public static void showMenu() {
        Menu menu = new Menu(MENU_ROUTE_TITLE, MENU_ROUTE_OPTIONS, true, true, true);

        int choice;

        do {
            choice = menu.choose();

            switch (choice) {
                case 1:
                    BornOut.fromTo();
                    break;
                case 2:
                    BornOut.BuildPathFromTo();
                    break;
            }
        } while (choice != 0);
    }
}
