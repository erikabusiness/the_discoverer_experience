package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Usuario;

public class UsuarioDAO {
	
	public void create(Usuario usuario) {

		String sql = "insert into usuario (senha, email, CPF, nome, localização) values (?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, usuario.getSenha());
			pstm.setString(2, usuario.getEmail());
			pstm.setString(3, usuario.getCpf());
			pstm.setString(4, usuario.getNome());
			pstm.setString(5, usuario.getLocalizacao());

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
		public List<Usuario> read() {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			String sql = "select * from usuario";

			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;

			try {

				conn = ConnectionMySQL.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);

				rset = pstm.executeQuery();

				while (rset.next()) {
					Usuario usuario = new Usuario();

					usuario.setIdUsuario(rset.getInt("idUsuario"));
					usuario.setSenha(rset.getString("senha"));
					usuario.setEmail(rset.getString("email"));
					usuario.setCpf(rset.getString("cpf"));
					usuario.setNome(rset.getString("nome"));
					usuario.setLocalizacao(rset.getString("localização"));

					usuarios.add(usuario);
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

			return usuarios;
		}
		
		// update
		public void update(Usuario usuario) {
			String sql = "UPDATE usuario SET senha = ?, email = ?, CPF = ?, nome = ?, localização = ? WHERE idUsuario = ?";

			Connection conn = null;
			PreparedStatement pstm = null;

			try {

				conn = ConnectionMySQL.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setString(1, usuario.getSenha());
				pstm.setString(2, usuario.getEmail());
				pstm.setString(3, usuario.getCpf());
				pstm.setString(4, usuario.getNome());
				pstm.setString(5, usuario.getLocalizacao());
				pstm.setInt(6, usuario.getIdUsuario());

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
			String sql = "DELETE FROM Usuario WHERE idUsuario = ?";

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
		public Usuario readById(int id) {
			Usuario usuario = new Usuario();
			String sql = "select * from usuario WHERE idUsuario = ?";

			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;

			try {
				conn = ConnectionMySQL.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);
				
				pstm.setInt(1, id);
				
				rset = pstm.executeQuery();
				
				rset.next();
				
				usuario.setIdUsuario(rset.getInt("idUsuario"));
				usuario.setSenha(rset.getString("senha"));
				usuario.setEmail(rset.getString("email"));
				usuario.setCpf(rset.getString("cpf"));
				usuario.setNome(rset.getString("nome"));
				usuario.setLocalizacao(rset.getString("localização"));
				

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
			return usuario;
		}

		
}
