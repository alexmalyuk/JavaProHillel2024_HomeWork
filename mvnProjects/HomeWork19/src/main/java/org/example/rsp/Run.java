package org.example.rsp;

import org.example.rsp.dto.Choice;
import org.example.rsp.dto.Player;
import org.example.rsp.exceptions.QuitGameException;
import org.example.rsp.services.ChoiceService;
import org.example.rsp.services.GameService;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Run {
    public static ResourceBundle rb;

    public static void main(String[] args) {

        Locale loc = Locale.getDefault();
        if (args.length >= 2) {
            loc = new Locale(args[0], args[1]);
        } else if (args.length >= 1) {
            if ("ru".equalsIgnoreCase(args[0])) {
                throw new RuntimeException("I don`t speak russian. I can, but YA EBAL !");
            }
            loc = new Locale(args[0]);
        }

        rb = ResourceBundle.getBundle("messages", loc);

        System.out.println("-------------------------------------------------------");
        System.out.println("--- " + rb.getString("welcome"));
        System.out.println("-------------------------------------------------------");

        Scanner scanner = new Scanner(System.in);
        System.out.println(rb.getString("enter.your.name"));
        String userName = scanner.nextLine();

        System.out.printf(rb.getString("enter.number.of.games")+"\n", userName);
        int gameCount = scanner.nextInt();

        Player player = new Player(userName);
        GameService gameService = new GameService();
        ChoiceService choiceService = new ChoiceService();

        for (int i = 1; i <= gameCount; i++) {
            System.out.printf(rb.getString("play.of.game")+"\n", i, gameCount);
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
        System.out.printf(rb.getString("play.result") + "\n", playerChoice, computerChoice, gameResult);
        player.addGameResult(gameResult);
    }
}
