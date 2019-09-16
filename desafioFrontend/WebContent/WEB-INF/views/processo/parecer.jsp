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
    <h1 class="h3 mb-2 text-gray-800">Incluir Parecer</h1>

	<hr />

    <!-- DataTales Example -->
    <form id="formCadastrarParecerProcesso" onsubmit="return false;">
    	<input type="hidden" name="id" id="id">
    	<div class="form-group">
		  <label class="font-weight-bold" for="nome">Nome:</label>
		  <label id="nome"></label>
		</div>
		<div class="form-group">
		  <label for="exampleFormControlInput1">Parecer</label>
		  <textarea class="form-control" name="parecer" id="parecer" rows="3" maxlength="500"></textarea>
		</div>
	  	<button type="button" class="btn btn-success" onclick="ajaxCadastrarParecerProcesso()">Incluir</button>
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
	
	$("textarea[maxlength]").on("propertychange input", function() {
	    if (this.value.length > this.maxlength) {
	        this.value = this.value.substring(0, this.maxlength);
	    }  
	});
	
});
</script>