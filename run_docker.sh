docker build . -t client-app:1.0.0
docker run -it --rm --name client_container-app -p 8080:8080 client-app:1.0.0
