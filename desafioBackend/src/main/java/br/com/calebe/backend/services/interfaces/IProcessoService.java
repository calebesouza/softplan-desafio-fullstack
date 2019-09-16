package br.com.calebe.backend.services.interfaces;

import java.util.List;

import br.com.calebe.backend.dto.ProcessoDTO;

public interface IProcessoService {
	
	/**
	 * Retorna lista de todos os processos do sistema
	 * 
	 * @return List<ProcessoDTO>
	 */
	public List<ProcessoDTO> listarProcessos();

	/**
	 * Retorna lista de todos os processos sem parecer do sistema
	 * 
	 * @return List<ProcessoDTO>
	 */
	public List<ProcessoDTO> listarProcessosSemParecer();

	/**
	 * Grava um processo no banco de dados
	 * @param nome
	 * @param idsUsuarios
	 */
	public void salvar(String nome);

	/**
	 * Atribui usuarios ao processo
	 * @param id
	 * @param idsUsuarios
	 */
	public void atribuirUsuarios(String id, List<String> idsUsuarios);

	/**
	 * Cadastra parecer ao processo
	 * @param id
	 * @param idsUsuarios
	 */
	void cadastrarParecer(String id, String parecer);

	/**
	 * Visualiza os dados do processo
	 * @param id
	 * @return
	 */
	ProcessoDTO visualizar(String id);

	/**
	 * Retorna um processo pelo id
	 * @param id
	 * @return
	 */
	ProcessoDTO buscar(Long id);
	
}
