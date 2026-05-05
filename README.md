# Bluebank

Projeto de exemplo com frontend Angular e backend Java/Spring MVC para treinamentos e POCs.

**Blue Bank** e uma instituicao financeira ficticia usada para demonstrar uma SPA consumindo APIs REST.

## Modulos

- `bluebank-spa-angular`: frontend SPA em Angular.
- `javaee/Bluebankend`: backend Java empacotado como WAR e executado localmente com Jetty via Maven.

## Versoes Atuais

Backend:

- Java 17
- Maven 3.9.10
- Spring MVC 5.3.39
- Jetty Maven Plugin 9.4.58
- Jackson 2.17.3
- JUnit 4.13.2
- Mockito 5.23.0
- MySQL Connector/J 8.0.33

Frontend:

- Node.js 20.19.2
- npm 10.8.2
- Angular 21.2.x
- Angular CLI 21.2.x
- TypeScript 5.9.x
- RxJS 7.8.x
- Vitest 4.0.x

## Como Rodar o Backend

O backend sobe no contexto `/bluebackend` e, por padrao, na porta `8080`.

```bash
cd javaee/Bluebankend
mvn clean package
mvn jetty:run
```

Para usar outra porta:

```bash
mvn -Djetty.port=8081 jetty:run
```

Endpoint rapido para validar:

```bash
curl -H "Accept: application/json" http://localhost:8080/bluebackend/rest/boasvindas
```

Resposta esperada:

```json
{"mensagem":"Aproveite nossa nova linha de crédito."}
```

## Como Rodar o Frontend

Em outro terminal:

```bash
cd bluebank-spa-angular
npm install
npm start
```

O frontend fica disponivel em:

```text
http://localhost:4200/
```

O proxy do Angular esta configurado em `bluebank-spa-angular/proxy.conf.json` para encaminhar chamadas de `/bluebackend` para:

```text
http://localhost:8080
```

Por isso, para rodar frontend e backend juntos sem CORS extra, deixe o backend em `8080`.

## Testes

Backend:

```bash
cd javaee/Bluebankend
mvn test
```

Frontend:

```bash
cd bluebank-spa-angular
npm test
```

## Build

Backend WAR:

```bash
cd javaee/Bluebankend
mvn clean package
```

Artefato gerado:

```text
javaee/Bluebankend/target/bluebankend-0.0.1-SNAPSHOT.war
```

Frontend:

```bash
cd bluebank-spa-angular
npm run build
```

## APIs Locais

```text
GET http://localhost:8080/bluebackend/rest/boasvindas
GET http://localhost:8080/bluebackend/rest/correntista/{cpf}
GET http://localhost:8080/bluebackend/rest/correntistas/cadastrados/transferencia/{cpf}
GET http://localhost:8080/bluebackend/rest/transferencia/{idCorrentistaOrigem}/{idCorrentistaDestino}/{valor}
```

Exemplos:

```text
http://localhost:8080/bluebackend/rest/correntista/58424255135
http://localhost:8080/bluebackend/rest/correntistas/cadastrados/transferencia/58424255135
http://localhost:8080/bluebackend/rest/transferencia/2/1/1000
```

## Observacoes

- O projeto ainda usa a API `javax.servlet`, entao o backend foi atualizado para Spring MVC 5.3.x. Spring 6 exigiria migracao para `jakarta.*`.
- As bibliotecas do backend sao resolvidas pelo Maven. Nao adicione jars manualmente em `WebContent/WEB-INF/lib`.
- O backend possui uma camada DAO preparada para MySQL, mas os testes atuais usam mocks.

## Links

- GitHub: https://github.com/casaroto/bluebank
- Wiki da API: https://github.com/casaroto/bluebank/wiki
- Issues: https://github.com/casaroto/bluebank/issues

## Roadmap Sugerido

- Implementar login e seguranca com OAuth2.
- Incluir Swagger/OpenAPI para documentacao da API.
- Adicionar logs nas classes e pontos criticos.
- Melhorar a cobertura de testes.
- Revisar seguranca contra SQL injection e XSS.
- Passar o codigo em uma ferramenta de qualidade como Sonar.
