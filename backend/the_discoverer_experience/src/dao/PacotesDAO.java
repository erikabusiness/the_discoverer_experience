package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Pacotes;

public class PacotesDAO {
	public void create(Pacotes pacote) {

		String sql = "insert into Pacotes (descPacote, valorPacote) values (?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setDouble(1, pacote.getDescPacote());
			pstm.setDouble(2, pacote.getValorPacote());
			

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
			public List<Pacotes> read() {
				List<Pacotes> pacotes = new ArrayList<Pacotes>();
				String sql = "select * from Pacotes";

				Connection conn = null;
				PreparedStatement pstm = null;
				ResultSet rset = null;

				try {

					conn = ConnectionMySQL.createConnectionMySQL();

					pstm = conn.prepareStatement(sql);

					rset = pstm.executeQuery();

					while (rset.next()) {
						Pacotes pacote = new Pacotes();

						pacote.setIdPacote(rset.getInt("idPacote"));
						pacote.setDescPacote(rset.getDouble("descPacote"));
						pacote.setValorPacote(rset.getDouble("valorPacote"));

						pacotes.add(pacote);
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

				return pacotes;
			}
			
			
			// update
			public void update(Pacotes pacote) {
				String sql = "UPDATE Pacotes SET descPacote = ?, valorPacote = ? WHERE idPacote = ?";

				Connection conn = null;
				PreparedStatement pstm = null;

				try {

					conn = ConnectionMySQL.createConnectionMySQL();

					pstm = conn.prepareStatement(sql);

					pstm.setDouble(1, pacote.getDescPacote());
					pstm.setDouble(2, pacote.getValorPacote());
					pstm.setInt(3, pacote.getIdPacote());
				

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
				String sql = "DELETE FROM Pacotes WHERE idPacote = ?";

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
			public Pacotes readById(int id) {
				Pacotes pacote = new Pacotes();
				String sql = "select * from Pacotes WHERE idPacote = ?";

				Connection conn = null;
				PreparedStatement pstm = null;
				ResultSet rset = null;

				try {
					conn = ConnectionMySQL.createConnectionMySQL();

					pstm = conn.prepareStatement(sql);
					
					pstm.setInt(1, id);
					
					rset = pstm.executeQuery();
					
					rset.next();
					
					pacote.setIdPacote(rset.getInt("idPacote"));
					pacote.setDescPacote(rset.getDouble("descPacote"));
					pacote.setValorPacote(rset.getDouble("valorPacote"));
					

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
				return pacote;
			}
	
	
}
