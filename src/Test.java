
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    private String url;
    private String usuario;
    private String password;
    public Test(){
       url="jdbc:oracle:thin:@localhost:1521:orcl";
       usuario="Alex";
       password="Secreto_10";
    }
    public void listarAlumnos(){
        try{        
         Connection cn=DriverManager.getConnection(url,usuario,password);
     
         Statement obj = cn.createStatement();
         ResultSet rs = obj.executeQuery("select * from Usuarios");
         
         while(rs.next()){     
         System.out.println("Identificador: "+rs.getInt(1));
         System.out.println("Usuario: "+rs.getString(2));
         System.out.println("Contraseña: "+rs.getString(3));
         System.out.println("Nombre: "+rs.getString(4));
           System.out.println("Correo: "+rs.getString(5));
         System.out.println("IdTipo: "+rs.getInt(6));
 
         System.out.println();
         }
        }
        catch(SQLException e){
          System.out.println("Error: "+e.getMessage());
        }
    }
    
    
        public static void main(String[]args){
        Test t=new Test();
        t.listarAlumnos();
    }

}
