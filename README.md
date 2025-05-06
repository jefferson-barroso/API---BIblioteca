
# API - Sistema de Gerenciamento de Biblioteca

Este projeto é uma API desenvolvida com **Spring Boot** para gerenciar o sistema de uma biblioteca. A API fornece funcionalidades para cadastrar, listar, atualizar e excluir autores, categorias e livros.

## Funcionalidades

A API oferece funcionalidades para gerenciar as entidades 'Autor', 'Categoria' e 'Livro', com as seguintes operações:

- **Autores**: Cadastrar, listar, alterar e excluir autores.
- **Categorias**: Cadastrar, listar, alterar e excluir categorias.
- **Livros**: Cadastrar, listar, alterar e excluir livros.

Cada entidade tem seu próprio controlador, serviço e repositório para garantir a separação de responsabilidades e a aplicação dos princípios de design de software.

## Tecnologias Utilizadas

- **Spring Boot**: Framework utilizado para o desenvolvimento da API.
- **Spring Data JPA**: Para facilitar a interação com o banco de dados.
- **Banco de Dados Relacional (MySQL/PostgreSQL)**: Para persistir os dados das entidades.
- **DTO (Data Transfer Object)**: Para realizar a troca de dados entre as camadas da aplicação de forma eficiente.
- **Lombok**: Para reduzir a verbosidade do código, gerando automaticamente métodos `getter`, `setter`, `toString`, etc.

## Estrutura do Projeto

A estrutura do projeto segue a arquitetura MVC (Model-View-Controller), onde as camadas são separadas da seguinte forma:

- **Controller**: Responsável por expor os endpoints da API e gerenciar as requisições HTTP.
- **Service**: Contém a lógica de negócios e manipulação das entidades.
- **Model**: Contém as entidades JPA que representam as tabelas do banco de dados.
- **Repository**: Interfaces de repositórios para interação com o banco de dados.

## Endpoints Disponíveis

### Autores

- **GET /api/biblioteca/autor/listarTodos**: Lista todos os autores.
- **GET /api/biblioteca/autor/{id}**: Consulta um autor pelo ID.
- **POST /api/biblioteca/autor/incluir**: Cadastra um novo autor.
- **PUT /api/biblioteca/autor/alterar/{id}**: Atualiza um autor existente.
- **DELETE /api/biblioteca/autor/deletar/{id}**: Deleta um autor pelo ID.

### Categorias

- **GET /api/biblioteca/categoria/listarTodos**: Lista todas as categorias.
- **GET /api/biblioteca/categoria/{id}**: Consulta uma categoria pelo ID.
- **POST /api/biblioteca/categoria/incluir**: Cadastra uma nova categoria.
- **PUT /api/biblioteca/categoria/alterar/{id}**: Atualiza uma categoria existente.
- **DELETE /api/biblioteca/categoria/deletar/{id}**: Deleta uma categoria pelo ID.

### Livros

- **GET /api/biblioteca/livro/listarTodos**: Lista todos os livros.
- **GET /api/biblioteca/livro/{id}**: Consulta um livro pelo ID.
- **POST /api/biblioteca/livro/incluir**: Cadastra um novo livro.
- **PUT /api/biblioteca/livro/alterar/{id}**: Atualiza um livro existente.
- **DELETE /api/biblioteca/livro/deletar/{id}**: Deleta um livro pelo ID.

## Como Rodar o Projeto

### Pré-requisitos

- **Java 11 ou superior**: Para compilar e rodar o projeto.
- **Banco de Dados (MySQL ou PostgreSQL)**: Configure o banco de dados conforme o que você escolher utilizar.
- **Maven**: Para compilar e rodar o projeto, certifique-se de ter o Maven instalado.

### Passos para Rodar

1. Clone o repositório:

   git clone https://github.com/jefferson-barroso/API---BIblioteca

2. Navegue até o diretório do projeto:
   cd API---Biblioteca


3. Configure as credenciais do banco de dados no arquivo 'src/main/resources/application.properties':
  properties
   spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca
   spring.datasource.username=root
   spring.datasource.password=root
   spring.jpa.hibernate.ddl-auto=update


4. Compile o projeto usando Maven:
   mvn clean install


5. Execute o projeto:
   mvn spring-boot:run


6. A API estará disponível em http://localhost:8080.



