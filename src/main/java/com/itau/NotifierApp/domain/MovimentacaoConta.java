package com.itau.NotifierApp.domain;


public class MovimentacaoConta {
    private Integer agencia;
    private Integer numero_conta;
    private Integer digito_conta;
    private Double valor_movimento;

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getNumero_conta() {
        return numero_conta;
    }

    public void setNumero_conta(Integer numero_conta) {
        this.numero_conta = numero_conta;
    }

    public Integer getDigito_conta() {
        return digito_conta;
    }

    public void setDigito_conta(Integer digito_conta) {
        this.digito_conta = digito_conta;
    }

    public Double getValor_movimento() {
        return valor_movimento;
    }

    public void setValor_movimento(Double valor_movimento) {
        this.valor_movimento = valor_movimento;
    }
}
