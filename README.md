## Bem-vindo ao projeto de exemplo CRUD Cliente.
<p align="center">
  <a href="https://github.com/psico/ludo-app/blob/master/LICENSE">
    <img src="https://img.shields.io/badge/license-MIT-blue.svg" alt="LudoApp the MIT license." />
  </a>
  <a href="https://github.com/psico/ludo-app">
    <img src="https://img.shields.io/badge/PRs-welcome-brightgreen.svg" alt="PRs welcome!" />
  </a>
</p>

Este projeto exemplica o uso de uma estrutura REST com REACT, as tecnólogias usadas foram:
- Banco de dados: PostGreSQL e Power Architect (Modelagem).
- Backend: Java, Springboot, JPA, Liquibases.
- Frontend: Javascript, React, Axios.


##### É IMPORTANTE criar uma base de dados chamada "crudClienteCooperSys" no PostGreSQL e o projeto por padrão espera o usuario "postgres" com a senha "admin".
Caso queira mudar essas configurações verifique os arquivos:
- src/main/resources/application.properties
- src/main/resources/META-INF/persistence.xml

O modelo de dados pode ser visto na raiz do projeto backend:
crudClienteCooperSystemModelo.pdf

Código-fonte do backend: 
https://github.com/psico/crudClienteCooperSystem

Código-fonte do frontend: 
https://github.com/psico/front-crud-cliente
