package br.com.calebe.backend.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import br.com.calebe.backend.utils.Utilitarios;

@Entity
@Component
@Table(name = "processo")
public class Processo implements Serializable {

	private static final long serialVersionUID = 6020617195244815009L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome", nullable = false, length = 80)
	private String nome;

	@Column(name = "parecer", nullable = true, length = 500)
	private String parecer;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "usuarios_processo", joinColumns = @JoinColumn(name = "processo_id"), inverseJoinColumns = @JoinColumn(name = "usuario_id") )
    private List<Usuario> usuarios = new ArrayList<>();

	public Processo() {

	}

	public Processo(String nome) {
		if (Utilitarios.isOK(nome)) {
			this.nome = nome;
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

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
