package org.Arch.IsTheBest.Planetarium;

import org.Arch.IsTheBest.Planetarium.Utils.Io.IoMain.IoMain;

import static org.Arch.IsTheBest.Planetarium.Utils.Io.ArtTacTac.*;

public abstract class Main {
    public static void main(String[] args) {
        System.out.print(STARTING_PLANETARIUM);

        IoMain.setUpSystem();

        System.out.println(LOTLOTSNEWLINES);
    }
}