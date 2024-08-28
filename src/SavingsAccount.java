package src;

public class SavingsAccount extends Account{
    private static int SAVINGS_SEQUENTIAL = 1000;

    public SavingsAccount(Client client) {
        super(client);
        super.agencyNumber = Account.AGENCY_DEFAULT;
        super.accountNumber = SAVINGS_SEQUENTIAL++;
    }

    @Override
    public void printStatement() {
        System.out.println("========================");
        System.out.println("Informações da Conta Poupança:");
        printAccountInformation();
    }
}
