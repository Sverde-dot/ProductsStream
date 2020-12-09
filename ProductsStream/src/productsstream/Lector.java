package productsstream;
import java.io.*;

public class Lector {
     public static void Escribir(File entrada, Producto product){
         File f;
         DataOutputStream salida=null;
         try{
             salida=new DataOutputStream(new FileOutputStream(entrada));
             salida.writeUTF(product.getCodigo());
             salida.writeUTF(product.getDescripcion());
             salida.writeDouble(product.getPrecio());
         }catch(IOException e){
            System.out.println("error al abrir el archivo");
         }finally {
            try {
                if (salida != null) {
                    salida.close();
                }
            } catch (IOException e2) {
                System.out.println("Error al cerrar el archivo");
            }
         }
     }
     public static void Agregar(File entrada, Producto product){
        DataOutputStream salida=null;
        try {
            salida = new DataOutputStream(new FileOutputStream(entrada,true));
            salida.writeUTF(product.getCodigo());
            salida.writeUTF(product.getDescripcion());
            salida.writeDouble(product.getPrecio());
        }catch(IOException e){
            System.out.println("hubo un error al abrir el archivo");
        }finally {
            try {
                if (salida != null) {
                    salida.close();
                }
            } catch (IOException e2) {
                System.out.println("Error al cerrar el archivo");
            }
        }
    }
     public static void Leer(DataInputStream entrada, Producto product){
        try {
            if(entrada.available() != 0){
                product.setCodigo(entrada.readUTF());
                product.setDescripcion(entrada.readUTF());
                product.setPrecio(entrada.readDouble());
            }
        }catch(IOException e){
            System.out.println("error al abrir el archivo");
        }
    }
}

