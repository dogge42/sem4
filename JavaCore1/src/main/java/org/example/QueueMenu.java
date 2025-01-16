package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueMenu {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Queue Menu ---");
            System.out.println("1. Add Element");
            System.out.println("2. Edit Element");
            System.out.println("3. Delete Element");
            System.out.println("4. Display Queue");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addElement(queue, scanner);
                    break;
                case 2:
                    editElement(queue, scanner);
                    break;
                case 3:
                    deleteElement(queue, scanner);
                    break;
                case 4:
                    displayQueue(queue);
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

    private static void addElement(Queue<String> queue, Scanner scanner) {
        System.out.print("Enter element to add: ");
        String element = scanner.nextLine();
        queue.add(element);
        System.out.println("Element added.");
    }

    private static void editElement(Queue<String> queue, Scanner scanner) {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty. Cannot edit.");
            return;
        }

        System.out.print("Enter index to edit (starting from 0): ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index < 0 || index >= queue.size()) {
            System.out.println("Invalid index.");
            return;
        }

        // Convert queue to list for easier index access
        LinkedList<String> tempList = new LinkedList<>(queue);
        System.out.print("Enter new value: ");
        String newValue = scanner.nextLine();
        tempList.set(index, newValue);

        // Clear the queue and re-add elements from modified list
        queue.clear();
        queue.addAll(tempList);
        System.out.println("Element edited.");
    }

    private static void deleteElement(Queue<String> queue, Scanner scanner) {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty. Cannot delete.");
            return;
        }

        System.out.print("Enter element to delete: ");
        String element = scanner.nextLine();

        if (queue.contains(element)) {
            queue.remove(element);
            System.out.println("Element deleted.");
        } else {
            System.out.println("Element not found in queue.");
        }
    }

    private static void displayQueue(Queue<String> queue) {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Queue elements: " + queue);
        }
    }
}

