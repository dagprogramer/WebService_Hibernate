/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.servicio;

import ar.com.dao.ProductoDeportivoDao;
import ar.com.manager.SessionManager;
import ar.com.modelo.ProductoDeportivo;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.hibernate.SessionFactory;

/**
 *
 * @author yo
 */
@WebService(serviceName = "WSProductoDeportivo")
public class WSProductoDeportivo {
SessionFactory factory=SessionManager.getSession();
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "ingresarProducto")
    public String ingresarProducto(@WebParam(name = "nombre")String nombre,@WebParam(name = "precio")Integer precio,@WebParam(name = "stock")Integer stock,@WebParam(name = "descripcion")String descripcion) {
        ProductoDeportivo producto=new ProductoDeportivo(nombre, precio, stock, descripcion);
            ProductoDeportivoDao dao=new ProductoDeportivoDao(factory);
            dao.ingresarProducto(producto);
        return "El producto ha sido ingresado a la base de datos con exito";
    }
    
    @WebMethod(operationName = "consultarProducto")
    public String consultarProducto(@WebParam(name = "codigo")Long codigo){
        ProductoDeportivoDao dao=new ProductoDeportivoDao(factory);
            return dao.consultarProducto(codigo);
    }
    
    @WebMethod(operationName = "verProductos")
    public List<ProductoDeportivo>verProductos(){
        ProductoDeportivoDao dao=new ProductoDeportivoDao(factory);
            List<ProductoDeportivo>lista=dao.verProductos();
            return lista;
    }
}
