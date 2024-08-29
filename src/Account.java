package src;

public abstract class Account implements IAccount {
    protected static int AGENCY_DEFAULT = 1;

    protected int agencyNumber;
    protected int accountNumber;
    protected double balance;
    protected Client client;


    public Account(Client client) {
        this.client = client;
    }

    public Account() {
    }

    @Override
    public void withdraw(double value) {
        this.balance -= value;
    }

    @Override
    public void deposit(double value) {
        this.balance += value;
    }

    @Override
    public void transfer(double value, Account destinationAccount) {
        this.withdraw(value);
        destinationAccount.deposit(value);
    }

    public int getAgencyNumber() {
        return agencyNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void printAccountInformation() {
        System.out.printf("Nome do Cliente: %s%n", client.getName());
        System.out.printf("Numero da Agência: %d%n", agencyNumber);
        System.out.printf("Numero da Conta: %d%n", accountNumber);
        System.out.printf("Saldo: %.2f%n", balance);
        System.out.println("======================================================");
    }
}
