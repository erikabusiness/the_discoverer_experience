package model;

public class Usuario {
	private int idUsuario;
	private String senha;
	private String email;
	private String cpf;
	private String nome;
	private String localizacao;

	public Usuario() {

	}

	public Usuario(String senha, String email, String cpf, String nome, String localizacao) {
		this.senha = senha;
		this.email = email;
		this.cpf = cpf;
		this.nome = nome;
		this.localizacao = localizacao;
	}

	public Usuario(int idUsuario, String senha, String email, String cpf, String nome, String localizacao) {
		this.idUsuario = idUsuario;
		this.senha = senha;
		this.email = email;
		this.cpf = cpf;
		this.nome = nome;
		this.localizacao = localizacao;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", senha=" + senha + ", email=" + email + ", cpf=" + cpf + ", nome="
				+ nome + ", localizacao=" + localizacao + "]";
	}
	
	

}
