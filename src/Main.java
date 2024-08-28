package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Bem Vindo ao Banco Digital da Claro =====");
        System.out.println("Escolha uma das opções abaixo:");
        System.out.println("1 - Abrir Conta Corrente");
        System.out.println("2 - Abrir Conta Poupança");
        System.out.println("3 - Depositar em Conta Corrente");
        System.out.println("4 - Depositar em Conta Poupança");


        /*Client client01 = new Client();
        client01.setName("John Doe");

        Account account01 = new CurrentAccount(client01);
        account01.deposit(100);
        Account account02 = new SavingsAccount(client01);
        Account account03 = new CurrentAccount(client01);

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
