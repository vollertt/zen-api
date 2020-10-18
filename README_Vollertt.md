# Sistema de visualização e cadastro de Peças Zen: "verificar item descritivo da atividade"

A aplicação do desafio utiliza dois projetos diferentes

 1. O "back-end" (pasta "zen") contém o projeto java Maven, Spring BOOT REST, criada com IDE Eclipse),  implementou serviços REST utilizando JPA aos modelos de entidade criados conforme a modelagem do sistema e regras.

 2. O "front-end" (pasta "zen-app"),  Foi utilizado o framework "Vue.js", para integração com o serviços
    da API do Back-end

====================================================

# Back-end, API de serviços REST: "zen-api"

Para o Back-End o pacote "zen-api" contém  o projeto Java e os fontes da API 
implementada para o desafio. 

O projeto está configurado, conforme o arquivo da aplicação "application.properties". 
A API dos serviços REST de requisições e responses em formato JSon, roda na porta "9000" podendo 
alterar conforme desejem. A aplicação roda como uma aplicação Tomcat, mas não tem páginas web associadas às requisições com a Api. 

Os itens implementados para a aplicação Java REST foram organizados em: model, resource, repository e util, contendo as respectivas classes.

As bibliotecas do projeto Mavem (arquivo pom.xml) foram : pring-boot-starter, spring-boot-starter-data-jpa, spring-boot-starter-web, spring-boot-devtools, postgresql, jackson-dataformat-yaml, jackson-databind, spring-boot-starter-test

O root da APi, foi configurado como "zen-api", logo as requisições são
para : http://localhost:9000/zen-api/

Foi implemntado três(3) serviços para a atividade:

1) Salvar novo produto :   http://localhost:9000/zen-api/novo-produto
   serviço: POST, e recebe de parâmetro (RequestBody) um objeto no formato "Json" conforme 
   a Entidade "Produto" implementada.
   Exemplo:  {
		"cd_item": 5390
		"linha_produto": {"id_linha_produto": 17}
		"peso_bruto": 25.69
		"peso_liquido": 10.25
		"veiculo": {"id_veiculo": 50}
   	     }
2) Remove produto: http://localhost:9000/zen-api/remove-produto
   serviço: POST, e recebe de parâmetro (RequestBody) um objeto conforme exemplo acima.


3) Lista dos produtos cadastrados: http://localhost:9000/zen-api/produto-page
   serviço: GET, e recebe de parâmetro (RequestParam) o valor inteiro associado à página desejada (page), a quantidade de registro por       página (size), o nome do campo a ser ordenado (order), a direção da ordenação ASC ou DESC (direction), o valor do filtro associado ao    grupo de produto (id_grupo_produto) e o valor do campo associado à linha de produto (id_linha_produto)
   Retorna uma lista de objetos associados à entidade produto, conforme implementação Lazy Data Modelaos serviços REST    
   Cada um dos objetos contem os seguintes campos e tipos, conforme exemplo abaixo:
   
   {
    "cd_item": 5390,
    "cd_usuario": 1,
    "dt_atualizacao": null,
    "dt_inclusao": "2020-10-16T13:08:28.988+0000",
    "id_produto": 80,
    "linha_produto": {                
                         "id_linha_produto": 17,
                         "ds_linha_produto": "TENSOR DA CORREIA DO ALTERNADOR",
                         "grupo_produto": {
                                            "id_grupo_produto": 3, 
                                            "ds_grupo_produto": "TENSOR"
                                          },
                         "peso_bruto": 25.69,
                         "peso_liquido": 10.25,
                         "veiculo": {
                                      "id_veiculo": 50,
                                      "ds_veiculo": "1500",
                                      "marca_veiculo": {
                                                         "id_marca": 5, 
                                                         "ds_marca": "BMW"
                                                       }
                                   }
                    }
   }

============================================

# Banco de Dados PostgreSQL

O banco de dados, conforme configuração "application.properties" foi utilizado o PostgresSQL versão 10.12,
e nome da base de dados utilizada foi : "zen_produtos" (podendo vocês também alterar conforme desejem)
seque o script sql (arquivo "zen-produtos.sql") para instalação contendo os dados e modelagem. 

primeiro crie a base de dados conforme nome desejado e depois import:
(incluir path do arquivo salvo "zen_produtos.sql" (exemplo: /app/zen_produtos.sql)
Comando:  psql -U username -d dbname < /app/zen-produtos.sql

obs: lembrar do nome da base de dados, nome de usuário e senha configurar no arquivo "application.properties"



***Camada "back-end" (caracteristica e dependências). Projeto Spring Boot Web Maven.

//=========================================

# Front-End , aplicação Vue.js : "zen-app"

**Preparação do ambiente para o front-end com framework "Vue.js" (módulos, bibliotecas e dependências utilizados)**

A aplicação (pasta : "zen-app"), necessita da instalação do servidor Node no servidor (https://nodejs.org/en/download/)
e após da instação do Vue que pode ser feito via terminal (npm install vue).

O servidor do front-end e do back-end, podem estar todos na mesma máquina. Eles rodam em portas distintas. A aplicação do
fron-end roda na porta 8080, por default. 

Após instalar estas dependências iniciais, via terminal entre na raiz da pasta do projeto ("zen-app") e
então instale as dependências do projeto utilizadas e associadas ao Vue/Node:

   npm install --save axios material-design-icons materialize-css vue-moment vue-router

Na pasta do projeto (zen-app) abra o arquivo /src/services/config.js
Verá a baseURL associada a API do Back-end (http://127.0.0.1/zen-api/)
caso altere porta e endereçõ deve alterar esta configuração do front-end.
Outro item importante é do Apache, com o navegador e COrs, como ambos serviços
rodam na mesma máquina mas serviços distintos e em portas diferentes.
No servidor Web Apache, item httpd.conf, configure o "VirtualHost" conforme abaixo:

    <VirtualHost  *:80>
           ProxyPass /zen-api http://localhost:9000/zen-api 
           ProxyPassReverse /zen-api http://localhost:9000/zen-api
    </VirtualHost>


Após a instalação e configurações , na pasta do projeto do front-end ("zen-app") realizer um build via terminal
 
   npm run build

E posteriormente inicie o servidor com a aplicação:

  npm run serve

Estando tudo ok, o serviço iniciará e avisará a porta default, conforme abaixo:

  App running at:
  - Local:   http://localhost:8080/


Se o banco de dados já estiver instalado e carregado com os dados iniciais,
a APi do back-end ("zen-api") já estiver rodando e configurada, 
a aplicação poderá ser acessada do navegador através do host abaixo:

  http://localhost:8080/zen-app/

