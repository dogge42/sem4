package org.example;

import java.util.Scanner;
import java.util.Stack;

public class StackMenu {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Push element");
            System.out.println("2. Edit element");
            System.out.println("3. Pop element");
            System.out.println("4. Display elements");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter element to push: ");
                    String elementToPush = scanner.nextLine();
                    stack.push(elementToPush);
                    System.out.println("Element pushed.");
                    break;

                case 2:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Current stack:");
                        for (int i = 0; i < stack.size(); i++) {
                            System.out.println(i + ": " + stack.get(i));
                        }
                        System.out.print("Enter index to edit: ");
                        int editIndex = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        if (editIndex >= 0 && editIndex < stack.size()) {
                            System.out.print("Enter new element: ");
                            String newElement = scanner.nextLine();
                            stack.set(editIndex, newElement);
                            System.out.println("Element updated.");
                        } else {
                            System.out.println("Invalid index.");
                        }
                    }
                    break;

                case 3:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Popped element: " + stack.pop());
                    }
                    break;

                case 4:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Elements in stack:");
                        for (int i = 0; i < stack.size(); i++) {
                            System.out.println(i + ": " + stack.get(i));
                        }
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
