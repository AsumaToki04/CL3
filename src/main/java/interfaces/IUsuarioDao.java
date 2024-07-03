package interfaces;

import modelo.Usuario;

public interface IUsuarioDao {
	Usuario usuarioLogin(String usuario, String clave);
}
