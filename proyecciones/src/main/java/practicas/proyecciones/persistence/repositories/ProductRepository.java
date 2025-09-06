package practicas.proyecciones.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import practicas.proyecciones.persistence.entities.Producto;
import practicas.proyecciones.persistence.projections.abiertas.ProductosProyeccionAbierta;
import practicas.proyecciones.persistence.projections.simples.ProductoProyeccionSimple;
import practicas.proyecciones.persistence.projections.clasesDTO.ProductoDTO;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Producto, Long> {


    List<ProductoProyeccionSimple> findAllProjectedBy();

    List<ProductosProyeccionAbierta> findAllOpenProjectedBy();

    @Query("SELECT new practicas.proyecciones.persistence.projections.clasesDTO.ProductoDTO(p.nombre, p.precio) From Producto p")
    List<ProductoDTO> findProductoByDTO();

}
