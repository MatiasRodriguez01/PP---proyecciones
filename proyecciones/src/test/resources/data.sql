USE proyecciones;

INSERT INTO cliente(nombre, email) VALUES
                                         ('Juan Perez', 'juan@example.com' ),
                                         ('Maria Garcia', 'maria@example.com' );
INSERT INTO producto(nombre, precio) VALUES
                                         ('Laptop', 1500.00),
                                         ('Telefono', 800.00),
                                         ('Mouse', 100.0),
                                         ('Teclado', 200.00);

INSERT INTO pedido(fecha, cliente_id) VALUES
                                          ('2023-10-21', 1),
                                          ('2023-10-22', 1);

INSERT INTO pedidos_cliente(cliente_id, pedido_id) VALUES
                                                       (1, 1),
                                                       (1, 2);

INSERT INTO pedido_productos(pedido_id, producto_id) VALUES
                                                         (1, 1),
                                                         (1, 2),
                                                         (2, 3),
                                                         (2, 4);

