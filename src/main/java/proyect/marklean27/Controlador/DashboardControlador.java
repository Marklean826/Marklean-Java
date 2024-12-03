package proyect.marklean27.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import proyect.marklean27.Servicio.DashboardServicio;

@Controller
public class DashboardControlador {

    @Autowired
    private DashboardServicio servicio;

    @GetMapping("/dasboard")
    public String mostrarDashboard(Model modelo) {
        modelo.addAttribute("metricas", servicio.listarMetricas());
        return "dasboard"; // Vista HTML del Dashboard
    }
}
