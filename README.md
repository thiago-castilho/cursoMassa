<!-- https://docs.pipz.com/central-de-ajuda/learning-center/guia-basico-de-markdown#open -->

<p align="center">
   <a href="/docs/README.pt-BR.md">Português - BR</a>
   ·
   <a href="/docs/README.en-US.md">English - US</a>
</p>

# Quickstart

## Prerequisites

- [Java 8](https://www.oracle.com/br/java/technologies/javase/javase8-archive-downloads.html)
- [PostgreSQL](PostgreSQL)

## Configuring DBUnit

1. Create a database named **_dbunit_** on PostgreSQL
2. Open the project, go to **src/main/java/../utils/ConnectionFactory** and configure your database connection
3. Go to **src/main/java/../utils/MontarAmbiente** and run as JavaApplication
   > Check that your database was created correctly

<br>

> If you need to reset your database, just execute step 3 again

<br>

## Strategy #1

> Strategy 1 uses the CRUD method, which means: Create; Read/Retrieve; Update; Delete;

For this strategy, we use the `@FixMethodOrder(MethodSorters.NAME_ASCENDING)` annotation from the JUnit library. With this class, we should name the methods similar to this example: _`test_1_create`_ so that the tests are executed in the desired order.
