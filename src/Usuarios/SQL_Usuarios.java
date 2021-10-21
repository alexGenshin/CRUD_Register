package Usuarios;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class SQL_Usuarios extends Conexion {

    public boolean registrar(Usuarios usr) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "Insert INTO usuarios(usuario,password,nombre,correo,id_tipo ) values(?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            ps.setString(2, usr.getPassword());
            ps.setString(3, usr.getNombre());
            ps.setString(4, usr.getCorreo());
            ps.setInt(5, usr.getId_tipo());
            //Insert into == execute
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SQL_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
   
    public boolean Login(Usuarios us) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "Select id,usuario,password,nombre,id_tipo from usuarios WHERE usuario=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getUsuario());
            JOptionPane.showMessageDialog(null, us.getUsuario()); 
            rs = ps.executeQuery();
//si trae un valor esta consulta
            if (rs.next()) {
                if (us.getPassword().equals(rs.getString(3))) {
                    //Estos Datos que consulte los voy a pasar al modSql
                    us.setId(rs.getInt(1));
                    us.setNombre(rs.getString(4));
                    us.setId_tipo(rs.getInt(5));
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(SQL_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public int existeUsuario(String usuario) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "Select count(id) from usuarios WHERE usuario=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            //Select == executeQuery
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(SQL_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
    }

    public boolean esEmail(String correo) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(correo);
        return matcher.find();
    }

    /*    public int existeUsuario(String usuario){
PreparedStatement(ps)=null;
ResulSet
}*/
 /*validar el correo electronico para que sea de un formato adecuado es boolean porque si devuelve valor true 
nos sale un mensaje(JOPPane) que nos dice "El correo es valido" o NO
public boolean esEmail(String correo){
PreparedStatement(ps)=null;
ResulSet
}*/

 /*METODO QUE VA BUSCAR LOS DATOS DEL LOGIN EN LA BASE DE DATOS --AUTOTENTIFICAR AL USUARIO
public BOOLEAN login(Usuario usr){
     */
}
