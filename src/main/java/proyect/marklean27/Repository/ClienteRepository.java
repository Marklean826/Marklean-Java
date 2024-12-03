
package proyect.marklean27.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyect.marklean27.Entidad.ClienteEntidad;


@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntidad, Long> {

    // Buscar clientes por nombre (parcial o completo)
    List<ClienteEntidad> findByNombreContainingIgnoreCase(String nombre);
}


