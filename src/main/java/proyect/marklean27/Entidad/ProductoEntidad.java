package proyect.marklean27.Entidad;

import jakarta.persistence.*;
import java.util.Date;



@Entity
@Table(name = "producto")
public class ProductoEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "categoria", nullable = false, length = 50)
    private String categoria;

    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;

    @Column(name = "iva", nullable = false)
    private Double iva;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "estado", nullable = false, length = 20)
    private String estado;

    // Constructor vacío
    public ProductoEntidad() {
        this.fecha = new Date();  // Asigna la fecha actual por defecto
    }

    // Constructor con parámetros
    public ProductoEntidad(String nombre, String categoria, String tipo, Double iva, Integer stock, Date fecha, Double precio, String estado) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.tipo = tipo;
        this.iva = iva;
        this.stock = stock;
        this.fecha = fecha != null ? fecha : new Date();  // Si no se proporciona una fecha, se asigna la fecha actual
        this.precio = precio;
        this.estado = estado;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
