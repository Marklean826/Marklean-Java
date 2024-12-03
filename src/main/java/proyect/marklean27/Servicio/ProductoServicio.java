package proyect.marklean27.Servicio;

import proyect.marklean27.Entidad.ProductoEntidad;
import java.util.List;

public interface ProductoServicio {
    List<ProductoEntidad> listarProducto();
    ProductoEntidad obtenerProductoPorId(Long id);
    ProductoEntidad guardarProducto(ProductoEntidad producto);
    ProductoEntidad agregarStock(Long id, Integer cantidad);
    List<ProductoEntidad> buscarProductos(String nombre, String estado);
    void eliminarProducto(Long id);
    boolean existeProductoPorNombre(String nombre); // Nuevo método
    void eliminarProductosPorEstado(String estado); // Nuevo método
}
