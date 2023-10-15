package model;

public class Destinos {
	private int idDestino;
	private String nomeDestino;
	private int avaliacao;
	
	
	public Destinos() {
		
	}
	
	public Destinos(int idDestino, String nomeDestino, int avaliacao) {
		this.idDestino = idDestino;
		this.nomeDestino = nomeDestino;
		this.avaliacao = avaliacao;
	}

	public Destinos(String nomeDestino, int avaliacao) {
		this.nomeDestino = nomeDestino;
		this.avaliacao = avaliacao;
	}
	
	public int getIdDestino() {
		return idDestino;
	}
	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}
	public String getNomeDestino() {
		return nomeDestino;
	}
	public void setNomeDestino(String nomeDestino) {
		this.nomeDestino = nomeDestino;
	}
	public int getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	@Override
	public String toString() {
		return "Destinos [idDestino=" + idDestino + ", nomeDestino=" + nomeDestino + ", avaliacao=" + avaliacao + "]";
	}
	
	
}
