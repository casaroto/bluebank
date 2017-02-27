# Projeto Bluebank frontend e backend 


**Blue Bank** é uma instituição financeira fictícia cujas demandas de desenvolvimento de software têm aumentado muito nos últimos meses. 

## Proposta de arquitetura técnica inicial
- Interface web SPA com Angular 2 e Bootstrap através do framework ng2-bootstrap 
- Backend Java EE - Spring framework -Spring MVC para criação das APIs REST
- Utilização de arquitetura OOP, utilizando MVC - com divisão de camadas de serviço REST, camada Business e camada DAO para persistência 
- Camada DAO criada com uso de interfaces e com injeção de dependências gerenciadas pelo Spring framework  
- Banco de dados relacional ORM MYSQL 
- Testes unitários utilizando Junit4

## Proposta de condução inicial do projeto
- Criação interativa de uma prova de conceito com interface web simples acessando uma API REST inicialmente mockada 
- Utilizar TDD e criar testes unitários conforme elabora a API
- Modelar as demais camadas do Backend conforme melhor elucidação dos requisitos
- Em uma etapa posterior onde os requisitos/proposta de projeto estiver mais madura criar e integrar com o banco de dados
- A cada interação rodar o plugin de cobertura para verificar percentual de cobertura dos testes unitários

## Arquitetura de módulos
- Projeto SPA deployado em war JEE rodando em servidor JBOSS
- Projeto Backend deployado em war JEE rodando em servidor JBOSS

## Ambiente de desenvolvimento
- Servidor Java: JBOSS EAP 6.1 - Linux
- Servidor MYSQL 5.1 - Linux
- IDE Eclipse para desenvolvimento Java rodando em linux
- IDE Visual Studio Code para desenvolvimento Angular JS 2 rodando em MacOS
- Plugin de cobertura de testes instalado no Eclipse

## Ambiente cloud escolhido para live preview do projeto
- AWS

## Github
https://github.com/casaroto/bluebank

## WIKI da API
https://github.com/casaroto/bluebank/wiki

## Problemas e bugs
https://github.com/casaroto/bluebank/issues

## Instruções para deploy e execução
- Executar o arquivo createdb.sql no banco de dados Mysql
- Configurar conexão ao banco de dados
- Efetuar deploy dos projetos WAR e EAR gerados

## Realese map *alterações desejadas para versão 2.0 (não foram realizadas devido a restrição de tempo)
- Incluir SWAGGER para documentação da API e retirar informações da WIKI
- Melhorar código Angular 2 com uso de Observables 
- Melhorias de segurança:
	Filtrar todo conteúdo enviado via API para impedir ataques sql injection, XSS
- Passar todo código fonte na ferramenta SONAR para garantia de qualidade


