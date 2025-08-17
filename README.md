# 🚀 Microservices NTTDATA

Este repositório contém um conjunto de microserviços desenvolvidos como parte de um desafio técnico, utilizando **Spring Boot**. A arquitetura segue o padrão de microserviços com **Eureka Server** para descoberta de serviços, **API Gateway** para roteamento e dois serviços principais: **Produtos** e **Pedidos**.

---

## 🏗️ Arquitetura

A arquitetura do sistema é composta pelos seguintes componentes:

- **Eureka Server**: Serviço de descoberta para registro e localização de microserviços.
- **API Gateway**: Roteador central que direciona as requisições para os microserviços apropriados.
- **Serviço de Produtos**: Gerencia informações sobre produtos.
- **Serviço de Pedidos**: Gerencia os pedidos realizados pelos clientes.

```
[Postman] → [API Gateway] → [Eureka] → [Produtos Service / Pedidos Service]
```

---

## ⚙️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3**
- **Spring Cloud** (Eureka Server, API Gateway)
- **Spring Data JPA**
- **Banco de Dados H2** (em memória)
- **Maven** para gerenciamento de dependências

---

## 🚀 Como Executar o Projeto

### 1. Clonar o Repositório

```bash
git clone https://github.com/Rodoxson/MicroservicesNTTDATA.git
cd MicroservicesNTTDATA
```

### 2. Subir os Microserviços

A ordem de inicialização é importante:

1. **Eureka Server**

```bash
cd NTTDATAserverEureka
mvn spring-boot:run
```

2. **API Gateway**

```bash
cd ../NTTDATAapiGateway
mvn spring-boot:run
```

3. **Serviço de Produtos**

```bash
cd ../NTTDATAprodutos
mvn spring-boot:run
```

4. **Serviço de Pedidos**

```bash
cd ../NTTDATApedidos
mvn spring-boot:run
```

---

## 🌐 Endpoints Disponíveis

Após iniciar os serviços, os seguintes endpoints estarão disponíveis:

- **Eureka Server**: [http://localhost:8761](http://localhost:8761)
- **API Gateway**: [http://localhost:8700](http://localhost:8700)
- **Serviço de Produtos**: [http://localhost:8081](http://localhost:8081)
- **Serviço de Pedidos**: [http://localhost:8082](http://localhost:8082)

---

## 🛠️ Testes com Postman

Para facilitar os testes, você pode importar a coleção do Postman incluída no repositório:

1. Abra o Postman.
2. Vá para **File > Import**.
3. Selecione o arquivo `MicroservicesNTTDATA.postman_collection.json` localizado na pasta do projeto.
4. Selecione o ambiente `MicroservicesNTTDATA` para configurar as variáveis de ambiente.

- **Endpoints Produtos**
  - `GET    /produtos` → lista produtos  
  - `POST   /produtos` → cria produto  
  - `DELETE /produtos/{id}` → remove produto  

- **Endpoints Pedidos**
  - `GET    /pedidos` → lista pedidos  
  - `POST   /pedidos` → cria pedido  

---

## 🤝 Contribuindo

Contribuições são bem-vindas! Para contribuir com o projeto:

1. Faça um fork deste repositório.
2. Crie uma branch para sua feature: 

```bash
git checkout -b minha-feature
```

3. Faça alterações e commit:

```bash
git add .
git commit -m "Descrição da alteração"
```

4. Envie para o seu fork:

```bash
git push origin minha-feature
```

5. Abra um Pull Request no repositório original.

### ⚠️ Dicas

- Mantenha a **estrutura de pastas e nomes de portas** do projeto.  
- Teste sempre os endpoints via Gateway antes de abrir PR.  
- Use mensagens de commit claras e objetivas.

---

## 📂 Estrutura do Repositório

```
MicroservicesNTTDATA/
 ├── NTTDATAserverEureka/       # Eureka Server
 ├── NTTDATAapiGateway/         # API Gateway
 ├── NTTDATAprodutos/           # Serviço de Produtos
 ├── NTTDATApedidos/            # Serviço de Pedidos
 ├── postman/                   # Coleção do Postman
 └── README.md                  # Este arquivo
```

---

## 📌 Autor

Desenvolvido por [Rodolfo Lima](https://github.com/Rodoxson).

---

## 🖼️ Diagrama da Arquitetura (ASCII)

```
          ┌───────────┐
          │  Postman  │
          └─────┬─────┘
                │
                ▼
          ┌───────────────┐
          │ API Gateway   │
          └─────┬─────────┘
                │
       ┌────────┴─────────┐
       │                  │
       ▼                  ▼
┌───────────────┐   ┌───────────────┐
│ Produtos Svcs │   │ Pedidos Svcs  │
└───────────────┘   └───────────────┘
       │                  │
       └────────┬─────────┘
                ▼
          ┌─────────────┐
          │  Eureka     │
          └─────────────┘
```

