<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
    String loginError = (String) request.getAttribute("loginError");
    if(loginError == null) loginError = "";
%>
<meta charset="UTF-8">
<title>Index</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body class="p-5">
    <div class="container col-4">
        <h1 class="fw-bold text-center">Ingresar al sistema</h1>
        <form action="ControladorUsuario" method="post">
            <div class="mb-3">
                <label class="form-label">Usuario</label>
                <input type="text" class="form-control" name="usuarioNombre" autocomplete="off" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Clave</label>
                <input type="password" class="form-control" name="usuarioClave" required>
            </div>
            <div class="mb-3">
                <button class="btn btn-primary" type="submit">
                    <i class="bi bi-door-open"></i> Iniciar Sesión
                </button>
            </div>
            <%
                if(!loginError.equals("")) {
            %>
            <div class="alert alert-warning text-center">
                <%=loginError %>
            </div>
            <%
                }
            %>
        </form>
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>