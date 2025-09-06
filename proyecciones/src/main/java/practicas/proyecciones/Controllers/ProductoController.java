package practicas.proyecciones.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practicas.proyecciones.persistence.projections.abiertas.ProductosProyeccionAbierta;
import practicas.proyecciones.persistence.projections.clasesDTO.ProductoDTO;
import practicas.proyecciones.persistence.projections.simples.ProductoProyeccionSimple;
import practicas.proyecciones.services.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/listaSimple")
    public List<ProductoProyeccionSimple> listarProductoProyeccionSimple() throws Exception {
        return productoService.listarProductosProyeccionSimple();
    }

    @GetMapping("/listaAbierta")
    public List<ProductosProyeccionAbierta>  listarProductoProyeccionAbierta() throws Exception {
        return productoService.listarProductosProyeccionAbierta();
    }

    @GetMapping("/listaDTO")
    public List<ProductoDTO> listarProductoProyeccionBasadaEnClase() throws Exception {
        return productoService.listarProductosProyeccionBasadaEnClases();
    }
}
