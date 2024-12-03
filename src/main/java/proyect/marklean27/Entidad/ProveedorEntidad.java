package proyect.marklean27.Entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "proveedor")
public class ProveedorEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "telefono", nullable = false, length = 15)
    private String telefono;

    @Column(name = "RazonSocial", nullable = false, length = 50)
    private String RazonSocial;

    @Column(name = "ciudad", nullable = false, length = 50)
    private String ciudad;

    // Constructor vacío
    public ProveedorEntidad() {}

    // Constructor con parámetros
    public ProveedorEntidad(String nombre, String email, String telefono, String RazonSocial, String ciudad) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.RazonSocial = RazonSocial;
        this.ciudad = ciudad;
    }

    // Getters y Setters
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

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}

