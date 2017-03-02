package br.com.bluebank.domain;

public class CorrentistaVO {
		private int idCorrentista;
		private String nome;
		private String cpf;
		private int banco;
		private int agencia;
		private int agenciaDac;
		private int conta;
		private int contaDac;
		private boolean logado;
		
		public int getIdCorrentista() {
			return idCorrentista;
		}
		public void setIdCorrentista(int idCorrentista) {
			this.idCorrentista = idCorrentista;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
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
		
}
