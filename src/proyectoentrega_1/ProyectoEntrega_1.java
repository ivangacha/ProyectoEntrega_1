/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoentrega_1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author PRIVATE
 */
public class ProyectoEntrega_1 {
    
    public static void main(String[] args) {
        
        //Llamada al metodo borrarArchivosCSV para eliminar los archivos existentes
        borrarArchivosCSV();
        
        //Se crea la variable scanner para obtener los datos ingresados por consola
        Scanner scanner = new Scanner(System.in);
        
        //Llamada al metodo menu para mostrar las diferentes opciones
        mostarMenu(scanner);
        
        //Mensaje final de finalizacion del programa
        System.out.println("Programa finalizado con exito");
        
    }
    
    //Metodo para eliminar los archivos que esten creados
    public static void borrarArchivosCSV(){
        
        //Nombres de los archivos a eliminar
        String [] archivosCSV = {"vendedores.csv", "productos.csv", "recaudacion_vendedores.csv"};
        
        //Ciclo para intentar borrar cada uno de los archivos
        for (String nombreArchivo : archivosCSV){
            File archivo = new File(nombreArchivo);
            
            if (archivo.exists()){
                if (archivo.delete()){
                    System.out.println("El archivo: " + nombreArchivo + " fue borrado exitosamente.");
                } else{
                    System.out.println("No se pudo eliminar el archivo " +nombreArchivo);
                }
            } else{
                System.out.println("El archivo " + nombreArchivo + " no existe.");
            }
        }
        
    }
    
    //Menu **********************************************
    
    //Metodo para encapsular el menu
    public static void mostarMenu(Scanner scanner){
        
        //Creacion de una lista para ingresar la informacion de los vendedores
        List<Vendedor> listaVendedores = new ArrayList<>();
        
        //Creacion de una lista para ingresar la informacion de los productos
        List<Producto> listaProductos = new ArrayList<>();
        
        //Creacion de una lista para ingresar la informacion de las ventas
        List<Venta> listaVentas = new ArrayList<>();
        
        int opcion = 0;
        
        //Ciclo para las diferentes opciones del menu, el ciclo se repite hasta el usuario elija la opcion de salida
        while (opcion != 9){
            System.out.println("\n---- MENU ----");
            System.out.println("1. Agregar vendedor");
            System.out.println("2. Listar vendedores");
            System.out.println("3. Generar archivo CSV de vendedores");
            System.out.println("4. Agregar producto");
            System.out.println("5. Listar productos");
            System.out.println("6. Generar archivo CSV de productos");
            System.out.println("7. Agregar venta");
            System.out.println("8. Generar archivo CSV de ventas, ordenados de mayor a menor");
            System.out.println("9. Salir");
            System.out.println("Seleccione una opcion: ");
            
            //Leer la opcion ingresada por el usuario
            opcion = scanner.nextInt();
            
            scanner.nextLine();
            
            //Por medio de un switch se ejecuta el codigo basado en la opcion que el usuario elija
            switch (opcion) {
                case 1:
                    System.out.println("Has escogido la opcion 1.");
                    
                    //Llamada al metodo agregarVendedor para ingresar la informacion de los vendedores
                    agregarVendedor(listaVendedores, scanner);
                    
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
                    
                    //Llamada al metodo agregarProducto para ingresar la informacion de los productos
                    agregarProducto(listaProductos, scanner);
                    
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
                    System.out.println("Has escogido la opcion 7.");
                    
                    //Llamada al metodo agregarVenta para ingresar la informacion de las ventas por vendedor
                    agregarVenta(listaVentas, listaVendedores, listaProductos, scanner);
                    
                    pausaYLimpiarConsola();
                    break;
                case 8:
                    System.out.println("Has escogido la opcion 8.");
                    
                    //Llamada al metodo generarArchivoRecaudacionPorVendedor para generar el archivo CSV con la información de las ventas por vendedor
                    generarArchivoRecaudacionPorVendedor(listaVentas, "recaudacion_vendedores.csv");
                    
                    pausaYLimpiarConsola();
                    break;
                case 9:
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
    
    //Metodos para vendedores **********************************************
    
    //Metodo agregarVendedor que permite ingresar la informacion de cada vendedor
    public static void agregarVendedor(List<Vendedor> listaVendedores, Scanner scanner){
    
        //Variable que controla la condicion del while
        boolean bandera = true;

        //Ciclo que controla el ingreso de los vendedores
        while(bandera){

            System.out.println("Ingrese la informacion del vendedor:");

            //Se pide por consola ingresar el tipo del documento y se almacena en la variable tipoDocumento
            System.out.println("Tipo de documento (ti/cc/te): ");
            String tipoDocumento = scanner.nextLine();

            //Variable que controla la condicion del while
            boolean validador = true;
            //Variable numeroDocumento que almacenara en numero de documento del vendedor
            String numeroDocumento = "";

            //Ciclo que controla que no se ingrese una cedula repetida
            while(validador){

                //Se pide por consola ingresar el numero del documento y se almacena en la variable numeroDocumento
                System.out.println("Numero de documento: ");
                numeroDocumento = scanner.nextLine();

                //Variable para saber si el documento ya existe
                boolean documentoRepetido = false;
                //Ciclo para verificar si ya existe un vendedor con el mismo numero de documento
                for (Vendedor v : listaVendedores){
                    if (v.getNumeroDocumento().equals(numeroDocumento)){
                        System.out.println("Error: Ya existe un vendedor con ese numero de documento.");
                        documentoRepetido = true;
                        //Sale del ciclo si encuentra un documento repetido
                        break;
                    }
                }

                if (!documentoRepetido){

                    //Sale del ciclo si el documento ingresado no esta repetido en la lista
                    validador = false;

                }

            }

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

            //Se pregunta al usuario si desea ingresar de otro vendedor, de lo contrario finaliza el ciclo
            System.out.println("Desea ingresar informacion de otro vendedor (si/no): ");
            String respuesta = scanner.nextLine();
            bandera = respuesta.equalsIgnoreCase("si");

        }

    }
    
    //Metodo listarVendedores que permite imprimir la informacion de los vendedores
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
    
    //Metodos para productos **********************************************
    
    //Metodo agregarProducto que permite ingresar la informacion de cada producto
    public static void agregarProducto(List<Producto> listaProductos, Scanner scanner){
        
        //Variable que controla la condicion del while
        boolean bandera = true;
        
        //Ciclo que controla el ingreso de los productos
        while(bandera){

            System.out.println("Ingrese la informacion del producto:");
            
            //Variable que controla la condicion del while
            boolean validador = true;
            
            //Variable id que almacenara el ID del producto a ingresar
            int id = 0;
            
            //Ciclo que controla que no se ingrese un id repetido
            while (validador){
                
                //Se pide por consola ingresar el ID y se almacena en la variable id
                System.out.println("Id: ");
                id = scanner.nextInt();
                
                //Consumir el salto de línea pendiente después de nextInt
                scanner.nextLine();
                
                //Variable para saber si el ID ya existe
                boolean idRepetido = false;
                //Ciclo para verificar si ya existe un producto con el mismo numero de ID
                for (Producto p : listaProductos) {
                    if (p.getId() == id) {
                    System.out.println("Error: Ya existe un producto con ese ID.");
                    idRepetido = true;
                    break;
                    }
                }
                
                if (!idRepetido){
                    
                    //Sale del ciclo si el ID ingresado no esta repetido en la lista
                    validador = false;
                }
                
            }

            //Se pide por consola ingresar el nombre del producto y se almacena en la variable nombreProducto
            System.out.println("Nombre del producto: ");
            String nombreProducto = scanner.nextLine();
            
            //Variable que controla la condicion del while
            bandera = true;
            
            //Variable id que almacenara el ID del producto a ingresar
            Double precioPorUnidad = 0.0;
            
            //Ciclo que controla que no se ingrese un valor de producto negativo
            while (bandera){
                
                //Se pide por consola ingresar el precio de la unidad y se almacena en la variable precioPorUnidad
                System.out.println("Precio por unidad: ");
                precioPorUnidad = scanner.nextDouble();
            
                //Consumir el salto de línea pendiente después de nextDouble
                scanner.nextLine();
                
                //Condicional que verifica que el precio de la unidad no sea negativo
                if (precioPorUnidad < 0){
                    System.out.println("El precio por unidad no puede ser negativo");
                }else{
                    bandera = false;
                }
                
            }

            //Se crea un objeto de tipo producto
            Producto producto = new Producto(id, nombreProducto, precioPorUnidad);

            //El objeto creado se agrega a la lista productos
            listaProductos.add(producto);

            //Se pregunta al usuario si desea ingresar de otro producto, de lo contrario finaliza el ciclo
            System.out.println("Desea ingresar informacion de otro producto (si/no): ");
            String respuesta = scanner.nextLine();
            bandera = respuesta.equalsIgnoreCase("si");

        }

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
    
    //Metodos para ventas **********************************************
    
    //Metodo agregarProducto que permite ingresar la informacion de cada producto
    public static void agregarVenta(List<Venta> listaVentas, List<Vendedor> listaVendedores, List<Producto> listaProductos, Scanner scanner){
        
        //Variable que controla la condicion del while
        boolean bandera = true;

        //Ciclo que controla el registro de las ventas
        while(bandera){
            
            System.out.println("Ingrese la informacion de la venta:");
            
            //Se declara la variable de tipo Vendedor y se inicializa con el valor null
            Vendedor vendedorEncontrado = null;
            
            //Ciclo que controla que no se ingrese un numero de cedula de un vendedor no existente
            while (vendedorEncontrado == null){
                
                //Se pide por consola ingresar la cedula del vendedor
                System.out.println("Ingrese el numero de cedula del vendedor: ");
                String numeroDocumento = scanner.nextLine();
                
                //Ciclo for que busca la cedula ingresada en la listaVendedores
                for (Vendedor v : listaVendedores){
                    //Condicional que compara el numero de cedula con el almacenado en la lista
                    if (v.getNumeroDocumento().equals(numeroDocumento)){
                        //Si la cedula existe se asigna al objeto vendedorEncontrado
                        vendedorEncontrado = v;
                        break;
                    }
                }
                //Si el numero de cedula no existe, se solicita nuevamente ingresar la informacion
                if (vendedorEncontrado == null){
                    System.out.println("Error: No existe un vendedor con ese numero de documento, por favor intentelo de nuevo.");
                }
            }
            
            //Se declara la variable de tipo Producto y se inicializa con el valor null
            Producto productoEncontrado = null;
            
            //Ciclo que controla que no se ingrese un ID de un producto no existente
            while (productoEncontrado == null){
                
                //Se pide ingresar el ID del producto
                System.out.println("Ingrese el ID del producto: ");
                int id = scanner.nextInt();
                
                //Consumir el salto de línea pendiente después de nextInt
                scanner.nextLine();
                
                //Ciclo for que busca el ID ingresado en la listaproductos
                for (Producto p : listaProductos){
                    //Condicional que compara el numero de ID con el almacenado en la lista
                    if (p.getId() == id){
                        //Si el ID existe se asigna al objeto productoEncontrado
                        productoEncontrado = p;
                        break;
                    }
                }
                //Si el ID no existe, se solicita nuevamente ingresar la informacion
                if (productoEncontrado == null){
                    System.out.println("Error: No existe un producto con ese numero de ID, por favor intentelo de nuevo.");
                }
            }
            
            //Se pide por consola ingresar la cantidad vendida del producto y se almacena en la variable cantidadProducto
            System.out.println("Ingrese la cantidad vendida: ");
            int cantidadProducto = scanner.nextInt();
            
            //Consumir el salto de línea pendiente después de nextInt
            scanner.nextLine();
            
            //Se crea un objeto de tipo venta
            Venta venta = new Venta(vendedorEncontrado, productoEncontrado, cantidadProducto);

            //El objeto creado se agrega a la lista de ventas
            listaVentas.add(venta);

            //Se pregunta al usuario si desea ingresar otro vendedor, de lo contrario finaliza el ciclo
            System.out.println("Desea ingresar informacion de otro venta (si/no): ");
            String respuesta = scanner.nextLine();
            bandera = respuesta.equalsIgnoreCase("si");
            
        }
        
    }
    
    //Metodo generarArchivoRecaudacionPorVendedor que permite calcular la cantidad de dinero recaudado por vendedor y ordenarlos de menos a mayor y genera el archivo CSV correspondiente
    public static void generarArchivoRecaudacionPorVendedor(List<Venta> listaVentas, String nombreArchivo) {
        
        // Calcular la cantidad de dinero recaudado por cada vendedor
        Map<Vendedor, Double> recaudacionPorVendedor = new HashMap<>();
        for (Venta venta : listaVentas) {
            Vendedor vendedor = venta.getVendedor();
            double totalVenta = venta.getProducto().getPrecioPorUnidad() * venta.getCantidadProducto();
            recaudacionPorVendedor.put(vendedor, recaudacionPorVendedor.getOrDefault(vendedor, 0.0) + totalVenta);
        }

        // Ordenar los vendedores por cantidad de dinero recaudado, de mayor a menor
        List<Map.Entry<Vendedor, Double>> listaRecaudacion = new ArrayList<>(recaudacionPorVendedor.entrySet());
        listaRecaudacion.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Crear el archivo CSV
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            for (Map.Entry<Vendedor, Double> entry : listaRecaudacion) {
                Vendedor vendedor = entry.getKey();
                double recaudacion = entry.getValue();
                writer.write(vendedor.getNombres()+ ";" +vendedor.getApellidos()+ ";" + recaudacion + "\n");
            }
            System.out.println("Archivo generado exitosamente: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al generar el archivo: " + e.getMessage());
        }
    }
    
}
