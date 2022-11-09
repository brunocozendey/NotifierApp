#SQS
aws --endpoint-url http://localhost:9324 sqs send-message --queue-url http://localhost:9324/queue/default --message-body '{"agencia":123,"numero_conta":123456,"digito_conta":1,"valor_movimento":200}'

#SNS
aws sns --endpoint-url http://localhost:9911 create-topic --name test2
aws sns --endpoint-url http://localhost:9911 publish --topic-arn arn:aws:sns:eu-west-2:123450000001:test-topic --message "Hello World!"
