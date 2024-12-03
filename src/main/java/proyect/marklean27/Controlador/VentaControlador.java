package proyect.marklean27.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import proyect.marklean27.Servicio.VentaServicio;

@Controller
public class VentaControlador {

    @Autowired
    private VentaServicio Servicio;

    @GetMapping("/venta")
    public String listarVentas(Model modelo) {
        modelo.addAttribute("venta", Servicio.listarVentas());
        return "venta"; // Archivo HTML "ventas"
    }
}
