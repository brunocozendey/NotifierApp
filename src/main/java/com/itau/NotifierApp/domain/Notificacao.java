package com.itau.NotifierApp.domain;

import com.itau.NotifierApp.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private Long id_conta;

    @Column(nullable = false)
    private Date data;

    @Column(nullable = false)
    private Double valor;

    public Notificacao(){

    }

    public Notificacao(int id, Long id_conta, Date created_at, Double valor) {
        this.id = id;
        this.id_conta = id_conta;
        this.data = created_at;
        this.valor =valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getId_conta() {
        return id_conta;
    }

    public void setId_conta(Long id_conta) {
        this.id_conta = id_conta;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor =valor;
    }

    @Override
    public String toString(){
        return "Notificacao{"+
                "id="+ id +
                ", id_conta="+ id_conta +
                ", data="+ data +
                ", valor="+ valor +
                "}";

    }
}
