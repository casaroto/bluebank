package br.com.bluebank.domain;

public class TransferenciaVO {
		private int idCorrentistaOrigem;
		private int idCorrentistaDestino;
		private double valor;
		
		public int getIdCorrentistaOrigem() {
			return idCorrentistaOrigem;
		}
		public void setIdCorrentistaOrigem(int idCorrentistaOrigem) {
			this.idCorrentistaOrigem = idCorrentistaOrigem;
		}
		public int getIdCorrentistaDestino() {
			return idCorrentistaDestino;
		}
		public void setIdCorrentistaDestino(int idCorrentistaDestino) {
			this.idCorrentistaDestino = idCorrentistaDestino;
		}
		public double getValor() {
			return valor;
		}
		public void setValor(double valor) {
			this.valor = valor;
		}
}
