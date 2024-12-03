package proyect.marklean27.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavegacionControlador {

    @GetMapping("/navegacion/venta")
    public String mostrarVentas() {
        return "venta"; // Nombre de la plantilla (ventas.html)
    }

    @GetMapping("/navegacion/productos")
    public String mostrarProductos() {
        return "productos"; // Nombre de la plantilla (productos.html)
    }

    @GetMapping("/navegacion/clientes")
    public String mostrarClientes() {
        return "clientes"; // Nombre de la plantilla (clientes.html)
    }


    @GetMapping("/navegacion/proveedor")
    public String mostrarProveedores() {
        return "proveedor"; // Nombre de la plantilla (proveedores.html)
    }

    @GetMapping("/navegacion/dashboard")
    public String mostrarDashboard() {
        return "dashboard"; // Nombre de la plantilla (dashboard.html)
    }
}
