

package EmpleadosCRUD;

public class Empleado {
private int idEmpleado;
private String nombre;
private String direccion;
private int edad;
private String dni;
private String ciudad;
private Double SueldoNeto;
private String estado;
private String telefono;
private String Depa;


public Empleado(){
    
}


    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Double getSueldoNeto() {
        return SueldoNeto;
    }

    public void setSueldoNeto(Double SueldoNeto) {
        this.SueldoNeto = SueldoNeto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String Observaciones) {
        this.telefono = Observaciones;
    }

    public String getDepa() {
        return Depa;
    }

    public void setDepa(String Depa) {
        this.Depa = Depa;
    }



}
