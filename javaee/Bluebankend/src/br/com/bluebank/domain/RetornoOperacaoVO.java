package br.com.bluebank.domain;

public class RetornoOperacaoVO {
		private String mensagem;
		private boolean sucesso;
		
		public RetornoOperacaoVO(){
		
		}
		
		public String getMensagem(){
			
			return mensagem;
		}
		
		public void setMensagem(String msg){
			this.mensagem  = msg;
		}

		public boolean isSucesso() {
			return sucesso;
		}

		public void setSucesso(boolean sucesso) {
			this.sucesso = sucesso;
		}


}
