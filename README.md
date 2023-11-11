# Challenge-Java-2SEM

# Apresentação do projeto



# Endpoints

## Usuario
- [Login](#login)
- [Buscar usuário](#buscar_usuário)
- [Cadastrar usuário](#cadastrar_usuário)
- [Atualizar usuário](#atualizar_usuário)
- [Deletar usuário](#deletar_telefone)

## Telefone
- [Listar telefones por ID de usuário](#listar_telefone_por_id)
- [Cadastrar telefone](#cadastar_telefone_usuario)
- [Atualizar telefone](#atualizar_usuário)
- [Deletar telefone](#deletar_telefone)

## Email
- [ID do Email](#id_do_email)
- [Cadastrar email](#cadastar_email_usuario)
- [Atualizar email](#atualizar_usuário)
- [Deletar email](#deletar_email)


---
padrão

GET 
- endpoint
- exemplo corpo de resposta
- http responses

POST
- endpoint
- tabela de atributos para request
- exemplo corpo de request
- exemplo corpo de resposta 
- http responses

PUT
- endpoint
- tabela de atributos para request
- exemplo corpo de request
- exemplo corpo de resposta 
- http responses

DELETE
- endpoint 
- exemplo de request 
- não há corpo de resposta 
- http responses
---

### Buscar_Usuário 

`GET` /localhost:8080/api/cliente/{id}

**Exemplo Corpo de resposta**
```JSON
{
    "id_cliente": 1,
    "nm_cliente": "Ronaldo",
    "nr_cnh": "47960336042",
    "nr_cpf": "50189933089",
    "nr_rg": "111631221"
    "dt_data_nascimento": "1995-07-20",
    "dt_cadastro": "2010-03-10",
}
```
**HTTP responses para `GET`**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Cadastrar_Cliente

`POST` /localhost:8080/api/cliente

**Atributos do request**
|        Campo         |   Tipo   | Obrigatorio |  Descrição
|----------------------|----------|:-----------:|--------------------------------------------------|
|  ID                  |   Int    |     Sim     | Campo para inserir o ID do cliente
|  Nome                |  String  |     Sim     | Campo para inserir nome do cliente
|  Data de Nasc        |Local_date|     Sim     | Campo para inserir data de nascimento do cliente
|  CNH                 |   Int    |     Sim     | Campo para inserir a CNH do cliente
|  CPF                 |   Int    |     Sim     | Campo para inserir o CPF do cliente
|  RG                  |   Int    |     Sim     | Campo para inserir o RG do cliente
|  Data de Cadastro    |Local_date|     Sim     | Campo para inserir a data de cadastro do cliente

**Exemplo Corpo do request** 
{
    "id_cliente": 2,
    "nm_cliente": "Maria",
    "nr_cnh": "62764900687",
    "nr_cpf": "60044365004",
    "nr_rg": "461404837",
    "dt_data_nascimento": "1990-06-15",
    dt_cadastro": "2015-02-05"
}

**Exemplo corpo de resposta**
```JSON
Status 200 ok
```

**HTTP responses para POST**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Atualizar_Cliente

`PUT` /localhost:8080/api/cliente/{id}


**Atributos do request**
|        Campo         |   Tipo   | Obrigatorio |  Descrição
|----------------------|----------|:-----------:|--------------------------------------------------|
|  ID                  |   Int    |     Sim     | Campo para inserir o ID do cliente
|  Nome                |  String  |     Sim     | Campo para inserir nome do cliente
|  Data de Nasc        |Local_date|     Sim     | Campo para inserir data de nascimento do cliente
|  CNH                 |   Int    |     Sim     | Campo para inserir a CNH do cliente
|  CPF                 |   Int    |     Sim     | Campo para inserir o CPF do cliente
|  RG                  |   Int    |     Sim     | Campo para inserir o RG do cliente
|  Data de Cadastro    |Local_date|     Sim     | Campo para inserir a data de cadastro do cliente

**Exemplo Corpo do request** 

```JSON
{
    "id_cliente": 1,
    "nm_cliente": "Ronaldo ",
    "nr_cnh": "47960336042",
    "nr_cpf": "50189933089",
    "nr_rg": "111631221"
    "dt_cadastro": "2010-03-10",
    "dt_data_nascimento": "1995-07-20",
}
```

**Exemplo Corpo do response**
```JSON
{
    "id_cliente": 1,
    "nm_cliente": "Ronaldo da silva ",
    "nr_cnh": "47960336042",
    "nr_cpf": "50189933089",
    "nr_rg": "111631221"
    "dt_cadastro": "2010-03-10",
    "dt_data_nascimento": "1995-07-20",
}
```

**Respostas que podem aparecer no `PUT` :**
| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Deletar_Usuário

`Delete` /localhost:8080/api/cliente/{id}

Retorna um arquivo JSON vazio.

**Respostas que podem aparecer no DELETE :**

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success).|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---


------------------------------------------------------------------------------------------------------------------------
### Cadastar_Email_Cliente
`POST` /localhost:8080/api/cliente/email

|    Campo         | Tipo   | Obrigatorio | Descrição
|------------------|--------|:-----------:|--------------------------------------------------------------|
| id do email      | Int    |     Sim     | Campo que contém o código do email do cliente
| dados do email   | String |     Sim     | Contém o código de endereçamento de email (email@email.com)
| status do email  | String |     Sim     | Contém o status do email do cliente(ativo ou inativo)

**Exemplo do Corpo do Request**
```JSON
  {
        "id_cliente": 21,
        "id_email": 21,
        "ds_email": "RedVelvet@gmail.com",
        "st_email": "A "
    }
```
**Exemplo do Corpo do Response**
```JSON
  Status 200 ok
```
**Respostas que podem aparecer no POST :**
| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Atualizar_Email

`PUT` /localhost:8080/api/cliente/email/{id}

|    Campo         | Tipo   | Obrigatorio | Descrição
|------------------|--------|:-----------:|--------------------------------------------------------------|
| id do email      | Int    |     Sim     | Campo que contém o código do email do cliente
| dados do email   | String |     Sim     | Contém o código de endereçamento de email (email@email.com)
| status do email  | String |     Sim     | Contém o status do email do cliente(ativo ou inativo)


**Exemplo do Corpo do Request**
```JSON
  {
        "id_cliente": 21,
        "id_email": 21,
        "ds_email": "RedVelvet@gmail.com",
        "st_email": "A "
    }
```
**Exemplo do Corpo do Response**
```JSON
{
    "ds_email": "RedVelvet@gmail.com",
    "id_cliente": 21,
    "id_email": 1,
    "st_email": "I "
}
```
**Respostas que podem aparecer no PUT :**
| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---
### Deletar_Email

`Delete` /localhost:8080/api/email/{id}

Retorna um arquivo JSON vazio.

**Respostas que podem aparecer no `DELETE` :**

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success).|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---


------------------------------------------------------------------------------------------------------------------------------------




### Cadastar_Telefone_Usuario
`POST` /localhost:8080/api/cliente/telefone

|    Campo         | Tipo | Obrigatorio | Descrição
|------------------|--------|:-----------:|------------------------------------------------------|
| id do telefone   | Int    |     Sim     | Campo que contém o ID do cliente 
| telefone         | Int    |     Sim     | Campo que contém o telefone do usuário até 9 digitos 
| ddd              | String |     Sim     | Contém o código de endereçamento urbano brasileiro
| ddi              | String |     Sim     | Contém o codigo de discagem direta internacional
| nome da operadora| String |     Sim     | Contém o nome da operadora de telefonia

**Exemplo do Corpo do Request** 
```JSON
 {
        "id_cliente": 21,
        "id_telfone": 21,
        "nm_operadora": "Claro",
        "nr_ddd": 81,
        "nr_ddi": 55,
        "nr_telefone": 81998887777
    }
```
**Exemplo do Corpo do Response**(-------------EDUUUUUUUU_____________)
```JSON
Status 200 ok
,
```
**Respostas que podem aparecer no POST :**
| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Atualizar_Telefone

`PUT` /localhost:8080/api/cliente/telefone/{id}

|    Campo         | Tipo   | Obrigatorio | Descrição
|------------------|--------|:-----------:|------------------------------------------------------|
| telefone         | String |     Sim     | Campo que contém o telefone do usuário até 9 digitos 
| ddd              | String |     Sim     | Contém o código de endereçamento urbano brasileiro
| ddi              | String |     Sim     | Contém o codigo de discagem direta internacional
| nome da operadora| String |     Sim     | Contém o nome da operadora de telefonia

**Exemplo do Corpo do Request** (-------------EDUUUUUUUU_____________)
```JSON
 {
        "id_cliente": 21,
        "id_telfone": 21,
        "nm_operadora": "Vivo",
        "nr_ddd": 81,
        "nr_ddi": 55,
        "nr_telefone": 81998887777
    }
```
**Exemplo do Corpo do Response**
```JSON
{
    "id_cliente": 21,
    "id_telfone": 21,
    "nm_operadora": "Vivo",
    "nr_ddd": 81,
    "nr_ddi": 55,
    "nr_telefone": 81998887777
}
```
**Respostas que podem aparecer no PUT :**
| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---
### Deletar_Telefone

`Delete` /localhost:8080/api/telefone/{id}
/localhost:8080/api/telefone/

Retorna um arquivo JSON vazio.

**Respostas que podem aparecer no `DELETE` :**

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success).|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---


# Diagrama de Classes
![Diagrama de classes](/diagrama_de_classe.PNG)

# Banco de dados enxuto
![Banco de dados enxuto](/Banco_enxuto.PNG)
**Ultilizamos esse banco de dados somente para materia de JAVA**
# Banco de dados original
![Banco de dados original](/Banco_original.PNG)
