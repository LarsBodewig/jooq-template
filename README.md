# DB-Template

This project serves as a template to manage an application database as a Maven module.

The template offers flyway to alter the database structure using incremental SQL scripts. After each migration jOOQ is used to generate new java source files from the database structure to allow type-safe SQL queries. As derived projects should be used as a dependency for other application modules, this template also includes additional utility functions to further simplify the usage of jOOQ.

#### Example usage of the provided jOOQ interface to query a MariaDB instance:

```java
public static void main(String[] args) {
  ConnectionManager.setConfiguration(Configuration.create()
      .setUser("user")
      .setPassword("password")
      .setIp("host")
      .setPort("port") // if omitted port defaults to 3306 for ConnectionUrlBuilder.MYSQL
      .setSchema(Mysql.MYSQL)
      .setDialect(SQLDialect.MARIADB)
      .setUrlBuilder(ConnectionUrlBuilder.MYSQL)
      .build());
  
  try (DSLConnection con = ConnectionManager.getConnection()) {
    Result<UserRecord> result = con.selectFrom(Tables.USER).fetch();
    for (UserRecord record : result) {
      System.out.println("Record: " + record.getUser());
    }
  } catch (SQLException e) {
    e.printStackTrace();
  }
}
```

Run `git config include.path ../.gitconfig` to include the template config in your project config.
