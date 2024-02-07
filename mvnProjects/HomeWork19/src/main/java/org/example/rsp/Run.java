package org.example.rsp;

import org.example.rsp.dto.Choice;
import org.example.rsp.dto.Player;
import org.example.rsp.exceptions.QuitGameException;
import org.example.rsp.services.ChoiceService;
import org.example.rsp.services.GameService;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------");
        System.out.println("--- Welcome to the Rock-Scissors-Paper game ---");
        System.out.println("-----------------------------------------------");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String userName = scanner.nextLine();

        System.out.print(userName + ", please enter number of games: ");
        int gameCount = scanner.nextInt();

        Player player = new Player(userName);
        GameService gameService = new GameService();
        ChoiceService choiceService = new ChoiceService();

        for (int i = 1; i <= gameCount; i++) {
            System.out.println("Game " + i + " from " + gameCount);
            try {
                play(player, gameService, choiceService, scanner);
            } catch (QuitGameException e) {
                break;
            }
        }
        System.out.println("\n" + player.getPlayerResult());
    }

    private static void play(Player player, GameService gs, ChoiceService chs, Scanner scanner) {
        Choice playerChoice = chs.getUserChoice(scanner);
        Choice computerChoice = chs.getRandomChoice();
        var gameResult = gs.takeResult(playerChoice, computerChoice);
        System.out.println("You: " + playerChoice + " vs Computer: " + computerChoice + " = " + gameResult);
        player.addGameResult(gameResult);
    }
}
