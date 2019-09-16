package br.com.calebe.backend.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.calebe.backend.entities.Processo;
import br.com.calebe.backend.entities.Usuario;
import br.com.calebe.backend.utils.Utilitarios;

public class ProcessoDTO implements Serializable {

	private static final long serialVersionUID = -3879461964268667743L;

	private String id;
	private String nome;
	private String parecer;
	private List<UsuarioDTO> usuarios;
	
	private String usuariosNomes;

	public ProcessoDTO() {
		super();
	}

	public ProcessoDTO(Processo processo) {

		if (Utilitarios.isOK(processo.getId())) {
			this.id = processo.getId().toString();
		}

		if (Utilitarios.isOK(processo.getNome())) {
			this.nome = processo.getNome();
		}

		if (Utilitarios.isOK(processo.getParecer())) {
			this.parecer = processo.getParecer();
		}

		if (Utilitarios.isOK(processo.getUsuarios())) {
			this.usuarios = new ArrayList<>();
			List<String> nomes = new ArrayList<>();
			for (Usuario usuario : processo.getUsuarios()) {
				this.usuarios.add(new UsuarioDTO(usuario));
				nomes.add(usuario.getNome()+' '+usuario.getSobrenome());
			}
			Collections.sort(nomes);
			this.usuariosNomes = Utilitarios.converteListaEmStringComVirgulas(nomes);
		}
		
	}

	public ProcessoDTO(String nome, List<UsuarioDTO> usuarios) {
		
		if (Utilitarios.isOK(nome)) {
			this.nome = nome;
		}

		if (Utilitarios.isOK(usuarios)) {
			this.usuarios = usuarios;
		}
		
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

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	public List<UsuarioDTO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioDTO> usuarios) {
		this.usuarios = usuarios;
	}

	public String getUsuariosNomes() {
		return usuariosNomes;
	}

	public void setUsuariosNomes(String usuariosNomes) {
		this.usuariosNomes = usuariosNomes;
	}
	
}
