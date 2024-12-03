package proyect.marklean27.Servicio;

import proyect.marklean27.Entidad.DashboardEntidad;

import java.util.List;

public interface DashboardServicio {
    List<DashboardEntidad> listarMetricas();
    DashboardEntidad obtenerMetricaPorId(Long id);
    DashboardEntidad guardarMetrica(DashboardEntidad metrica);
    void eliminarMetrica(Long id);
}
