package practicas.proyecciones.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practicas.proyecciones.persistence.entities.Pedido;
import practicas.proyecciones.persistence.projections.PedidoProyeccion;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {


    List<PedidoProyeccion> findByClienteNombre(String nombre);

}
