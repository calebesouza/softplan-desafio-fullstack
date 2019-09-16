package br.com.calebe.backend.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import br.com.calebe.backend.dto.UsuarioDTO;
import br.com.calebe.backend.tipos.TipoUsuario;
import br.com.calebe.backend.utils.Utilitarios;

@Entity
@Component
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 6020617195244815009L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome", nullable = false, length = 50)
	private String nome;

	@Column(name = "sobrenome", nullable = false, length = 50)
	private String sobrenome;

	@Column(name = "email", nullable = false, length = 100)
	private String email;

	@Column(name = "senha", nullable = false, length = 128)
	private String senha;
	
	@Column(name = "tipo", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoUsuario;
	
	@ManyToMany(mappedBy = "usuarios")
    private List<Processo> processos = new ArrayList<>();
	
	public Usuario() {

	}

	public Usuario(UsuarioDTO usuarioDTO) {
		
		if ( Utilitarios.isOK(usuarioDTO.getId()) ) {
			this.id = Long.valueOf( usuarioDTO.getId() );
		}
		
		if ( Utilitarios.isOK(usuarioDTO.getNome()) ) {
			this.nome = usuarioDTO.getNome();
		}
		
		if ( Utilitarios.isOK(usuarioDTO.getSobrenome()) ) {
			this.sobrenome = usuarioDTO.getSobrenome();
		}
		
		if ( Utilitarios.isOK(usuarioDTO.getEmail()) ) {
			this.email = usuarioDTO.getEmail();
		}
		
		if ( Utilitarios.isOK(usuarioDTO.getTipoUsuario()) ) {
			this.tipoUsuario = this.getTipoUsuarioEnum(usuarioDTO.getTipoUsuario());
		}
		
		if ( Utilitarios.isOK(usuarioDTO.getSenha()) ) {
			try {
				this.senha = Utilitarios.encriptPassword(usuarioDTO.getSenha());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<Processo> getProcesso() {
		return processos;
	}

	public void setProcesso(List<Processo> processos) {
		this.processos = processos;
	}
	
	public TipoUsuario getTipoUsuarioEnum(String tipoUsuario) {
		try {
			return TipoUsuario.get(Integer.valueOf(tipoUsuario));
		} catch (Exception e) {
			return TipoUsuario.get(String.valueOf(tipoUsuario));
		}
	}
	
}
