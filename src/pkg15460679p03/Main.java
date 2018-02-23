/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg15460679p03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import vistas.VistaPrincipal;

/**
 *
 * @author mendo
 */
public class Main {

    
    //Este método es para crear un nuevo archivo .txt, también funciona como guardado del mismo
    public static void nuevoTXT(String ruta, String texto){
        try{            
            if(texto.equals("")){
                texto = " ";   //Esto evita marcar un error al intentar abrir un archivo que no contenga nada, le damos un espaciado para así poder detectarlo
            }            
            File f = new File(ruta);   //Se crea el archivo txt
            
            FileWriter w = new FileWriter(f);  //Se abre el archivo txt en ambos casos para después dar acceso sobre la escritura sobre ellos
            
            BufferedWriter bw = new BufferedWriter(w);   //Se usa buffered como herramienta de archivos en ambos casos
            
            PrintWriter pw = new PrintWriter(bw);                                   //Esto es para poder escribir sobre los archivos                                                
            bw.write(texto);                                                                   //Se escribe dentro del archivo
            bw.newLine();
            pw.close();                                                                         //Se cierran tanto como la escritura como el documento en ambos archivos para que se guarden            
            bw.close();
            
        }catch(Exception e){
            System.out.println("Ha sucedido un error "+e);
        }
    }
    
    //Método que abre cualquier documento .txt
    public static String abrirTXT(String ruta) throws IOException{
        try {                        
            FileReader fr = new FileReader(ruta);     //Buscamos el archivo txt               
            if (fr.ready()){                              //Aquí se entra si el archivo existe                
                BufferedReader bf = new BufferedReader(fr);    //Preparamos el archivo                                                                
                    String lineas, texto = "";                    
                    while ((lineas = bf.readLine()) != null) {                        //Lee el fichero linea a linea hasta llegar a la ultima
                        texto = texto + lineas + "\n";                   //Imprime la linea leida
                    }                        
                return texto;                   //Regresa el archivo con todas las lineas
            }else{
                return "";                   //No regresamos nada si el archivo no existe
            }                                    
        } catch (FileNotFoundException ex) {                        
            return "";                     //Cualquier error no regresa algún valor en String
        }
    }
    
    
    public static void main(String[] args) throws IOException {
        VistaPrincipal vp = new VistaPrincipal();   
        vp.setVisible(true);  //Abrimos la ventana principal        
    }
    
}
