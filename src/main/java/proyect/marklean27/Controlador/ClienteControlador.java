package proyect.marklean27.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import proyect.marklean27.Servicio.ClienteServicio;



@Controller
public class ClienteControlador{
    
    @Autowired
    private ClienteServicio servicio;
    
    
    @GetMapping("/clientes")
    public String listarCliente(Model modelo){
        
            modelo.addAttribute("clientes", servicio.listarCliente());
            return "clientes"; //retorna a archivo clientes
                    
    }
}

