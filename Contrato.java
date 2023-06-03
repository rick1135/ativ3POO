/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ativ3;

/**
 *
 * @author rick1
 */
import java.time.LocalDate;

import java.time.LocalDate;

public class Contrato {
    private Long id;
    private String redacao;
    private LocalDate ultimaAtualizacao;
    private Cliente cliente;

    public Contrato(Long id, String redacao, LocalDate ultimaAtualizacao) {
        this.id = id;
        this.redacao = redacao;
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRedacao() {
        return redacao;
    }

    public void setRedacao(String redacao) {
        this.redacao = redacao;
    }

    public LocalDate getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(LocalDate ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }
    
    
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

