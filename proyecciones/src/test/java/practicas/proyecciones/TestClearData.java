package practicas.proyecciones;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import practicas.proyecciones.persistence.projections.abiertas.ProductosProyeccionAbierta;
import practicas.proyecciones.persistence.projections.clasesDTO.ProductoDTO;
import practicas.proyecciones.persistence.repositories.ProductRepository;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
@Sql(scripts = "/data.sql")
@Sql(scripts = "/clean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class TestClearData {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void run() {

        List<ProductoDTO> productos = productRepository.findProductoByDTO();
        assertThat(productos).hasSize(4);
        for(ProductoDTO p : productos) {
            System.out.println(p);
        }

        List<ProductosProyeccionAbierta> ps = productRepository.findAllOpenProjectedBy();
        assertThat(ps).hasSize(4);
        for(ProductosProyeccionAbierta p : ps) {
            System.out.println(p.getFullData());
        }
    }
}
