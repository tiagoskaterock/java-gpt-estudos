# JavaGptEstudos

![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=java) ![Spring](https://img.shields.io/badge/Spring-6.1.6-6DB33F?logo=spring) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-6DB33F?logo=spring-boot) ![Maven](https://img.shields.io/badge/Maven-3.9.6-C71A36?logo=apache-maven) ![Flyway](https://img.shields.io/badge/Flyway-9.22.3-FF6F61?logo=flyway)

Bem-vindo ao meu projeto **JavaGptEstudos**, uma aplicação Spring Boot com integração ao MySQL e gerenciamento de migrações de banco de dados usando Flyway. Este projeto demonstra como configurar uma aplicação Java com persistência de dados e inicialização de usuários.

## 📋 Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- **Java 17** ![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=java)
- **Maven** ![Maven](https://img.shields.io/badge/Maven-3.9.6-C71A36?logo=apache-maven)
- **MySQL 8.0** (ou superior)
- Um editor de código, foi utilizado IntelliJ Community

## 🛠 Configuração do Banco de Dados

1. **Crie o banco de dados no MySQL**:
   ```bash
   mysql -u root -p
   CREATE DATABASE java_gpt_estudos;
   ```
2. **Configure o usuário e permissões**:
   ```sql
   GRANT ALL PRIVILEGES ON java_gpt_estudos.* TO 'tiago'@'localhost' IDENTIFIED BY '12345678';
   FLUSH PRIVILEGES;
   ```

3. Verifique se o MySQL está rodando na porta `3306`:
   ```bash
   netstat -an | grep 3306
   ```

## ⚙️ Configuração do Projeto

O projeto usa Spring Boot com JPA e Flyway para gerenciamento de migrações. As configurações estão definidas em `src/main/resources/application.properties`:

```properties
# MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/java_gpt_estudos?useSSL=false&serverTimezone=UTC
spring.datasource.username=tiago
spring.datasource.password=12345678

# Hibernate
spring.jpa.hibernate.ddl-auto=none
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=true

# Flyway
spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration
spring.flyway.baseline-on-migrate=true
spring.flyway.clean-disabled=false
```

### Dependências Principais
- **Spring Boot** ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-6DB33F?logo=spring-boot): Framework para construção da aplicação.
- **Spring Data JPA** ![Spring](https://img.shields.io/badge/Spring-6.1.6-6DB33F?logo=spring): Persistência de dados.
- **MySQL Connector** : Conexão com o banco MySQL.
- **Flyway** ![Flyway](https://img.shields.io/badge/Flyway-9.22.3-FF6F61?logo=flyway): Gerenciamento de migrações de banco.
- **Spring Boot DevTools**: Ferramentas para desenvolvimento.

## 🚀 Como Rodar o Projeto

1. **Clone o repositório** (se aplicável):
   ```bash
   git clone https://github.com/tiagoskaterock/java-gpt-estudos
   cd java-gpt-estudos
   ```

2. **Compile o projeto**:
   ```bash
   mvn clean install
   ```

3. **Execute a aplicação**:
   ```bash
   mvn spring-boot:run
   ```

   Isso iniciará a aplicação Spring Boot na porta `8080`. O `CommandLineRunner` cadastrará um usuário inicial (`Admin`, `admin@admin.com`) na tabela `user`.

4. **Verifique o usuário no banco**:
   ```bash
   mysql -u tiago -p12345678 -h localhost -P 3306 java_gpt_estudos
   SELECT * FROM user;
   ```

## 🗄 Como Rodar as Migrações

O Flyway gerencia as migrações do banco de dados. Os scripts de migração estão localizados em `src/main/resources/db/migration`.

1. **Aplicar migrações**:
   ```bash
   mvn flyway:migrate
   ```

   Isso executará todos os scripts de migração pendentes (exemplo: `V1__create_user_table.sql`).

2. **Verificar o status das migrações**:
   ```bash
   mvn flyway:info
   ```

## 🧹 Como Resetar as Migrações

**Atenção**: O comando `flyway:clean` exclui todas as tabelas no banco `java_gpt_estudos`. Use com cuidado!

1. **Limpar o banco de dados**:
   ```bash
   mvn flyway:clean
   ```

2. **Reaplicar as migrações**:
   ```bash
   mvn flyway:migrate
   ```

3. **Limpar e migrar em um único comando**:
   ```bash
   mvn flyway:clean flyway:migrate
   ```

## 🐞 Depuração

Se encontrar erros, execute os comandos com modo debug para mais detalhes:

- Para a aplicação:
  ```bash
  mvn spring-boot:run -Dspring-boot.run.arguments=--debug
  ```

- Para o Flyway:
  ```bash
  mvn flyway:clean flyway:migrate -X
  ```

## 📂 Estrutura do Projeto

```
JavaGptEstudos/
├── src/
│   ├── main/
│   │   ├── java/org/example/
│   │   │   ├── models/
│   │   │   │   └── User.java
│   │   │   ├── repositories/
│   │   │   │   └── UserRepository.java
│   │   │   └── JavaGptEstudosApplication.java
│   │   ├── resources/
│   │   │   ├── db/migration/
│   │   │   │   └── V1__create_user_table.sql
│   │   │   └── application.properties
├── pom.xml
└── README.md
```

## 📝 Notas

- A tabela `user` é criada automaticamente pelo Flyway se houver um script de migração (exemplo: `V1__create_user_table.sql`).
- O `CommandLineRunner` cadastra um usuário inicial (`Admin`, `admin@admin.com`) ao iniciar a aplicação.
- Certifique-se de que o MySQL está rodando e as credenciais no `application.properties` estão corretas.

## 📚 Recursos

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/3.2.5/reference/html/) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-6DB33F?logo=spring-boot)
- [Flyway Documentation](https://flywaydb.org/documentation/) ![Flyway](https://img.shields.io/badge/Flyway-9.22.3-FF6F61?logo=flyway)
- [Maven Documentation](https://maven.apache.org/guides/) ![Maven](https://img.shields.io/badge/Maven-3.9.6-C71A36?logo=apache-maven)