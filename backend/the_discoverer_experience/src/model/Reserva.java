package model;

public class Reserva {
	private int idReserva;
	private String dtCheckout;
	private String dtCheckIn;
	private boolean statusReserva;
	
	private Pacotes pacotes;
	private Destinos destinos;
	private Usuario usuario;
	
	public Reserva() {
		
	}
	public Reserva(String dtCheckIn, String dtCheckout, boolean statusReserva, Pacotes pacotes, Destinos destinos,
			Usuario usuario) {
		
		this.dtCheckout = dtCheckout;
		this.dtCheckIn = dtCheckIn;
		this.statusReserva = statusReserva;
		this.pacotes = pacotes;
		this.destinos = destinos;
		this.usuario = usuario;
	}
	public Reserva(int idReserva, String dtCheckout, String dtCheckIn, boolean statusReserva, Pacotes pacotes,
			Destinos destinos, Usuario usuario) {
		
		this.idReserva = idReserva;
		this.dtCheckout = dtCheckout;
		this.dtCheckIn = dtCheckIn;
		this.statusReserva = statusReserva;
		this.pacotes = pacotes;
		this.destinos = destinos;
		this.usuario = usuario;
	}
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public String getDtCheckout() {
		return dtCheckout;
	}
	public void setDtCheckout(String dtCheckout) {
		this.dtCheckout = dtCheckout;
	}
	public String getDtCheckIn() {
		return dtCheckIn;
	}
	public void setDtCheckIn(String dtCheckIn) {
		this.dtCheckIn = dtCheckIn;
	}
	public boolean isStatusReserva() {
		return statusReserva;
	}
	public void setStatusReserva(boolean statusReserva) {
		this.statusReserva = statusReserva;
	}
	public Pacotes getPacotes() {
		return pacotes;
	}
	public void setPacotes(Pacotes pacotes) {
		this.pacotes = pacotes;
	}
	public Destinos getDestinos() {
		return destinos;
	}
	public void setDestinos(Destinos destinos) {
		this.destinos = destinos;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", dtCheckout=" + dtCheckout + ", dtCheckIn=" + dtCheckIn
				+ ", statusReserva=" + statusReserva + ", pacotes=" + pacotes + ", destinos=" + destinos + ", usuario="
				+ usuario + "]";
	}
	
	
	
	
	
	
}
