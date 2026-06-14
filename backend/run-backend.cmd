@echo off
setlocal

set "JAVA_HOME=C:\Program Files\Java\jdk-26"
set "PATH=%JAVA_HOME%\bin;%PATH%"

set "MAVEN_CMD=%USERPROFILE%\.m2\wrapper\dists\apache-maven-3.9.16\0daed3be3ebd1c706f0e69e8b07c6b73f5cc4ea3dfce72a8d0ec2e849ca2ddb0\bin\mvn.cmd"
set "SPRING_ARGS=--spring.autoconfigure.exclude=org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration,org.springframework.boot.hibernate.autoconfigure.HibernateJpaAutoConfiguration,org.springframework.boot.flyway.autoconfigure.FlywayAutoConfiguration"

call "%MAVEN_CMD%" -U spring-boot:run "-Dspring-boot.run.arguments=%SPRING_ARGS%"
