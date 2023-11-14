
**To run locally you have to pass the following values:**

| value                  | meaning                         |
|------------------------|---------------------------------|
| spring.profiles.active | Profile that should be executed |
| DB_USERNAME            | Username to connect to DB       |
| DB_PASSWORD            | Password to connect to DB       |
| DB_URL                 | Connection's URL of DB          |

Some reference values from local using H2:
-Dspring.profiles.active=dev

-DDB_USERNAME=admin

-DDB_PASSWORD=admin

-DDB_URL=jdbc:h2:mem:test

