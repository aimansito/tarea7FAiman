/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author aiman
 */
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el archivo a leer");
        String archivo = teclado.nextLine();
        List<String> fichero = Ficheros.leerFichero(archivo);
        Ficheros.mostrarFichero(fichero);
        List<Persona> personas = Ficheros.crearListaPersonas(fichero);
        Ficheros.mostrarPersona(personas);
        System.out.println("Géneros: ");
        Set<String> genero = Ficheros.conjuntoGenero(fichero);
        genero.forEach(System.out::println);
        System.out.println("----------------");
        System.out.println("Map de géneros: ");
        Map<String, Integer> generos = Ficheros.contadorGeneros(fichero);
        generos.forEach((key,value)-> System.out.println(key+" , "+value));
    }
}
