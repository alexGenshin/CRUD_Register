package EmpleadosCRUD;

import Usuarios.Conexion;
import Usuarios.SQL_Usuarios;
import Usuarios.Usuarios;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SQLEmpleados extends Conexion {

    public void GuardarDatos(Empleado emp) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "Insert INTO Empleados(nombre,Direccion,Edad,Dni,Ciudad,Sueldo_Neto,Estado,Telefono,ID_Depa ) "
                + "values(?,?,?,?,?,?,?,?,(select Id_Departamento from departamentos where tipo=?))";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getDireccion());
            ps.setInt(3, emp.getEdad());
            ps.setString(4, emp.getDni());
            ps.setString(5, emp.getCiudad());
            ps.setDouble(6, emp.getSueldoNeto());
            ps.setString(7, emp.getEstado());
            ps.setString(8, emp.getTelefono());
            ps.setString(9, emp.getDepa());
            // ps.setInt(10, emp.getUsuar());
            //Insert into == execute
            int res = ps.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Empleado Guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SQL_Usuarios.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void actualizarEmpleado(Empleado emp) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "Update Empleados set nombre=?,Direccion=?,Edad=?,Dni=?,Ciudad=?,Sueldo_Neto=?,"
          + "Estado=?,Telefono=?,ID_Depa=(select Id_Departamento from departamentos where tipo=?)where Codigo=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getDireccion());
            ps.setInt(3, emp.getEdad());
            ps.setString(4, emp.getDni());
            ps.setString(5, emp.getCiudad());
            ps.setDouble(6, emp.getSueldoNeto());
            ps.setString(7, emp.getEstado());
            ps.setString(8, emp.getTelefono());
            ps.setString(9, emp.getDepa());
            ps.setInt(10, emp.getIdEmpleado());
            // ps.setInt(10, emp.getUsuar());
            //Insert into == execute
            int res = ps.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Persona Guardar");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SQL_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

}
