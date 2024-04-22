# Desafio

Projeto desenvolvido em framework Spring, versão 3.2.4
O objetivo deste projeto foi desensvolver uma API rest utilizando o Spring e conectando-se a um bando de dados - neste caso, o MySQL.

# Como executar

Clone o projeto, execute mvn install para certificar de que as dependências foram corretamente instaladas e rode mvn spring-boot:run para executar o projeto em modo desenvolvimento. Os end-points tem como raiz a url base do Spring (normalmente http://localhost:8080/user) mais alguma subrota.

Migrations iniciais para o banco de dados estão disponíveis no arquivo dump.sql;

# Próximos passos
- Documentação das rotas via Swagger;
- Utilização token (JWT) para autenticação.
