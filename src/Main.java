package src;

public class Main {
    public static void main(String[] args) {

        Account account01 = new CurrentAccount();
        Account account02 = new SavingsAccount();
        Account account03 = new CurrentAccount();

        account01.printStatement();
        account02.printStatement();
        account03.printStatement();

    }
}
