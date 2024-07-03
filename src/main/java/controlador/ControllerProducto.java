package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductoDaoImpl;
import modelo.Producto;

/**
 * Servlet implementation class ControllerProducto
 */
public class ControllerProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDaoImpl productoDaoImpl = new ProductoDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		switch(accion) {
		case "guardar":
			guardarProducto(request, response);
			break;
		case "actualizar":
			actualizarProducto(request, response);
			break;
		case "eliminar":
			eliminarProducto(request, response);
			break;
		default:
			listarProductos(request, response);
		}
	}

	private void listarProductos(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("productos", productoDaoImpl.listar());
			RequestDispatcher rd = request.getRequestDispatcher("mantenimientoproductos.jsp");
			rd.forward(request, response);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) {
		Integer idProd = Integer.parseInt(request.getParameter("idProd"));
		productoDaoImpl.eliminar(idProd);
		listarProductos(request, response);
	}

	private void actualizarProducto(HttpServletRequest request, HttpServletResponse response) {
		Integer idProd = Integer.parseInt(request.getParameter("idProd"));
		Producto producto = productoDaoImpl.obtener(idProd);
		request.setAttribute("producto", producto);
		listarProductos(request, response);
	}

	private void guardarProducto(HttpServletRequest request, HttpServletResponse response) {
		Integer idProd = Integer.parseInt(request.getParameter("idProd"));
		String nombre = request.getParameter("nombre");
		Double precioV = Double.parseDouble(request.getParameter("precioV"));
		Double precioC = Double.parseDouble(request.getParameter("precioC"));
		String estado = request.getParameter("estado");
		String descripcion = request.getParameter("descripcion");
		
		Producto producto = new Producto(idProd, nombre, precioV, precioC, estado, descripcion);
		productoDaoImpl.guardar(producto);
		listarProductos(request, response);
	}
	
	

}
