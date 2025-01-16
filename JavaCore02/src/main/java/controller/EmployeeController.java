package controller;

import model.Employee;
import model.EmployeeService;

import java.util.List;

public class EmployeeController {
    // Step 2: Initialize the service to interact with the data layer
    private EmployeeService service;

    // Constructor to initialize EmployeeService
    public EmployeeController() {
        this.service = new EmployeeService();
    }

    // Tạo mới 1 Employee
    public Employee createEmployee(String name, double salary) {
        return service.createEmployee(name, salary);
    }

    // Lấy danh sách Employee từ ArrayList
    public List<Employee> getEmployeesFromArrayList() {
        return service.getAllEmployeesFromArrayList();
    }

    // Lấy danh sách Employee từ LinkedList
    public List<Employee> getEmployeesFromLinkedList() {
        return service.getAllEmployeesFromLinkedList();
    }

    // Tìm Employee theo ID
    public Employee getEmployeeById(int id) {
        return service.getEmployeeById(id);
    }

    // Cập nhật thông tin Employee
    public boolean updateEmployee(int id, String newName, double newSalary) {
        return service.updateEmployee(id, newName, newSalary);
    }

    // Xóa Employee theo ID
    public boolean deleteEmployee(int id) {
        return service.deleteEmployee(id);
    }

    // In kích thước các cấu trúc dữ liệu
    public void printSizes() {
        service.printDataStructureSizes();
    }
}
