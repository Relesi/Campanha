[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.darrachequesne/spring-data-jpa-datatables/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.darrachequesne/spring-data-jpa-datatables)
[![](https://travis-ci.org/typicode/json-server.svg?branch=master)](https://travis-ci.org/typicode/json-server) 
[![](https://badge.fury.io/js/json-server.svg)](http://badge.fury.io/js/json-server) 
[![JavaScript Style Guide](https://img.shields.io/badge/code_style-standard-brightgreen.svg)](https://standardjs.com) 
[![styled with prettier](https://img.shields.io/badge/styled_with-prettier-ff69b4.svg)](https://github.com/prettier/prettier) 
[![](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/typicode/json-server?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[!](http://emberobserver.com/badges/ember-ajax.svg)](http://emberobserver.com/addons/ember-ajax)
[![Dependency Status](https://gemnasium.com/intuit/node-pom-parser.svg)]

# Spring MVC 

Um exemplo de projeto para demonstrar como um aplicativo da Web pode ser construído usando uma pilha Spring MVC. O frontend é baseado em Javascript e JQuery, lodash e requirejs, e o backend é composto por serviços da Web JSON REST baseados em Spring MVC / JPA, protegidos com Spring Security. 

### Dependências de instalação ###

As seguintes dependências são necessárias:

 - Java 8
 - Nó 0,12 ou superior
 - maven 2.4 ou superior


# Hibernate

O backend é baseado em Java 8, Spring 4, JPA 2 / Hibernate 4. A configuração Spring é baseada em Java. Os principais módulos Spring utilizados onde Spring MVC e Spring Security. O backend foi construído usando a abordagem DDD, que inclui um modelo de domínio, serviços, repositórios e DTOs para transferência de dados frontend / backend.

Os serviços da Web REST baseiam-se no Spring MVC e no JSON. Os testes de unidade são feitos com testes de primavera e os testes funcionais da API REST, quando realizados usando o [Spring test MVC] http://docs.spring.io/spring/docs/current/spring-framework-reference/html/index.html # Spring-mvc-test-framework).

#### Backend Security ####

O módulo Spring Security foi usado para proteger o backend REST (essas diretrizes (https://www.owasp.org/index.php/REST_Security_Cheat_Sheet) são, em geral, aplicadas). O aplicativo pode ser feito para executar no modo HTTPS somente através de um parâmetro do servidor, o que significa que nenhuma página será atendida se o usuário tentar acessá-lo via HTTP.

O modo de início de sessão do Spring Security Form foi usado, com retorno para HTTP-Basic Authentication para clientes HTTP não baseados no navegador. 


#spring-data-jpa-datatables

Este projeto é uma extensão do projeto Spring Data JAA para facilitar sua utilização com o jQuery plugin DataTables com o processamento do lado do servidor ativado.

Isso permitirá que você lide com os pedidos do Ajax enviados pela DataTables para cada desenho das informações na página (ou seja, na paginação, no pedido, na busca, etc.) da Spring @RestController.

# Maven Dependências

<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-war-plugin</artifactId>
				<version>2.4</version>
				<configuration>
					<failOnMissingWebXml>false</failOnMissingWebXml>
				</configuration>
			</plugin>
		
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>2.3.2</version>
				<configuration>
					<source>1.8</source>
					<target>1.8</target>
				</configuration>
			</plugin>
			
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-eclipse-plugin</artifactId>
				<version>2.9</version>
				<configuration>
					<downloadSources>true</downloadSources>
					<downloadJavadocs>true</downloadJavadocs>
				</configuration>
			</plugin>
			



##### Authentication Service #####

Url | Verb | Descrição
-------------- | ------------- | -------------
/ Authenticate | POST | Autentica o usuário
/ Logout | POST | Termina a sessão atual

