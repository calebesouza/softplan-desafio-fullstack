package br.com.calebe.backend.dto;

import java.io.Serializable;

import br.com.calebe.backend.tipos.TipoUsuario;

public class TipoUsuarioDTO implements Serializable {

	private static final long serialVersionUID = 8010622609744775418L;
	
	private String id;
	private String tipo;

	public TipoUsuarioDTO() {
		super();
	}

	public TipoUsuarioDTO(TipoUsuario tipoUsuario) {
		
		this.id = String.valueOf(tipoUsuario.ordinal());
		this.tipo = tipoUsuario.getDescricao();

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}
