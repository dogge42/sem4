package Controller;

import Model.Bank;
import Model.Account;
import View.ATMView;

public class ATMController {
    private Bank bank;
    private ATMView view;

    public ATMController(Bank bank, ATMView view) {
        this.bank = bank;
        this.view = view;
    }

    public void run() {
        while (true) {
            view.printMenu();
            int choice = Integer.parseInt(view.getAccountNumber());

            switch (choice) {
                case 1:
                    handleWithdraw();
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    handleTransfer();
                    break;
                case 4:
                    handleBalanceCheck();
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    view.showError("Lựa chọn không hợp lệ.");
            }
        }
    }

    private void handleWithdraw() {
        String accountNumber = view.getAccountNumber();
        if (!bank.accountExists(accountNumber)) {
            view.showError("Tài khoản không tồn tại.");
            return;
        }
        double amount = view.getAmount();
        Account account = bank.getAccount(accountNumber);
        if (account.withdraw(amount)) {
            view.showMessage("Rút tiền thành công.");
        } else {
            view.showError("Số dư không đủ.");
        }
    }

    private void handleDeposit() {
        String accountNumber = view.getAccountNumber();
        if (!bank.accountExists(accountNumber)) {
            view.showError("Tài khoản không tồn tại.");
            return;
        }
        double amount = view.getAmount();
        Account account = bank.getAccount(accountNumber);
        account.deposit(amount);
        view.showMessage("Gửi tiền thành công.");
    }

    private void handleTransfer() {
        String sourceAccountNumber = view.getAccountNumber();
        if (!bank.accountExists(sourceAccountNumber)) {
            view.showError("Tài khoản nguồn không tồn tại.");
            return;
        }

        String targetAccountNumber = view.getAccountNumber();
        if (!bank.accountExists(targetAccountNumber)) {
            view.showError("Tài khoản đích không tồn tại.");
            return;
        }

        double amount = view.getAmount();
        Account sourceAccount = bank.getAccount(sourceAccountNumber);
        Account targetAccount = bank.getAccount(targetAccountNumber);

        sourceAccount.transfer(targetAccount, amount);
        view.showMessage("Chuyển tiền thành công.");
    }

    private void handleBalanceCheck() {
        String accountNumber = view.getAccountNumber();
        if (!bank.accountExists(accountNumber)) {
            view.showError("Tài khoản không tồn tại.");
            return;
        }
        Account account = bank.getAccount(accountNumber);
        view.showBalance(account.getBalance());
    }
}

