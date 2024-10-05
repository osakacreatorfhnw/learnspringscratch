Make sure that you have installed:

Gradle version: `8.10.2` (check gradle -v)
Java version: `17.0.10` (check java --version)

Check https://sdkman.io/ for that extra spicy ict sauce.

1. Apply the repository path in `application.properties`.
2. Run `gradle clean build bootRun`.
3. Access `localhost:8080/import`.
4. Import files; they will be stored in the "imported" folder.