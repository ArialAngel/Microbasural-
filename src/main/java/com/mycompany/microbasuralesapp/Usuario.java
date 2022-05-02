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
public class Usuario {
    //Globales
    public ArrayList<Usuario> Lusuarios=new ArrayList<Usuario>();
    private ArrayList<Basurero> LBasureros=new ArrayList<Basurero>();
    private ArrayList<MicroBasural> LMicroBasurales=new ArrayList<MicroBasural>();
            
    //Atributos
    private String Nickname;
    private String Nombre;
    private String Correo;
    private String ID;
    
    public Usuario(){
        LBasureros=new ArrayList<Basurero>();
        LMicroBasurales=new ArrayList<MicroBasural>();
    }
    /**
     * 
     * @param Nickname
     * @param Nombre
     * @param Correo
     * @param ID 
     */
    public Usuario(String Nickname, String Nombre, String Correo, String ID) {
        this.Nickname = Nickname;
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.ID = ID;
    }
    
    
    //Accesores
    /**
     * 
     * @return 
     */
    public String getNickname(){
        return Nickname;
    }
    /**
     * 
     * @return 
     */
    public String getNombre(){
        return Nombre;
    }
    /**
     * 
     * @return 
     */
    public String getCorreo(){
        return Correo;
    }
    /**
     * 
     * @return 
     */
    public String getID(){
        return ID;
    }
    
    //Mutadores
    
    /**
     * 
     * @param Nickname1 
     */
    public void setNickname(String Nickname1){
        Nickname = Nickname1;
    }
    /**
     * 
     * @param Nombre1 
     */
    public void setNombre(String Nombre1){
        Nombre = Nombre1;
    }
    /**
     * 
     * @param Correo1 
     */
    public void setCorreo(String Correo1){
        Correo = Correo1;
    }
    /**
     * 
     * @param ID1 
     */
    public void setID(String ID1){
        ID = ID1;
    }
    
    //Comportamientos
    
    /**
     * 
     * @param Objeto 
     */
    public void CrearUsuario(Usuario Objeto){
        
        
        Scanner Entrada=new Scanner(System.in);
        System.out.println("Ingresar un Nickname");
        Objeto.Nickname=Entrada.next();
        
        System.out.println("Ingresar Nombre");
        Objeto.Nombre=Entrada.next();
        
        System.out.println("Ingrese un Correo");
        Objeto.Correo=Entrada.next();
        
        Lusuarios.add(Objeto);
        
        System.out.println("Usuario creado con exito!!");  
        
        //La ID no se agrego al codigo porque genero error. Esta variable se agregara proximamente.
    }
    
    public class OperacionEnArchivo{
        public static void CrearArchivo(ArrayList Lusuarios){
        FileWriter flwriter=null;
        try{
            //Se usa para escribir en el archivo
            flwriter=new FileWriter("C:\\Users\\Luz\\Desktop\\MicroBasuralesApp\\src\\test\\java\\Usuarios.txt");
            //creacion de buffer
            BufferedWriter bfwriter=new BufferedWriter(flwriter);
            for(Usuario usuario :(ArrayList<Usuario>)Lusuarios){
                //escribe los datos en archivo
                bfwriter.write(usuario.getNickname()+";"+usuario.getNombre()+";" +usuario.getCorreo()+";"+usuario.getID());
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
            File file = new File("C:\\Users\\Luz\\Desktop\\MicroBasuralesApp\\src\\test\\java\\Usuarios.txt");
            ArrayList Lusuario= new ArrayList<>();
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
                    Usuario e= new Usuario();
                    e.setNickname(delimitar.next());
                    e.setNombre(delimitar.next());
                    e.setCorreo(delimitar.next());
                    e.setID(delimitar.next());
                    Lusuario.add(e);
                }
                //se cierra el ojeto scanner
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return Lusuario;
        }
        /**
         * 
         * @param Lusuario 
         */
        public static void aniadirDatosArchivo(ArrayList Lusuario) {
            FileWriter flwriter = null;
            try {//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 
                flwriter = new FileWriter("C:\\Users\\Luz\\Desktop\\MicroBasuralesApp\\src\\test\\java\\Usuario.txt", true);
                BufferedWriter bfwriter = new BufferedWriter(flwriter);
                for(Usuario usuario :(ArrayList<Usuario>)Lusuario) {
                    //escribe los datos en el archivo
                    bfwriter.write(usuario.getNickname()+";"+ usuario.getNombre()+";"+usuario.getCorreo()+";"+usuario.getID());
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
     * @param nickname
     * @return 
     */
    public Usuario BuscarUsuario(String nickname){
        
        for(int i=0;i<Lusuarios.size();i++){
            
            if(Lusuarios.get(i).Nickname.equals(nickname)){
                System.out.println("Nickname: "+Lusuarios.get(i).Nickname);
                System.out.println("Nombre: "+Lusuarios.get(i).Nombre);
                System.out.println("Correo: "+Lusuarios.get(i).Correo);
                return Lusuarios.get(i);
            }
        }
        return null;
    }
    
    public void MostrarLista(){
        
        for(int i =0;i<Lusuarios.size();i++){
                System.out.println("Nombre de usuario: "+Lusuarios.get(i).Nickname);
                System.out.println("Nombre: "+Lusuarios.get(i).Nombre);
                System.out.println("Correo electronico: "+Lusuarios.get(i).Correo);
        }
    } 
}
