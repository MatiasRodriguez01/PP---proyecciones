package practicas.proyecciones.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practicas.proyecciones.persistence.entities.Pedido;
import practicas.proyecciones.persistence.projections.compuestas.PedidoProyeccionCompuesta;
import practicas.proyecciones.persistence.projections.simples.PedidoProyeccionSimple;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Override
    Optional<Pedido> findById(Long Long);

    Optional <PedidoProyeccionSimple> findByClienteNombre(String nombre);

    List<PedidoProyeccionSimple> findAllPedidosBy();

    List<PedidoProyeccionCompuesta> findAllByClienteNombre(String nombre);
  
}
