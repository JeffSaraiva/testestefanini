#Task Management API
A Task Management API é uma aplicação RESTful construída com Spring Boot e utiliza a arquitetura Clean Architecture. O objetivo é fornecer uma interface simples para a criação, leitura, atualização e exclusão de tarefas, utilizando um banco de dados SQL Server.

##Tecnologias Utilizadas
Spring Boot - Framework para criação de aplicações Java.
JPA (Java Persistence API) - Para interação com o banco de dados.
SQL Server - Banco de dados relacional.
Maven - Gerenciador de dependências e build.
JUnit 5 - Framework de testes unitários.
Spring Data JPA - Repositórios e gerenciamento de persistência.
##Pré-requisitos
Antes de começar, certifique-se de ter as seguintes ferramentas instaladas:

Java 17
Maven
SQL Server (localmente ou utilizando o Docker)
Postman ou qualquer outro cliente HTTP para testar a API.
Como Configurar o Projeto

##1. Clone o Repositório:
git clone https://github.com/seu-usuario/task-management-api.git

##2. Configuração do Banco de Dados
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
    id INT IDENTITY(1,1) PRIMARY KEY,  -- ID auto-incremento
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    status VARCHAR(50) CHECK (status IN ('PENDENTE', 'EM_ANDAMENTO', 'CONCLUIDA')) NOT NULL,
    date_task DATETIME NOT NULL DEFAULT GETDATE()
);
GO)







