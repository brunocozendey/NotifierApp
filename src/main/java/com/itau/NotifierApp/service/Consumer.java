package com.itau.NotifierApp.service;

import com.itau.NotifierApp.domain.Conta;
import com.itau.NotifierApp.domain.Notificacao;
import com.itau.NotifierApp.repository.NotificacaoRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

import static java.lang.Double.valueOf;

@Service
public class Consumer {
    private static final Logger log = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @Autowired
    private NotificationPusblisher notificationPusblisher;

    @JmsListener(destination = "dlq")
    public void process(String stringJson) {
        log.info("Message Received using SQS Listner " + stringJson);
        try {
            JSONObject jsonObject = new JSONObject(stringJson);
            Long numero_conta = Long.valueOf(jsonObject.getString("numero_conta"));
            Long agencia = Long.valueOf(jsonObject.getString("agencia"));
            Integer digito = Integer.valueOf(jsonObject.getString("digito_conta"));
            Double valor_movimento = Double.valueOf(jsonObject.getString("valor_movimento"));
            Conta conta = new Conta(agencia,numero_conta,digito);
            Notificacao notificacao = new Notificacao(conta.getId_conta(), valor_movimento);
            if (conta.getSaldo() + valor_movimento < 0) {
                notificacaoRepository.save(notificacao);
                notificationPusblisher.publishNotificationEvent("Conta"+conta.getId_conta()+"negativado em "+conta.getSaldo());
            }

        }catch (Exception err){
            log.error("Queue object not accepted "+err.toString());
        }

    }
}
