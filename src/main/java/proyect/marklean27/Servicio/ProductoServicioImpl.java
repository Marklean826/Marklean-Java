package proyect.marklean27.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyect.marklean27.Entidad.ProductoEntidad;
import proyect.marklean27.Repository.ProductoRepository;

import java.util.List;

@Service
public class ProductoServicioImpl implements ProductoServicio {

    @Autowired
    private ProductoRepository repository;

    @Override
    public List<ProductoEntidad> listarProducto() {
        return repository.findAll();
    }

    @Override
    public ProductoEntidad obtenerProductoPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto con ID " + id + " no encontrado."));
    }

    @Override
    public ProductoEntidad guardarProducto(ProductoEntidad producto) {
        if (producto.getNombre() == null || producto.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del producto es obligatorio.");
        }

        if (existeProductoPorNombre(producto.getNombre())) {
            throw new IllegalStateException("Ya existe un producto con el nombre " + producto.getNombre());
        }

        if (producto.getStock() == null || producto.getStock() < 0) {
            throw new IllegalArgumentException("El stock no puede ser nulo o negativo.");
        }

        return repository.save(producto);
    }

    @Override
    public ProductoEntidad agregarStock(Long id, Integer cantidad) {
        if (cantidad == null || cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0.");
        }

        ProductoEntidad producto = obtenerProductoPorId(id);
        producto.setStock(producto.getStock() + cantidad);
        return repository.save(producto);
    }

    @Override
    public List<ProductoEntidad> buscarProductos(String nombre, String estado) {
        if (nombre == null && estado == null) {
            return listarProducto(); // Si no hay filtros, devuelve todos los productos.
        } else if (nombre == null) {
            return repository.findByEstado(estado); // Filtra por estado.
        } else if (estado == null) {
            return repository.findByNombreContainingIgnoreCase(nombre); // Filtra por nombre.
        } else {
            return repository.findByNombreContainingIgnoreCaseAndEstado(nombre, estado); // Filtra por ambos.
        }
    }

    @Override
    @Transactional
    public void eliminarProducto(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("El producto con ID " + id + " no existe.");
        }
        repository.deleteById(id);
    }

    @Override
    public boolean existeProductoPorNombre(String nombre) {
        return repository.existsByNombre(nombre);
    }

    @Override
    @Transactional
    public void eliminarProductosPorEstado(String estado) {
        if (estado == null || estado.isBlank()) {
            throw new IllegalArgumentException("El estado no puede ser nulo o vacío.");
        }
        repository.eliminarProductosPorEstado(estado);
    }
}
