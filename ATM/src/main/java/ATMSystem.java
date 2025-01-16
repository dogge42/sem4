import Model.Bank;
import Model.Account;
import View.ATMView;
import Controller.ATMController;

public class ATMSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();
        ATMView view = new ATMView();
        ATMController controller = new ATMController(bank, view);

        // Thêm một vài tài khoản mẫu
        bank.addAccount(new Account("12345", 1000));
        bank.addAccount(new Account("67890", 2000));

        controller.run();
    }
}
