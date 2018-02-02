/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author yo
 */
@Entity
@Table(name = "producto")
public class ProductoDeportivo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "p_id")
    private Long id;
    
    @Column(name = "p_nombre")
    private String nombre;
    
    @Column(name = "p_precio")
    private Integer precio;
    
    @Column(name = "p_stock")
    private Integer stock;
    
    @Column(name = "p_descripcion")
    private String descripcion;

    public ProductoDeportivo() {
    }

    public ProductoDeportivo(String nombre, Integer precio, Integer stock, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
    }

    public ProductoDeportivo(Long id, String nombre, Integer precio, Integer stock, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "ProductoDeportivo{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + ", descripcion=" + descripcion + '}';
    }
    
    
}
