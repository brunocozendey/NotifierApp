package com.itau.NotifierApp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itau.NotifierApp.domain.Conta;
import com.itau.NotifierApp.domain.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;

@Service
public class ContaService {
    private static final Logger LOG = LoggerFactory.getLogger(ContaService.class);

    @Value("${api.uri}")
    private String endpoint;

    @Autowired
    RestTemplate restTemplate;

    public String getSaldo(String conta) {
        String uri = endpoint + conta + "/saldos";
        System.out.println(endpoint + conta + "/saldos");
        Data data = restTemplate.getForObject(uri, Data.class);
        return data.getSaldo().toString();
    }

}
