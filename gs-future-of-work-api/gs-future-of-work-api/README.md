# GS Future of Work API

API RESTful desenvolvida em Spring Boot para gerenciar usuários e trilhas de aprendizado.

## Tecnologias

- Java 21
- Spring Boot 3.3.4
- Spring Data JPA
- H2 Database (em memória)
- Maven

## Como Executar

1.  **Pré-requisitos:** Certifique-se de ter o Java 21 e o Maven instalados.
2.  **Compilação:** Navegue até o diretório raiz do projeto (`cd .\gs2-java-api\`) e execute:
    \`\`\`bash
    mvn clean install
    \`\`\`
3.  **Execução:** Execute o arquivo JAR gerado:
    \`\`\`bash
    java -jar target/gs-future-of-work-api-1.0.0.jar
    \`\`\`

A API estará disponível em \`http://localhost:8080\`.

## Endpoints

### Usuários (\`/api/usuarios\`)

| Método | Caminho | Descrição |
| :--- | :--- | :--- |
| \`GET\` | \`/api/usuarios\` | Lista todos os usuários. |
| \`GET\` | \`/api/usuarios/{id}\` | Busca um usuário pelo ID. |
| \`POST\` | \`/api/usuarios\` | Cria um novo usuário. |
| \`PUT\` | \`/api/usuarios/{id}\` | Atualiza um usuário existente. |
| \`DELETE\` | \`/api/usuarios/{id}\` | Remove um usuário pelo ID. |

### Trilhas (\`/api/trilhas\`)

| Método | Caminho | Descrição |
| :--- | :--- | :--- |
| \`GET\` | \`/api/trilhas\` | Lista todas as trilhas. |
| \`GET\` | \`/api/trilhas/{id}\` | Busca uma trilha pelo ID. |
| \`POST\` | \`/api/trilhas\` | Cria uma nova trilha. |
| \`PUT\` | \`/api/trilhas/{id}\` | Atualiza uma trilha existente. |
| \`DELETE\` | \`/api/trilhas/{id}\` | Remove uma trilha pelo ID. |

## Console H2

O console do banco de dados H2 está habilitado em \`http://localhost:8080/h2-console\`.
Use as seguintes credenciais:
- **JDBC URL:** \`jdbc:h2:mem:gsdb\`
- **User Name:** \`sa\`
- **Password:** (deixe em branco)

## Integrantes:

- Matheus Cantiere RM558479
- Guilherme Barbiero RM555185
- Vinicius Castro RM556137