package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapMenu {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Map Menu ---");
            System.out.println("1. Add Element");
            System.out.println("2. Edit Element");
            System.out.println("3. Delete Element");
            System.out.println("4. Display Map");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addElement(map, scanner);
                    break;
                case 2:
                    editElement(map, scanner);
                    break;
                case 3:
                    deleteElement(map, scanner);
                    break;
                case 4:
                    displayMap(map);
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

    private static void addElement(Map<String, String> map, Scanner scanner) {
        System.out.print("Enter key: ");
        String key = scanner.nextLine();
        System.out.print("Enter value: ");
        String value = scanner.nextLine();
        map.put(key, value);
        System.out.println("Element added.");
    }

    private static void editElement(Map<String, String> map, Scanner scanner) {
        System.out.print("Enter key to edit: ");
        String key = scanner.nextLine();
        if (map.containsKey(key)) {
            System.out.print("Enter new value: ");
            String newValue = scanner.nextLine();
            map.put(key, newValue);
            System.out.println("Element edited.");
        } else {
            System.out.println("Key not found.");
        }
    }

    private static void deleteElement(Map<String, String> map, Scanner scanner) {
        System.out.print("Enter key to delete: ");
        String key = scanner.nextLine();
        if (map.remove(key) != null) {
            System.out.println("Element deleted.");
        } else {
            System.out.println("Key not found.");
        }
    }

    private static void displayMap(Map<String, String> map) {
        if (map.isEmpty()) {
            System.out.println("Map is empty.");
        } else {
            System.out.println("Map contents:");
            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }
        }
    }
}
