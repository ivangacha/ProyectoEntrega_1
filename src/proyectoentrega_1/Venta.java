package proyectoentrega_1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PRIVATE
 */
public class Venta {
    
    private Vendedor vendedor;
    private Producto producto;
    private int cantidadProducto;

    public Venta() {
    }

    public Venta(Vendedor vendedor, Producto producto, int cantidadProducto) {
        this.vendedor = vendedor;
        this.producto = producto;
        this.cantidadProducto = cantidadProducto;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    @Override
    public String toString() {
        return "Venta:\n"+vendedor.getTipoDocumento()+";"+vendedor.getNumeroDocumento()+"\n"+producto.getId()+";"+cantidadProducto;
    }
    
    
    
}
