package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        List<Account> accounts = new ArrayList<Account>();
        Client client = new Client();
        Account account;
        int accountNumber;
        Transaction transaction = new Transaction();

        System.out.println("=========== Bem Vindo ao Banco Digital da Claro ===========");
        do {
            System.out.println("=========== Escolha uma das opções abaixo: ===========");
            System.out.println("1 - Abrir Conta Corrente");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir entre Contas");
            System.out.println("5 - Exibir todas as contas cadastradas");
            System.out.println("6 - Exibir dados de uma conta específica");
            System.out.println("0 - Sair");
            System.out.println("======================================================");


            int option = scanner.nextInt();

            switch (option) {
                case 0:
                    System.out.println("===============================================");
                    System.out.println("Obrigado por utilizar o Banco Digital da Claro!");
                    System.out.println("===============================================");
                    sair = true;
                    break;
                case 1:
                    System.out.println("============== Criação de Conta ==============");
                    System.out.println("Digite o nome do cliente:");
                    String name = scanner.next();
                    client.setName(name);
                    account = new CurrentAccount(client);
                    System.out.println("Conta Corrente aberta com sucesso!");
                    System.out.println("Número da conta criada: " + account.getAccountNumber() + "\n");
                    accounts.add(account);
                    break;
                case 2:
                    System.out.println("============== Depósito ==============");
                    System.out.println("Digite o numero da conta que deseja depositar:");
                    accountNumber = scanner.nextInt();
                    ValidationAccounts.accountExists(accountNumber, accounts);
                    for (Account account1 : accounts) {
                        if (account1.accountNumber == accountNumber) {
                            System.out.println("Digite o valor que gostaria de depositar:");
                            double value = scanner.nextDouble();
                            scanner.nextLine();
                            transaction.deposit(account1, value);
                            System.out.println("Depósito realizado com sucesso!\n");
                        }
                    }
                    break;
                case 3:
                    System.out.println("============== Sacar ==============");
                    System.out.println("Digite o numero da conta que deseja sacar:");
                    accountNumber = scanner.nextInt();
                    ValidationAccounts.accountExists(accountNumber, accounts);
                    for (Account account1 : accounts) {
                        if (account1.accountNumber == accountNumber) {
                            System.out.println("Digite o valor que gostaria de sacar:");
                            double value = scanner.nextDouble();
                            ValidationAccounts.avaliableValue(value, account1);
                            transaction.withdraw(account1, value);
                        }
                    }
                    break;
                case 4:
                    System.out.println("============== Transferência ==============");
                    System.out.println("Digite o numero da conta de origem:");
                    int originAccountNumber = scanner.nextInt();
                    ValidationAccounts.accountExists(originAccountNumber, accounts);

                    System.out.println("Digite o numero da conta de destino:");
                    int destinationAccountNumber = scanner.nextInt();
                    ValidationAccounts.accountExists(destinationAccountNumber, accounts);

                    for (Account account1 : accounts) {
                        if (account1.accountNumber == originAccountNumber) {
                            for (Account account2 : accounts) {
                                if (account2.accountNumber == destinationAccountNumber) {
                                    System.out.println("Digite o valor que gostaria de transferir:");
                                    double value = scanner.nextDouble();
                                    ValidationAccounts.avaliableValue(value, account1);
                                    transaction.transfer(account1, account2, value);
                                    System.out.println("Transferência realizada com sucesso!\n");
                                }
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("============== Contas Cadastradas ==============");
                    if (accounts.isEmpty()) {
                        System.out.println("Não há contas cadastradas.\n");
                    } else {
                        System.out.println("Exibindo todas as contas cadastradas:");
                        for (Account account2 : accounts) {
                            account2.printStatement();
                        }
                    }
                    break;
                case 6:
                    System.out.println("============== Exibir Dados de uma Conta ==============");
                    if (accounts.isEmpty()) {
                        System.out.println("Não há contas cadastradas.\n");
                    } else {
                        System.out.println("Digite o numero da conta que deseja exibir informações:");

                        accountNumber = scanner.nextInt();
                        ValidationAccounts.accountExists(accountNumber, accounts);
                        for (Account account1 : accounts) {
                            if (account1.accountNumber == accountNumber) {
                                account1.printStatement();
                            }
                        }
                    }
                    break;
            }
        } while (!sair);

        scanner.close();
    }
}
