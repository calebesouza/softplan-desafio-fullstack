<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Desafio implementador fullstack</title>

  <!-- Custom fonts for this template-->
  <link href="<c:url value='/resources/fontawesome-free/css/all.min.css'/>" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="<c:url value='/resources/css/sb-admin-2.min.css'/>" rel="stylesheet" type="text/css">

  <link href="<c:url value='/resources/css/projeto.css'/>" rel="stylesheet" type="text/css">
	
</head>

<body class="bg-gradient-primary">

  <div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">

      <div class="col-xl-6 col-lg-12 col-md-9">

        <div class="card o-hidden border-0 shadow-lg my-5">
          <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
              <div class="col-lg-12">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">Desafio implementador fullstack</h1>
                  </div>
                  <form id="formLogin" class="user">
                    <div class="form-group">
                      <input type="email" class="form-control form-control-user" name="email" aria-describedby="emailHelp" placeholder="Email">
                    </div>
                    <div class="form-group">
                      <input type="password" class="form-control form-control-user" name="senha" placeholder="Senha">
                    </div>
                    <button id="btnLogin" class="btn btn-primary btn-user btn-block" onclick="redirect('principal')">
                      Login
                    </button>
                  </form>
                  <hr>
                  <div class="text-center">
                    <a class="small" href="#">Criar uma conta!</a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>

    </div>

  </div>

  <!-- Bootstrap core JavaScript-->
  <script type="text/javascript" src="<c:url value='/resources/jquery/jquery-3.4.1.min.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/resources/jquery-easing/jquery.easing.min.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/resources/jquery/jquery.validate.min.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/resources/jquery/additional-methods.min.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/resources/js/popper.min.js'/>"></script>
  
  <!-- Custom scripts for all pages-->
  <script type="text/javascript" src="<c:url value='/resources/js/sb-admin-2.min.js'/>"></script>

  <script type="text/javascript" src="<c:url value='/resources/js/default.js'/>"></script>
  
  <script>

	$().ready(function(){
		
		$('#formLogin').validate({
			focusInvalid: false,
			rules: {
				email: {
					required: true,
					email: true
				},
				senha: {
					required: true
				}
			},
			messages: {
				email: {
					required: "Informe um email",
					email: "Informe um email válido"
				},
				senha: {
					required: "Informe uma senha"
				}
			}
		});
		
		$('#btnLogin').click(function(){
			
			// se os dados do formulario sao validos
			if ( $('#formLogin').valid() ) {
				
				$.ajax({
					  method: "POST",
					  url: "usuario/logar",
					  dataType: "text",
					  async: false,
					  data: $('#formLogin').serialize(),
					  beforeSend: function() { $('#btnLogin').attr('disabled','disabled'); },
					  complete: function() { $('#btnLogin').removeAttr('disabled'); }
				}).success(function( dados ) {
					alert(dados);
				});
				
			}
			
		});
		
	});

  </script>

</body>

</html>