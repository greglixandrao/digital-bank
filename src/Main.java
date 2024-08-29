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
            System.out.println("5 - Exibir todas as accounts cadastradas");
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
                    System.out.println("Digite o numero da conta que deseja depositar:");
                    accountNumber = scanner.nextInt();
                    for (Account account1 : accounts) {
                        if (account1.accountNumber == accountNumber) {
                            System.out.println("Digite o valor que gostaria de depositar:");
                            double value = scanner.nextDouble();
                            transaction.deposit(account1, value);
                        } else {
                            System.out.println("Conta não encontrada.\n");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Digite o numero da conta que deseja sacar:");
                    accountNumber = scanner.nextInt();
                    for (Account account1 : accounts) {
                        if (account1.accountNumber == accountNumber) {
                            System.out.println("Digite o valor que gostaria de sacar:");
                            double value = scanner.nextDouble();
                            transaction.withdraw(account1, value);
                        } else {
                            System.out.println("Conta não encontrada.");
                        }
                    }
                    break;
                case 4:
                    break;
                case 5:
                    if (accounts.isEmpty()) {
                        System.out.println("Nenhuma conta cadastrada.\n");
                    } else {
                        System.out.println("Exibindo todas as accounts cadastradas:");
                        for (Account account2 : accounts) {
                            account2.printStatement();
                        }
                    }
                    break;
                case 6:
                    System.out.println("Digite o numero da conta que deseja exibir informações:");
                    accountNumber = scanner.nextInt();
                    for (Account account1 : accounts) {
                        if (account1.accountNumber == accountNumber) {
                            account1.printStatement();
                        } else {
                            System.out.println("Conta não encontrada.");
                        }
                    }
                    break;
            }
        } while (!sair);

        /*Client client01 = new Client();
        client01.setName("John Doe");
        Client client02 = new Client();
        client01.setName("Greg Lee");

        Account account01 = new CurrentAccount(client01);
        account01.deposit(100);
        Account account02 = new SavingsAccount(client01);
        Account account03 = new CurrentAccount(client02);

        account01.printStatement();
        account02.printStatement();
        account03.printStatement();
        System.out.println("-------------------------------------------------");
        System.out.println("-------------------------------------------------");

        account01.transfer(100, account02);
        account01.printStatement();
        account02.printStatement();*/
        scanner.close();
    }
}
