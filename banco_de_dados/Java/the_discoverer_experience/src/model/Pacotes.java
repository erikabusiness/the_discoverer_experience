package model;

public class Pacotes {
	private int idPacote;
	private double descPacote;
	private double valorPacote;
	
	
	
	public Pacotes() {

	}

	public Pacotes(double descPacote, double valorPacote) {
		
		this.descPacote = descPacote;
		this.valorPacote = valorPacote;
	}

	public Pacotes(int idPacote, double descPacote, double valorPacote) {
		
		this.idPacote = idPacote;
		this.descPacote = descPacote;
		this.valorPacote = valorPacote;
	}
	
	public int getIdPacote() {
		return idPacote;
	}
	public void setIdPacote(int idPacote) {
		this.idPacote = idPacote;
	}
	public double getDescPacote() {
		return descPacote;
	}
	public void setDescPacote(double descPacote) {
		this.descPacote = descPacote;
	}
	public double getValorPacote() {
		return valorPacote;
	}
	public void setValorPacote(double valorPacote) {
		this.valorPacote = valorPacote;
	}

	@Override
	public String toString() {
		return "Pacotes [idPacote=" + idPacote + ", descPacote=" + descPacote + ", valorPacote=" + valorPacote + "]";
	}
	
	
	
}
