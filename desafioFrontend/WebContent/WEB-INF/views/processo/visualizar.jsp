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
    <h1 class="h3 mb-2 text-gray-800">Visualizar Processo</h1>
    
    <hr />

    <!-- DataTales Example -->
    <form id="formCadastrarProcesso" onsubmit="false">
    	<input type="hidden" name="id" id="id">
		<div class="form-group">
		  <label class="font-weight-bold" for="nome">Nome:</label>
		  <label id="nomeLabel"></label>
		</div>
		<div class="form-group">
		  <label class="font-weight-bold" for="nome">Parecer:</label>
		  <label id="parecerLabel"></label>
		</div>
		<div class="form-group">
		  <label class="font-weight-bold" for="nome">Responsáveis pelo parecer:</label>
		  <label id="usuariosNomesLabel"></label>
		</div>
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
	
	ajaxBuscarProcesso(${id});
	
	if ( $('#parecerLabel').html() == '' ) {
		$('#parecerLabel').html('-');
	}
	
	if ( $('#usuariosNomesLabel').html() == '' ) {
		$('#usuariosNomesLabel').html('-');
	}
	
});
</script>