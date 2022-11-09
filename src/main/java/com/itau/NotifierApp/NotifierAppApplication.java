package com.itau.NotifierApp;

import com.itau.NotifierApp.domain.Conta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaRepositories
public class NotifierAppApplication {

	private static final Logger log = LoggerFactory.getLogger(NotifierAppApplication.class);

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(NotifierAppApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner demo() {
//		return (args) -> {
//			// save a few customers
//			Conta conta = new Conta();
//			conta.setConta(123456L);
//			conta.setAgencia(123L);
//			conta.setDigito_conta(1);
//			conta.setId_conta();
//			log.info(conta.getId_conta().toString());
//			conta.setSaldo();
//			log.info("Saldo:"+conta.getSaldo());
//
//			// fetch all customers
//			log.info("Conta criada:");
//			log.info("-------------------------------");
//			log.info(conta.getId_conta().toString());
//			//log.info(queueMessagingTemplate.receive("dlq").getPayload().toString());
//			try {
//				log.info(queueMessagingTemplate.receiveAndConvert("dlq", MovimentacaoConta.class).getValor_movimento().toString());
//			}
//			catch (Exception e){
//				throw e;
//			}

			//MovimentacaoConta conta2 = this.queueMessagingTemplate.receiveAndConvert("default", MovimentacaoConta.class);
			//log.info(conta2.getValor_movimento().toString());
			//aws --endpoint-url http://localhost:9324 sqs send-message --queue-url http://localhost:9324/queue/default --message-body '{"agencia":123,"numero_conta":123456,"digito_conta":1,"valor_movimento":200}'

//		};
//	}


}
