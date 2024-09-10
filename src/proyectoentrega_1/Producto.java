/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoentrega_1;

//Creacion de la clase producto
public class Producto {
    
    //Atributos de la clase Producto: id, nombreProducto, precioPorUnidad
    private int id;
    private String nombreProducto;
    private Double precioPorUnidad;
    
    //Constructor vacio
    public Producto() {
    }
    
    //Constructor con todos los atributos
    public Producto(int id, String nombreProducto, Double precioPorUnidad) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.precioPorUnidad = precioPorUnidad;
    }
    
    //Metodos Get y Set de los 3 atributos de la clase
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
    
    //Metodo para la impresion con el formato que se requiere
    public void mostrarInformacion(){
        
        System.out.println(id+";"+nombreProducto+";"+precioPorUnidad);
    
    }
    
}
