/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoentrega_1;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author PRIVATE
 */
public class ProyectoEntrega_1 {
    
    public static void main(String[] args) {
        
        //Se crea la variable scanner para obtener los datos ingresados por consola
        Scanner scanner = new Scanner(System.in);
        
        //Creacion de una lista para ingresar la informacion de los vendedores
        List<Vendedor> listaVendedores = new ArrayList<>();
        
        //Variable que controla la condicion del while
        boolean bandera = true;
        
        //Ciclo que controla el ingreso de los vendedores
        while(bandera){
            
            //Se utiliza el metodo agregarVendedor
            agregarVendedor(listaVendedores, scanner);
            
            //Se pregunta al usuario si desea ingresar de otro vendedor, de lo contrario finaliza el ciclo
            System.out.println("Desea ingresar informacion de otro vendedor (si/no): ");
            String respuesta = scanner.nextLine();
            bandera = respuesta.equalsIgnoreCase("si");
            
        }
        
        listarVendedores(listaVendedores);
        
    }
    
    //Metodo agregarVendedor que permite ingresar la informacion de cada vendedor
    public static void agregarVendedor(List<Vendedor> listaVendedores, Scanner scanner){
        
        System.out.println("Ingrese la informacion del vendedor:");
        
        //Se pide por consola ingresar el tipo del documento y se almacena en la variable tipoDocumento
        System.out.println("Tipo de documento (ti/cc/te): ");
        String tipoDocumento = scanner.nextLine();
        
        //Se pide por consola ingresar el numero del documento y se almacena en la variable numeroDocumento
        System.out.println("Numero de documento: ");
        String numeroDocumento = scanner.nextLine();
        
        //Se pide por consola ingresar los nombres y se almacenan en la variable nombres
        System.out.println("Nombres: ");
        String nombres = scanner.nextLine();
        
        //Se pide por consola ingresar los apellidos y se almacenan en la variable apellidos
        System.out.println("Apellidos: ");
        String apellidos = scanner.nextLine();
        
        //Se crea un objeto de tipo vendedor
        Vendedor vendedor = new Vendedor(tipoDocumento, numeroDocumento, nombres, apellidos);
        
        //El objeto creado se agrega a la lista vendedores
        listaVendedores.add(vendedor);
        
    }
    
    //Metodo listarVendedores que permite imprimir la informacion de los vededores
    public static void listarVendedores(List<Vendedor> listaVendedores){
        
        System.out.println("Lista con la informacion de todos los vendedores: ");
        
        //Ciclo for-each que recorre la lista de los vendedores con toda la informacion del objeto
        for (Vendedor vendedor : listaVendedores) {
            //Se utiliza el metodo mostrarInformacion de la clase vendedor para mostrar la impresion de los datos de los vendedores
            vendedor.mostrarInformacion();
        }
        
    }
    
}
