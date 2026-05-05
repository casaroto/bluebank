export interface Conta {
  idCorrentista: number;
  nome: string;
  cpf?: string;
  banco?: number;
  agencia: number;
  agenciaDac?: number;
  conta: number;
  contaDac: number;
  saldo?: number;
}

export interface TransferenciaResponse {
  mensagem: string;
}
