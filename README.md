# Estoque SOAP Java

Sistema de gestão de estoque desenvolvido em **Java** utilizando **Web Services SOAP**, como projeto da disciplina de **Programação Web II**.

## Sobre o projeto

O objetivo do projeto é desenvolver um Web Service para gerenciamento de estoque de pequenas empresas.

O sistema utiliza duas entidades principais relacionadas:

- **Produto**
- **Estoque**

A aplicação permitirá realizar operações de **CRUD** (cadastrar, consultar, atualizar e excluir) para as duas entidades.

Os dados serão armazenados em memória utilizando `List` ou `Map`, simulando a persistência de dados durante a execução da aplicação.

As operações serão disponibilizadas através de um **Web Service SOAP**, que poderá ser consumido por uma aplicação cliente.

## Tecnologias utilizadas

- Java
- Maven
- SOAP
- JAX-WS
- XML
- WSDL
- Git e GitHub

## Estrutura do projeto

```text
src/main/java/br/com/estoque/
├── client/
│   └── EstoqueClient.java
├── controller/
│   ├── EstoqueController.java
│   └── ProdutoController.java
├── exception/
│   ├── CampoObrigatorioException.java
│   └── InformacaoInvalidaException.java
├── model/
│   ├── Estoque.java
│   └── Produto.java
├── publisher/
│   └── EstoquePublisher.java
└── service/
    ├── EstoqueService.java
    └── EstoqueServiceImpl.java
```

---

## Instruções para os integrantes da equipe

> Esta seção contém instruções básicas de Git para os integrantes responsáveis pelo desenvolvimento do projeto.

### Antes de começar a programar

Sempre atualize sua cópia local do projeto antes de realizar alterações:

```bash
git pull --rebase
```

Depois disso, faça suas alterações normalmente.

### Quando terminar suas alterações

Adicione os arquivos modificados:

```bash
git add .
```

Crie um commit descrevendo o que foi feito:

```bash
git commit -m "descreva o que foi feito"
```

Antes de enviar, atualize novamente sua branch local:

```bash
git pull --rebase
```

Por fim, envie as alterações para o GitHub:

```bash
git push
```

### Fluxo resumido

```text
1. git pull --rebase

2. Fazer as alterações no código

3. git add .

4. git commit -m "mensagem do commit"

5. git pull --rebase

6. git push
```

> **Importante:** não começar a desenvolver sem antes executar `git pull --rebase`. Isso ajuda a garantir que você esteja trabalhando com a versão mais recente do projeto e reduz a possibilidade de conflitos com alterações realizadas por outros integrantes.