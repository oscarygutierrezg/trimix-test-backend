FROM tomcat:9.0

COPY ./target/backendtest-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/backendtest.war
