/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.*;
import dominio.Empleado;
import excepciones.*;
import java.util.*;


public class Nominatrabajadores {
    private final AccesoDatos datos;
    private final String errorAcceso = " oh Error de ecceder a datos";
    private final String errorLectura = "oh Error de leer  datos";
    private final String errorEscritura = " oh Error de escribir los  datos";
    
    public Nominatrabajadores(){
        this.datos = new AccesoDatos();
    }
    
    public void iniciarArchivo(String nombreArchivo) {
        if(datos.existe(nombreArchivo)){
            datos.borrar(nombreArchivo);
            datos.crear(nombreArchivo);
        } else {
            datos.crear(nombreArchivo);
        }
    }

    public void agregarEmpleado(String nombreArchivo, String nombretrabajador, Double enero, Double febrero, Double marzo) {
        empleado empleado;
        empleado = new empleado(nombreempleado, enero, febrero, marzo);
        boolean anexar = false;
        anexar = datos.existe(nombreArchivo);
        datos.escribi(empleado), nombreArchivo, anexar);
        System.out.println("**registro validado**");
    }

    public void buscarMayorYMenorVendedorPorMes(String nombreArchivo, int mes) {
        Double mayor = 0.0;
        Double menor = 999999999999.9;
        String nombreMayor = null;
        String nombreMenor = null;
        List<Object> empleados = datos.listar(nombreArchivo);
        for (Object  empledado : empleados) {
            String[] empDatos = trabajador.toString().split("\\|");
            if (Double.valueOf(empDatos[mes]) > mayor) {
                mayor = Double.valueOf(empDatos[mes]);
                nombreMayor = empDatos[0];
            }
            if (Double.valueOf(empDatos[mes]) < menor) {
                menor = Double.valueOf(empDatos[mes]);
                nombreMenor = empDatos[0];
            }
        }
        if (nombreMayor != null && nombreMenor != null) {
            System.out.println("Mayor vendedor: " + nombreMayor + " con " + mayor
                    + "\nMenor vendedor: " + nombreMenor + " con " + menor);
        }
    }

    public void buscarMayorVendedorGeneral(String nombreArchivo) {
        Double mayor = 0.0;
        String resultado = null;
        List<empleado> empleados = datos.listar(nombreArchivo);
        for(empleado empleado : empleados) {
            if (empleado.getTotal() > mayor) {
                resultado = empleado.getNombre() + " con " + empleado.getTotal();
            }
        }
        System.out.println("mayor vendedor es" + resultado);
    }

    public void editarDato(String nombreArchivo, String nuevoDato, int registro, int columna) {
        registro--;
        try {
            List<Object> empleados = datos.listar(nombreArchivo);
            String nombre = empleados.get(registro).getNombre();
            Double enero = empleados.get(registro).getEnero();
            Double febrero = empleados.get(registro).getFebrero();
            Double marzo = empleados.get(registro).getMarzo();
            switch (columna) {
                case 1:
                    nombre = nuevoDato;
                    break;
                case 2:
                    enero = Double.valueOf(nuevoDato);
                    break;
                case 3:
                    febrero = Double.valueOf(nuevoDato);
                    break;
                case 4:
                    marzo = Double.valueOf(nuevoDato);
                    break;
                default:
                    System.out.println("Columna no aceptada");
                    break;
            }
            Empleado empleado = new Empleado(nombre, enero, febrero, marzo);
            empleados.set(registro, empleado);
            boolean anexar = false;
            for (Empleado linea : empleados) {
                datos.escribir(linea, nombreArchivo, anexar);
                anexar = datos.existe(nombreArchivo);
            }  
        } catch (NumberFormatException ex) {
            System.out.println("Error ");
            ex.printStackTrace(System.out);
        }
    }

    public void busquedaPorCantidad(String nombreArchivo, Double cantidad) {
        String resultado = null;
        resultado = datos.buscar(nombreArchivo, cantidad);
        System.out.println("Resultado: " + resultado);
    }

    public void listarEmpleados(String nombreArchivo) {
        List<Object> empleados = datos.listar(nombreArchivo);
        if (empleados.size() > 0) {
            empleados.forEach(empleado -> {
                System.out.println(empleado);
            });
        } else {
            System.out.println("Ningun registro");
        }
    }
}