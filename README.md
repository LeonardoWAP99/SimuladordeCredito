# SimuladordeCredito

## Iniciar aplicação
### subir docker
    docker compose up
    --inicia o kafka
### Linter foi utilizando o klint
    ./gradlew ktlintCheck
    --checar se a erros de formatação no codigo 

    ./gradlew ktlintFormat 
    --formata partes dos codigos



# SimuladordeCredito

## 1. Visão Geral do Projeto:
### 🛠️ Teste Prático de Engenharia Backend - Simulador de Crédito
Este repositório contém a implementação de um simulador de crédito, projetado para avaliar habilidades em desenvolvimento backend, incluindo APIs RESTful, cálculos financeiros, otimização de desempenho, testes automatizados e documentação.

### Tecnologias Utilizadas:
#### Kotlin:
O Kotlin oferece sintaxe concisa e segurança contra nulabilidade, tornando o código menos verboso e mais limpo, com boa interoperabilidade com Java.

#### Springboot:
O Spring Boot facilitou a criação da API REST, com configuração simplificada e integração com Kafka para escalabilidade.

#### Docker:
Docker foi usado para criar um container Kafka, garantindo um ambiente isolado e replicável.

#### Kafka:
Kafka gerencia o envio de e-mails com a simulação de crédito de forma assíncrona, melhorando a escalabilidade.










### Padrão de Arquitetura - MVVM:
Parão de arquitetura xxxxxx e utilizando boas patricas como clean-code

## 1. creditSimulator
Pasta raiz do projeto.

## 2. application:
*    Nessa camada é encotrada a regra de negocio do projeto, determinando como as funcionalidades vão ser executadas 
####   2.1. model
*    Representa dados de entrada e saída para a aplicação. É um objeto que transporta informações entre as camadas. logo temos o LoanCalculationResult e o LoanRequest 
####   2.2. useCase
*    Contém a lógica específica de um caso de uso, coordenando o fluxo de dados e interagindo com o Domain para realizar as ações necessárias. a logica seria o LoanCalculationUseCase.


## 3. domain:
####   3.1. Entities
*    A entidade **Client** representa o cliente que está solicitando o empréstimo. Ela contém dados como a data de nascimento e possui a função calculateAge(), que calcula a idade do cliente com base na sua data de nascimento.

*    A entidade **InterestRate** determina a taxa de juros aplicável com base na idade do cliente. A função calculateCorrectRate() utiliza a idade do cliente (calculada pelo Client) e retorna a taxa de juros correta.

*    A entidade **Loan** representa o empréstimo em si. Ela contém a lógica de cálculo do empréstimo utilizando os valores fornecidos, como o valor do empréstimo, o prazo e a taxa de juros. A função calculateLoan() realiza os cálculos do valor total a ser pago, as parcelas mensais e os juros totais.

## 4. interface:
#### 4.1. controllers
* O LoanController recebe requisições HTTP para calcular simulações de empréstimo, processa os dados de entrada e chama a lógica de negócios. Ele também publica os resultados no Kafka para envio de notificações assíncronas. Por fim, retorna a resposta com os detalhes da simulação de crédito.
#### 4.2. model
*  O **LoanRequestModel** recebe a entrada do cliente, o **LoanResponseModel** retorna os resultados da simulação ao cliente e o **LoanSimulationNotification** envia esses dados para o Kafka, permitindo o envio de notificações assíncronas.

## 4.Infrastructure :









## 3. Classes Criadas no Projeto


## 4. Entidades 





