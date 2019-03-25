FROM java:8 AS build
ADD . /usr/app
WORKDIR /usr/app/
RUN ./mvnw clean install -Dmaven.test.skip=true


FROM java:8

RUN mkdir -p /usr/app/ 
WORKDIR /usr/app/
COPY --from=0 /usr/app/target/spring-redis-0.0.1-SNAPSHOT.jar .
RUN ls -la /usr/app/

ENTRYPOINT ["java", "-jar", "/usr/app/spring-redis-0.0.1-SNAPSHOT.jar"]
