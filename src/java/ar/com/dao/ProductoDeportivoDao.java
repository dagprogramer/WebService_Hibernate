/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dao;

import ar.com.manager.SessionManager;
import ar.com.modelo.ProductoDeportivo;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author yo
 */
public class ProductoDeportivoDao {
private SessionFactory factory;

    public ProductoDeportivoDao(SessionFactory factory) {
        if(factory==null){
            throw new RuntimeException("Session Cerrada");
        }
        this.factory = factory;
    }
    
    
    public void ingresarProducto(ProductoDeportivo producto){
        Session session=null;
        Transaction tx=null;
        try {
            session=factory.openSession();
            tx=session.beginTransaction();
            session.save(producto);
            tx.commit();
        } catch (HibernateException e) {
            if(tx!=null){
                tx.rollback();
                throw new RuntimeException("No se pudo insertar el producto en la base de datos");
            }
        }finally{
            if(session!=null){
                session.close();
            }
        }
        
    }
    
    public String consultarProducto(Long id){
        Session session=factory.openSession();
        ProductoDeportivo producto=(ProductoDeportivo) session.get(ProductoDeportivo.class, id);
        session.close();
        if(producto!=null){
            return "Producto[codigo:"+producto.getId()+",nombre:"+producto.getNombre()+",precio:"+producto.getPrecio()+",stock:"+producto.getStock()+",descripcion:"+producto.getDescripcion()+"]";
        }else{
            return "El producto de codigo:"+id+",no existe en las base de datos";
        }
    }
    
    public List<ProductoDeportivo>verProductos(){
        Session session=factory.openSession();
        String query="from ProductoDeportivo";
        Query q=session.createQuery(query);
        List<ProductoDeportivo>lista=q.list();
        session.close();
        return lista;
    }
    
}
