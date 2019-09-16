package br.com.calebe.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.calebe.backend.dto.TipoUsuarioDTO;
import br.com.calebe.backend.dto.UsuarioDTO;
import br.com.calebe.backend.services.UsuarioService;
import br.com.calebe.backend.tipos.TipoUsuario;

@RestController
@RequestMapping( value = "/usuario" )
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
		// criando dados iniciais
		usuarioService.salvar(new UsuarioDTO("1", "Luis", "Freitas", "lfreitas@teste.com.br", "123456", TipoUsuario.USUARIO_TRIADOR.getDescricao()));
    	usuarioService.salvar(new UsuarioDTO("2", "Marcelo", "Lima", "mlima@teste.com.br", "123456", TipoUsuario.ADMINISTRADOR.getDescricao()));
    	usuarioService.salvar(new UsuarioDTO("3", "Diego", "Costa", "dcosta@teste.com.br", "123456", TipoUsuario.USUARIO_TRIADOR.getDescricao()));
    	usuarioService.salvar(new UsuarioDTO("4", "Vitor", "Santos", "vsantos@teste.com.br", "123456", TipoUsuario.USUARIO_FINALIZADOR.getDescricao()));
    	usuarioService.salvar(new UsuarioDTO("5", "Pedro", "Souza", "psouza@teste.com.br", "123456", TipoUsuario.USUARIO_TRIADOR.getDescricao()));
    	usuarioService.salvar(new UsuarioDTO("6", "Marcos", "Ramirez", "mramirez@teste.com.br", "123456", TipoUsuario.USUARIO_FINALIZADOR.getDescricao()));
    	usuarioService.salvar(new UsuarioDTO("7", "Fernando", "Rocha", "frocha@teste.com.br", "123456", TipoUsuario.USUARIO_FINALIZADOR.getDescricao()));
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
		List<UsuarioDTO> usuarios = usuarioService.listarUsuarios();
		return ResponseEntity.status(HttpStatus.OK).body(usuarios);
	}
	
	@RequestMapping(value = "/listarFinalizador", method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> listarUsuariosFinalizador() {
		List<UsuarioDTO> usuarios = usuarioService.listarUsuariosFinalizador();
		return ResponseEntity.status(HttpStatus.OK).body(usuarios);
	}
	
	@RequestMapping(value = "/tipos", method = RequestMethod.GET)
	public ResponseEntity<List<TipoUsuarioDTO>> listarTipos() {
		List<TipoUsuarioDTO> tiposUsuario = usuarioService.listarTipos();
		return ResponseEntity.status(HttpStatus.OK).body(tiposUsuario);
	}
	
    @RequestMapping(value = "/incluir", method = RequestMethod.POST)
	public void cadastrar(@RequestParam(name = "nome") String nome,
			              @RequestParam(name = "sobrenome") String sobrenome,
			              @RequestParam(name = "email") String email,
			              @RequestParam(name = "senha") String senha,
			              @RequestParam(name = "tipoUsuario") String tipoUsuario) {
		usuarioService.salvar(nome, sobrenome, email, senha, tipoUsuario);
	}
	
    @RequestMapping(value = "/alterar", method = RequestMethod.POST)
	public void alterar(@RequestParam(name = "id") String id,
						@RequestParam(name = "nome") String nome,
			            @RequestParam(name = "sobrenome") String sobrenome,
			            @RequestParam(name = "email") String email,
			            @RequestParam(name = "tipoUsuario") String tipoUsuario) {
		usuarioService.alterar(id, nome, sobrenome, email, tipoUsuario);
	}
	
    @GetMapping(path = "/{id}")
	public ResponseEntity<UsuarioDTO> buscar(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscar(id));
	}
    
    @GetMapping(path = "/excluir/{id}")
	public void excluir(@PathVariable("id") Long id) {
    	System.out.println("excluindo usuário");
    	usuarioService.excluir(id);
    	System.out.println("excluido");
	}
	
}
