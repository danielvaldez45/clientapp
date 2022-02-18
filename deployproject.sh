GLASSFISH_HOME=/home/daniel/glassfish5
bin=$GLASSFISH_HOME/bin

init_glassfishServer() {
 $bin/asadmin start-domain domain1
}

stop_glassfishServer() {
 $bin/asadmin stop-domain domain1
}

#mvn clean package > /dev/null

#curl -sf localhost:8080 > /dev/null
#isHealth=$?
#echo $isHealth
#[ $? == 0 ] && echo "Todo chido" || echo "Algo salio mal"


#Empaqueta una aplicacion en un .war y despliega el comprimido en glassfish
deploywar(){
 mvn clean package > logs/server.logs 2>&1
 isSuccess=$?
 if [[ $isSuccess != 0 ]]; then
   cat logs/server.logs 
 fi

 $bin/asadmin undeploy mavenproject3-1.0-SNAPSHOT
 $bin/asadmin deploy ./target/mavenproject3-1.0-SNAPSHOT.war
}
