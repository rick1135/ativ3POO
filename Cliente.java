/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ativ3;

/**
 *
 * @author rick1
 */
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private Long id;
    private Long cpf;
    private String nome;
    private final List<Contrato> contratos;

    public Cliente(Long id, Long cpf, String nome) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.contratos = new ArrayList<>();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    // Método para adicionar um contrato a lista de contratos do cliente
    public void adicionarContrato(Contrato contrato) {
        contratos.add(contrato);
    }
    
    // Método para remover um contrato da lista de contratos do cliente
    public void removerContrato(Contrato contrato) {
        contratos.remove(contrato);
    }
    
    // Método para obter a lista de contratos do cliente
    public List<Contrato> getContratos() {
        return contratos;
    }
}

