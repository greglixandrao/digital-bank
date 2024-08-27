package src;

public class Main {
    public static void main(String[] args) {

        Account account01 = new CurrentAccount();
        account01.deposit(100);
        Account account02 = new SavingsAccount();
        Account account03 = new CurrentAccount();

        account01.printStatement();
        account02.printStatement();
        account03.printStatement();
        System.out.println("-------------------------------------------------");
        System.out.println("-------------------------------------------------");

        account01.transfer(100, account02);
        account01.printStatement();
        account02.printStatement();

    }
}
