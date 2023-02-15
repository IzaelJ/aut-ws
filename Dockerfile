FROM adpotopenjdk/openjdk17:latest 
VOLUME /tpm 
COPY target/auth-*.jar app.jar
ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar" ]
