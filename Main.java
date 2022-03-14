package br.com.david.exercicio.Main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> historico = new ArrayList<String>();
		int acao = 1;

		while (acao > 0) {
			if (acao == 1) {
				System.out.println("  ==Operação Matematica==  \n");
				System.out.println("Digite o Primeiro número: ");
//			Ocorrimento do Cast abaixo:
//			int numero1 =Integer.parseInt(scan.nextLine());
				int numero1 = 0;
				try {
					numero1 = scan.nextInt();
				} catch (InputMismatchException e) {
					System.out.println(String.format(
							"Ocorreu um erro de formato, [%s]. o primeiro número receberá a atribuição de 1 ",
							e.getMessage()));
					scan.nextLine();
					numero1 = 1;
				} catch (Exception e) {
					System.out.println("Erro desconhecido");
				}
				System.out.println("Digite o Segundo número: ");
				int numero2 = 0;
				try {
					numero2 = scan.nextInt();
				} catch (InputMismatchException e) {
					System.out.println(String.format(
							"Ocorreu um erro de formato, [%s]. o primeiro número receberá a atribuição de 1 ",
							e.getMessage()));
					scan.nextLine();
					numero2 = 1;
				} catch (Exception e) {
					System.out.println("Erro desconhecido");
				}

				System.out.println("Agora digite o Operador: ");
				char operador = scan.next().charAt(0);
				int resultado = 0;
				switch (operador) {
				case '+':
					resultado = numero1 + numero2;
					break;
				case '-':
					resultado = numero1 - numero2;
					break;
				case '*':
					resultado = numero1 * numero2;
					break;
				case '/':
					if (numero1 >= 0 && numero2 > 0) {
						resultado = numero1 / numero2;
						break;
					}
				default:
					System.out.println("Opcão invalida! por favor corrija sua operação e tente novamente.");
				}

				String entradaDoHistorico = String.format("Resultado: \n %d %c %d = %d \n", numero1, operador, numero2,
						resultado);
				historico.add(entradaDoHistorico);
				System.out.println(entradaDoHistorico);

			} else if (acao == 2) {
				System.out.println(" ----Historico---- ");
				System.out.println(String.format("Você ja vez %d operações", historico.size()));
				historico.forEach(intemHistorico -> System.out.println(intemHistorico));
//				for (int index = 0; index < historico.size(); index++) {
//					System.out.println(historico.get(index));
//				}
			}
			System.out.println(" -- O que vocẽ deseja fazer? --");
			System.out.println("1 - Realizar mais um Operação Matematica");
			System.out.println("2 - Visualizar Historico");
			System.out.println("0 - Sair");
			System.out.println("Digite: ");
			acao = scan.nextInt();

		}
		scan.close();

	}

}
