package proyect.marklean27.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyect.marklean27.Entidad.DashboardEntidad;

@Repository
public interface DashboardRepository extends JpaRepository<DashboardEntidad, Long> {
    // Métodos adicionales para consultas específicas (si es necesario)
}
