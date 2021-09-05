/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.*;
import negocio.*;


public class ClsPrincipal {
    private static final Scanner scanner = new Scanner(System.in);
    private static int opcion = -1;
    private static final String nombreArchivo = "c:\\tmp\\trabajador.txt";
    private static final listatrabajadores empleados = new listatrabajadores();
    
    
    public static void main(String[] args) {
        while (opcion != 0) {
            try {
                System.out.println("Elegir opcion:\n1-. Iniciar Nomina de trabajadores"
                        + "\n2-. registro de trabajdor"
                        + "\n3-. menor venta y mayor por los meses"
                        + "\n4-. trabajador principal"
                        + "\n5-. Editar Dato "
                        + "\n6-. encontar por cantidad"
                        + "\n7-. Lista de información"
                        + "\n0-. salir :)");
                
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        empleados.iniciarArchivo(nombreArchivo);
                        break;
                    case 2:
                        System.out.println("por favor registre el nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.println("por favor registre enero: ");
                        Double enero = scanner.nextDouble();
                        System.out.println("por favor registre febrero: ");
                        Double febrero = scanner.nextDouble();
                        System.out.println("por favor registre marzo: ");
                        Double marzo = scanner.nextDouble();
                        empleados.agregartrabajador(nombreArchivo, nombre, enero, febrero, marzo);
                        scanner.nextLine();
                        break;
                    case 3:
                        System.out.println("registre  el mes: "
                                + "\n<1>Enero <2>Febrero <3>Marzo");
                        int mes = Integer.parseInt(scanner.nextLine());
                        empleados.buscarmahyorymenorventa(nombreArchivo, mes);
                        break;
                    case 4:
                        empleados.buscarMayorVendedorGeneral(nombreArchivo);
                        break;
                    case 5:
                        System.out.println("por favor registre el numero de registro: ");
                        int registro = Integer.parseInt(scanner.nextLine());
                        System.out.println("por favor Elija el dato que desea editar: "
                                + "\n<1>Nombre <2>Enero <3>Febrero <4>Marzo");
                        int columna = Integer.parseInt(scanner.nextLine());
                        System.out.println("por favor Ingrese el nuevo dato: ");
                        String nuevoDato = scanner.nextLine();
                        empleados.editarDato(nombreArchivo, nuevoDato, registro, columna);
                        break;
                    case 6:
                        System.out.println("por favor Ingrese la cantidad: ");
                        Double cantidad = scanner.nextDouble();
                        scanner.nextLine();
                        empleados.encontrarporcantidad(nombreArchivo, cantidad);
                        break;
                    case 7:
                        empleados.listatrabajadores(nombreArchivo);
                        break;
                    case 0:
                        System.out.println("Salir del programa...");
                        break;
                    default:
                        System.out.println("Opcion no aceptada");
                        break;
                }
                System.out.println("\n");
            } catch (Exception ex) {
                System.out.println("Error\n");
            }
        }
    }
}
    

    

       

