<p align="center">
   <a href="/docs/README.pt-BR.md">Português - BR</a>
   ·
   <a href="/docs/README.en-US.md">English - US</a>
</p>

# Início rápido

## Pré-requisitos

- [Java 8](https://www.oracle.com/br/java/technologies/javase/javase8-archive-downloads.html)
- [PostgreSQL](PostgreSQL)

## Configurando DBUnit

1. Crie uma base de dados chamada **_dbunit_** no PostgreSQL
2. Abra o projeto, vá para **src/main/java/../utils/ConnectionFactory** e configure sua conexão com o banco de dados
3. Vá para **src/main/java/../utils/MontarAmbiente** e execute como JavaApplication
   > Certifique-se que seu banco de dados foi criado corretamente

<br>

> Se você precisar redefinir seu banco de dados, execute o passo 3 novamente

<br>

## Estratégia #1

### WEB

> A Estratégia 1 usa o método CRUD, que significa: Create; Read/Retrieve; Update; Delete; <br>Em português: Criar; Ler/Recuperar; Alterar; Deletar

Para esta estratégia, utilizamos a anotação `@FixMethodOrder(MethodSorters.NAME_ASCENDING)` da biblioteca do JUnit. Com esta classe, devemos nomear os métodos de forma parecida com este exemplo: _`teste_1_criar`_ para que os testes sejam executados na ordem desejada.
