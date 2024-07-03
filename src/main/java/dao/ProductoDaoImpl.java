package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import interfaces.IProductoDao;
import modelo.Producto;

public class ProductoDaoImpl implements IProductoDao {

	public Producto obtener(Integer idProd) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSISTENCE-UNIT-CL3");
		EntityManager em = emf.createEntityManager();
		Producto producto = null;
		try {
			producto = em.find(Producto.class, idProd);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		return producto;
	}

	public void guardar(Producto producto) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSISTENCE-UNIT-CL3");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		if(producto.getIdProd() > 0)
			em.merge(producto);
		else
			em.persist(producto);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public List<Producto> listar() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSISTENCE-UNIT-CL3");
		EntityManager em = emf.createEntityManager();
		List<Producto> productos = new ArrayList<Producto>();
		try {
			String sql = "Select P From Producto P";
			Query query = em.createQuery(sql, Producto.class);
			productos = (List<Producto>) query.getResultList();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		return productos;
	}

	public void eliminar(Integer idProd) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSISTENCE-UNIT-CL3");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Producto producto = em.find(Producto.class, idProd);
		if(producto != null) {
			em.remove(producto);
		}
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
