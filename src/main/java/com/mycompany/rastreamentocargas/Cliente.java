/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rastreamentocargas;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author PICHAU
 */


public class Cliente implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    public void acompanharCarga(Carga carga) {
        carga.addObserver(this);
    }

    @Override
    public void update(Observable carga, Object arg) {
        Carga cargaAtualizada = (Carga) carga;

        this.ultimaNotificacao = this.nome
                + ", a carga " + cargaAtualizada.getCodigo()
                + " teve seu status atualizado para: "
                + cargaAtualizada.getStatus();
    }
}
