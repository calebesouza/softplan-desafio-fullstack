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

import br.com.calebe.backend.dto.ProcessoDTO;
import br.com.calebe.backend.services.ProcessoService;

@RestController
@RequestMapping( value = "/processo" )
public class ProcessoController {

	@Autowired
	private ProcessoService processoService;

	public ProcessoController(ProcessoService processoService) {
		this.processoService = processoService;
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<ProcessoDTO>> listarProcessos() {
		List<ProcessoDTO> processos = processoService.listarProcessos();
		return ResponseEntity.status(HttpStatus.OK).body(processos);
	}
	
	@RequestMapping(value = "/listarSemParecer", method = RequestMethod.GET)
	public ResponseEntity<List<ProcessoDTO>> listarProcessosSemParecer() {
		List<ProcessoDTO> processos = processoService.listarProcessosSemParecer();
		return ResponseEntity.status(HttpStatus.OK).body(processos);
	}
	
	@RequestMapping(value = "/incluir", method = RequestMethod.POST)
	public void incluir(@RequestParam(name = "nome") String nome) {
		processoService.salvar(nome);
	}
	
	@RequestMapping(value = "/atribuirUsuarios", method = RequestMethod.POST)
	public void incluir(@RequestParam(name = "id") String id,
						@RequestParam(name = "usuarios") List<String> usuarios) {
		processoService.atribuirUsuarios(id, usuarios);
	}
	
	@RequestMapping(value = "/cadastrarParecer", method = RequestMethod.POST)
	public void incluir(@RequestParam(name = "id") String id,
						@RequestParam(name = "parecer") String parecer) {
		processoService.cadastrarParecer(id, parecer);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<ProcessoDTO> buscar(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(processoService.buscar(id));
	}
	
}
