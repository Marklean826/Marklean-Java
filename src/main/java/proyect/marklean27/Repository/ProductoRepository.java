package proyect.marklean27.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proyect.marklean27.Entidad.ProductoEntidad;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntidad, Long> {

    // Búsquedas básicas
    List<ProductoEntidad> findByNombreContainingIgnoreCase(String nombre);
    List<ProductoEntidad> findByEstado(String estado);
    List<ProductoEntidad> findByNombreContainingIgnoreCaseAndEstado(String nombre, String estado);

    // Búsquedas con paginación
    Page<ProductoEntidad> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);
    Page<ProductoEntidad> findByEstado(String estado, Pageable pageable);
    Page<ProductoEntidad> findByNombreContainingIgnoreCaseAndEstado(String nombre, String estado, Pageable pageable);

    // Búsqueda personalizada con criterios dinámicos
    @Query("SELECT p FROM ProductoEntidad p WHERE " +
           "(:nombre IS NULL OR LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) " +
           "AND (:estado IS NULL OR p.estado = :estado)")
    List<ProductoEntidad> buscarProductosPersonalizados(String nombre, String estado);

    // Actualización de stock
    @Transactional
    @Modifying
    @Query("UPDATE ProductoEntidad p SET p.stock = p.stock + :cantidad WHERE p.id = :id")
    int actualizarStock(Long id, Integer cantidad);

    // Verificar si existe un producto por nombre
    boolean existsByNombre(String nombre);

    // Borrar productos por estado
    @Transactional
    @Modifying
    @Query("DELETE FROM ProductoEntidad p WHERE p.estado = :estado")
    void eliminarProductosPorEstado(String estado);
    static Optional<ProductoEntidad> eliminarProductosPorEstado(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarProductosPorEstado'");
    }
}
