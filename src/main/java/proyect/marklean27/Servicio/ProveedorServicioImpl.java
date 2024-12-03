package proyect.marklean27.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyect.marklean27.Entidad.ProveedorEntidad;
import proyect.marklean27.Repository.ProveedorRepository;

import java.util.List;

@Service
public class ProveedorServicioImpl implements ProveedorServicio {

    @Autowired
    private ProveedorRepository repository;

    @Override
    public List<ProveedorEntidad> listarProveedor() {
        return repository.findAll();
    }
}
