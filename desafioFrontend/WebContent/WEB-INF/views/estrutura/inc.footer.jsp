<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!-- Footer -->
    <footer class="sticky-footer bg-white">
      <div class="container my-auto">
        <div class="copyright text-center my-auto">
          <span>Desafio implementador fullstack - Calebe Souza</span>
        </div>
      </div>
    </footer>
    <!-- End of Footer -->

  </div>
  <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
  <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">×</span>
        </button>
      </div>
      <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
      <div class="modal-footer">
        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
        <a class="btn btn-primary" href="login.html">Logout</a>
      </div>
    </div>
  </div>
</div>

<!-- JQuery and plugins-->
<script type="text/javascript" src="<c:url value='/resources/jquery/jquery-3.4.1.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/jquery-easing/jquery.easing.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/jquery/jquery.validate.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/jquery/additional-methods.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/popper.min.js'/>"></script>

<!-- Bootstrap core JavaScript-->
<script type="text/javascript" src="<c:url value='/resources/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

<!-- Custom scripts for all pages-->
<script type="text/javascript" src="<c:url value='/resources/js/sb-admin-2.min.js'/>"></script>

<script type="text/javascript" src="<c:url value='/resources/js/BsMultiSelect.min.js'/>"></script>

<!-- Page level plugins -->
<script type="text/javascript" src="<c:url value='/resources/datatables/jquery.dataTables.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/datatables/dataTables.bootstrap4.min.js'/>"></script>

<script type="text/javascript" src="<c:url value='/resources/js/default.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/functions.js'/>"></script>

</body>

</html>