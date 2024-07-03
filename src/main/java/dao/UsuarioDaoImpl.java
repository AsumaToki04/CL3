package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import interfaces.IUsuarioDao;
import modelo.Usuario;

public class UsuarioDaoImpl implements IUsuarioDao {

	public Usuario usuarioLogin(String usuario, String clave) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSISTENCE-UNIT-CL3");
		EntityManager em = emf.createEntityManager();
		Usuario usuarioLogin = null;
		try {
			String sql = "SELECT U FROM Usuario U " +
		                 "WHERE U.usuario = :usuario AND " +
					           "U.clave = :clave";
			Query query = em.createQuery(sql, Usuario.class);
			query.setParameter("usuario", usuario);
			query.setParameter("clave", clave);
			usuarioLogin = (Usuario) query.getSingleResult();
		} catch(Exception ex) {
			System.out.println("Usuario " + usuario + " no encontrado");
		}
		em.close();
		emf.close();
		return usuarioLogin;
	}

}
