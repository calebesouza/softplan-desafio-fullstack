<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- start: Header -->
<c:import url='../estrutura/inc.header.jsp' />
<!-- end: Header -->

<!-- Main Content -->
<div id="content">

  <!-- Begin Page Content -->
  <div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Alterar Usuário</h1>

	<hr />

    <!-- DataTales Example -->
    <form id="formCadastrarUsuario" onsubmit="return false;">
      <input type="hidden" name="id" id="id">
	  <c:import url='../usuario/campos-form.jsp' />
	  <button type="button" class="btn btn-primary" onclick="ajaxAlterarUsuario()">Alterar</button>
	  <button type="button" class="btn btn-danger" onclick="redirectListarUsuario()">Voltar</button>
	</form>

  </div>
  <!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<!-- Footer -->
<c:import url='../estrutura/inc.footer.jsp' />
<!-- End of Footer -->

<script>
$(document).ready(function() {
	
	ajaxTiposUsuarioSelect();
	
	ajaxBuscarUsuario(${id});
	
	$('#formCadastrarUsuario').validate({
		focusInvalid: false,
		rules: {
			tipoUsuario: {
				required: true
			},
			nome: {
				required: true
			},
			sobrenome: {
				required: true
			},
			email: {
				required: true,
				email: true
			},
			senha: {
				required: true
			}
		},
		messages: {
			tipoUsuario: {
				required: "Informe o perfil do usuário"
			},
			nome: {
				required: "Informe um nome"
			},
			sobrenome: {
				required: "Informe um sobrenome"
			},
			email: {
				required: "Informe um email",
				email: "Informe um email válido"
			},
			senha: {
				required: "Informe uma senha"
			}
		}
	});
	
		
 	
});
</script>