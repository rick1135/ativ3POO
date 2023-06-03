package com.mycompany.ativ3;

import com.mycompany.ativ3.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ativ3";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "325158";

    public void inserir(Cliente cliente) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO cliente (id, cpf, nome) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, cliente.getId());
                statement.setLong(2, cliente.getCpf());
                statement.setString(3, cliente.getNome());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Cliente cliente) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "UPDATE cliente SET cpf = ?, nome = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, cliente.getCpf());
                statement.setString(2, cliente.getNome());
                statement.setLong(3, cliente.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cliente buscarPorId(Long id) {
        Cliente cliente = null;
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "SELECT id, cpf, nome FROM cliente WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Long cpf = resultSet.getLong("cpf");
                        String nome = resultSet.getString("nome");
                        cliente = new Cliente(id, cpf, nome);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    public List<Cliente> buscarTodos() {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "SELECT id, cpf, nome FROM cliente";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    Long id = resultSet.getLong("id");
                    Long cpf = resultSet.getLong("cpf");
                    String nome = resultSet.getString("nome");
                    Cliente cliente = new Cliente(id, cpf, nome);
                    clientes.add(cliente);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public void excluir(Long id) {
    try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
        // Excluir contratos relacionados ao cliente, para depois isso excluir o cliente em si
        String sqlContratos = "DELETE FROM contrato WHERE cliente_id = ?";
        PreparedStatement statementContratos = conn.prepareStatement(sqlContratos);
        statementContratos.setLong(1, id);
        statementContratos.executeUpdate();
        
        // Excluir cliente
        String sqlCliente = "DELETE FROM cliente WHERE id = ?";
        PreparedStatement statementCliente = conn.prepareStatement(sqlCliente);
        statementCliente.setLong(1, id);
        statementCliente.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }

}
