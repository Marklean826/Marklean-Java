package proyect.marklean27.Entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "dashboard")
public class DashboardEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "metrica", nullable = false, length = 100)
    private String metrica;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private java.util.Date fecha;

    public DashboardEntidad() {}

    public DashboardEntidad(String metrica, Double valor, java.util.Date fecha) {
        this.metrica = metrica;
        this.valor = valor;
        this.fecha = fecha;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMetrica() {
        return metrica;
    }

    public void setMetrica(String metrica) {
        this.metrica = metrica;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public java.util.Date getFecha() {
        return fecha;
    }

    public void setFecha(java.util.Date fecha) {
        this.fecha = fecha;
    }
}
