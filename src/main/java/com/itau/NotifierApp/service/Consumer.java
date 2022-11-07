package com.itau.NotifierApp.service;

import com.itau.NotifierApp.domain.Conta;
import com.itau.NotifierApp.domain.Notificacao;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static java.lang.Double.valueOf;

@Service
public class Consumer {
    private static final Logger log = LoggerFactory.getLogger(Consumer.class);

    @JmsListener(destination = "dlq")
    public void process(String stringJson) {
        log.info("Message Received using SQS Listner " + stringJson);
        try {
            JSONObject jsonObject = new JSONObject(stringJson);
            Long id_conta = Long.valueOf(jsonObject.getString("id_conta"));
            Long agencia = Long.valueOf(jsonObject.getString("agencia"));
            Long numero_conta = Long.valueOf(jsonObject.getString("conta"));
            Integer digito = Integer.valueOf(jsonObject.getString("digito_conta"));
            Double valor_movimento = Double.valueOf(jsonObject.getString("valor_movimento"));

            Conta conta = new Conta(id_conta,agencia,numero_conta,digito);
            if (conta.getSaldo() - valor_movimento < 0) {
                log.info("Passou");

            }

        }catch (JSONException err){
            log.error("Queue object not accepted", err.toString());
        }

    }
}
