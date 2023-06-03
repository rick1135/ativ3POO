package com.mycompany.ativ3;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContratoDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ativ3";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "325158";

    public void inserir(Contrato contrato) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO contrato (id, redacao, ultimaAtualizacao, cliente_id) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, contrato.getId());
                statement.setString(2, contrato.getRedacao());
                statement.setDate(3, Date.valueOf(contrato.getUltimaAtualizacao()));
                statement.setLong(4, contrato.getCliente().getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Contrato contrato) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "UPDATE contrato SET redacao = ?, ultimaAtualizacao = ?, cliente_id = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, contrato.getRedacao());
                statement.setDate(2, Date.valueOf(contrato.getUltimaAtualizacao()));
                statement.setLong(3, contrato.getCliente().getId());
                statement.setLong(4, contrato.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Contrato buscarPorId(Long id) {
        Contrato contrato = null;
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "SELECT id, redacao, ultimaAtualizacao, cliente_id FROM contrato WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String redacao = resultSet.getString("redacao");
                        LocalDate ultimaAtualizacao = resultSet.getDate("ultimaAtualizacao").toLocalDate();
                        Long clienteId = resultSet.getLong("cliente_id");
                        ClienteDAO clienteDAO = new ClienteDAO();
                        Cliente cliente = clienteDAO.buscarPorId(clienteId);
                        contrato = new Contrato(id, redacao, ultimaAtualizacao);
                        contrato.setCliente(cliente);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contrato;
    }

    public List<Contrato> buscarTodos() {
        List<Contrato> contratos = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "SELECT id, redacao, ultimaAtualizacao, cliente_id FROM contrato";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    Long id = resultSet.getLong("id");
                    String redacao = resultSet.getString("redacao");
                    LocalDate ultimaAtualizacao = resultSet.getDate("ultimaAtualizacao").toLocalDate();
                    Long clienteId = resultSet.getLong("cliente_id");
                    ClienteDAO clienteDAO = new ClienteDAO();
                    Cliente cliente = clienteDAO.buscarPorId(clienteId);
                    Contrato contrato = new Contrato(id, redacao, ultimaAtualizacao);
                    contrato.setCliente(cliente);
                    contratos.add(contrato);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contratos;
    }

    public void excluir(Long id) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "DELETE FROM contrato WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
