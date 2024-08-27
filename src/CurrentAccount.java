package src;

public class CurrentAccount extends Account {
    private static int CURRENT_SEQUENTIAL = 1;

    public CurrentAccount() {
        super.agencyNumber = Account.AGENCY_DEFAULT;
        super.accountNumber = CURRENT_SEQUENTIAL++;
    }

    @Override
    public void printStatement() {
        System.out.println("========================");
        System.out.println("Informações da Conta Corrente:");
        printAccountInformation();
    }


}
