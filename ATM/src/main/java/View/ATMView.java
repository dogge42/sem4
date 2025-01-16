package View;

import java.util.Scanner;

public class ATMView {
    private Scanner scanner = new Scanner(System.in);

    public void printMenu() {
        System.out.println("1. Rút tiền");
        System.out.println("2. Gửi tiền");
        System.out.println("3. Chuyển tiền");
        System.out.println("4. Kiểm tra số dư");
        System.out.println("5. Thoát");
    }

    public String getAccountNumber() {
        System.out.print("Nhập số tài khoản: ");
        return scanner.nextLine();
    }

    public double getAmount() {
        System.out.print("Nhập số tiền: ");
        return Double.parseDouble(scanner.nextLine());
    }

    public void showBalance(double balance) {
        System.out.println("Số dư hiện tại: " + balance);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showError(String errorMessage) {
        System.out.println("Lỗi: " + errorMessage);
    }
}
