package org.example;

import java.util.Scanner;
import java.util.Vector;

public class VectorMenu {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add element");
            System.out.println("2. Edit element");
            System.out.println("3. Delete element");
            System.out.println("4. Display elements");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter element to add: ");
                    String elementToAdd = scanner.nextLine();
                    vector.add(elementToAdd);
                    System.out.println("Element added.");
                    break;

                case 2:
                    System.out.print("Enter index to edit: ");
                    int editIndex = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    if (editIndex >= 0 && editIndex < vector.size()) {
                        System.out.print("Enter new element: ");
                        String newElement = scanner.nextLine();
                        vector.set(editIndex, newElement);
                        System.out.println("Element updated.");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 3:
                    System.out.print("Enter index to delete: ");
                    int deleteIndex = scanner.nextInt();
                    if (deleteIndex >= 0 && deleteIndex < vector.size()) {
                        vector.remove(deleteIndex);
                        System.out.println("Element deleted.");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 4:
                    System.out.println("Elements in vector:");
                    for (int i = 0; i < vector.size(); i++) {
                        System.out.println(i + ": " + vector.get(i));
                    }
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
}

