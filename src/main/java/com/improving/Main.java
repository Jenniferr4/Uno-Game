package com.improving;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.print("How many players? ");
        Scanner scan = new Scanner(System.in);
        int playerAmount = scan.nextInt();
        Game game = new Game(playerAmount);

        game.play();

    }
}
