package com.itau.NotifierApp.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

public class Conta {

    @Id
    @Column(nullable = false)
    private Long id_conta;

    @Column(nullable = false)
    private Long agencia;

    @Column(nullable = false)
    private Long conta;

    @Column(nullable = false)
    private Integer digito_conta;

    @Column(nullable = false)
    private Double saldo;

    public Conta(Long id_conta, Long agencia, Long conta, Integer digito_conta) {
        this.id_conta = id_conta;
        this.agencia = agencia;
        this.conta = conta;
        this.digito_conta = digito_conta;
    }

    RestTemplate restTemplate = new RestTemplate();
    public Long getId_conta() {
        return id_conta;
    }

    public void setId_conta() {
        this.id_conta = Long.valueOf(String.valueOf(this.agencia)+String.valueOf(this.conta)+String.valueOf(this.digito_conta));
    }

    public Long getAgencia() {
        return agencia;
    }

    public void setAgencia(Long agencia) {
        this.agencia = agencia;
    }

    public Long getConta() {
        return conta;
    }

    public void setConta(Long conta) {
        this.conta = conta;
    }

    public Integer getDigito_conta() {
        return digito_conta;
    }

    public void setDigito_conta(Integer digito_conta) {
        this.digito_conta = digito_conta;
    }

    public Double getSaldo() {
        String uri = "http://localhost/contas/" + this.id_conta + "/saldos";
        System.out.println(uri);

        ApiConsumer api = restTemplate.getForObject(uri, ApiConsumer.class);

        return api.getData().getSaldo();
//        try {
//            Object[] saldo = restTemplate.getForObject(uri, Object[].class);
//
//            //this.saldo = Double.parseDouble(contaService.getSaldo(this.id_conta.toString()));
//            return contaService.getSaldo(this.id_conta.toString());
//
//        }
//        catch (Exception e) {
//            throw new RuntimeException("Problema ao conectar a API url:");
//        }
        //System.out.println(saldo.toString());
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
