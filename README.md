# MoneyPlus

O **MoneyPlus** é um sistema de controle financeiro, desenvolvido para gerenciar transações financeiras, cadastrar e gerenciar usuários e contas. A aplicação permite registrar transações, realizar cadastros de usuários e contas, e realizar operações sobre os dados.

## Tecnologias Utilizadas

- **Java** (Spring Boot) - Framework para desenvolvimento do backend.
- **JPA/Hibernate** - Para mapeamento objeto-relacional e persistência de dados.
- **MySQL/PostgreSQL** - Banco de dados para armazenar as informações do sistema.
- **Maven** - Gerenciador de dependências e build.
- **Lombok** - Para reduzir o código boilerplate, como getters, setters e construtores.
- **Postman** - Utilizado para testar as APIs RESTful.

## Funcionalidades

### 1. **Cadastro de Usuário**
   - Endpoint para cadastrar novos usuários no sistema.
   - Campos necessários: `nome`, `email`, `senha`.

### 2. **Cadastro de Conta**
   - Endpoint para criar contas associadas a usuários.
   - Campos necessários: `nome`, `saldo inicial`, `id do usuário`.

### 3. **Cadastro de Transação**
   - Endpoint para registrar transações financeiras.
   - Campos necessários: `valor`, `data da transação`, `tipo da transação` (crédito ou débito), `id da conta` associada.

### 4. **Listagem de Transações**
   - Endpoint para listar todas as transações realizadas no sistema.

## Como Rodar o Projeto Localmente

### 1. **Clonar o repositório**

```bash
git clone https://github.com/seunome/moneyplus.git
