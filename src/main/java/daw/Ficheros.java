/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author aiman
 */
public class Ficheros {
    public static List<String> leerFichero(String fichero){
        List<String> lineas=new ArrayList<>();
        try {
            lineas = Files.readAllLines(Paths.get(fichero),
                    StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.out.println("Error leyendo el fichero");
        }
        return lineas;
    }
    public static List<Persona> crearListaPersonas(List<String> fichero){
        DateTimeFormatter formatted = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<Persona> lista = new ArrayList();
        for (String persona : fichero) {
            String[] array = persona.split(",");
            LocalDate fecha = LocalDate.parse(array[5], formatted);
            boolean jubilado = Boolean.parseBoolean(array[6]);
            Persona nuevo = new Persona(Integer.parseInt(array[0]), array[1],
                    array[2], array[3], array[4], fecha,
                    jubilado, array[7]);
            lista.add(nuevo);
        }
        return lista;
    }
     public static Set<String> conjuntoGenero(List<String> fichero) {
        Set<String> lista = new TreeSet();
        for (String genero : fichero) {
            String[] array = genero.split(",");
            lista.add(array[4]);
        }
        try {
            Files.write(Paths.get("genero.txt"), lista);
        } catch (IOException ioe) {
            System.out.println("No se ha podido crear el .txt");
        }
        return lista;
    }
     public static Map<String, Integer> contadorGeneros(List<String> fichero) {
        Map<String, Integer> listaMap = new TreeMap();
        for (String genero : fichero) {
            String[] array = genero.split(",");
            listaMap.put(array[4], listaMap.getOrDefault(array[4], 0) + 1);
        }
        try {
            List<String> ficheroNuevo = new ArrayList();
            for (Map.Entry<String, Integer> entry : listaMap.entrySet()) {
                ficheroNuevo.add(entry.getKey() + ", " + entry.getValue());
            }
            Files.write(Paths.get("contadorGeneros.csv"), ficheroNuevo);
        } catch (IOException ioe) {
            System.out.println("No se ha podido crear el .csv");
        }
        return listaMap;
    }
    public static void mostrarFichero(List<String> fichero){
        System.out.println("Lectura Fichero...");
        for (String str : fichero) {
            System.out.println(str);
        }
        System.out.println("-----------");
    }
    public static void mostrarPersona(List<Persona> fichero){
        System.out.println("Mostrando lista personas...");
        for (Persona str : fichero) {
            System.out.println(str);
        }
        System.out.println("-----------");
    }
    public static List<Persona> crearListaPersonasFecha(List<String> fichero){
        DateTimeFormatter formatted = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<Persona> lista = new ArrayList();
        for (String persona : fichero) {
            String[] array = persona.split(",");
            LocalDate fecha = LocalDate.parse(array[5], formatted);
            boolean jubilado = Boolean.parseBoolean(array[6]);
            Persona nuevo = new Persona(Integer.parseInt(array[0]), array[1],
                    array[2], array[3], array[4], fecha,
                    jubilado, array[7]);
            if(nuevo.getFecha_nacimiento().getYear()==1985){
                lista.add(nuevo);
            }
        }
        return lista;
    }
}
