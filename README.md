

---

# 📦 Sistema de Gestão de Produtos e Estoque

Este projeto é um **sistema web desenvolvido em Java** para **cadastro e controle de produtos e estoque**, utilizando **JSP, Servlets, JDBC e MySQL**, seguindo o padrão **MVC**.

O objetivo é praticar conceitos fundamentais de **Java Web** e criar um projeto **realista para portfólio**.

---

## 🎯 Objetivo do Projeto

* Praticar Programação Orientada a Objetos (POO)
* Implementar um CRUD completo
* Aplicar o padrão MVC
* Trabalhar com Java + Banco de Dados
* Criar um projeto organizado para vagas de estágio/júnior

---

## 🛠️ Tecnologias Utilizadas

* Java
* JSP
* Servlets
* JDBC
* MySQL
* HTML5
* CSS3

---

## ⚙️ Funcionalidades

* Cadastrar produtos
* Listar produtos cadastrados
* Editar informações do produto
* Desativar produtos (não são excluídos do banco)
* Buscar produtos por nome
* Exibir status de estoque (com ou sem estoque)

---

## 🧠 Regras de Negócio

* O nome do produto é obrigatório
* O preço não pode ser negativo
* A quantidade não pode ser negativa
* Produtos com quantidade igual a 0 são considerados sem estoque
* Apenas produtos ativos são exibidos na listagem principal

---

## 🏗️ Arquitetura do Projeto

O projeto segue o padrão **MVC (Model–View–Controller)**.

```
src/main/java
 ├── model
 │    └── Produto.java
 │
 ├── dao
 │    └── ProdutoDAO.java
 │
 ├── controller
 │    └── ProdutoServlet.java
 │
 ├── util
 │    └── ConnectionFactory.java
 │
src/main/webapp
 ├── produtos
 │    ├── list.jsp
 │    └── form.jsp
 │
 └── index.jsp
```

---

## 🛢️ Banco de Dados

### Tabela `produto`

```sql
CREATE TABLE produto (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  descricao TEXT,
  preco DECIMAL(10,2) NOT NULL,
  quantidade INT NOT NULL,
  data_cadastro DATETIME,
  ativo BOOLEAN
);
```

---

## ▶️ Como Executar o Projeto

1. Clone este repositório
2. Importe o projeto em sua IDE (Eclipse ou IntelliJ)
3. Configure o banco de dados MySQL
4. Ajuste as credenciais no arquivo `ConnectionFactory.java`
5. Execute o projeto em um servidor (Tomcat)
6. Acesse pelo navegador

---

## 📌 Status do Projeto

🚧 Em desenvolvimento — novas funcionalidades serão adicionadas 🚧
⚠️ Pode haver mudanças no README ao longo do projeto ⚠️

---

## 🚀 Melhorias Futuras

* Sistema de login
* Controle de usuários
* Relatórios de estoque
* API REST
* Migração para Spring Boot

---

## 👨‍💻 Autor

Desenvolvido por **Kauã Pereira**
📌 Estudante de desenvolvimento Java Back-end

---

