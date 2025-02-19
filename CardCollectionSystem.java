import java.util.*;

public class CardCollectionSystem {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> cardCollection = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        // Prepopulate cards
        cardCollection.put("Hearts", new ArrayList<>(Arrays.asList("Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King")));
        cardCollection.put("Spades", new ArrayList<>(Arrays.asList("Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King")));
        cardCollection.put("Diamonds", new ArrayList<>(Arrays.asList("Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King")));
        cardCollection.put("Clubs", new ArrayList<>(Arrays.asList("Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King")));

        while (true) {
            System.out.println("\n--- Card Collection System ---");
            System.out.println("1. Search for cards by symbol");
            System.out.println("2. Display all cards");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Search for cards by symbol
                    System.out.print("Enter the card symbol (e.g., Hearts, Spades, Diamonds, Clubs): ");
                    String symbol = scanner.nextLine();
                    if (cardCollection.containsKey(symbol)) {
                        System.out.println("Cards of " + symbol + ": " + cardCollection.get(symbol));
                    } else {
                        System.out.println("Invalid symbol. Please try again.");
                    }
                    break;

                case 2: // Display all cards
                    System.out.println("\n--- All Cards ---");
                    for (Map.Entry<String, ArrayList<String>> entry : cardCollection.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                    break;

                case 3: // Exit
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
