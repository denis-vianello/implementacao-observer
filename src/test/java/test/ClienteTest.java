/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.mycompany.rastreamentocargas.Carga;
import com.mycompany.rastreamentocargas.Cliente;

/**
 *
 * @author PICHAU
 */
public class ClienteTest {

    @Test
    public void deveNotificarUmCliente() {
        Carga carga = new Carga("C001", "São Paulo");
        Cliente cliente = new Cliente("Cliente 1");

        cliente.acompanharCarga(carga);
        carga.atualizarStatus("Em transporte");

        assertEquals(
                "Cliente 1, a carga C001 teve seu status atualizado para: Em transporte",
                cliente.getUltimaNotificacao()
        );
    }

    @Test
    public void deveNotificarClientes() {
        Carga carga = new Carga("C002", "Rio de Janeiro");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");

        cliente1.acompanharCarga(carga);
        cliente2.acompanharCarga(carga);

        carga.atualizarStatus("Em transporte");

        assertEquals(
                "Cliente 1, a carga C002 teve seu status atualizado para: Em transporte",
                cliente1.getUltimaNotificacao()
        );

        assertEquals(
                "Cliente 2, a carga C002 teve seu status atualizado para: Em transporte",
                cliente2.getUltimaNotificacao()
        );
    }

    @Test
    public void naoDeveNotificarCliente() {
        Carga carga = new Carga("C003", "Curitiba");
        Cliente cliente = new Cliente("Cliente 1");

        carga.atualizarStatus("Em transporte");

        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    public void deveNotificarApenasClienteDaCargaAcompanhada() {
        Carga cargaA = new Carga("C004", "São Paulo");
        Carga cargaB = new Carga("C005", "Curitiba");

        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");

        cliente1.acompanharCarga(cargaA);
        cliente2.acompanharCarga(cargaB);

        cargaA.atualizarStatus("Entregue");

        assertEquals(
                "Cliente 1, a carga C004 teve seu status atualizado para: Entregue",
                cliente1.getUltimaNotificacao()
        );

        assertNull(cliente2.getUltimaNotificacao());
    }
}