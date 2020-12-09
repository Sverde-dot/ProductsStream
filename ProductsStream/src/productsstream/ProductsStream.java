package productsstream;

import java.io.*;

public class ProductsStream {

    public static void main(String[] args) {
        DataInputStream entrada=null;
        File archivo=new File("productos.txt");
        Producto pr1=new Producto("cod1","tornillos",3);
        Producto pr2=new Producto("cod2","clavos",4);
        Producto pr3=new Producto();
        Lector.Escribir(archivo, pr1);
        Lector.Agregar(archivo, pr2);
        try{
            entrada=new DataInputStream(new FileInputStream(archivo));
        }catch(IOException e){
            System.out.println("Error al abrir el archivo");
        }
        System.out.println("Lista añadida a " +archivo.getName());
        try {
            do {
                Lector.Leer(entrada, pr3);
                System.out.println(pr3.getCodigo()+" "+pr3.getDescripcion()+" "+pr3.getPrecio());
            }while (entrada.available() != 0);
            if(entrada.available() == 0){
                entrada.close();
            }
        }catch (IOException e2){
            System.out.println("Error al operar con el archivo");
        }
    }  
}
