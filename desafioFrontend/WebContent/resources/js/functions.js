// REDIRECTs ------------------------------------------------------------------------------------------------------------------------------------

function redirectListarUsuario() {
	window.location = 'listarUsuarios';
}

function redirectCadastrarUsuario() {
	window.location = 'cadastrarUsuario';
}

function redirectAlterarUsuario(id) {
	window.location = 'alterarUsuario?id='+id;
}

function redirectListarProcesso() {
	window.location = 'listarProcessos';
}

function redirectCadastrarProcesso() {
	window.location = 'cadastrarProcesso';
}

function redirectVisualizarProcesso(id) {
	window.location = 'visualizarProcesso?id='+id;
}

function redirectAtribuirUsuariosProcesso(id) {
	window.location = 'atribuirUsuariosProcesso?id='+id;
}

function redirectCadastrarParecerProcesso(id) {
	window.location = 'cadastrarParecer?id='+id;
}

// AJAXs ---------------------------------------------------------------------------------------------------------------------------------------

function ajaxUsuarioListar() {
	
	$.getJSON( "usuario/listar", function( resp ) {
		
		if ( resp == '' ) {
			$('#listaUsuarios').html('<tr><td colspan="4">Não existem usuários cadastrados</td></tr>');
			return;
		}
		htmlLista = '';
		$.each(resp, function(index, item) {
			htmlLista += '<tr>';
			usuarioDTO = resp[index];
			htmlLista += '<td>'+usuarioDTO.nome+' '+usuarioDTO.sobrenome+'</td>';
			htmlLista += '<td>'+usuarioDTO.email+'</td>';
			htmlLista += '<td>'+usuarioDTO.tipoUsuario+'</td>';
			var buttonAlterar = '<button type="button" class="btn btn-sm btn-warning" onclick="redirectAlterarUsuario('+usuarioDTO.id+')">Alterar</button>';
			var buttonExcluir = '<button type="button" class="btn btn-sm btn-danger" onclick="ajaxExcluirUsuario('+usuarioDTO.id+')">Excluir</button>';
			htmlLista += '<td>'+buttonAlterar+'&nbsp;'+buttonExcluir+'</td>';
			htmlLista += '</tr>';
		});
		$('#listaUsuarios').html(htmlLista);
		$('#dataTable').DataTable();
		
	}).fail(function( data ) {
	    printObject(data)
	});
	
}

function ajaxTiposUsuarioSelect() {
	$.getJSON( "usuario/tipos", function( resp ) {
		
		htmlLista = '';
		htmlLista += '<option value="">Selecione</option>';
		
		if ( resp == '' ) {
			$('#tipoUsuario').html(htmlLista);
			return;
		}
		
		$.each(resp, function(index, item) {
			tipoUsuarioDTO = resp[index];
			htmlLista += '<option value="'+tipoUsuarioDTO.id+'">'+tipoUsuarioDTO.tipo+'</option>';
		});
		htmlLista += '</tr>';
		$('#tipoUsuario').html(htmlLista);
		
	}).fail(function( data ) {
	    printObject(data)
	});
}

function ajaxCadastrarUsuario() {
	
	if ( $("#formCadastrarUsuario").valid() ) {
		var dados = $("#formCadastrarUsuario").serialize();
		$.post( "usuario/incluir", dados )
		.done(function() {
			redirectListarUsuario();  
		})
		.fail(function() {
		    alert( "error" );
		});
	}
	
}

function ajaxAlterarUsuario(){
	
	if ( $("#formCadastrarUsuario").valid() ) {
		var dados = $("#formCadastrarUsuario").serialize();
		$.post( "usuario/alterar", dados )
		.done(function() {
			redirectListarUsuario();  
		})
		.fail(function() {
		    alert( "error" );
		});
	}
	
}

function ajaxBuscarUsuario(id) {
	
	$.getJSON( "usuario/"+id+"", function( usuarioDTO ) {
		
		if ( usuarioDTO == '' ) {
			return;
		}
		
		$('#id').val(usuarioDTO.id);
		$('#nome').val(usuarioDTO.nome);
		$('#sobrenome').val(usuarioDTO.sobrenome);
		$('#email').val(usuarioDTO.email);
		$('#tipoUsuario').val(usuarioDTO.tipoUsuarioId);
		
	}).fail(function( data ) {
	    printObject(data)
	});
	
}

function ajaxExcluirUsuario(id) {
	
	$.get( "usuario/excluir/"+id+"" )
	.done(function() {
		ajaxUsuarioListar();
	})
	.fail(function() {
	    alert( "error" );
	});
	
}

function ajaxProcessoListar() {
	
	$.getJSON( "processo/listar", function( resp ) {
		
		if ( resp == '' ) {
			$('#listaProcessos').html('<tr><td colspan="4">Não existem processos cadastrados</td></tr>');
			return;
		}
		htmlLista = '';
		$.each(resp, function(index, item) {
			htmlLista += '<tr>';
			processoDTO = resp[index];
			htmlLista += '<td>'+processoDTO.nome+'</td>';
			if ( processoDTO.usuariosNomes == null ) {
				htmlLista += '<td>-</td>';				
			} else {
				htmlLista += '<td>'+processoDTO.usuariosNomes+'</td>';
			}
			if ( processoDTO.parecer == null ) {
				htmlLista += '<td>-</td>';				
			} else {
				htmlLista += '<td>'+processoDTO.parecer+'</td>';
			}
			var buttonAtribuir = '<button type="button" class="btn btn-sm btn-info" onclick="redirectAtribuirUsuariosProcesso('+processoDTO.id+')">Atribuir</button>';
			var buttonVisualizar = '<button type="button" class="btn btn-sm btn-primary" onclick="redirectVisualizarProcesso('+processoDTO.id+')">Visualizar</button>';
			var buttonParecer = '<button type="button" class="btn btn-sm btn-secondary" onclick="redirectCadastrarParecerProcesso('+processoDTO.id+')">Parecer</button>';
			htmlLista += '<td>'+buttonAtribuir+'&nbsp;'+buttonVisualizar+'&nbsp;'+buttonParecer+'</td>';
			htmlLista += '</tr>';
		});
		$('#listaProcessos').html(htmlLista);
		$('#dataTable').DataTable();
		
	}).fail(function( data ) {
	    printObject(data)
	});
	
}

function ajaxCadastrarProcesso() {
	
	if ( $("#formCadastrarProcesso").valid() ) {
		var dados = $("#formCadastrarProcesso").serialize();
		$.post( "processo/incluir", dados )
		.done(function() {
			redirectListarProcesso();  
		})
		.fail(function() {
		    alert( "error" );
		});
	}
	
}

function ajaxBuscarProcesso(id) {

	$.getJSON( "processo/"+id+"", function( processoDTO ) {
		
		if ( processoDTO == '' ) {
			return;
		}
		
		$('#id').val(processoDTO.id);
		$('#nomeLabel').html(processoDTO.nome);
		$('#parecerLabel').html(processoDTO.parecer);
		$('#parecer').val(processoDTO.parecer);
		$('#usuariosNomesLabel').html(processoDTO.usuariosNomes);
		
	}).fail(function( data ) {
	    printObject(data)
	});
	
}

function ajaxSelectUsuariosFinalizadores(id) {
	
	var usuariosDeProcesso = [];
	
	$.getJSON( "processo/"+id+"", function( processoDTO ) {
		
		if ( processoDTO == '' ) {
			return;
		}
		
		$.each(processoDTO.usuarios, function(index, item) {
			usuarioDTO = processoDTO.usuarios[index];
			usuariosDeProcesso.push(usuarioDTO.id);
		});
		
	}).fail(function( data ) {
	    printObject(data)
	});
	
	$.getJSON( "usuario/listarFinalizador", function( resp ) {

		htmlSelect = '';
		if ( resp == '' ) {
			$('#usuarios').html(htmlSelect);
			return;
		}
		$.each(resp, function(index, item) {
			
			usuarioDTO = resp[index];
			
			var selected = '';
			if ( usuariosDeProcesso.indexOf(usuarioDTO.id) != -1 ) { 
				selected = 'selected';
			}
			
			htmlSelect += '<option '+selected+' value="'+usuarioDTO.id+'">'+usuarioDTO.nome+' '+usuarioDTO.sobrenome+'</option>';
		});
		$('#usuarios').html(htmlSelect);
		$('#usuarios').multiselect({
            search: true,
            selectAll: true
        });
		
	}).fail(function( data ) {
	    printObject(data)
	});
	
}

function ajaxAtribuirUsuariosProcesso() {
	
	if ( $("#formAtribuirUsuariosProcesso").valid() ) {
		var dados = $("#formAtribuirUsuariosProcesso").serialize();
		$.post( "processo/atribuirUsuarios", dados )
		.done(function() {
			redirectListarProcesso();  
		})
		.fail(function() {
		    alert( "error" );
		});
	}
	
}

function ajaxCadastrarParecerProcesso(){
	var dados = $("#formCadastrarParecerProcesso").serialize();
	$.post( "processo/cadastrarParecer", dados )
	.done(function() {
		redirectListarProcesso();  
	})
	.fail(function() {
	    alert( "error" );
	});
}