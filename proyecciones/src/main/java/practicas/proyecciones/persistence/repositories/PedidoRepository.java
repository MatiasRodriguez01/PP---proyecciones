package practicas.proyecciones.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practicas.proyecciones.persistence.entities.Pedido;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // proyeccion dinamica
    <T> List<T> findAllByClienteNombre(String nombre, Class<T> type);
  
}
