import com.github.rvesse.airline.Cli;
import commands.RecommenderCli;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      displayMenu();

      // Prompt user for command choice
      System.out.print("Enter the command (or 'exit' to quit): ");
      String userInput = scanner.nextLine();

      if ("exit".equalsIgnoreCase(userInput.trim())) {
        System.out.println("Exiting program. Goodbye!");
        break;
      }

      // Execute the chosen command
      runCommand(userInput);
    }

    scanner.close();
  }

  private static void runCommand(String command) {
    try {
      Cli<Runnable> cli = new Cli<>(RecommenderCli.class);
      Runnable cmd = cli.parse(command.split("\\s+"));
      cmd.run();
    } catch (Exception e) {
      System.out.println("Invalid command. Please enter a valid command.");
    }
  }

  private static void displayMenu() {
    // Display available commands
    System.out.println("Available commands:");
    System.out.println("1. register");
    System.out.println("2. recommend --userId [userId]");
    System.out.println("3. recommend --userId [userId] --actor [actor name]");
    System.out.println("4. user-interaction view --userId [userId] --movieId [movieId]");
    System.out.println("5. user-interaction bookmark --userId [userId] --movieId [movieId]");
    System.out.println("6. user-interaction rate --userId [userId] --movieId [movieId] --rate [rating]");
  }
}
