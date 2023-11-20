
**To run locally you have to pass the following values:**

| value                  | meaning                         |
|------------------------|---------------------------------|
| spring.profiles.active | Profile that should be executed |
| DB_USERNAME            | Username to connect to DB       |
| DB_PASSWORD            | Password to connect to DB       |
| DB_URL                 | Connection's URL of DB          |
| JWT_KEY                | Key used to encryp/generate JWT |

Some reference values from local using H2:

`-Dspring.profiles.active=dev -DDB_USERNAME=admin -DDB_PASSWORD=admin -DDB_URL=jdbc:h2:mem:test -DJWT_TOKEN={signing-key-used-to-generate-jwt}`

