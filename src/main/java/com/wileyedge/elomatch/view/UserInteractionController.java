package com.wileyedge.elomatch.view;

public class View {
    UserIO io;

        public View(UserIO io){this.io = io;}


    public int printMenuAndGetSelection() {
        io.print("   * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        io.print("   * <<Welcome to the Chess Matchmaker>>");
        io.print("   * 1. Display UserDB");
        io.print("   * 2. Display RankDB");
        io.print("   * 3. Add to UserDB");
        io.print("   * 4. Edit a User");
        io.print("   * 5. Remove a User");
        io.print("   * 6. Make Matches");
        io.print("   * 7. Quit");
        io.print("   *");
        io.print("   * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        return io.readInt("Please select a choice by typing a number between 1 and 7", 1, 7);
    }

}
