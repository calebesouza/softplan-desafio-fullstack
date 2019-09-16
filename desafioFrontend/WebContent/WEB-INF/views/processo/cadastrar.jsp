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
    <h1 class="h3 mb-2 text-gray-800">Incluir Processo</h1>

	<hr />

    <!-- DataTales Example -->
    <form id="formCadastrarProcesso" onsubmit="return false;">
		<div class="form-group">
		  <label for="exampleFormControlInput1">Nome</label>
		  <input type="text" class="form-control" name="nome" id="nome" maxlength="80" placeholder="">
		</div>
	  	<button type="button" class="btn btn-success" onclick="ajaxCadastrarProcesso()">Incluir</button>
	  	<button type="button" class="btn btn-danger" onclick="redirectListarProcesso()">Voltar</button>
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
	
	$('#formCadastrarProcesso').validate({
		focusInvalid: false,
		rules: {
			nome: {
				required: true
			}
		},
		messages: {
			nome: {
				required: "Informe um nome"
			}
		}
	});
	
});
</script>