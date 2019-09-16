<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="form-group">
  <label for="tipoUsuario">Perfil</label>
  <select class="form-control" name="tipoUsuario" id="tipoUsuario"></select>
</div> 
<div class="form-group">
  <label for="nome">Nome</label>
  <input type="text" class="form-control" name="nome" id="nome" maxlength="50" placeholder="">
</div>
<div class="form-group">
  <label for="sobrenome">Sobrenome</label>
  <input type="text" class="form-control" name="sobrenome" id="sobrenome" maxlength="50" placeholder="">
</div>
<div class="form-group">
  <label for="email">Email</label>
  <input type="email" class="form-control" name="email" id="email" maxlength="100" placeholder="">
</div>
