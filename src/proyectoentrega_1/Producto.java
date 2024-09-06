/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoentrega_1;

/**
 *
 * @author PRIVATE
 */
public class Producto {
    
    int id;
    String nombreProducto;
    Double precioPorUnidad;

    public Producto() {
    }

    public Producto(int id, String nombreProducto, Double precioPorUnidad) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.precioPorUnidad = precioPorUnidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecioPorUnidad() {
        return precioPorUnidad;
    }

    public void setPrecioPorUnidad(Double precioPorUnidad) {
        this.precioPorUnidad = precioPorUnidad;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombreProducto=" + nombreProducto + ", precioPorUnidad=" + precioPorUnidad + '}';
    }
    
}
