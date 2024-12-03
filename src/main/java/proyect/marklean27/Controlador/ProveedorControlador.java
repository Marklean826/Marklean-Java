package proyect.marklean27.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import proyect.marklean27.Servicio.ProveedorServicio;



@Controller
public class ProveedorControlador {

    @Autowired
    private ProveedorServicio servicio;


    @GetMapping("/proveedor")
    public String listarProveedor(Model modelo) {

        modelo.addAttribute("proveedor", servicio.listarProveedor());
        return "proveedor"; // Archivo HTML "proveedores"
    }
}
