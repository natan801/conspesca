package conspesca;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.conspesca.model.Ferramenta;
import br.com.conspesca.model.Local;
import br.com.conspesca.model.Peixe;
import br.com.conspesca.model.Usuario;
import br.com.conspesca.service.UsuarioService;

public class Teste {

	public static void main(String[] args) {

		UsuarioService usuarioService= new UsuarioService();
		Usuario usuario = new Usuario(null, "Manoel Antônio de Souza Filho",
				"manoelfilho@conspesca.com.br", "manoelfilho", "manoel321",
				Date.valueOf("10/10/1990"));

		 usuarioService.salvar(usuario);

		// Usuario usuarioFind = usuarioRepository.find(1);

		List<Usuario> listaUsuario = usuarioService.findAllUsuario();

		for (Object l : listaUsuario) {
			System.out.println(((Usuario) l).getNome());
		}
		System.exit(0);

		System.out.println("terminou");

	}

	public static Usuario recuperarUsuario(Integer id, EntityManager em) {

		Usuario usuario = em.find(Usuario.class, id);
		// em.close();
		return usuario;
	}

	public static Ferramenta recuperarFerramenta(Integer id, EntityManager em) {

		Ferramenta ferramenta = em.find(Ferramenta.class, id);
		// em.close();
		return ferramenta;
	}

	public static Peixe recuperarPeixe(Integer id, EntityManager em) {

		Peixe peixe = em.find(Peixe.class, id);
		// em.close();
		return peixe;
	}

	public static Local recuperarLocal(Integer id, EntityManager em) {

		Local local = em.find(Local.class, id);
		// em.close();
		return local;
	}
}
