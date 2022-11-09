package com.itau.NotifierApp.api;

import com.itau.NotifierApp.domain.Notificacao;
import com.itau.NotifierApp.repository.NotificacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@RestController
public class HistoryApi {
        private static final Logger LOG = LoggerFactory.getLogger(HistoryApi.class);

        @Autowired
        private NotificacaoRepository notificacaoRepository;

        @GetMapping("/historico")
        public List<Notificacao> index(){
            return notificacaoRepository.findAll();
        }

}
