package src;

import java.util.List;

public class ValidationAccounts {
    public static boolean possibleToDeposit(double value) {
        if (value <= 0) {
            System.out.println("Valor inválido, digite um valor maior que 0.");
            return false;
        }
        return true;
    }


    public static boolean avaliableValue(double value, Account account) {
        if (value <= 0) {
            System.out.println("Valor inválido, digite um valor maior que 0.");
            return false;
        } else if (value > account.getBalance()) {
            System.out.println("Valor indisponível");
            return false;
        }
        return true;
    }

    public static boolean accountExists(int accountNumber, List<Account> accounts) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return true;
            }
        }
        System.out.println("Conta não encontrada.\n");
        return false;
    }
}
