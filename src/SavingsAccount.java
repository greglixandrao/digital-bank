package src;

public class SavingsAccount extends Account{
    private static int SAVINGS_SEQUENTIAL = 1000;

    public SavingsAccount() {
        super.agencyNumber = Account.AGENCY_DEFAULT;
        super.accountNumber = SAVINGS_SEQUENTIAL++;
    }

    @Override
    public void printStatement() {
        System.out.println("========================");
        System.out.println("Informações da Conta Poupança:");
        System.out.printf("Numero da Agência: %d%n", agencyNumber);
        System.out.printf("Numero da Conta: %d%n", accountNumber);
        System.out.printf("Saldo: %.2f%n", balance);
    }
}
