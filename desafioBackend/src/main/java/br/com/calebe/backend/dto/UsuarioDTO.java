package br.com.calebe.backend.dto;

import java.io.Serializable;

import br.com.calebe.backend.entities.Usuario;
import br.com.calebe.backend.utils.Utilitarios;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = -3879461964268667743L;

	private String id;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private String tipoUsuario;
	private String tipoUsuarioId;

	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(String id, String nome, String sobrenome, String email, String senha, String tipoUsuario) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
	}

	public UsuarioDTO(Usuario usuario) {

		if (Utilitarios.isOK(usuario.getId())) {
			this.id = usuario.getId().toString();
		}

		if (Utilitarios.isOK(usuario.getNome())) {
			this.nome = usuario.getNome();
		}

		if (Utilitarios.isOK(usuario.getSobrenome())) {
			this.sobrenome = usuario.getSobrenome();
		}

		if (Utilitarios.isOK(usuario.getEmail())) {
			this.email = usuario.getEmail();
		}
		
		if (Utilitarios.isOK(usuario.getSenha())) {
			this.senha = usuario.getSenha();
		}

		this.tipoUsuario = usuario.getTipoUsuario().getDescricao();
		this.tipoUsuarioId = String.valueOf( usuario.getTipoUsuario().ordinal() );

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	public String getTipoUsuarioId() {
		return tipoUsuarioId;
	}

	public void setTipoUsuarioId(String tipoUsuarioId) {
		this.tipoUsuarioId = tipoUsuarioId;
	}

}
