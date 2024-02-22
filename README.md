# Rinha de Backend - Spring Boot e PostgreSQL
## Descrição
Este projeto é uma aplicação desenvolvida para a Rinha de Backend, utilizando Spring Boot e PostgreSQL, destinada a simular um sistema bancário. A API REST criada oferece funcionalidades para realizar transações bancárias, como depósitos e saques, além de permitir a consulta de extratos e a busca de informações detalhadas dos clientes no banco de dados. O sistema foi otimizado para suportar alta carga de acessos, visando demonstrar robustez e eficiência em um ambiente de competição que desafia os limites de processamento e gestão de dados sob demanda.

## Tecnologias Utilizadas
- Java
- Spring Boot
- PostgreSQL
- Docker e Docker Compose

## Requisitos do Sistema
Java JDK 17 ou superior
Docker e Docker Compose
PostgreSQL (Opcional para desenvolvimento local sem Docker)

## Configuração do Ambiente
Antes de começar a trabalhar no projeto, é importante configurar o ambiente de desenvolvimento com todas as ferramentas necessárias. Siga os passos abaixo para garantir que tudo esteja configurado corretamente.

### Instalação do Java JDK
1. Baixe e instale o Java JDK 11 ou superior do site oficial da Oracle ou use um gerenciador de pacotes de sua preferência.
2. Configure a variável de ambiente JAVA_HOME para apontar para o diretório de instalação do JDK.
3. Adicione o caminho do JDK à variável de ambiente PATH.

### Instalação do Docker e Docker Compose
1. Siga as instruções de instalação do Docker disponíveis na documentação oficial.
2. Instale o Docker Compose seguindo as orientações encontradas na documentação oficial do Docker Compose.

### Configuração do Ambiente PostgreSQL (Opcional para desenvolvimento local sem Docker)
Caso prefira trabalhar com o PostgreSQL localmente, sem o uso de Docker, siga estes passos:

1. Baixe e instale o PostgreSQL do site oficial.
2. Crie um banco de dados e um usuário com permissões adequadas para acessar este banco de dados.
3. Anote o nome do banco de dados, o usuário e a senha, pois essas informações serão necessárias para configurar a aplicação.

## Execução da Aplicação
Esta seção detalha como iniciar a aplicação utilizando Docker para um ambiente isolado e configurado previamente, bem como a execução local para desenvolvimento e testes rápidos.

### Execução via Docker
O uso do Docker simplifica a configuração do ambiente, garantindo que a aplicação execute de forma consistente em qualquer máquina. Siga os passos abaixo para iniciar a aplicação usando Docker Compose.

1. Preparação: Certifique-se de que o Docker e o Docker Compose estejam instalados e funcionando na sua máquina. Consulte a seção Configuração do Ambiente para orientações de instalação.

2. Arquivo Docker Compose: Navegue até o diretório raiz do projeto, onde o arquivo docker-compose.yml está localizado. Este arquivo contém a configuração necessária para executar tanto o aplicativo Spring Boot quanto o serviço PostgreSQL em containers Docker.

3. Iniciar Serviços: Execute o seguinte comando no terminal:
```docker-compose up```

Este comando construirá as imagens Docker necessárias (se ainda não estiverem construídas) e iniciará os containers definidos no docker-compose.yml. A primeira execução pode levar algum tempo, pois precisa baixar as imagens base e construir a imagem da aplicação.

4. Verificação: Após a conclusão do comando, a aplicação estará acessível no endereço http://localhost:8080 (ou na porta configurada no docker-compose.yml).

5. Encerramento: Para interromper e remover os containers criados pelo Docker Compose, utilize o comando:
```docker-compose down```

### Execução Localmente
Para executar a aplicação diretamente na sua máquina, sem o uso de Docker, siga estes passos. Esta abordagem é útil para desenvolvimento e testes rápidos.

1. Configuração do Banco de Dados: Certifique-se de que o PostgreSQL esteja instalado e configurado conforme descrito na seção Configuração do Ambiente. A aplicação precisa conectar-se a um banco de dados PostgreSQL.

2. Variáveis de Ambiente: Configure as variáveis de ambiente ou ajuste o arquivo application.properties com as credenciais do seu banco de dados local.

3. Execução da Aplicação: Navegue até o diretório raiz do projeto e execute o seguinte comando para iniciar a aplicação Spring Boot:
```./mvnw spring-boot:run```
Este comando irá compilar o código-fonte (se necessário) e iniciar o servidor da aplicação na porta padrão 8080. A aplicação estará acessível no endereço http://localhost:8080.

### Acesso e Teste
Após iniciar a aplicação, seja via Docker ou localmente, você pode acessar a API através do navegador ou utilizando ferramentas como Postman para testar os endpoints disponíveis. Consulte a seção Uso da API para mais detalhes sobre os endpoints e exemplos de uso.

## Uso da API
Esta seção descreve os endpoints disponíveis na API de simulação bancária, permitindo realizar transações, consultar extratos e buscar informações dos clientes.

Endpoints Disponíveis
1. Criação de Conta
Endpoint: /clientes
Método: POST
Descrição: Cria uma nova conta bancária para um cliente.
Corpo da Requisição:
```
{
    "limite": 1000,
    "saldo": 0 
}
```
Resposta de Sucesso:
```
{
    "limite" : 100000,
    "saldo" : -9098
}
```
2. Depósito
Endpoint: /api/contas/{id}/deposito
Método: POST
Descrição: Realiza um depósito em uma conta específica.
Parâmetros: id - ID da conta
Corpo da Requisição:
json
Copy code
```
{
  "valor": 500.00
}
```
Resposta de Sucesso:
json
Copy code
{
  "id": 1,
  "novoSaldo": 1500.00
}
3. Saque
Endpoint: /api/contas/{id}/saque
Método: POST
Descrição: Realiza um saque de uma conta específica.
Parâmetros: id - ID da conta
Corpo da Requisição:
json
Copy code
{
  "valor": 200.00
}
Resposta de Sucesso:
json
Copy code
{
  "id": 1,
  "novoSaldo": 1300.00
}
4. Consulta de Extrato
Endpoint: /api/contas/{id}/extrato
Método: GET
Descrição: Obtém o extrato de transações de uma conta específica.
Parâmetros: id - ID da conta
Resposta de Sucesso:
json
Copy code
[
  {
    "tipo": "DEPOSITO",
    "valor": 500.00,
    "data": "2024-02-21T12:00:00"
  },
  {
    "tipo": "SAQUE",
    "valor": 200.00,
    "data": "2024-02-21T15:00:00"
  }
]
5. Busca de Informações do Cliente
Endpoint: /api/clientes/{cpf}
Método: GET
Descrição: Busca informações detalhadas do cliente pelo CPF.
Parâmetros: cpf - CPF do cliente
Resposta de Sucesso:
json
Copy code
{
  "nome": "Nome do Cliente",
  "cpf": "CPF do Cliente",
  "contas": [
    {
      "id": 1,
      "saldo": 1300.00
    }
  ]
}
Dicas de Uso
Utilize ferramentas como Postman ou cURL para testar os endpoints da API.
Certifique-se de substituir os valores dos parâmetros e do corpo da requisição conforme necessário.
Para solicitações POST, não esqueça de definir o cabeçalho Content-Type como application/json.

## Testes
Instruções sobre como executar testes automatizados, se disponíveis.

## Colaboração
Informações sobre como contribuir para o projeto, incluindo padrões de código, processos de revisão de código e como reportar bugs ou solicitar novas funcionalidades.
