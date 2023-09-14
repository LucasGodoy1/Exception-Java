package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidade.Reserva;
import modelo.exception.DomainException;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Numero do quarto: ");
			int quarto = sc.nextInt();
			System.out.println("Entre com a Data de check-in dd/MM/yyyy");
			Date checkin = sdf.parse(sc.next());
			System.out.println("Entre com a Data de check-out dd/MM/yyyy");
			Date checkout = sdf.parse(sc.next());
			
			
			Reserva reserva = new Reserva(quarto, checkin, checkout);
			System.out.println(reserva);
			
			System.out.println();
			System.out.println("Entre com uma data para atualziar a reserva");
			System.out.println("Data de check-in dd/MM/yyyy");
			checkin = sdf.parse(sc.next());
			System.out.println("Data de check-out dd/MM/yyyy");
			checkout = sdf.parse(sc.next());
			
			System.out.println("---------------------");
			reserva.atualizacaoData(checkin, checkout);
			
			System.out.println(reserva);
			
			}catch(ParseException e) {
				System.out.println("Formato de Data INVALIDO!");
			}catch(DomainException e) {
				System.out.println("ERRO AO RESERVAR! " + e.getMessage());
			}catch(RuntimeException e) {
				System.out.println("ERRO INESPERADO!");
			}

		sc.close();

	}

}
