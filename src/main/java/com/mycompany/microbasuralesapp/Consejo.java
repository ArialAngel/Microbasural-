/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.microbasuralesapp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Luz Pinto Castillo
 * @author Sebastian Henriquez Cartagena
 */
public class Consejo {
    
    //Globales
    private ArrayList<Consejo>LConsejo=new ArrayList<Consejo>();
    
    //Atributos
    
    private String Info;
    private int ID;
    private String Titulo;
    
    /**
     * 
     * @param Info
     * @param ID
     * @param Titulo 
     */
    public Consejo(String Info, int ID, String Titulo) {
        this.Info = Info;
        this.ID = ID;
        this.Titulo = Titulo;
    }

    public Consejo() {
        LConsejo=new ArrayList<Consejo>();
    }
    
    
    //Accesores
    
    /**
     * 
     * @return 
     */
    public String getInfo(){
        return Info;
    }
    
    public int getID(){
        return ID;
    }
    /**
     * 
     * @return 
     */
    public String getTitulo(){
        return Titulo;
    }
    
    //Mutadores
    
    /**
     * 
     * @param Info1 
     */
    public void setInfo(String Info1){
        Info = Info1;
    }
    /**
     * 
     * @param ID1 
     */
    public void setID(int ID1){
        ID = ID1;
    }
    /**
     * 
     * @param Titulo1 
     */
    public void setTitulo(String Titulo1){
        Titulo = Titulo1;
    }
    
    //Comportamiento
    
    /**
     * 
     * @param Objeto 
     */
    public void Crear(Consejo Objeto){
        //Crea un objeto de tipo microbasural
        Scanner Entrada=new Scanner(System.in);
        System.out.println("Escriba aqui su consejo ");
        Objeto.Info= Entrada.next();
        
        System.out.println("Inserte El titulo ");
        Objeto.Titulo= Entrada.next();
        
        LConsejo.add(Objeto);
        
        System.out.println("Creado con exito!!");  
        
        /*La ID no se agrego al codigo porque genero error. Esta variable se agregara proximamente
        -Preguntar a la profesora sobre la creacion de ID aleatorios (IMPORTANTE)*/
    }
    
    public class OperacionEnArchivo{
        public static void CrearArchivo(ArrayList LConsejo){
        FileWriter flwriter=null;
        try{
            //Se usa para escribir en el archivo
            flwriter=new FileWriter("C:\\Users\\Luz\\Desktop\\MicroBasuralesApp\\src\\test\\java\\Comsejos.txt");
            //creacion de buffer
            BufferedWriter bfwriter=new BufferedWriter(flwriter);
            for(Consejo consejos :(ArrayList<Consejo>)LConsejo){
                //escribe los datos en archivo
                bfwriter.write(consejos.getInfo()+";"+consejos.getTitulo());
            }
            //cierra el buffer
            bfwriter.close();
            System.out.println("Archivo Creado :)");
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(flwriter!=null){
                try{
                    flwriter.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
        public static ArrayList leerArchivo() {
            // crea el flujo para leer desde el archivo
            File file = new File("C:\\Users\\Luz\\Desktop\\MicroBasuralesApp\\src\\test\\java\\Consejos.txt");
            ArrayList LConsejo= new ArrayList<>();
            Scanner scanner;
            try {
                //se pasa el buffer al objeto scanner
                scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    // el objeto scanner lee linea a linea desde el archivo
                    String linea = scanner.nextLine();
                    Scanner delimitar = new Scanner(linea);
                    //se usa una expresión regular
                    //que valida que antes o despues de una punto y coma (;) exista cualquier cosa
                    //parte la cadena recibida cada vez que encuentre una coma
                    delimitar.useDelimiter("|\\s*;|\\s*");
                    Consejo e= new Consejo();
                    e.setInfo(delimitar.next());
                    e.setTitulo(delimitar.next());
                    
                    LConsejo.add(e);
                }
                //se cierra el ojeto scanner
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return LConsejo;
        }
        /**
         * 
         * @param LConsejo 
         */
        public static void aniadirDatosArchivo(ArrayList LConsejo) {
            FileWriter flwriter = null;
            try {//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 
                flwriter = new FileWriter("C:\\Users\\Luz\\Desktop\\MicroBasuralesApp\\src\\test\\java\\Consejos.txt", true);
                BufferedWriter bfwriter = new BufferedWriter(flwriter);
                for(Consejo consejos :(ArrayList<Consejo>)LConsejo) {
                    //escribe los datos en el archivo
                    bfwriter.write(consejos.getInfo()+";"+ consejos.getTitulo());
                }
                bfwriter.close();
                System.out.println("Archivo modificado ;)");

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (flwriter != null) {
                    try {
                        flwriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }             
    }
    /**
     * 
     * @param Titulo 
     */
    public Consejo BuscarInfo(String titulo){
        
        for(int i=0;i<LConsejo.size();i++){
            if(LConsejo.get(i).Titulo.equals(titulo)){
                System.out.println(LConsejo.get(i).Titulo);
                System.out.println(LConsejo.get(i).Info);
                return LConsejo.get(i);
            }
        }
        return null;
    }
    /**
     * 
     * @param ID 
     */
    public void EliminarInfo(int ID){
        System.out.println("Eliminar Info "+ ID);
    }
    //Proximamente noticias con relacion a el cambio climatico y reciclaje.
    
    public void MostrarConsejos(){
        
        for(int i =0;i<LConsejo.size();i++){
                System.out.println(LConsejo.get(i).Titulo);
                System.out.println(LConsejo.get(i).Info);
                System.out.println("");
        }
    }
}
