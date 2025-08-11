package practicas.proyecciones.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practicas.proyecciones.persistence.entities.Producto;
import practicas.proyecciones.persistence.projections.ProductoProyeccion;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Producto, Long> {

    List<ProductoProyeccion> findAllBy();
}
