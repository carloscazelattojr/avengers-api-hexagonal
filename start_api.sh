./mvnw spring-boot:run -Dspring-boot.run.profiles=dev -Dspring-boot.run.jvmArguments="-Xmx256m -Xms128m" -Dspring-boot.run.arguments="'--DB_USER=local.avenger' '--DB_PASSWORD=local.avenger' '--DB_NAME=avengers'"