package modelo.entidade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import modelo.exception.DomainException;

public class Reserva {
	private Integer numeroQuarto;
	private Date checkin;
	private Date checkout;

	// *o simpledate está estatico, para que não seja instanciado
	// um novo simpledateformate para cada obj Reserva que a minha aplicação tiver
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva(Integer numeroQuarto, Date checkin, Date checkout) {
		if (!checkout.after(checkin)) {
			throw new DomainException(": A data do cehck-out deve ser apos a data Check-in"); 
			}
		this.numeroQuarto = numeroQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public long duracao() {
		long diff = checkout.getTime() - checkin.getTime(); // millisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // converte o valor de milisegs para dias
	}

	public void atualizacaoData(Date checkin, Date checkout){
		Date agora = new Date();
		if (checkin.before(agora) || checkout.before(agora)) {
			throw new DomainException(
					": As datas de atualizacao devem ser futuras"
					);
		} else if (!checkout.after(checkin)) {
			throw new DomainException(
					": A data do cehck-out deve ser apos a data Check-in"
					); 
		} 		
		this.checkin = checkin;
		this.checkout = checkout;
	}

	@Override
	public String toString() {
		return "Numero do quarto: " + numeroQuarto + " checkin: " + sdf.format(checkin) + " checkout: "
				+ sdf.format(checkout) + " " + duracao() + " Noites: ";
	}

}
