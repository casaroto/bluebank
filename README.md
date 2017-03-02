# Projeto Bluebank frontend e backend 


**Blue Bank** é uma instituição financeira fictícia cujas demandas de desenvolvimento de software têm aumentado muito nos últimos meses. 

## Proposta de arquitetura técnica inicial
- Backend Java EE - Spring framework -Spring MVC para criação das APIs REST
- Interface web SPA com Angular 2 e Angular Material  
- Utilização de arquitetura OOP, utilizando MVC - com divisão de camadas de serviço REST, camada Business e camada DAO para persistência 
- Camada DAO criada com uso de interfaces e com injeção de dependências gerenciadas pelo Spring framework  
- Banco de dados relacional ORM MYSQL 
- Testes unitários utilizando Junit

## Proposta de condução inicial do projeto
- Criação interativa de uma prova de conceito com interface web simples acessando uma API REST inicialmente mockada 
- Modelar as demais camadas do Backend conforme melhor elucidação dos requisitos
- Em uma etapa posterior onde os requisitos/proposta de projeto estiver mais madura criar e integrar com o banco de dados

## Arquitetura de módulos
- Projeto SPA deployado em war JEE rodando em servidor JBOSS
- Projeto Backend deployado em war JEE rodando em servidor JBOSS

## Ambiente de desenvolvimento
- Servidor Java: JBOSS EAP 6.1 - Linux
- Servidor MYSQL 5.1 - Linux
- IDE Eclipse para desenvolvimento Java rodando em linux
- IDE Visual Studio Code para desenvolvimento Angular JS 2 rodando em MacOS
- Angular cli e servidor Node.js para servir a camada SPA
- Plugin de índice de cobertura de testes instalado no Eclipse

## Ambiente cloud escolhido para live preview do projeto
- Amazon Web Services

## Site SPA publicado no servidor AWS para teste integrado da funcionalidade  
http://ec2-52-206-208-89.compute-1.amazonaws.com:4200/

***Observação: RODAR COM PLUG-IN CORS DO CHROME INSTALADO, POIS O APLICATIVO E A API TIVERAM QUE FICAR EM PORTAS DIFERENTES
https://chrome.google.com/webstore/search/CORSTOGGLE

## Github
https://github.com/casaroto/bluebank

## WIKI da API
https://github.com/casaroto/bluebank/wiki

## APIs publicadas no servidor AWS Jboss 
http://ec2-52-206-208-89.compute-1.amazonaws.com/bluebackend/rest/correntista/{cpf}     <br>
Exemplo: 
http://ec2-52-206-208-89.compute-1.amazonaws.com/bluebackend/rest/correntista/58424255135    <br>

http://ec2-52-206-208-89.amazonaws.com/bluebackend/rest/correntistas/cadastrados/transferencia/{cpf}     <br>
Exemplo:
http://ec2-52-206-208-89.amazonaws.com/bluebackend/rest/correntistas/cadastrados/transferencia/58424255135   <br>

http://ec2-52-206-208-89.amazonaws.com/bluebackend/rest/transferencia/{idCorrentistaOrigem}/{idCorrentistaDestino}/{valor}   <br>
Exemplo:
http://ec2-52-206-208-89.amazonaws.com/bluebackend/rest/transferencia/2/1/1000   <br>

## Problemas e bugs
https://github.com/casaroto/bluebank/issues

## Instruções para deploy e execução
- Executar o arquivo createdb.sql no banco de dados Mysql
- Efetuar deploy dos projetos WAR e EAR gerados - diretório deploy
- Ou importar projeto JavaEE na IDE Eclipse e exportar o WAR pela ferramenta de exportação.
- Rodar o aplicativo spa do diretório bluebank-spa-angular 
	--Instalar as dependências com npm install
	--Após isto rodar o aplicativo com ng serve --host 0.0.0.0

## Realese map *alterações desejadas para versão 2.0 (não foram realizadas devido a restrição de tempo)
- Incluir SWAGGER para documentação da API e retirar informações da WIKI
- Incluir chamadas a log em todas as classes e pontos críticos do sistema
- Melhorar código Angular 2 com uso de Observables e criação de classes Service separadas
- Melhorias de segurança:
	Filtrar todo conteúdo enviado via API para impedir ataques sql injection, XSS
- Passar todo código fonte na ferramenta SONAR para garantia de qualidade



