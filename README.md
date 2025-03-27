# Simulador de Crédito

## Iniciar aplicação
1. subir docker para inicializar o kafka

   
        docker compose up
3. subir o projeto localmente
4. Fazer request na localmente para a porta 8083
    
        http://localhost:8083/loan/calculate
    
### Linter foi utilizando o klint
    ./gradlew ktlintCheck
    // checar se a erros de formatação no codigo 

    ./gradlew ktlintFormat 
    // formata partes dos codigos



# SimuladordeCredito

## 1. Visão Geral do Projeto:
### 🛠️ Simulador de Crédito - Backend
Este projeto consiste em uma API backend para simulação de crédito, permitindo que os usuários insiram informações sobre o empréstimo desejado e recebam cálculos detalhados sobre os valores das parcelas, total a ser pago e juros pago.


## Diagrama de sequencia

![TLH1Zjf04BnRyXzQv098y00EqIAl3mXBGOOye1atx2JsZ3Cp9knxSeZsaDC-mHzBpzYm9W4VfslALLrbFrc7nZLL6KSed3RmrPA9epZQwpEC4gomG2W8bdKf1RQ_srzw19zAUNnn-xAXE09-QgQGGjQe78moZIgd7mrPDmAqaEKFG0cMeYdHISrusvGzFBc7N-FXEyB6](https://github.com/user-attachments/assets/44e2f4ce-0f3a-4a10-acc2-1b7d2390b2e5)


### Tecnologias Utilizadas:
#### Kotlin:
O Kotlin oferece sintaxe concisa e segurança contra nulabilidade, tornando o código menos verboso e mais limpo, com boa interoperabilidade com Java.

#### Springboot:
O Spring Boot facilitou a criação da API REST, com configuração simplificada e integração com Kafka para escalabilidade.

#### Docker:
Docker foi usado para criar um container Kafka, garantindo um ambiente isolado e replicável.

#### Kafka:
Kafka gerencia o envio de e-mails com a simulação de crédito de forma assíncrona, melhorando a escalabilidade.

### Padrão de Arquitetura - clean Architecture:
Parão de arquitetura **clean Architecture** 

### Application:
*    Nessa camada é encotrada a regra de negocio do projeto, determinando como as funcionalidades vão ser executadas
*    Nela temos os useCases
  ####  UseCase
*    Contém a lógica específica de um caso de uso, coordenando o fluxo de dados e interagindo com o Domain para realizar as ações necessárias. a logica seria o LoanCalculationUseCase.
####   Model
*    Representa dados de entrada e saída para a aplicação. É um objeto que transporta informações entre as camadas. logo temos o LoanCalculationResult e o LoanRequest 



## Domain:
####   Entities
*    A entidade **Client** representa o cliente que está solicitando o empréstimo. Ela contém dados como a data de nascimento e possui a função calculateAge(), que calcula a idade do cliente com base na sua data de nascimento.

*    A entidade **InterestRate** determina a taxa de juros aplicável com base na idade do cliente. A função calculateCorrectRate() utiliza a idade do cliente (calculada pelo Client) e retorna a taxa de juros correta.

*    A entidade **Loan** representa o empréstimo em si. Ela contém a lógica de cálculo do empréstimo utilizando os valores fornecidos, como o valor do empréstimo, o prazo e a taxa de juros. A função calculateLoan() realiza os cálculos do valor total a ser pago, as parcelas mensais e os juros totais.

## interface:
#### controllers
* O **LoanController** recebe requisições HTTP para calcular simulações de empréstimo, processa os dados de entrada e chama a lógica de negócios. Ele também publica os resultados no Kafka para envio de notificações assíncronas. Por fim, retorna a resposta com os detalhes da simulação de crédito.
#### model
*  O **LoanRequestModel** recebe a entrada do cliente, o **LoanResponseModel** retorna os resultados da simulação ao cliente e o **LoanSimulationNotification** envia esses dados para o Kafka, permitindo o envio de notificações assíncronas.
#### kafka
* O **KafkaProducerService** é responsável por enviar mensagens para um tópico Kafka. Ele utiliza um KafkaTemplate para publicar a mensagem de forma assíncrona e aguarda a confirmação do envio e classe **KafkaProducerConfig** configura o produtor Kafka para a aplicação.
