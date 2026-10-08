/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rastreamentocargas;

/**
 *
 * @author PICHAU
 */
import java.util.Observable;

public class Carga extends Observable {

    private String codigo;
    private String destino;
    private String status;

    public Carga(String codigo, String destino) {
        this.codigo = codigo;
        this.destino = destino;
        this.status = "Em preparação";
    }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
        setChanged();
        notifyObservers();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDestino() {
        return destino;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Carga{" +
                "codigo='" + codigo + '\'' +
                ", destino='" + destino + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
