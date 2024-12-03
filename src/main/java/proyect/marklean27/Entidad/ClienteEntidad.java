package proyect.marklean27.Entidad;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cliente")
public class ClienteEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Column (name= "nombre", nullable= false, length= 50)
    private String nombre;
    
    @Column (name= "email", nullable= false, length= 50, unique= true)
    private String email;
    
    @Column (name= "telefono", nullable= false, length= 50)
    private String telefono;
    
    @Column (name= "direccion", nullable= false, length= 50)
    private String direccion;
    
    @Column (name= "ciudad", nullable= false, length= 50)
    private String ciudad;

    // Constructor vacío (requerido por JPA)
    public ClienteEntidad() {}

    // Constructor con parámetros
    public ClienteEntidad(String nombre, String email, String telefono, String direccion, String ciudad) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "ClienteEntidad{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + ", direccion=" + direccion + ", ciudad=" + ciudad + '}';
    }

   
}
