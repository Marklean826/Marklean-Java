package proyect.marklean27.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyect.marklean27.Entidad.DashboardEntidad;
import proyect.marklean27.Repository.DashboardRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DashboardServicioImpl implements DashboardServicio {

    @Autowired
    private DashboardRepository repository;

    @Override
    public List<DashboardEntidad> listarMetricas() {
        return repository.findAll();
    }

    @Override
    public DashboardEntidad obtenerMetricaPorId(Long id) {
        Optional<DashboardEntidad> metrica = repository.findById(id);
        return metrica.orElse(null);
    }

    @Override
    public DashboardEntidad guardarMetrica(DashboardEntidad metrica) {
        return repository.save(metrica);
    }

    @Override
    public void eliminarMetrica(Long id) {
        repository.deleteById(id);
    }
}
