package proyect.marklean27.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyect.marklean27.Entidad.ProveedorEntidad;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntidad, Long> {
    // Métodos de búsqueda adicionales (si son necesarios)
}
