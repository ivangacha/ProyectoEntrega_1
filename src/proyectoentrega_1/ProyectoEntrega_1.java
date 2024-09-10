/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoentrega_1;

import java.io.FileWriter;
import java.io.IOException;
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
        
        //Llamada al metodo menu para mostrar las diferentes opciones
        mostarMenu(scanner);
        
        //Mensaje final de finalizacion del programa
        System.out.println("Programa finalizado con exito");
        
    }
    
    //Menu
    
    //Metodo para encapsular el menu
    public static void mostarMenu(Scanner scanner){
        
        //Creacion de una lista para ingresar la informacion de los vendedores
        List<Vendedor> listaVendedores = new ArrayList<>();
        
        //Creacion de una lista para ingresar la informacion de los productos
        List<Producto> listaProductos = new ArrayList<>();
        
        int opcion = 0;
        
        //Ciclo para las diferentes opciones del menu, el ciclo se repite hasta el usuario elija la opcion de salida
        while (opcion != 7){
            System.out.println("\n---- MENU ----");
            System.out.println("1. Agregar vendedor");
            System.out.println("2. Listar vendedores");
            System.out.println("3. Generar archivo CSV de vendedores");
            System.out.println("4. Agregar producto");
            System.out.println("5. Listar productos");
            System.out.println("6. Generar archivo CSV de productos");
            System.out.println("7. Salir");
            System.out.println("Seleccione una opcion: ");
            
            //Leer la opcion ingresada por el usuario
            opcion = scanner.nextInt();
            
            scanner.nextLine();
            
            //Por medio de un switch se ejecuta el codigo basado en la opcion que el usuario elija
            switch (opcion) {
                case 1:
                    System.out.println("Has escogido la opcion 1.");
                    
                    //Variable que controla la condicion del while
                    boolean bandera = true;
        
                    //Ciclo que controla el ingreso de los vendedores
                    while(bandera){

                        //Llamada al metodo agregarVendedor para ingresar la informacion de los vendedores
                        agregarVendedor(listaVendedores, scanner);

                        //Se pregunta al usuario si desea ingresar de otro vendedor, de lo contrario finaliza el ciclo
                        System.out.println("Desea ingresar informacion de otro vendedor (si/no): ");
                        String respuesta = scanner.nextLine();
                        bandera = respuesta.equalsIgnoreCase("si");

                    }
                    
                    pausaYLimpiarConsola();
                    break;
                case 2:
                    System.out.println("Has escogido la opcion 2.");
                    
                    //Llamada al metodo listarVendedores para imprimir la informacion de los vendedores
                    listarVendedores(listaVendedores);
                    
                    pausaYLimpiarConsola();
                    break;
                case 3:
                    System.out.println("Has escogido la opcion 3.");
                    
                    //Llamada al metodo generarVendedoresCSV para generar el archivo CSV con la información de los vendedores
                    generarVendedoresCSV(listaVendedores, "vendedores.csv");
                    
                    pausaYLimpiarConsola();
                    break;
                case 4:
                    System.out.println("Has escogido la opcion 4.");
                    
                    bandera = true;
        
                    //Ciclo que controla el ingreso de los productos
                    while(bandera){

                        //Llamada al metodo agregarProducto para ingresar la informacion de los productos
                        agregarProducto(listaProductos, scanner);

                        //Se pregunta al usuario si desea ingresar de otro producto, de lo contrario finaliza el ciclo
                        System.out.println("Desea ingresar informacion de otro producto (si/no): ");
                        String respuesta = scanner.nextLine();
                        bandera = respuesta.equalsIgnoreCase("si");

                    }
                    
                    pausaYLimpiarConsola();
                    break;
                case 5:
                    System.out.println("Has escogido la opcion 5.");
                    
                    //Llamada al metodo listarProductos para imprimir la informacion de los productos
                    listarProductos(listaProductos);
                    
                    pausaYLimpiarConsola();
                    break;
                case 6:
                    System.out.println("Has escogido la opcion 6.");
                    
                    //Llamada al metodo generarProductosCSV para generar el archivo CSV con la información de los productos
                    generarProductosCSV(listaProductos, "productos.csv");
                    
                    pausaYLimpiarConsola();
                    break;
                case 7:
                    System.out.println("Saliendo del menu...");
                    break;
                default:
                    System.out.println("La opcion escogida no es valida, intente de nuevo por favor.");
                    pausaYLimpiarConsola();
            }
        }
    }
    
    // Método para simular la limpieza de la consola
    public static void pausaYLimpiarConsola() {
        // Pausa de 2 segundos para que el usuario vea el mensaje antes de limpiar
        try {
            Thread.sleep(2000); // Pausa el programa durante 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Simulación de limpieza: imprimir varias líneas en blanco
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    
    //Metodos para vendedores
    
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
    
    // Metodo para generar el archivo CSV con la informacion de los vendedores
    public static void generarVendedoresCSV(List<Vendedor> vendedores, String archivo) {
        try (FileWriter writer = new FileWriter(archivo)) {
            // Escribir la cabecera del CSV
            writer.append("TipoDocumento,NumeroDocumento,Nombres,Apellidos\n");

            // Escribir la información de cada vendedor
            for (Vendedor vendedor : vendedores) {
                writer.append(vendedor.getTipoDocumento())
                      .append(';')
                      .append(vendedor.getNumeroDocumento())
                      .append(';')
                      .append(vendedor.getNombres())
                      .append(';')
                      .append(vendedor.getApellidos())
                      .append('\n');
            }

            System.out.println("Archivo CSV de vendedores generado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al generar el archivo CSV de vendedores: " + e.getMessage());
        }
    }
    
    //Metodos para productos
    
    //Metodo agregarProducto que permite ingresar la informacion de cada producto
    public static void agregarProducto(List<Producto> listaProductos, Scanner scanner){
        
        System.out.println("Ingrese la informacion del producto:");
        
        //Se pide por consola ingresar el id y se almacena en la variable id
        System.out.println("Id: ");
        int id = scanner.nextInt();
        
        scanner.nextLine();
        
        //Se pide por consola ingresar el nombre del producto y se almacena en la variable nombreProducto
        System.out.println("Nombre del producto: ");
        String nombreProducto = scanner.nextLine();
        
        //Se pide por consola ingresar el precio de la unidad y se almacena en la variable precioPorUnidad
        System.out.println("Precio por unidad: ");
        Double precioPorUnidad = scanner.nextDouble();
        
        scanner.nextLine();
        
        //Se crea un objeto de tipo producto
        Producto producto = new Producto(id, nombreProducto, precioPorUnidad);
        
        //El objeto creado se agrega a la lista productos
        listaProductos.add(producto);
        
    }
    
    //Metodo listarProductos que permite imprimir la informacion de los productos
    public static void listarProductos(List<Producto> listaProductos){
        
        System.out.println("Lista con la informacion de todos los productos: ");
        
        //Ciclo for-each que recorre la lista de los productos con toda la informacion del objeto
        for (Producto producto : listaProductos) {
            //Se utiliza el metodo mostrarInformacion de la clase producto para mostrar la impresion de los datos de los productos
            producto.mostrarInformacion();
        }
        
    }
    
    // Metodo para generar el archivo CSV con la informacion de los vendedores
    public static void generarProductosCSV(List<Producto> productos, String archivo) {
        try (FileWriter writer = new FileWriter(archivo)) {
            // Escribir la cabecera del CSV
            writer.append("IDProducto,NombreProducto,PrecioPorUnidadProducto\n");

            // Escribir la información de cada vendedor
            for (Producto producto : productos) {
                writer.append(Integer.toString(producto.getId()))
                      .append(';')
                      .append(producto.getNombreProducto())
                      .append(';')
                      .append(Double.toString(producto.getPrecioPorUnidad()))
                      .append('\n');
            }

            System.out.println("Archivo CSV de productos generado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al generar el archivo CSV de productos: " + e.getMessage());
        }
    }
    
}
