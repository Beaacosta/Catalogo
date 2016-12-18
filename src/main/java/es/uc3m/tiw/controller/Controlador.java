package es.uc3m.tiw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.uc3m.tiw.daos.ProductoDao;
import es.uc3m.tiw.dominios.Producto;
import es.uc3m.tiw.dominios.Usuario;



@RestController
// La siguiente anotación es necesaria para permitir 
// que diferente dominios puedan usar este microservicio
@CrossOrigin
public class Controlador {
	
	private Producto producto;
	@Autowired
	private ProductoDao dao;
	
	//Buscar un producto en la BBDD por id
	@RequestMapping(value = "/buscar_id", method = RequestMethod.POST)
	public @ResponseBody Producto buscarId(@RequestBody int idProducto){
		Producto p = null;
		p = dao.findByIdProducto(idProducto);
		return p;
	}
	
	//Buscar los productos de un usuario en la BBDD
	@RequestMapping(value = "/productos_usuario", method = RequestMethod.POST)
	public @ResponseBody List<Producto> productosUsuario(@RequestBody Usuario usuario_ses){
		int usuario = usuario_ses.getId();
		List<Producto> productos= null;
		productos = dao.findByUsuario(usuario);
		return productos;
	}
	
	//Listar todos los productos de la BBDD
	@RequestMapping(value = "/listar_productos", method = RequestMethod.POST)
	public @ResponseBody List<Producto> productosUsuario(){
		List<Producto>productos=null;
		productos = dao.findAll();
		return productos;
	}
	
	//Listar productos de una categoria
	@RequestMapping(value = "/productos_categoria", method = RequestMethod.POST)
	public List<Producto> productosCategoria(@RequestBody String categoria){
		List<Producto >productos = dao.findByCategoria(categoria);
		return productos;
	}
	
	//Eliminar un producto
	@RequestMapping(value = "/eliminar_producto", method = RequestMethod.POST)
	public void eliminarProducto(@RequestBody int idProducto){
		producto = dao.findByIdProducto(idProducto);
		dao.delete(producto);
	}
		
	//Añadir un usuario
	@RequestMapping(value = "/anyadir_producto", method = RequestMethod.POST)
	public void anyadirProducto(@RequestBody Producto producto){
   dao.save(producto);
	}
	
	//Modificar un producto
	@RequestMapping(value = "/modificar_producto", method = RequestMethod.POST)
	public void modificarProducto(@RequestBody Producto producto){
		dao.save(producto);
	}
	
	//Listar productos de una categoria
	@RequestMapping(value = "/productos_titulo", method = RequestMethod.POST)
	public List<Producto> productosTitulo(@RequestBody String titulo){
		List<Producto >productos = dao.findByTitulo(titulo);
		return productos;
	}
	
}
