/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoentrega_1;

//Creacion de la clase producto
public class Vendedor {
    
    //Atributos de la clase Vendedor: tipoDocumento, numeroDocumento, nombres, apellidos
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombres;
    private String apellidos;
    
    //Constructor vacio
    public Vendedor() {
    }
    
    //Constructor con todos los atributos
    public Vendedor(String tipoDocumento, String numeroDocumento, String nombres, String apellidos) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }
    
    //Metodos Get y Set de los 4 atributos de la clase
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    //Metodo para la impresion con el formato que se requiere
    public void mostrarInformacion(){
        
        System.out.println(tipoDocumento+";"+numeroDocumento+";"+nombres+";"+apellidos);
    
    }
    
}
