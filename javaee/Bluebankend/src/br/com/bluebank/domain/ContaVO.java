package br.com.bluebank.domain;

public class ContaVO {
	private int idConta;
	private int banco;
	private int agencia;
	private int agenciaDac;
	private int conta;
	private int contaDac;
	private boolean logado;
	private double saldo;

	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getConta() {
		return conta;
	}
	public void setConta(int conta) {
		this.conta = conta;
	}
	public int getContaDac() {
		return contaDac;
	}
	public void setContaDac(int dac) {
		this.contaDac = dac;
	}
	public boolean isLogado() {
		return logado;
	}
	public void setLogado(boolean logado) {
		this.logado = logado;
	}
	public int getBanco() {
		return banco;
	}
	public void setBanco(int banco) {
		this.banco = banco;
	}
	public int getAgenciaDac() {
		return agenciaDac;
	}
	public void setAgenciaDac(int agenciaDac) {
		this.agenciaDac = agenciaDac;
	}
	public int getIdConta() {
		return idConta;
	}
	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
}
