package practicas.proyecciones.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practicas.proyecciones.persistence.projections.abiertas.ProductosProyeccionAbierta;
import practicas.proyecciones.persistence.projections.clasesDTO.ProductoDTO;
import practicas.proyecciones.persistence.projections.simples.ProductoProyeccionSimple;
import practicas.proyecciones.persistence.repositories.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductoProyeccionSimple> listarProductosProyeccionSimple() throws Exception {
        try {
            return productRepository.findAllProjectedBy();
        } catch (Exception e) {
            throw new Exception("No se filtro la lista de productos por proyeccion simple!!");
        }
    }

    public List<ProductosProyeccionAbierta> listarProductosProyeccionAbierta() throws Exception {
        try {
            return productRepository.findAllOpenProjectedBy();
        } catch (Exception e) {
            throw new Exception("No se filtro la lista de productos por proyeccion abierta!!");
        }
    }

    public List<ProductoDTO> listarProductosProyeccionBasadaEnClases() throws Exception {
        try {
            return productRepository.findProductoByDTO();
        } catch (Exception e) {
            throw new Exception("No se filtro la lista de productos por proyeccion basada en clases!!");
        }
    }

}
