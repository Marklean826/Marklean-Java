
package proyect.marklean27.Servicio;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyect.marklean27.Entidad.ClienteEntidad;
import proyect.marklean27.Repository.ClienteRepository;




@Service
public class ClienteServicioImpl implements ClienteServicio{

    @Autowired
    private ClienteRepository repository;
    
    @Override
    public List<ClienteEntidad> listarCliente() {
       
        return repository.findAll();
    }
    
          
    }
    