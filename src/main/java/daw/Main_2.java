/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author aiman
 */
public class Main_2 {

    public static void main(String[] args) {
        //Obtener una lista de personas nacidas en 1985, ordenadas por su email.
        List<String> fichero = Ficheros.leerFichero("./personas.csv");
        List<Persona> personas = Ficheros.crearListaPersonasFecha(fichero);
        //ordenacion
        personas.sort(new Comparator<Persona>() {
            @Override
            public int compare(Persona o1, Persona o2) {
                return o1.getEmail().compareTo(o2.getEmail());
            }
        });
        personas.forEach(System.out::println);
        //Obtener un set de correos electrónicos, ordenados alfabéticamente, 
        //de aquellas personas cuyo género es "non-binary" y estén jubiladas.
        Set<Persona> listaNoBinaria = Listas.listaNoBinaria(personas);
        listaNoBinaria.forEach(System.out::println);
        //Obtener el número de ciudades diferentes.
        System.out.println("Ciudades distintas: " + obtenerNumCiudades(personas));
        //Comprobar si alguna persona se llama "Zondra".
        System.out.println("¿Hay alguna persona llamada Zondra?: " + comprobarPersona(personas));
        //Comprobar si ninguna persona vive en "Estepona".
        System.out.println("¿No hay ninguna persona que viva en Estepona: " + comprobarCiudad(personas));
        //Saber cuantas personas tienen en su apellido la terminación "cía"
        System.out.println("Número de apellidos con cia al final: " + comprobarApellidos(personas));
        //Obtener una lista con todas las edades de cada persona.
        List<Integer> edades = listaEdades(personas);
        edades.forEach(System.out::println);
        //Obtener la suma de todas las edades de las personas de la lista.
        System.out.println("Suma edades: " + sumasEdades(personas));
        //Obtener la media de las edades
        System.out.println("La media es: "+devolverMediaEdad(personas));
        //Obtener en un String todos los nombres de las personas concatenados.
        System.out.println("Nombres: "+conjuntoNombres(personas));
    }

    public static long obtenerNumCiudades(List<Persona> personas) {
        long num = personas.stream().distinct().count();
        return num;
    }

    public static boolean comprobarPersona(List<Persona> personas) {
        return personas.stream().anyMatch((s) -> s.getNombre().equalsIgnoreCase("Zondra"));
    }

    public static boolean comprobarCiudad(List<Persona> personas) {
        return personas.stream().noneMatch(s -> s.getCiudad().equalsIgnoreCase("Estepona"));
    }

    public static long comprobarApellidos(List<Persona> personas) {
        long cia = personas.stream()
                .filter(persona -> persona.getApellido().toLowerCase().endsWith("cía")).count();
        return cia;
    }

    public static List<Integer> listaEdades(List<Persona> lista) {
        return lista.stream().map(Persona::devolverEdad).collect(Collectors.toList());
    }

    public static int sumaEdades(List<Integer> edades) {
        int suma = 0;
        for (Integer integer : edades) {
            suma += integer;
        }
        return suma;
    }
    public static long sumasEdades(List<Persona> lista){
        return lista.stream().mapToLong(Persona::devolverEdad).sum();
    }
    public static OptionalDouble devolverMediaEdad(List<Persona> edades){
        OptionalDouble mediaEdad = edades.stream()
        .mapToInt(Persona::devolverEdad)
        .average();
        return mediaEdad;
    }
    public static String conjuntoNombres(List<Persona> lista){
        return lista.stream().map(Persona::getNombre).collect(Collectors.joining(", "));
    }
}
