# Projeto de Agendamento de Emails

Este projeto consiste em uma aplicação para agendamento de emails utilizando tecnologias como EJB com Jakarta EE, integração com JPA, agendamento de tarefas, criação de serviços REST, gerenciamento de transações com JTA, Session Beans e mensageria com JMS. O servidor de aplicação utilizado é o WildFly.

## Funcionalidades

- **Envio de Emails:** Agendamento e envio de emails de forma automatizada.
- **APIs REST:** Implementação de endpoints para gerenciamento de agendamentos via REST.
- **Transações:** Gerenciamento de transações com JTA para garantir a consistência dos dados.
- **Agendamento de Tarefas:** Tarefas agendadas utilizando a API de agendamento do EJB.
- **Session Beans:** Uso de Stateless e Stateful Beans para diferentes tipos de operações.
- **Mensageria:** Integração com JMS para troca de mensagens entre sistemas.

## Tecnologias Utilizadas

- **Java 11**
- **Jakarta EE**
  - EJB (Enterprise Java Beans)
  - JPA (Java Persistence API)
  - JTA (Java Transaction API)
  - JMS (Java Message Service)
- **Servidor de Aplicação:** WildFly 33.0.1.Final
- **Banco de Dados:** MySQL
- **Ferramentas de Build:** Maven

## Estrutura do Projeto

```bash
src/main/java
│
├── br.com.teste
│   ├──AgendamentoEmailApplication.java
│   ├── controllers
│   ├── entity
│   ├── mdb
│   ├── jobs
│   ├── servlet
│   ├── servico
│   └── dao
│
│
├── META-INF
   └── persistence.xml

