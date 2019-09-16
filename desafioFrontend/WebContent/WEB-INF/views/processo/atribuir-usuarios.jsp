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
    <h1 class="h3 mb-2 text-gray-800">Atribuir Usuários</h1>
    
    <hr />

    <!-- DataTales Example -->
    <form id="formAtribuirUsuariosProcesso" onsubmit="return false;">
    	<input type="hidden" name="id" id="id">
		<div class="form-group">
		  <label class="font-weight-bold" for="nome">Nome:</label>
		  <label id="nome"></label>
		</div>
		<div class="form-group">
		  <label class="font-weight-bold" for="nome">Responsáveis pelo parecer:</label>
		  <select class="form-control" name="usuarios" id="usuarios" multiple="multiple"></select>
		</div>
		<button type="button" class="btn btn-success btnForm" onclick="ajaxAtribuirUsuariosProcesso()">Atualizar</button>
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
	
	ajaxSelectUsuariosFinalizadores(${id});
	
});
</script>