import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // ANSI escape codes to clear the screen and move cursor to top-left
    System.out.print("\033[H\033[2J");
    System.out.flush(); // Ensure the output is sent immediately
    // Code that swaps the welcome message making animation effect
    boolean swap = true;
    while (true) {
      // Display the welcome message and prices
      if (swap) {
        // ANSI escape codes to clear the screen and move cursor to top-left
        System.out.print("\033[H\033[2J");
        System.out.flush();
        swap = false;
        System.out.println("--------------------------------");
        System.out.println("\\                               \\");
        System.out.println("| Welcome to PuddyTat Pastries  |");
        System.out.println("\\ We swear the food isn't puddy \\");
        System.out.println("|                               |");
        System.out.println("\\         ~ Prices ~            \\");
        System.out.println("|Purrfect Puff Pasteries:  $1.00|");
        System.out.println("\\Chorley Cat Cakes         $0.45\\");
        System.out.println("|Tweety's Tasty Turnovers  $0.75|");
        System.out.println("\\                               \\");
        System.out.println("|                               |");
        System.out.println("--------------------------------");
      } else {
        // ANSI escape codes to clear the screen and move cursor to top-left
        System.out.print("\033[H\033[2J");
        System.out.flush();
        swap = true;

        // Display the welcome message and prices
        System.out.println("--------------------------------");
        System.out.println("|                               |");
        System.out.println("\\ Welcome to PuddyTat Pastries  \\");
        System.out.println("| We swear the food isn't puddy |");
        System.out.println("\\                               \\");
        System.out.println("|         ~ Prices ~            |");
        System.out.println("\\Purrfect Puff Pasteries:  $1.00\\");
        System.out.println("|Chorley Cat Cakes         $0.45|");
        System.out.println("\\Tweety's Tasty Turnovers  $0.75\\");
        System.out.println("|                               |");
        System.out.println("\\                               \\");
        System.out.println("--------------------------------");
      }
      // stops when enter is pressed without scanner
      try {
        if (System.in.available() > 0) {
          scanner.nextLine(); // Consume the newline character
          break; // Exit the loop if there's inpu
        }
        Thread.sleep(500); // Pause for half a second
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    // Prompt for the number of Purrfect Puff Pastries
    System.out.print(
        "How many Purrfect Puff Pastries would you like to order? ");
    int puffPastries = scanner.nextInt();
    // Prompt for the number of Chorley Cat Cakes
    System.out.print("How many Chorley Cat Cakes would you like to order? ");
    int catCakes = scanner.nextInt();
    // Prompt for the number of Tweety's Tasty Turnovers
    System.out.print(
        "How many Tweety's Tasty Turnovers would you like to order? ");
    int turnovers = scanner.nextInt();
    // Calculate the total cost
    double totalCost =
        (puffPastries * 1.00) + (catCakes * 0.45) + (turnovers * 0.75);
    // add 6.5 tax
    totalCost += totalCost * 0.065;

    // Fun Element - if more than 10 items, apply 10% discount
    int totalItems = puffPastries + catCakes + turnovers;
    if (totalItems > 10) {
      totalCost *= 0.90; // Apply 10% discount
      System.out.println(
          "You ordered more than 10 items! A 10% discount has been applied.");
    }
    // Display the total cost

    System.out.printf("Your total cost is $%.2f\n", totalCost);

    scanner.close();
  }
}