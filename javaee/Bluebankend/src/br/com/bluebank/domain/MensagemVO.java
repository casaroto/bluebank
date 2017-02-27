package br.com.bluebank.domain;

public class MensagemVO {
	
		
		private String mensagem;
		
		public MensagemVO(){
			this.mensagem = "Aproveite nossa nova linha de crédito.";
		}
		
		public String getMensagem(){
			
			return mensagem;
		}
		
		public void setMensagem(String msg){
			this.mensagem  = msg;
		}


}
