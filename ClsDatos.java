/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.trabajador;
import excepciones.*;
import java.util.*;

/**
 *
 * @author Sergio Armando
 */
public interface ClsDatos {
    boolean existe(String nombreArchivo) throws AccesoDatos;
    public List<trabajador> listar(String nombreArchivo) throws LecturaDatos;
    void escribir(trabajador trabajdor, String nombreArchivo, boolean anexar) throws EscrituraDatos;
    public String buscar(String nombreArchivo, Double buscar) throws LecturaDatos;
    public void crear(String nombreArchivo) throws AccesoDatos;
    public void borrar(String nombreArchivo) throws AccesoDatos;
}
