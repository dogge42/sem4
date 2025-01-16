package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * Lớp này đóng vai trò "Model" (hoặc Service) quản lý dữ liệu
 * - Thực hiện các nhiệm vụ nghiệp vụ của bài toán
 * - Được gọi bởi "Controller"
 * - Thực hiện các thao tác trực tiếp với CSDL (hoặc dữ liệu)
 * - Sử dụng Collection API để lưu trữ dữ liệu (có thể là từ CSDL trả về)
 */
public class EmployeeService {
    // Lưu toàn bộ Employee trong một ArrayList
    private List<Employee> employeeArrayList = new ArrayList<>();
    // Lưu toàn bộ Employee trong một LinkedList
    private List<Employee> employeeLinkedList = new LinkedList<>();
    // Dùng HashMap để tra cứu nhanh theo ID (Key: employeeId, Value: Employee)
    private Map<Integer, Employee> employeeMap = new HashMap<>();
    // Tạo ID tự tăng (đơn giản nhất)
    private int autoIncrementId = 1;

    // Tạo Employee mới
    public Employee createEmployee(String name, double salary) {
        // Tạo Employee
        Employee emp = new Employee(autoIncrementId, name, salary);
        autoIncrementId++;

        // Lưu vào các cấu trúc dữ liệu
        employeeArrayList.add(emp); // Lưu vào ArrayList
        employeeLinkedList.add(emp); // Lưu vào LinkedList
        employeeMap.put(emp.getId(), emp); // Lưu vào Map (tra cứu nhanh)
        return emp;
    }

    // Lấy danh sách tất cả nhân viên từ ArrayList
    public List<Employee> getAllEmployeesFromArrayList() {
        return employeeArrayList;
    }

    // Lấy danh sách tất cả nhân viên từ LinkedList
    public List<Employee> getAllEmployeesFromLinkedList() {
        return employeeLinkedList;
    }

    // Tìm Employee theo ID (tra cứu nhanh bằng Map)
    public Employee getEmployeeById(int id) {
        return employeeMap.get(id);
    }

    // Cập nhật thông tin Employee theo ID
    public boolean updateEmployee(int id, String newName, double newSalary) {
        Employee emp = employeeMap.get(id);
        if (emp == null) {
            return false; // Không tìm thấy nhân viên
        }
        emp.setName(newName);
        emp.setSalary(newSalary);
        return true;
    }

    // Xóa Employee theo ID
    public boolean deleteEmployee(int id) {
        Employee emp = employeeMap.remove(id);
        if (emp == null) {
            return false; // Không tìm thấy nhân viên để xóa
        }

        // Cập nhật đồng thời trên ArrayList và LinkedList
        employeeArrayList.remove(emp);
        employeeLinkedList.remove(emp);
        return true;
    }

    // In ra kích thước của các cấu trúc dữ liệu
    public void printDataStructureSizes() {
        System.out.println("ArrayList size: " + employeeArrayList.size());
        System.out.println("LinkedList size: " + employeeLinkedList.size());
        System.out.println("Map size: " + employeeMap.size());
    }
}
