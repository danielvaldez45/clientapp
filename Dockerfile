FROM glassfish:latest


COPY target/mavenproject3-1.0-SNAPSHOT.war $GLASSFISH_HOME/glassfish/domains/domain1/autodeploy/
