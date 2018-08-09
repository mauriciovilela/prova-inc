# spring

Pré requisitos e ferramentas para rodar o ambiente:

  - Java JDK 8
  - Node e npm | node >= 8
  - Apache maven 
  - Eclipse | Spring Tool Suite (STS
  - Banco de dados | H2 (memória)
  - Visual studio code
  - Postman
  
### Arquitetura e bibliotecas

  - Spring Java
  - Spring boot (servidor de aplicativo)
  - Mapstruct (Parse automatico dos DTO's, front => back)
  - Cache de consultas (Spring)
  - Flyway (Versionamento de scripts)
  
### Insumos

Projeto no POSTMAN: 
https://raw.githubusercontent.com/mauriciovilela/prova-inc/master/Prova.postman_collection.json
[![N|Solid](https://image.ibb.co/kQLHMy/image.png)](https://nodesource.com/products/nsolid)
### Entidades

  - Cliente, Produto e Pedido

### Instalação

Instalar as bibliotecas e dependências e rodar o projeto executando os testes.

```sh
$ npm install
$ mvn install
$ mvn spring-boot:run
```

Gerar pacote para produção ...

```sh
$ ng build --prod
```

### Projeto rodando

[![N|Solid](https://image.ibb.co/j0CWgy/image.png)](https://nodesource.com/products/nsolid)

### O que ficou pendende


  - Autenticação JWT
  - Terminar a publicação em um ambiente externo 50% (Somente o back pulicado - Jenkins)
  - Unit de de teste no front (Protactor)
  - Completar a unit de teste no backend para api REST
  - Implementar o interceptor no front (Enviar o token gerado, tratar os status de retorno de validação, erro e sucesso)
  - Finalizar a integração contínua (Jenkins) em um servidor que tenho uma conta (Azure):
  http://ubuntudev.eastus.cloudapp.azure.com:8081
