package br.com.bluebank.domain;

public class UsuarioVO {
		private String nome;
		private String cpf;
		private int agencia;
		private int conta;
		private int dac;
		private boolean logado;
		
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
		public int getDac() {
			return dac;
		}
		public void setDac(int dac) {
			this.dac = dac;
		}
		public boolean isLogado() {
			return logado;
		}
		public void setLogado(boolean logado) {
			this.logado = logado;
		}

}
