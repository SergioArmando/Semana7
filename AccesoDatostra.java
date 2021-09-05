
package datos;

import dominio.trabajador;
import excepciones.*;
import java.io.*;
import java.util.*;


public class AccesoDatostra implements AccesoDatos {

    
    public AccesoDatostra() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public AccesoDatostra() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public AccesoDatostra() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /** *  @param nombreArchivo
     * @return boolean
    * @exception AccesoDatosEx
    * @pdOid 482213a6-85eb-4673-88f5-00c579ed64a0 */
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }
    
    /** *  @param nombreArchivo
     * @return Empleado
    * @exception LecturaDatosEx
    * @pdOid 94530568-a4cb-4297-96e0-3cac88bada7e */
    public List<Empleado> listar(String nombreArchivo) throws LecturaDatosEx {
        List<Empleado> empleados = new ArrayList();
        try {
            BufferedReader entrada = null;
            File archivo = new File(nombreArchivo);
            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null){
                String[] empDatos = linea.split("\\|");
                Empleado empleado = new Empleado(empDatos[0], Double.valueOf(empDatos[1]), 
                                    Double.valueOf(empDatos[2]), Double.valueOf(empDatos[3]));
                empleados.add(empleado);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return empleados;
    }
    
    /** @param empleado
    * @param nombreArchivo
    * @param anexar
    * @exception EscrituraDatosEx
    * @pdOid ac225a72-846e-4700-ab01-ac2ee29fefac */
    public void escribir(Empleado empleado, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo,anexar));
            salida.println(empleado.toString());
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            salida.close();
        }
    }
    
    /** *  @param nombreArchivo
    * @param buscar
     * @return 
     * @throws excepciones.LecturaDatosEx
    * @pdOid 74d2bc4a-8157-4371-9100-92acfea2a4d1 */
    public String buscar(String nombreArchivo, Double buscar) throws LecturaDatosEx {
        BufferedReader entrada = null;
        String resultado = null;
        try {
            File archivo = new File(nombreArchivo);
            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            int i=1;
            linea = entrada.readLine();
            while (linea != null){
                String empDatos[] = linea.split("\\|");
                for(String dato : empDatos){
                    if(buscar != null && String.valueOf(buscar).equals(dato)){
                        resultado = linea + " indice buscar " + i;
                        break;
                    }
                }
                linea = entrada.readLine();
                i++;
            } 
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                entrada.close();
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return resultado;
    }
    
    /** *  @param nombreArchivo
     * @throws excepciones.AccesoDatosEx
    * @pdOid c2d9fcb6-be82-4c10-a7a2-c8e0b07811be */
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            salida.close();
        }
    }
    
    /** @param nombreArchivo
    * @exception AccesoDatosEx
    * @pdOid 51d99696-2469-491c-ab14-45a2ccad0fc5 */
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        archivo.delete();
        System.out.println("Se ha borrado el archivo");
    }
}

