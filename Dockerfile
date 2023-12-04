FROM amazoncorretto:17 as builder

RUN mkdir -p /app/msvc-auth
WORKDIR /app/msvc-auth

COPY ./settings.gradle settings.gradle
COPY ./build.gradle build.gradle
COPY ./gradle  gradle
COPY ./gradlew gradlew
#Print load files
RUN ls -al
#Create cache gradlw
RUN ./gradlew clean -DskipTests -DskipMain  -Dspring-boot.repackage.skip
#RUN ./gradlew --offline clean
#Copy source files
COPY ./src src
#Build app
RUN ./gradlew clean build -DskipTests
#Print build files
RUN ls -al build/libs/

FROM openjdk:17-jdk-alpine

WORKDIR /app
RUN mkdir ./logs
RUN ls  -al
COPY --from=builder /app/msvc-auth/build/libs/auth-0.0.1.jar .
#Application port
ENV PORT 8001
EXPOSE $PORT

CMD ["java", "-jar", "auth-0.0.1.jar"]