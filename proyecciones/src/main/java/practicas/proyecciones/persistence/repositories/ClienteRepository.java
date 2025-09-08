package practicas.proyecciones.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import practicas.proyecciones.persistence.entities.Cliente;
import practicas.proyecciones.persistence.entities.Pedido;
import practicas.proyecciones.persistence.projections.simples.ClienteProyeccionSimple;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // proyeccion dimanca que muestra una lista
    <T> List<T> findAllBy(Class<T> type);

    // proyeccion dinamica que muestra un objeto
    <T> T findFirstByNombre(String nombre, Class<T> type);

    // query
    @Query(value = """
        SELECT p.* FROM pedido p
                INNER JOIN pedidos_cliente pc ON pc.pedido_id = p.id
                INNER JOIN cliente c ON c.id = p.cliente_id
            WHERE c.nombre = :nombre;  
    """, nativeQuery = true)
    List<Pedido> findByListPedidosForCliente(@Param("nombre") String nombre);

}
