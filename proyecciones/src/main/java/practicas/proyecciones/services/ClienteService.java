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

    // usando la proyeccion dinamica retornamos una lista de clientes usando la entidad
    public List<Cliente> listarClientes() throws Exception{
        try {
            return clienteRepository.findAllBy(Cliente.class);
        } catch (Exception ex) {
            throw new Exception("No se Encontraron los Clientes");
        }
    }

    // usando la proyeccion dinamica retornamos un cliente por proyeccion simple
    public ClienteProyeccionSimple listarProyeccionSimple(String nombre) throws Exception {
        try {
            return clienteRepository.findFirstByNombre(nombre, ClienteProyeccionSimple.class);
        } catch (Exception ex) {
            throw new Exception("No se filtro la proyeccion simple");
        }
    }

    // usando la proyeccion dinamica retornamos una lista de clientes por proyeccion simple
    public List<ClienteProyeccionSimple> listarClientesPorProyeccionSimple(String proyeccion)  {
        try {
            return clienteRepository.findAllBy(ClienteProyeccionSimple.class);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo filtrar los clientes por proyección", e);
        }
    }


    // Aca usamos la query hecha en el repositorio para retornar los pedidos del cliente usando su nombre
    public List<Pedido> listarPedidos(String nombre) throws Exception {
        try {
            return clienteRepository.findByListPedidosForCliente(nombre);
        } catch (Exception ex) {
            throw new Exception("No se filtra por query");
        }

    }

}
