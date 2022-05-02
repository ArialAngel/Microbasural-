package com.mycompany.microbasuralesapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;
/**
 *
 * @author Sebastian Henriquez Cartagena
 * @author Luz Pinto Castillo
 */ 
public class Main {
    
    public static Usuario usuario=new Usuario();
    public static Basurero basurero=new Basurero();
    public static MicroBasural microbasural=new MicroBasural();
    public static Consejo consejo= new Consejo();
    
    /**
     * 
     * @param args
     * @throws ParseException 
     */
    public static void main(String args[]) throws ParseException{
        
        Scanner Entrada;
        int opcion;
        String buffer;
        int bufferInt;
        
        
        do{
            
            System.out.println("1- Usuarios");
            System.out.println("2- Puntos de reciclaje");
            System.out.println("3- Consejos");
            System.out.println("4- Microbasurales");
            System.out.println("5- Salir");
            
            System.out.println("Digite una opcion: ");
            Entrada=new Scanner(System.in);
            opcion=Entrada.nextInt();
            
            switch(opcion){
                case 1:
                    do{
                        Entrada=new Scanner(System.in);
                        opcion=Entrada.nextInt();
                        //Usuario
                        System.out.println("1- Crear Usuario");
                        System.out.println("2- Buscar Usuario");
                        System.out.println("3- Mostrar Lista de Usuarios");
                        switch(opcion){
                            case 1:
                                usuario.CrearUsuario(usuario);
                            break;

                            case 2:
                                buffer=Entrada.next();
                                usuario.BuscarUsuario(buffer);
                            break;
                                
                            case 3:
                                usuario.MostrarLista();
                            break;
                        }
                    }while(opcion != 4);
                break;
                
                case 2:
                    do{
                        Entrada=new Scanner(System.in);
                        opcion=Entrada.nextInt();
                        //Puntos de reciclaje
                        System.out.println("1- Crear punto de reciclaje");
                        System.out.println("2- Mostrar datos de punto de reciclaje");
                        System.out.println("3- Buscar punto de reciclaje por calle");
                        System.out.println("4- Buscar punto de reciclaje por tipo");
                        System.out.println("5- Eliminar un punto de reciclaje");
                        
                        switch(opcion){
                            case 1:
                                basurero.InsertarDato();
                            break;
                            
                            case 2:
                                basurero.MostrarLista();
                            break;
                            
                            case 3:
                                buffer=Entrada.next();
                                basurero.BuscarCalle(buffer);
                            break;
                            
                            case 4:
                                
                                bufferInt=Entrada.nextInt();
                                basurero.BuscarTipo(bufferInt);
                            break;
                            
                            case 5:
                                bufferInt=Entrada.nextInt();
                                basurero.Eliminar(bufferInt);
                            break;
                        }
                    }while(opcion != 6);
                break;
                
                case 3:
                    //Consejos
                    Entrada=new Scanner(System.in);
                    opcion=Entrada.nextInt();
                    System.out.println("1- Crear un texto informativo");
                    System.out.println("2- Mostrar lista de Consejos");
                    System.out.println("3- Buscar texto");
                    System.out.println("4- Eliminar consejo");
                    do{
                        switch(opcion){
                            
                            case 1:
                                consejo.Crear(consejo);
                            break;
                            
                            case 2:
                                consejo.MostrarConsejos();
                            break;
                            
                            case 3:
                                buffer=Entrada.next();
                                consejo.BuscarInfo(buffer);
                            break;
                            
                            case 4:
                                bufferInt=Entrada.nextInt();
                                consejo.EliminarInfo(bufferInt);
                            break;
                        }
                    }while(opcion != 5);
                break;
                
                case 4:
                    //Microbasurales
                    do{
                        
                        Entrada=new Scanner(System.in);
                        opcion=Entrada.nextInt();
                        System.out.println("1- Crear zona de Microbasural");
                        System.out.println("2- Mostrar lista de Microbasurales");
                        System.out.println("3- Buscar Microbasural por calle");
                        System.out.println("4- Actualizar una zona de Microbasural");
                        System.out.println("5- Eliminar un Microbasural");
                        switch(opcion){
                            
                            case 1:
                                microbasural.Crear(microbasural);
                            break;
                            
                            case 2:
                                microbasural.MostrarListaMicrobasurales();
                            break;
                            
                            case 3:
                                buffer=Entrada.next();
                                microbasural.BuscarCalle(buffer);
                            break;
                            
                            case 4:
                                bufferInt= Entrada.nextInt();
                                microbasural.Actualizar(bufferInt);
                            break;
                            
                            case 5:
                                bufferInt= Entrada.nextInt();
                                microbasural.Eliminar(bufferInt);
                            break;
                        }
                    }while(opcion != 6);
                break;
            }   
        }while(opcion != 5);
    }
 
    /*
    public static void InsertaDatosArchivos() throws FileNotFoundException{
        
        String file = "src/test/java/Usuarios.txt";
        int i = 0;
        
        try{
            File archivo = new File(file);
            System.out.println(archivo.getAbsolutePath());
            try (Scanner scanner = new Scanner(archivo)) {
                while(scanner.hasNext()){
                    String []datos = scanner.next().split(";");
                    System.out.print("Linea "+i+ "Nickname:"+datos[0]);
                    System.out.print("Nombre:"+datos[1]);
                    System.out.print("Correo:"+datos[2]);
                    System.out.print("ID:"+datos[3]);
                    i++;
                }
            }
        }catch (FileNotFoundException e){
        }
    }
    
    public static void DatosMicrobasural() throws FileNotFoundException{
        String file = "src/test/java/Microbasurales.txt";
        int i=0;

        try{
            File archivo=new File(file);
            System.out.println(archivo.getAbsolutePath());
            try (Scanner scanner = new Scanner(archivo)) {
                while(scanner.hasNext()){
                    String []datos=scanner.next().split(";");
                    System.out.print("Linea "+i + " Usuario:"+datos[0]);
                    System.out.print(" ID:"+datos[1]);
                    System.out.print(" Latitud:"+datos[2]);
                    System.out.print(" Longitud:"+datos[3]);
                    System.out.println(" Calle:"+datos[4]);
                    System.out.println(" N°:"+datos[5]);
                    i++;
                }
            }
        }catch (FileNotFoundException e){
        }
    }
    
    public static void DatosBasurarero() throws FileNotFoundException{
        String file = "src/test/java/Basureros.txt";
        int i=0;

        try{
            File archivo=new File(file);
            System.out.println(archivo.getAbsolutePath());
            Scanner scanner = new Scanner(archivo);

            while(scanner.hasNext()){
                String []datos=scanner.next().split(";");
                System.out.print("Linea "+i + " ID:"+datos[0]);
                //La idea es poner un if que defina el tipo, sin embargo por desconocimiento queda estipulado de esta forma
                System.out.println("Los tipos de basurero estan definidos por:");
                System.out.println("Tipo 1:Pilas\n 2:Plastico\n Tipo 3:Papel\n Tipo 4:Vidrio\n Tipo 5 :Organico\n Tipo 6:Metales.");
                System.out.print(" Tipo:"+datos[1]);
                System.out.print(" Latitud:"+datos[2]);
                System.out.print(" Longitud:"+datos[3]);
                System.out.println(" Calle:"+datos[4]);
                System.out.println(" N°:"+datos[5]);
                i++;
            }scanner.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }   
    */
}
