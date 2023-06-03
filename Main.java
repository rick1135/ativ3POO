package com.mycompany.ativ3;

import com.mycompany.ativ3.Cliente;
import com.mycompany.ativ3.Contrato;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
        ContratoDAO contratoDAO = new ContratoDAO();

        // criando cliente1 e cliente2
        Cliente cliente1 = new Cliente(1L, 123456789L, "João");
        clienteDAO.inserir(cliente1);

        Cliente cliente2 = new Cliente(2L, 987654321L, "Maria");
        clienteDAO.inserir(cliente2);

        // atualizando os dados dos clientes
        cliente1.setNome("Ana Zaira");
        cliente1.setCpf(11929826303L);
        clienteDAO.atualizar(cliente1);
        System.out.println("Nome de cliente1 atualizado: " + cliente1.getNome());
        System.out.println("CPF de cliente1 atualizado: " + cliente1.getCpf());

        cliente2.setNome("Beatriz Yana");
        cliente2.setCpf(26752965030L);
        clienteDAO.atualizar(cliente2);
        System.out.println("Nome de cliente2 atualizado: " + cliente2.getNome());
        System.out.println("CPF de cliente2 atualizado: " + cliente2.getCpf()); 

        // adicionando os contratos para cliente1
        Contrato contrato1 = new Contrato(1L, "Contrato por tempo determinado", LocalDate.now());
        contrato1.setCliente(cliente1);
        contratoDAO.inserir(contrato1);
        System.out.println("Contrato adicionado a cliente1");

        Contrato contrato2 = new Contrato(2L, "Contrato por tempo indeterminado", LocalDate.now());
        contrato2.setCliente(cliente1);
        contratoDAO.inserir(contrato2);
        System.out.println("Contrato adicionado a cliente1");

        Contrato contrato3 = new Contrato(3L, "Contrato de trabalho eventual", LocalDate.now());
        contrato3.setCliente(cliente1);
        contratoDAO.inserir(contrato3);
        System.out.println("Contrato adicionado a cliente1");

        // adicionando os contratos para cliente2
        Contrato contrato4 = new Contrato(4L, "Contrato de estágio", LocalDate.now());
        contrato4.setCliente(cliente2);
        contratoDAO.inserir(contrato4);
        System.out.println("Contrato adicionado a cliente2");

        Contrato contrato5 = new Contrato(5L, "Contrato de experiência", LocalDate.now());
        contrato5.setCliente(cliente2);
        contratoDAO.inserir(contrato5);
        System.out.println("Contrato adicionado a cliente2");

        Contrato contrato6 = new Contrato(6L, "Contrato de teletrabalho", LocalDate.now());
        contrato6.setCliente(cliente2);
        contratoDAO.inserir(contrato6);
        System.out.println("Contrato adicionado a cliente2");

        Contrato contrato7 = new Contrato(7L, "Contrato intermitente", LocalDate.now());
        contrato7.setCliente(cliente2);
        contratoDAO.inserir(contrato7);
        System.out.println("Contrato adicionado a cliente2");

        // busca por cliente específico
        Cliente clienteBuscado = clienteDAO.buscarPorId(1L);
        System.out.println("Cliente buscado: " + clienteBuscado.getNome());

        // buscando todos clientes
        List<Cliente> todosClientes = clienteDAO.buscarTodos();
        System.out.println("Todos os clientes:");
        for (Cliente cliente : todosClientes) {
            System.out.println(cliente.getNome());
        }

        // busca por contrato específico
        Contrato contratoBuscado = contratoDAO.buscarPorId(1L);
        System.out.println("Contrato buscado: " + contratoBuscado.getRedacao());

        // busca por todos os contratos
        List<Contrato> todosContratos = contratoDAO.buscarTodos();
        System.out.println("Todos os contratos:");
        for (Contrato contrato : todosContratos) {
            System.out.println(contrato.getRedacao());
        }

        // removendo cliente específico
        clienteDAO.excluir(1L);
        System.out.println("Cliente removido");
        
        
        // removendo contrato específico
        contratoDAO.excluir(1L);
        System.out.println("Contrato removido");
    }
}
