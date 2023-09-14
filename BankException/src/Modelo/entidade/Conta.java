package Modelo.entidade;

import Modelo.exception.ValorException;

public class Conta {
	
	private int numero;
	private String nome;
	private Double saldo;
	private Double saldoLimite;
	private Double saldoGlobal;
	
	
	
	
	
	
	public Conta(int numero, String nome) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.saldo = 0.0;
		this.saldoLimite = 0.0;
	}

	public void addSaldo(double valor) {
		this.saldo = valor;
		this.saldoLimite = (valor * 30/ 100) + valor;
		this.saldoGlobal = this.saldo + this.saldoLimite;
	}
	public void saque(double saque) {
		if (saque > saldoGlobal ) {
			throw new ValorException("Valor Superior ao Saldo Disponivel");
		}
		this.saldoGlobal -= saque;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public Double getSaldoLimite() {
		return saldoLimite;
	}
	public void setSaldoLimite(Double saldoLimite) {
		this.saldoLimite = saldoLimite;
	}

	@Override
	public String toString() {
		return "Conta numero " 
				+ numero + " nome " 
				+ nome 
				+ "\nsaldo " 
				+ String.format("%.2f", saldo)
				+ " saldoLimite " 
				+ String.format("%.2f",saldoLimite)
				+ "\nSaldo Disponivel " + String.format("%.2f", saldoGlobal);
	}

	
	
	
	
	

}
