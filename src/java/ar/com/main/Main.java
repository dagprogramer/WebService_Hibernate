/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.main;

import ar.com.dao.ProductoDeportivoDao;
import ar.com.manager.SessionManager;
import ar.com.modelo.ProductoDeportivo;
import org.hibernate.SessionFactory;

/**
 *
 * @author yo
 */
public class Main {
    public static void main(String[] args) {
        /*
        SessionFactory factory=SessionManager.getSession();
        try{
            ProductoDeportivo productoDeportivo=new ProductoDeportivo("Zapatilla Nyke", 1600, 120, "Calzado Deportivo");
            
            ProductoDeportivoDao dao=new ProductoDeportivoDao(factory);
            dao.ingresarProducto(productoDeportivo);
            String datos=dao.consultarProducto(2L);
            System.out.println(datos);
        }finally{
            factory.close();
        }
        */        
    }
}
