package App;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import Modelo.entidade.Conta;
import Modelo.exception.ValorException;

public class Bank {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		try {
			
			System.out.println("Numero Da Conta: ");
			int numero =sc.nextInt();
			System.out.println("Nome: ");
			String nome = sc.next();
			
			Conta c1 = new Conta(numero, nome);
			
			System.out.println("Valor para deposito: ");
			Double valor = sc.nextDouble();
			c1.addSaldo(valor);
			System.out.println(c1);
			System.out.println("Valor para saque: ");
			double saque = sc.nextDouble();
			c1.saque(saque);
			System.out.println(c1);
		}catch (ValorException e) {
			System.out.println("ERRO! " + e.getMessage());
		}catch (InputMismatchException e) {
			System.out.println("ERRO! Digite Apenas Numeros: ");
		}catch (RuntimeException e) {
			System.out.println("ERRO DESCONHECIDO!");
		}

	sc.close();
	}

}
