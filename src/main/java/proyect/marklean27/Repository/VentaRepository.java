package proyect.marklean27.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyect.marklean27.Entidad.VentaEntidad;

@Repository
public interface VentaRepository extends JpaRepository<VentaEntidad, Long> {
}
