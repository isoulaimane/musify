FROM rtsi.inca.rte-france.com/oraclejdk:1.8.0_74
MAINTAINER Ismail Soulaimane <soulaimane@gmail.com>
WORKDIR /opt
ADD build/libs/mus*.jar music.jar
ENV JAVA_OPTS "-Djava.security.egd=file:/dev/./urandom"
EXPOSE 8083
ENTRYPOINT ["java", "-jar",  "/opt/music.jar"]
