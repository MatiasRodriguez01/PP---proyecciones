package practicas.proyecciones;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import practicas.proyecciones.persistence.entities.Pedido;
import practicas.proyecciones.persistence.projections.compuestas.ClienteProyeccionCompuesta;
import practicas.proyecciones.persistence.projections.simples.ClienteProyeccionSimple;
import practicas.proyecciones.persistence.projections.compuestas.PedidoProyeccionCompuesta;
import practicas.proyecciones.persistence.repositories.ClienteRepository;
import practicas.proyecciones.persistence.repositories.PedidoRepository;
import practicas.proyecciones.services.ClienteService;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql(scripts = "/data.sql")
@Sql(scripts = "/clean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class PedidoProyeccionTest {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @Test
    public void testBuscarPedidosConCliente() throws Exception {
        List<PedidoProyeccionCompuesta> pedidos = pedidoRepository.findByClienteNombre("Juan Perez");

        assertThat(pedidos).hasSize(2);

        PedidoProyeccionCompuesta pedido = pedidos.get(0);
        assertThat(pedido.getId()).isNotNull();
        assertThat(pedido.getFecha()).isEqualTo("2023-10-21");

        ClienteProyeccionSimple cliente = clienteRepository.findAllByNombre("Juan Perez");
        assertThat(cliente.getNombre()).isEqualTo("Juan Perez");
        assertThat(cliente.getEmail()).isEqualTo("juan@example.com");

        System.out.println("--------------------------");
        System.out.println("Pedido ID: " + pedido.getId());
        System.out.println("Fecha: " + pedido.getFecha());
        System.out.println("Cliente: " + cliente.getNombre() + " - " + cliente.getEmail());

        System.out.println("--------------------------");
        System.out.println("Pedidos del cliente " + cliente.getNombre());

        List<Pedido> ps = clienteService.listarPedidos("Juan");
        for (Pedido p : ps){
            System.out.println(p);
        }

    }
}
