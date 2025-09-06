package practicas.proyecciones.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practicas.proyecciones.persistence.entities.Cliente;
import practicas.proyecciones.persistence.entities.Pedido;
import practicas.proyecciones.persistence.projections.simples.ClienteProyeccionSimple;
import practicas.proyecciones.persistence.repositories.ClienteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listar() throws Exception{
        try {
            return clienteRepository.findAllBy();
        } catch (Exception ex) {
            throw new Exception("No se Encontraron los Clientes");
        }
    }

    public ClienteProyeccionSimple listarProyeccionSimple(String nombre) throws Exception {
        try {
            return clienteRepository.findAllByNombre(nombre);
        } catch (Exception ex) {
            throw new Exception("No se filtro la proyeccion simple");
        }
    }

    public List<Pedido> listarPedidos(String nombre) throws Exception {
        try {
            return clienteRepository.findByListPedidosForCliente(nombre);
        } catch (Exception ex) {
            throw new Exception("No se filtra por query");
        }

    }

}
