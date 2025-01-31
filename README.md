# Task Management API
A Task Management API é uma aplicação RESTful construída com Spring Boot e utiliza a arquitetura Clean Architecture. O objetivo é fornecer uma interface simples para a criação, leitura, atualização e exclusão de tarefas, utilizando um banco de dados SQL Server.

## Tecnologias Utilizadas
Spring Boot - Framework para criação de aplicações Java.
JPA (Java Persistence API) - Para interação com o banco de dados.
SQL Server - Banco de dados relacional.
Maven - Gerenciador de dependências e build.
JUnit 5 - Framework de testes unitários.
Spring Data JPA - Repositórios e gerenciamento de persistência.

## Pré-requisitos
Antes de começar, certifique-se de ter as seguintes ferramentas instaladas:

Java 17
Maven
SQL Server (localmente ou utilizando o Docker)
Postman ou qualquer outro cliente HTTP para testar a API.
Como Configurar o Projeto

## 1. Clone o Repositório:
git clone https://github.com/seu-usuario/task-management-api.git

## 2. Configuração do Banco de Dados
Este projeto foi configurado para usar o SQL Server como banco de dados. Antes de rodar o projeto, você precisa criar o banco de dados e as tabelas necessárias. Abaixo, fornecemos o script SQL para criar o banco de dados e a tabela task.

Script de Criação do Banco e Tabelas
sql

-- Criar o banco de dados
(CREATE DATABASE task_db;
GO

-- Selecionar o banco de dados
USE task_db;
GO

-- Criar a tabela de tarefas


CREATE TABLE task (
    
    id INT IDENTITY(1,1) PRIMARY KEY,
    
    title VARCHAR(255) NOT NULL,
    
    description VARCHAR(255) NOT NULL,
    
    status VARCHAR(50) CHECK (status IN ('PENDENTE', 'EM_ANDAMENTO', 'CONCLUIDA')) NOT NULL,
    
    date_task DATETIME NOT NULL DEFAULT GETDATE()
    );
    GO)

## 3. Configuração do Projeto
Após criar o banco de dados e a tabela, configure as credenciais do banco de dados no arquivo application.properties (ou application.yml), localizado em src/main/resources.

Aqui está um exemplo de configuração para o application.properties:

properties

spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=task_db
spring.datasource.username=sa
spring.datasource.password=SuaSenhaAqui
spring.datasource.driverClassName=com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.jpa.database-platform=org.hibernate.dialect.SQLServer2012Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


## 4. Executando o Projeto
Para rodar o projeto, você pode usar o Maven para construir e executar a aplicação.


mvn clean spring-boot:run
A API estará disponível no http://localhost:8080.

## Endpoints da API
Aqui estão os principais endpoints da API para gerenciar tarefas:

## POST /tasks
Cria uma nova tarefa.

Corpo da Requisição:
json

{
  "title": "Comprar leite",
  
  "description": "Ir ao mercado e comprar leite",
  
  "status": "PENDENTE"
}
Resposta:
json
{

  "id": 1,
  
  "title": "Comprar leite",
  
  "description": "Ir ao mercado e comprar leite",
  
  "status": "PENDENTE",
  
  "dateTask": "2025-01-31T10:00:00"
}
## GET /tasks
Retorna todas as tarefas.

Resposta:
json
[
  {
  
    "id": 1,
    "title": "Comprar leite",
    "description": "Ir ao mercado e comprar leite",
    "status": "PENDENTE",
    "dateTask": "2025-01-31T10:00:00"
  },
  
  { 
     "id": 2,
    "title": "Estudar para prova",
    "description": "Estudar matemática para a prova de amanhã",
    "status": "EM_ANDAMENTO",
    "dateTask": "2025-01-30T14:30:00"
  }
]
## GET /tasks/{id}
Retorna uma tarefa específica com base no id.

Resposta:
json
{

  "id": 1,
  
  "title": "Comprar leite",
  
  "description": "Ir ao mercado e comprar leite",
  
  "status": "PENDENTE",
  
  "dateTask": "2025-01-31T10:00:00"
}
## PUT /tasks/{id}
Atualiza os detalhes de uma tarefa existente.

Corpo da Requisição:
json

{
  "title": "Comprar leite e pão",
  
  "description": "Ir ao mercado e comprar leite e pão",
  
  "status": "EM_ANDAMENTO"
}
Resposta:
json

{
  "id": 1,
  
  "title": "Comprar leite e pão",
  
  "description": "Ir ao mercado e comprar leite e pão",
  
  "status": "EM_ANDAMENTO",
  
  "dateTask": "2025-01-31T10:00:00"
  
}
## DELETE /tasks/{id}
Deleta uma tarefa específica.

Resposta:
Status 204 No Content


## Contribuindo
Se você deseja contribuir para este projeto, por favor, siga estas etapas:

Fork o repositório.
Crie uma branch para sua alteração (git checkout -b feature/nome-da-alteracao).
Realize suas alterações.
Commit suas alterações (git commit -am 'Adicionar nova funcionalidade').
Envie para o repositório remoto (git push origin feature/nome-da-alteracao).
Abra um Pull Request.







