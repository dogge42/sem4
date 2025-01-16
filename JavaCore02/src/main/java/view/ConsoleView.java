package view;

import controller.EmployeeController;
import model.Employee;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    // Step 1: Initialize controller and scanner
    private EmployeeController controller;
    private Scanner scanner;

    // Constructor to initialize controller and scanner
    public ConsoleView() {
        this.controller = new EmployeeController();
        this.scanner = new Scanner(System.in);
    }

    // Method to display the main menu
    public void showMainMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n===== MENU QUẢN LÝ NHÂN VIÊN (MVC) =====");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Xem ds nhân viên (theo ArrayList)");
            System.out.println("3. Xem ds nhân viên (theo LinkedList)");
            System.out.println("4. Tìm nhân viên theo ID");
            System.out.println("5. Cập nhật nhân viên");
            System.out.println("6. Xoá nhân viên");
            System.out.println("7. Xem kích thước của cấu trúc dữ liệu");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ!");
                continue;
            }

            switch (choice) {
                case 1:
                    createEmployeeView();
                    break;
                case 2:
                    showAllEmployeeArrayList();
                    break;
                case 3:
                    showAllEmployeeLinkedList();
                    break;
                case 4:
                    findEmployeeById();
                    break;
                case 5:
                    updateEmployee();
                    break;
                case 6:
                    deleteEmployee();
                    break;
                case 7:
                    printDataStructureSizes();
                    break;
                case 8:
                    exit = true;
                    System.out.println("Kết thúc chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    // Method to create a new employee
    private void createEmployeeView() {
        System.out.print("Nhập tên nhân viên: ");
        String name = scanner.nextLine();

        System.out.print("Nhập lương: ");
        double salary;
        try {
            salary = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Lương không hợp lệ!");
            return;
        }

        Employee created = controller.createEmployee(name, salary);
        System.out.println("Đã thêm nhân viên: " + created);
    }

    // Method to show all employees stored in ArrayList
    private void showAllEmployeeArrayList() {
        List<Employee> list = controller.getEmployeesFromArrayList();
        if (list.isEmpty()) {
            System.out.println("Chưa có nhân viên nào trong ArrayList");
        } else {
            System.out.println("=== Danh sách nhân viên trong (ArrayList) ===");
            for (Employee emp : list) {
                System.out.println(emp);
            }
        }
    }

    // Method to show all employees stored in LinkedList
    private void showAllEmployeeLinkedList() {
        List<Employee> list = controller.getEmployeesFromLinkedList();
        if (list.isEmpty()) {
            System.out.println("Chưa có nhân viên nào trong LinkedList");
        } else {
            System.out.println("=== Danh sách nhân viên trong (LinkedList) ===");
            for (Employee emp : list) {
                System.out.println(emp);
            }
        }
    }

    // Method to find an employee by ID
    private void findEmployeeById() {
        System.out.print("Nhập ID nhân viên cần tìm: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID không hợp lệ!");
            return;
        }

        Employee emp = controller.getEmployeeById(id);
        if (emp != null) {
            System.out.println("Thông tin nhân viên: " + emp);
        } else {
            System.out.println("Không tìm thấy nhân viên với ID: " + id);
        }
    }

    // Method to update employee details
    private void updateEmployee() {
        System.out.print("Nhập ID nhân viên cần cập nhật: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID không hợp lệ!");
            return;
        }

        System.out.print("Nhập tên mới: ");
        String newName = scanner.nextLine();

        System.out.print("Nhập lương mới: ");
        double newSalary;
        try {
            newSalary = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Lương không hợp lệ!");
            return;
        }

        boolean success = controller.updateEmployee(id, newName, newSalary);
        if (success) {
            System.out.println("Thông tin nhân viên đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy nhân viên với ID: " + id);
        }
    }

    // Method to delete an employee
    private void deleteEmployee() {
        System.out.print("Nhập ID nhân viên cần xoá: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID không hợp lệ!");
            return;
        }

        boolean success = controller.deleteEmployee(id);
        if (success) {
            System.out.println("Nhân viên đã được xoá.");
        } else {
            System.out.println("Không tìm thấy nhân viên với ID: " + id);
        }
    }

    // Method to print sizes of all data structures
    private void printDataStructureSizes() {
        controller.printSizes();
    }
}
