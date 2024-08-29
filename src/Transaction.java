package src;

public class Transaction {


    public void deposit(Account account, double value) {
        if (value <= 0) {
            System.out.println("Valor inválido, digite um valor maior que 0.");
        } else {
            account.deposit(value);
        }
    }

    public void withdraw(Account account, double value) {
        if (value <= 0) {
            System.out.println("Valor inválido, digite um valor maior que 0.");
        } else if (value > account.getBalance()) {
            System.out.println("Valor indisponível");
        } else {
            account.withdraw(value);
        }
    }

    public void transfer(Account originAccount, Account destinationAccount, double value) {
        if (value <= 0) {
            System.out.println("Valor inválido, digite um valor maior que 0.");
        } else if (value > originAccount.getBalance()) {
            System.out.println("Valor indisponível");
        } else {
            originAccount.transfer(value, destinationAccount);
        }
    }
}
