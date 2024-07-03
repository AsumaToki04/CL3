package interfaces;

import java.util.List;

import modelo.Producto;

public interface IProductoDao {
	Producto obtener(Integer idProd);
	void guardar(Producto producto);
	List<Producto> listar();
	void eliminar(Integer idProd);
}
