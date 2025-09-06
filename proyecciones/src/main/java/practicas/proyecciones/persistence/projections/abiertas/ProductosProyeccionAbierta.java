package practicas.proyecciones.persistence.projections.abiertas;

import org.springframework.beans.factory.annotation.Value;

public interface ProductosProyeccionAbierta {

    @Value("#{target.precio + ' ' + target.nombre}")
    String getFullData();

}