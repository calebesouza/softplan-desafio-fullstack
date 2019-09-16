package br.com.calebe.backend.services.interfaces;

import java.util.List;

import br.com.calebe.backend.dto.TipoUsuarioDTO;
import br.com.calebe.backend.dto.UsuarioDTO;

public interface IUsuarioService {

	/**
	 * Retorna lista de todos os usuarios do sistema
	 * 
	 * @return List<UsuarioDTO>
	 */
	public List<UsuarioDTO> listarUsuarios();
	
	/**
	 * Retorna lista dos usuarios com perfil usuario-finalizador
	 * 
	 * @return List<UsuarioDTO>
	 */
	List<UsuarioDTO> listarUsuariosFinalizador();

	/**
	 * Grava um usuario no banco
	 * 
	 * @param nome
	 * @param sobrenome
	 * @param email
	 * @param senha
	 * @param tipoUsuario
	 */
	public void salvar(String nome, String sobrenome, String email, String senha, String tipoUsuario);

	/**
	 * Grava um usuario no banco
	 * 
	 * @param usuarioDTO
	 */
	public void salvar(UsuarioDTO usuarioDTO);

	/**
	 * Retorna lista de tipos de usuarios
	 * 
	 * @return List<TipoUsuarioDTO>
	 */
	public List<TipoUsuarioDTO> listarTipos();

	/**
	 * Retorna um usuario pelo id
	 * 
	 * @param id
	 * @return UsuarioDTO
	 */
	public UsuarioDTO buscar(Long id);

	/**
	 * Altera os dados de um usuario
	 * 
	 * @param id
	 * @param nome
	 * @param sobrenome
	 * @param email
	 * @param tipoUsuario
	 */
	public void alterar(String id, String nome, String sobrenome, String email, String tipoUsuario);

	/**
	 * Exclui um usuario
	 * 
	 * @param id
	 */
	public void excluir(Long id);

	public void limparTabela();

}
