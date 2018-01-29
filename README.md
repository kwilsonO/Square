# Square

Saves and gets a number from an Oracle database and squares it.

The idea of the project is that there are two rest-services which saves and gets a number from a database. One rest-service will save a number that is supplied through a frontend. The other rest-service takes an id number from the frontend, looks in the database for that id, takes the number and squares it. Finally the service returns the value to the frontend. I am trying to make the project to run and during the testing I want a in-memory database (H2) to simulate the database.

Installation <br>
A dependency is needed from Oracle at http://www.oracle.com/technetwork/database/features/jdbc/jdbc-drivers-12c-download-1958347.html called ojdbc7.jar. Download it to eg "C:\ojdbc7.jar" and in the terminal of the project write "mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc7 -Dpackaging=jar -Dversion=12.1.0.1 -DgeneratePom=true -Dfile=C:\ojdbc7.jar" to install that one separately.

Issues <br>
1. When running main application maven cannot start a bean. Why? What is wrong?
2. When running only the test in the square-app module it say "Failed to load ApplicationContext". Why? Again what is wrong?
