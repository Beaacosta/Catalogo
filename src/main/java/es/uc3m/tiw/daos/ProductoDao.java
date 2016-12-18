package es.uc3m.tiw.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uc3m.tiw.dominios.Producto;
import es.uc3m.tiw.dominios.Usuario;

public interface ProductoDao extends JpaRepository<Producto, Long>{

	List<Producto> findAll();
	Producto findByIdProducto(int idProducto);
	List<Producto> findByCategoria(String categoria);
	List<Producto> findByUsuario(int usuario);
	List<Producto> findByTitulo(String titulo);


}
