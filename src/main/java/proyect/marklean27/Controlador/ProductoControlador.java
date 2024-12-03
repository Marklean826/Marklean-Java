package proyect.marklean27.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import proyect.marklean27.Servicio.ProductoServicio;
import proyect.marklean27.Entidad.ProductoEntidad;
import proyect.marklean27.Repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductoControlador {

    @Autowired
    private ProductoServicio servicio;

  // Mostrar lista de productos
  @GetMapping("/productos")
  public String listarProducto(Model modelo) {
      modelo.addAttribute("productos", servicio.listarProducto()); // Cargar todos los productos
      return "productos"; // Nombre de la vista de productos
  }

  // Buscar productos sin redirigir a otra página (usando AJAX)
  @GetMapping("/productos/buscar")
  @ResponseBody
  public List<ProductoEntidad> buscarProducto(@RequestParam(required = false) String nombreProducto, 
                                               @RequestParam(required = false) String estadoProducto) {
      return servicio.buscarProductos(nombreProducto, estadoProducto); // Llamada al servicio para buscar productos
  }

  @PostMapping("/productos/{id}/actualizarStock")
@ResponseBody
public ProductoEntidad actualizarStock(@PathVariable Long id, @RequestBody Integer cantidad) {
    return servicio.agregarStock(id, cantidad);
}

@PostMapping("/productos")
@ResponseBody
public ResponseEntity<?> agregarProducto(@RequestBody ProductoEntidad producto) {
    try {
        ProductoEntidad nuevoProducto = servicio.guardarProducto(producto);
        return ResponseEntity.ok(nuevoProducto);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al agregar el producto: " + e.getMessage());
    }

}

// Eliminar producto
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long id) {
        Optional<ProductoEntidad> producto = ProductoRepository.eliminarProductosPorEstado(id);
        if (producto.isPresent()) {
            ProductoRepository.eliminarProductosPorEstado(id);
            return ResponseEntity.ok("Producto eliminado exitosamente.");
        } else {
            return ResponseEntity.status(404).body("Producto no encontrado.");
        }
    }







    // mas metodos acá
}   
