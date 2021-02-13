# jOOQ-Template

This project serves as a template to generate java classes from any existing database scheme using jOOQ. 

Derived projects can easily be used as a dependency for other projects without publicizing the database credentials.

#### Example usage of the generated code for the MySQL system schema on MariaDB with the additionally supplied utility functions:

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
