package com.danielnatan.conversor.view;

import com.danielnatan.conversor.api.ExchangeRateService;
import com.danielnatan.conversor.model.Conversion;
import com.danielnatan.conversor.service.HistoricoService;
import com.danielnatan.conversor.util.DateUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner = new Scanner(System.in);
    private final HistoricoService historicoService = new HistoricoService();
 
    private final String[][] opcoes = {
            {"USD", "BRL"},
            {"BRL", "USD"},
            {"EUR", "BRL"},
            {"BRL", "EUR"},
            {"USD", "EUR"},
            {"EUR", "USD"},
            {"GBP", "BRL"},
            {"BRL", "GBP"},
            {"USD", "ARS"},
            {"ARS", "USD"},
            {"CAD", "JPY"},
            {"JPY", "CAD"},
    };

    public void iniciar() {
        while (true) {
            System.out.println("\n=== Conversor de Moedas ===");
            System.out.println("1. USD -> BRL");
            System.out.println("2. BRL -> USD");
            System.out.println("3. EUR -> BRL");
            System.out.println("4. BRL -> EUR");
            System.out.println("5. USD -> EUR");
            System.out.println("6. EUR -> USD");
            System.out.println("7. GBP -> BRL");
            System.out.println("8. BRL -> GBP");
            System.out.println("9. USD -> ARS");
            System.out.println("10. ARS -> USD");
            System.out.println("11. CAD -> JPY");
            System.out.println("12. JPY -> CAD");
            System.out.println("13. Ver histórico de conversões");
            System.out.println("14. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao;
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.nextLine();
                continue;
            }

            if (opcao == 14) {
                System.out.println("Encerrando o programa. Até logo!");
                break;
            } else if (opcao == 13) {
                historicoService.exibirHistorico();
                continue;
            } else if (opcao < 1 || opcao > 12) {
                System.out.println("Opção inválida.");
                continue;
            }

            String origem = opcoes[opcao - 1][0];
            String destino = opcoes[opcao - 1][1];

            System.out.print("Digite o valor a ser convertido: ");
            double valor;
            try {
                valor = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Digite um número decimal.");
                scanner.nextLine(); 
                continue;
            }

            double taxa = ExchangeRateService.obterTaxa(origem, destino);
            if (taxa == -1) {
                System.out.println("Não foi possível obter a taxa de câmbio.");
                continue;
            }

            double convertido = valor * taxa;
            System.out.printf("Valor convertido: %.2f %s%n", convertido, destino);

            Conversion conversao = new Conversion(origem, destino, valor, convertido, taxa, DateUtil.dataAtual());
            historicoService.adicionarConversao(conversao);

            scanner.nextLine(); 
        }

        scanner.close(); 
    }
}