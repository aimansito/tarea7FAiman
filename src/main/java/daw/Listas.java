/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author aiman
 */
public class Listas {
    public static Set<Persona> listaNoBinaria(List<Persona> personas){
        Set<Persona> listaNoBinaria = new TreeSet();
        for(Persona persona : personas){
            if(persona.getGenero().equalsIgnoreCase("Non-binary")&& persona.isJubilado()){
                listaNoBinaria.add(persona);
            }
        }
        return listaNoBinaria;
    }
}
