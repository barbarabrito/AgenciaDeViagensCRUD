package br.com.crudagencia.model;

public class Viagens {
	
	private int viagemId;
	private String destino;
	private String dataViagem;
	
	public int getViagemId() {
		return viagemId;
	}
	public void setViagemId(int viagemId) {
		this.viagemId = viagemId;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getDataViagem() {
		return dataViagem;
	}
	public void setDataViagem(String dataViagem) {
		this.dataViagem = dataViagem;
	}
}
