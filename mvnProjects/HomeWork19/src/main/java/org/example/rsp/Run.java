package org.example.rsp;

import org.example.rsp.dto.Choice;
import org.example.rsp.dto.GameResult;
import org.example.rsp.dto.Player;
import org.example.rsp.services.ChoiceService;
import org.example.rsp.services.GameService;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------");
        System.out.println("--- Welcome to the Rock-Scissors-Paper game ---");
        System.out.println("-----------------------------------------------");
        System.out.println("Please enter your name:");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();

        System.out.println(userName + ": please enter number of games:");
        int gameCount = scanner.nextInt();
        scanner.nextLine();

        Player player = new Player(userName);
        GameService gameService = new GameService();
        ChoiceService choiceService = new ChoiceService();

        for (int i = 1; i <= gameCount; i++) {
            System.out.println("Game " + i + " from " + gameCount);

            play(player, gameService, choiceService);

            if (i < gameCount) {
                System.out.println("Continue? [Y/N]");
                String nextGame = scanner.nextLine();
                if ("N".equalsIgnoreCase(nextGame)) {
                    break;
                }
            }
        }

        System.out.println("\n" + player.getPlayerResult());
    }

    private static void play(Player player, GameService gs, ChoiceService chs) {
        Choice playerChoice = chs.getRandomChoice();
        Choice computerChoice = chs.getRandomChoice();
        var gameResult = gs.takeResult(playerChoice, computerChoice);
        System.out.println("Player: " + playerChoice + " vs Computer: " + computerChoice + " = " + gameResult);
        player.addGameResult(gameResult);
    }


}
