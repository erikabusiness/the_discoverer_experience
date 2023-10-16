package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Destinos;
import model.Pacotes;
import model.Reserva;
import model.Usuario;

public class ReservaDAO {

	public void create(Reserva reserva) {

		String sql = "insert into Reserva (idPacote, idDestino, idUsuario, dtCheckout, statusReserva, dtCheckIn) values (?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, reserva.getPacotes().getIdPacote());
			pstm.setInt(2, reserva.getDestinos().getIdDestino());
			pstm.setInt(3, reserva.getUsuario().getIdUsuario());
			pstm.setString(4,reserva.getDtCheckout());
			pstm.setBoolean(5, reserva.isStatusReserva());
			pstm.setString(6,reserva.getDtCheckIn());
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// read
	public List<Reserva> read() {
		List<Reserva> reservas = new ArrayList<Reserva>();
		String sql = "select * from reserva_destino order by idReserva";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Reserva reserva = new Reserva();
				Destinos destino = new Destinos();
				Pacotes pacote = new Pacotes();
				Usuario usuario = new Usuario();

				reserva.setIdReserva(rset.getInt("idReserva"));
				reserva.setDtCheckout(rset.getString("dtCheckout"));
				reserva.setStatusReserva(rset.getBoolean("statusReserva"));
				reserva.setDtCheckIn(rset.getString("dtCheckIn"));

				destino.setIdDestino(rset.getInt("idDestino"));
				destino.setNomeDestino(rset.getString("nomeDestino"));
				destino.setAvaliacao(rset.getInt("avaliacao"));

				pacote.setIdPacote(rset.getInt("idPacote"));
				pacote.setDescPacote(rset.getDouble("descPacote"));
				pacote.setValorPacote(rset.getDouble("valorPacote"));

				usuario.setIdUsuario(rset.getInt("idUsuario"));
				usuario.setSenha(rset.getString("senha"));
				usuario.setEmail(rset.getString("email"));
				usuario.setCpf(rset.getString("cpf"));
				usuario.setNome(rset.getString("nome"));
				usuario.setLocalizacao(rset.getString("localização"));

				reserva.setDestinos(destino);
				reserva.setPacotes(pacote);
				reserva.setUsuario(usuario);

				reservas.add(reserva);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return reservas;
	}

	// update
	public void update(Reserva reserva) {
		String sql = "UPDATE Reserva SET idPacote = ?, idDestino = ?, idUsuario = ?, dtCheckout = ?, statusReserva = ?, dtCheckIn = ? WHERE idReserva = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, reserva.getPacotes().getIdPacote());
			pstm.setInt(2, reserva.getDestinos().getIdDestino());
			pstm.setInt(3, reserva.getUsuario().getIdUsuario());
			pstm.setString(4,reserva.getDtCheckout());
			pstm.setBoolean(5, reserva.isStatusReserva());
			pstm.setString(6,reserva.getDtCheckIn());
			pstm.setInt(7, reserva.getIdReserva());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// delete
	public void delete(int id) {
		String sql = "DELETE FROM Reserva WHERE idReserva = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// readById
	public Reserva readById(int id) {
		Reserva reserva = new Reserva();
		String sql = "select * from reserva_destino WHERE idReserva = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			
			Destinos destino = new Destinos();
			Pacotes pacote = new Pacotes();
			Usuario usuario = new Usuario();

			reserva.setIdReserva(rset.getInt("idReserva"));
			reserva.setDtCheckout(rset.getString("dtCheckout"));
			reserva.setStatusReserva(rset.getBoolean("statusReserva"));
			reserva.setDtCheckIn(rset.getString("dtCheckIn"));

			destino.setIdDestino(rset.getInt("idDestino"));
			destino.setNomeDestino(rset.getString("nomeDestino"));
			destino.setAvaliacao(rset.getInt("avaliacao"));

			pacote.setIdPacote(rset.getInt("idPacote"));
			pacote.setDescPacote(rset.getDouble("descPacote"));
			pacote.setValorPacote(rset.getDouble("valorPacote"));

			usuario.setIdUsuario(rset.getInt("idUsuario"));
			usuario.setSenha(rset.getString("senha"));
			usuario.setEmail(rset.getString("email"));
			usuario.setCpf(rset.getString("cpf"));
			usuario.setNome(rset.getString("nome"));
			usuario.setLocalizacao(rset.getString("localização"));

			reserva.setDestinos(destino);
			reserva.setPacotes(pacote);
			reserva.setUsuario(usuario);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return reserva;
	}

}
