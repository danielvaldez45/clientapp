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


#Sirve para desplegar un war en el servidor. target: Glassfish - $GLASSFISH_HOME
deploy(){
 echo $1
 [ ! -z $1 ] && warPackage=$1 || warPackage=./target/mavenproject3-1.0-SNAPSHOT.war
 $bin/asadmin deploy $warPackage
}

#Sirve para quita la package war del servidor. target: Glassfish - $GLASSFISH_HOME
undeploy(){
 $bin/asadmin undeploy mavenproject3-1.0-SNAPSHOT
}


#Empaqueta una aplicacion en un .war y despliega el comprimido en glassfish
deploywar(){
 mvn clean package > logs/server.logs 2>&1
 isSuccess=$?
 if [[ $isSuccess != 0 ]]; then
   cat logs/server.logs 
 fi

 undeploy
 deploy
 
 #if [[ $? == 0 ]]; then
 #  echo "Abriendo el proyecto en el navegador: "
 #  google-chrome --new-window http://localhost:8080/mavenproject3-1.0-SNAPSHOT
 #
 #  #Levantamos los logs del servidor en otra ventana de la terminal:
 #  gnome-terminal --window --maximize --working-directory=/home/daniel/NetBeansProjects/mavenproject3
 #  tail -f $GLASSFISH_HOME/glassfish/domains/domain1/logs/server.log
 #fi
}
