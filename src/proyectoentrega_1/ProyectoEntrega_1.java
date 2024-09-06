/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoentrega_1;

/**
 *
 * @author PRIVATE
 */
public class ProyectoEntrega_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Vendedor vendedor1 = new Vendedor();
        vendedor1.setTipoDocumento("cedula");
        vendedor1.setNumeroDocumento("1013607757");
        vendedor1.setNombres("Ivan Javier");
        vendedor1.setApellidos("Gachancipa Manrique");
        
        Vendedor vendedor2 = new Vendedor("cedula", "1067813753", "Jessica Julieth", "Narvaez Cadena");
        
        System.out.println("Vendedor 1: "+vendedor1.getTipoDocumento()+";"+vendedor1.getNumeroDocumento()+";"+vendedor1.getNombres()+";"+vendedor1.getApellidos());
        System.out.println("Vendedor 2: "+vendedor2.getTipoDocumento()+";"+vendedor2.getNumeroDocumento()+";"+vendedor2.getNombres()+";"+vendedor2.getApellidos());
        
        System.out.println(vendedor1.toString());
        
    }
    
}
