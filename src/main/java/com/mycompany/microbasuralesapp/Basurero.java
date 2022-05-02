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
public class Basurero {
    public ArrayList<Consejo> LConsejo=new ArrayList<Consejo>();
    public ArrayList<Basurero>LBasurero=new ArrayList<Basurero>();
    //Atributos
    //Todos los atributos estan relacionados con Tipo
    private float Latitud; 
    private float Longitud;
    private String Calle;
    private int NCalle;
    private int ID;
    private int Tipo; //1:Pilas 2:Plastico 3:Papel 4:Vidrio 5:Organico 6:Metales 
    
    
    //Coleccion
    
    /**
     * 
     * @param Latitud
     * @param Longitud
     * @param ID
     * @param Tipo
     * @param NCalle
     * @param Calle 
     */
    public Basurero(float Latitud,float Longitud,int ID,int Tipo,int NCalle,String Calle){
        this.Longitud=Longitud;
        this.Latitud=Latitud;
        this.Calle=Calle;
        this.NCalle=NCalle;
        this.ID=ID;
        this.Tipo=Tipo;
    }
    
    public Basurero() {
        
        LBasurero=new ArrayList<Basurero>();
        LConsejo=new ArrayList<Consejo>();
    }
 
    
    //Accesores
    
    /**
     * 
     * @return 
     */
    public float getLatitud(){
        return Latitud;
    }
    /**
     * 
     * @return 
     */
    public float getLongitud(){
        return Longitud;
    }
    /**
     * 
     * @return 
     */
    public int getID(){
        return ID;
    }
    /**
     * 
     * @return 
     */
    public int getTipo(){
        return Tipo;
    }
    /**
     * 
     * @return 
     */
    public String getCalle() {
        return Calle;
    }
    /**
     * 
     * @return 
     */
    public int getNCalle() {
        return NCalle;
    }
    
    //Mutadores
    
    /**
     * 
     * @param Latitud1 
     */
    public void setLatitud(float Latitud1){
        Latitud = Latitud1;
    }
    /**
     * 
     * @param Longitud1 
     */
    public void setLongitud(float Longitud1){
        Longitud = Longitud1;
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
     * @param Tipo1 
     */
    public void setTipo(int Tipo1){
        Tipo = Tipo1;
    }
    /**
     * 
     * @param Calle 
     */
    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public void setNCalle(int NCalle) {
        this.NCalle = NCalle;
    }

    //Comportamiento
    
    
    public void InsertarDato(){
        float Latitud,Longitud;
        int Tipo,NCalle;
        String Calle;
        //La ID no se agrego al codigo porque genero error. Esta variable se agregara proximamente.
        Scanner Entrada=new Scanner(System.in);
        System.out.println("Digite su Latitud");
        Latitud=Entrada.nextFloat();
        System.out.println("Ingrese su Longitud");
        Longitud=Entrada.nextInt();
        System.out.println("Insertar tipo de Basurero:\n Tipo 1:Pilas\n 2:Plastico\n Tipo 3:Papel\n Tipo 4:Vidrio\n Tipo 5 :Organico\n Tipo 6:Metales.");
        Tipo=Entrada.nextInt();
        System.out.println("Ingrese combre de la calle");
        Calle=Entrada.next();
        System.out.println("Ingrese el numero de calle");
        NCalle=Entrada.nextInt();
        //NOTA: Agregar metodo para implementar un ID automatico a cada Basurero al ser agregado a la BD.
        Basurero basurero=new Basurero(Latitud,Longitud,ID,Tipo,NCalle,Calle);
        LBasurero.add(basurero);
        /*if((Entrada>6)||(Entrada<1)){
            System.out.println("Ingresar tipo valido\n");
        }else{
            Tipo=Entrada.next;
        }
        */
    }

    public class OperacionEnArchivo{
        public static void CrearArchivo(ArrayList LBasurero){
        FileWriter flwriter=null;
        try{
            //Se usa para escribir en el archivo
            flwriter=new FileWriter("C:\\Users\\Luz\\Desktop\\MicroBasuralesApp\\src\\test\\java\\Basureros.txt");
            //creacion de buffer
            BufferedWriter bfwriter=new BufferedWriter(flwriter);
            for(Basurero basurero :(ArrayList<Basurero>)LBasurero){
                //escribe los datos en archivo
                bfwriter.write(basurero.getLatitud()+";"+ basurero.getLongitud()+ ";" + basurero.getTipo()+ ";" + basurero.getCalle()+ ";" + basurero.getNCalle());
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
            File file = new File("C:\\Users\\Luz\\Desktop\\MicroBasuralesApp\\src\\test\\java\\Basureros.txt");
            ArrayList LBasurero= new ArrayList<>();
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
                    Basurero e= new Basurero();
                    e.setLatitud(delimitar.nextFloat());
                    e.setLongitud(delimitar.nextFloat());
                    e.setTipo(delimitar.nextInt());
                    LBasurero.add(e);
                }
                //se cierra el ojeto scanner
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return LBasurero;
        }
        public static void aniadirDatosArchivo(ArrayList LBasurero) {
            FileWriter flwriter = null;
            try {//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 
                flwriter = new FileWriter("C:\\Users\\Luz\\Desktop\\MicroBasuralesApp\\src\\test\\java\\Basureros.txt", true);
                BufferedWriter bfwriter = new BufferedWriter(flwriter);
                for(Basurero basurero :(ArrayList<Basurero>)LBasurero) {
                    //escribe los datos en el archivo
                    bfwriter.write(basurero.getLatitud() + ";" + basurero.getLongitud() + ";" + basurero.getTipo() + ";" + basurero.getCalle()+ ";" + basurero.getNCalle());
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
    public void Eliminar(int ID){
        for(int i=0;i<LBasurero.size();i++){
            
            if(LBasurero.get(i).ID==ID){
                LBasurero.remove(i);
            }
        }
    }
    
    public Basurero BuscarCalle(String calle){
        
        for(int i=0;i<LBasurero.size();i++){
            
            if(LBasurero.get(i).Calle.equals(calle)){
                System.out.println(LBasurero.get(i).ID+" " +LBasurero.get(i).Calle+" " +LBasurero.get(i).NCalle+" " +LBasurero.get(i).Tipo+" "+LBasurero.get(i).Latitud+" "+LBasurero.get(i).Longitud);
                return LBasurero.get(i);    
            }
        }
        
        return null;
    }
    
        
    public Basurero BuscarTipo(int Tipo){  
        for(int i=0;i<LBasurero.size();i++){
            
            if(LBasurero.get(i).Tipo==Tipo){
                System.out.println(LBasurero.get(i).ID+" " +LBasurero.get(i).Calle+" " +LBasurero.get(i).NCalle+" " +LBasurero.get(i).Tipo+" "+LBasurero.get(i).Latitud+" "+LBasurero.get(i).Longitud);
                return LBasurero.get(i);    
            }
        }
        return null;
    }
    
    public void MostrarLista(){
        
        for(int i =0;i<LBasurero.size();i++){
                System.out.println("ID: "+LBasurero.get(i).ID);
                System.out.println("Tipo: "+LBasurero.get(i).Tipo);
                System.out.println("Calle: "+LBasurero.get(i).Calle);
                System.out.println("Numero Calle: "+LBasurero.get(i).NCalle);
                System.out.println("Latitud: "+LBasurero.get(i).Latitud);
                System.out.println("Longitud: "+LBasurero.get(i).Longitud);
        }
    }
}
