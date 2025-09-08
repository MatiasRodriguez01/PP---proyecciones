package practicas.proyecciones;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import practicas.proyecciones.persistence.projections.compuestas.PedidoProyeccionCompuesta;
import practicas.proyecciones.persistence.repositories.ClienteRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql(scripts = "/data.sql")
@Sql(scripts = "/clean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class ClientePedidosProyeccionCompuestaTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void test() {
        ClienteProyeccionCompuesta cliente = clienteRepository.findFirstByNombre("Juan Perez", ClienteProyeccionCompuesta.class);

        assertThat(cliente.getNombre()).isEqualTo("Juan Perez");
        assertThat(cliente.getEmail()).isEqualTo("juan@example.com");

        System.out.println("Cliente: " + cliente.getNombre() + " - " + cliente.getEmail());
        System.out.println(cliente.getPedidos().size());

        List<PedidoProyeccionCompuesta> pedidos = cliente.getPedidos();
        System.out.println("--------------------");
        for (PedidoProyeccionCompuesta p : pedidos) {
            System.out.println("Id: " + p.getId());
            System.out.println("Fecha: " + p.getFecha());
            System.out.println("Productos : " + p.getProductos().size());
        }


    }

}
