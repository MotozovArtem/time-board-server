FROM ubuntu:18.04

RUN mkdir -p /code && \
    apt update && \
    apt install -y wget maven

RUN wget http://download.bell-sw.com/java/11.0.6+10/bellsoft-jre11.0.6+10-linux-amd64.tar.gz && \
    tar -zxvf bellsoft-jre11.0.6+10-linux-amd64.tar.gz && \
    export JAVA_HOME=/jre-11.0.6 && \
    export PATH=$JAVA_HOME/bin:$PATH && \
    echo $(java -version) && \
    echo "DB_ADDRESS=$DB_ADDRESS"

COPY . /code

WORKDIR /code
RUN mvn clean package

CMD ["java", "-jar", "target/server-0.0.1-SNAPSHOT.jar"]