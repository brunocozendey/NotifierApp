package com.itau.NotifierApp.repository;

import com.itau.NotifierApp.domain.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Integer> {
    public List<Notificacao> findAll();
}
