package br.com.calebe.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.calebe.backend.dto.ProcessoDTO;
import br.com.calebe.backend.entities.Processo;
import br.com.calebe.backend.entities.Usuario;
import br.com.calebe.backend.repositories.interfaces.ProcessoRepository;
import br.com.calebe.backend.repositories.interfaces.UsuarioRepository;
import br.com.calebe.backend.services.interfaces.IProcessoService;
import br.com.calebe.backend.utils.Utilitarios;

@Service
@Transactional
public class ProcessoService implements IProcessoService {
	
	@Autowired
	private ProcessoRepository processoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public ProcessoService() {
		super();
	}

	@Override
	public List<ProcessoDTO> listarProcessos() {
		List<ProcessoDTO> processoDTO = new ArrayList<>();
		try {
			List<Processo> processos = processoRepository.findAll();
			if ( processos.size() == 0 ) {
				return processoDTO;
			}
			for (Processo processo : processos) {
				processoDTO.add(new ProcessoDTO(processo));
			}
			return processoDTO;
		} catch ( Exception e ) {
			return processoDTO;
		}
	}
	
	@Override
	public List<ProcessoDTO> listarProcessosSemParecer() {
		List<ProcessoDTO> processoDTO = new ArrayList<>();
		try {
			List<Processo> processos = processoRepository.findAll();
			if ( processos.size() == 0 ) {
				return processoDTO;
			}
			for (Processo processo : processos) {
				if ( Utilitarios.isOK(processo.getParecer()) ) {
					continue;
				}
				processoDTO.add(new ProcessoDTO(processo));
			}
			return processoDTO;
		} catch ( Exception e ) {
			return processoDTO;
		}
	}
	
	@Override
	public void salvar( String nome ) {
		Processo processo = new Processo( nome );
		processoRepository.save(processo);
	}
	
	@Override
	public ProcessoDTO visualizar( String id ) {
		if( !Utilitarios.isOK(id) ) {
			return new ProcessoDTO();
		}
		Processo processo = processoRepository.getOne(Long.valueOf(id));
		return new ProcessoDTO(processo);
	}
	
	@Override
	public ProcessoDTO buscar(Long id) {
		try {
			Processo processo = processoRepository.getOne(id);
			return new ProcessoDTO(processo);
		} catch ( Exception e ) {
			return new ProcessoDTO();
		}
	}
	
	@Override
	public void atribuirUsuarios( String id, List<String> idsUsuarios ) {
		
		if( !Utilitarios.isOK(id) || !Utilitarios.isOK(idsUsuarios) ) {
			return;
		}
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		for (String idUsuario : idsUsuarios) {
			usuarios.add( usuarioRepository.getOne(Long.valueOf(idUsuario)) );
		}
		
		Processo processo = processoRepository.getOne(Long.valueOf(id));
		processo.getUsuarios().clear();
		processo.setUsuarios(usuarios);
		
		processoRepository.save(processo);
	}
	
	@Override
	public void cadastrarParecer( String id, String parecer ) {
		
		if( !Utilitarios.isOK(id) || !Utilitarios.isOK(parecer) ) {
			return;
		}

		Processo processo = processoRepository.getOne(Long.valueOf(id));
		processo.setParecer(parecer);
		
		processoRepository.save(processo);
	}
	
}
