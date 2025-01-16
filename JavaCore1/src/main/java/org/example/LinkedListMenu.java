import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListMenu {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Linked List Menu ---");
            System.out.println("1. Add Element");
            System.out.println("2. Edit Element");
            System.out.println("3. Delete Element");
            System.out.println("4. Display List");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addElement(list, scanner);
                    break;
                case 2:
                    editElement(list, scanner);
                    break;
                case 3:
                    deleteElement(list, scanner);
                    break;
                case 4:
                    displayList(list);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addElement(LinkedList<String> list, Scanner scanner) {
        System.out.print("Enter element to add: ");
        String element = scanner.nextLine();
        list.add(element);
        System.out.println("Element added.");
    }

    private static void editElement(LinkedList<String> list, Scanner scanner) {
        System.out.print("Enter index to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (index >= 0 && index < list.size()) {
            System.out.print("Enter new element: ");
            String newElement = scanner.nextLine();
            list.set(index, newElement);
            System.out.println("Element edited.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    private static void deleteElement(LinkedList<String> list, Scanner scanner) {
        System.out.print("Enter index to delete: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < list.size()) {
            list.remove(index);
            System.out.println("Element deleted.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    private static void displayList(LinkedList<String> list) {
        System.out.println("List elements: " + list);
    }
}
