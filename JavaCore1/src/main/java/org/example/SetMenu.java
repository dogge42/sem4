package org.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;

public class SetMenu {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Set Menu ---");
            System.out.println("1. Add Element");
            System.out.println("2. Edit Element");
            System.out.println("3. Delete Element");
            System.out.println("4. Display Set");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addElement(set, scanner);
                    break;
                case 2:
                    editElement(set, scanner);
                    break;
                case 3:
                    deleteElement(set, scanner);
                    break;
                case 4:
                    displaySet(set);
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

    private static void addElement(HashSet<String> set, Scanner scanner) {
        System.out.print("Enter element to add: ");
        String element = scanner.nextLine();
        if (set.add(element)) {
            System.out.println("Element added.");
        } else {
            System.out.println("Element already exists.");
        }
    }

    private static void editElement(HashSet<String> set, Scanner scanner) {
        System.out.print("Enter element to edit: ");
        String oldElement = scanner.nextLine();
        if (set.contains(oldElement)) {
            System.out.print("Enter new element: ");
            String newElement = scanner.nextLine();
            set.remove(oldElement);
            set.add(newElement);
            System.out.println("Element edited.");
        } else {
            System.out.println("Element not found.");
        }
    }

    private static void deleteElement(HashSet<String> set, Scanner scanner) {
        System.out.print("Enter element to delete: ");
        String element = scanner.nextLine();
        if (set.remove(element)) {
            System.out.println("Element deleted.");
        } else {
            System.out.println("Element not found.");
        }
    }

    private static void displaySet(HashSet<String> set) {
        System.out.println("Set elements: " + set);
    }
}
