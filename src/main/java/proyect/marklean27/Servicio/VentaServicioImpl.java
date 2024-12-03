package proyect.marklean27.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyect.marklean27.Entidad.VentaEntidad;
import proyect.marklean27.Repository.VentaRepository;

import java.util.List;

@Service
public class VentaServicioImpl implements VentaServicio {

    @Autowired
    private VentaRepository repository;

    @Override
    public List<VentaEntidad> listarVentas() {
        return repository.findAll();
    }
}
