<%@page import="modelo.Producto"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProductoDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
    ProductoDaoImpl productoDaoImpl = new ProductoDaoImpl();

    List<Producto> productos = (List<Producto>) request.getAttribute("productos");
    if(productos == null) productos = productoDaoImpl.listar();
    
    Producto producto = (Producto) request.getAttribute("producto");
    if(producto == null) producto = new Producto(0, "", 0.0, 0.0, "Vigente", "");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body class="p-5">
    <div class="container col-5">
        <h3 class="text-center fw-bold">Mantenimiento de Productos</h3>
        <form action="ControllerProducto">
            <input type="hidden" name="idProd" value="<%=producto.getIdProd()%>">
            <input type="hidden" name="accion" value="guardar">
            <div class="mb-3">
                <label class="form-label">Nombre</label>
                <input class="form-control" name="nombre" autocomplete="off" required type="text" value="<%=producto.getNombre()%>">
            </div>
            <div class="mb-3">
                <label class="form-label">Precio Venta</label>
                <input class="form-control" name="precioV" step="0.01" min="0.01" required type="number" value="<%=producto.getPrecioV()%>">
            </div>
            <div class="mb-3">
                <label class="form-label">Precio Compra</label>
                <input class="form-control" name="precioC" step="0.01" min="0.01" required type="number" value="<%=producto.getPrecioC()%>">
            </div>
            <div class="mb-3">
                <label class="form-label">Estado</label>
                <select class="form-select" name="estado">
                <%
                    if(producto.getEstado().equals("Vigente")) {
                %>
                <option selected>Vigente</option>
                <%
                    } else {
                %>
                <option>Vigente</option>
                <%
                    }
                %>
                <%
                    if(producto.getEstado().equals("No Vigente")) {
                %>
                <option selected>No Vigente</option>
                <%
                    } else {
                %>
                <option>No Vigente</option>
                <%
                    }
                %>
                </select>
            </div>
            <div class="mb-3">
                <label class="form-label">Descripción</label>
                <textarea class="form-control" name="descripcion" required><%=producto.getDescripcion() %></textarea>
            </div>
            <div class="mb-3">
                <button class="btn btn-success"><i class="bi bi-check-circle"></i> Guardar</button>
            </div>
        </form>
    </div>
    
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Código</th>
                <th>Producto</th>
                <th>Precio Venta</th>
                <th>Precio Compra</th>
                <th>Estado</th>
                <th>Descripción</th>
                <th colspan="2">Acciones</th>
            </tr>
        </thead>
        <tbody>
            <%
                if(productos != null)
                	for(Producto prod: productos) {
            %>
            <tr>
                <td><%=prod.getIdProd() %></td>
                <td><%=prod.getNombre() %></td>
                <td><%=prod.getPrecioV() %></td>
                <td><%=prod.getPrecioC() %></td>
                <td><%=prod.getEstado() %></td>
                <td><%=prod.getDescripcion() %></td>
                <td>
                    <a class="btn btn-primary" href="ControllerProducto?accion=actualizar&idProd=<%=prod.getIdProd()%>">
                        <i class="bi bi-pencil"></i> Actualizar
                    </a>
                </td>
                <td>
                    <a class="btn btn-danger" href="ControllerProducto?accion=eliminar&idProd=<%=prod.getIdProd()%>">
                        <i class="bi bi-trash"></i> Eliminar
                    </a>
                </td>
            </tr>
            <%
                	}
            %>
        </tbody>
    </table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>