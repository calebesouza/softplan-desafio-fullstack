package br.com.calebe.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.calebe.backend.dto.TipoUsuarioDTO;
import br.com.calebe.backend.dto.UsuarioDTO;
import br.com.calebe.backend.entities.Usuario;
import br.com.calebe.backend.repositories.interfaces.UsuarioRepository;
import br.com.calebe.backend.services.interfaces.IUsuarioService;
import br.com.calebe.backend.tipos.TipoUsuario;

@Service
@Transactional
public class UsuarioService implements IUsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioService() {
		super();
	}

	@Override
	public List<UsuarioDTO> listarUsuarios() {
		List<UsuarioDTO> usuariosDTO = new ArrayList<>();
		try {
			List<Usuario> usuarios = usuarioRepository.findAll();
			if ( usuarios.size() == 0 ) {
				return usuariosDTO;
			}
			for (Usuario usuario : usuarios) {
				usuariosDTO.add(new UsuarioDTO(usuario));
			}
			return usuariosDTO;
		} catch ( Exception e ) {
			return usuariosDTO;
		}
	}
	
	@Override
	public List<UsuarioDTO> listarUsuariosFinalizador() {
		List<UsuarioDTO> usuariosDTO = new ArrayList<>();
		try {
			List<Usuario> usuarios = usuarioRepository.findAll();
			if ( usuarios.size() == 0 ) {
				return usuariosDTO;
			}
			for (Usuario usuario : usuarios) {
				if ( !TipoUsuario.USUARIO_FINALIZADOR.equals( usuario.getTipoUsuario() ) ) {
					continue;
				}
				usuariosDTO.add(new UsuarioDTO(usuario));
			}
			return usuariosDTO;
		} catch ( Exception e ) {
			return usuariosDTO;
		}
	}
	
	@Override
	public List<TipoUsuarioDTO> listarTipos() {
		List<TipoUsuarioDTO> tiposUsuarios = new ArrayList<>();
		for( TipoUsuario tipo: TipoUsuario.values() ) {
			tiposUsuarios.add(new TipoUsuarioDTO(tipo));
		}
		return tiposUsuarios;
	}
		
	@Override
	public void salvar( String nome, String sobrenome, String email, String senha, String tipoUsuario ) {
		this.salvar(new UsuarioDTO(null, nome, sobrenome, email, senha, tipoUsuario));
	}
	
	@Override
	public void salvar( UsuarioDTO usuarioDTO) {
		usuarioRepository.save(new Usuario(usuarioDTO));
	}
	
	@Override
	public void alterar( String id, String nome, String sobrenome, String email, String tipoUsuario ) {
		try {
			Usuario usuario = usuarioRepository.getOne(Long.valueOf( id ));
			UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
			usuarioDTO.setId(id);
			usuarioDTO.setNome(nome);
			usuarioDTO.setSobrenome(sobrenome);
			usuarioDTO.setEmail(email);
			usuarioDTO.setTipoUsuario(tipoUsuario);
			salvar(usuarioDTO);
		} catch ( Exception e ) {
			System.out.println(e);
		}
	}
	
	@Override
	public UsuarioDTO buscar(Long id) {
		try {
			Usuario usuario = usuarioRepository.getOne(id);
			return new UsuarioDTO(usuario);
		} catch ( Exception e ) {
			return new UsuarioDTO();
		}
	}
	
	@Override
	public void excluir(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	@Override
	public void limparTabela() {
		usuarioRepository.deleteAll();
	}
	
}
