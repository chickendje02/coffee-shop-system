docker login -u $DOCKER_HUB_USERNAME -p $DOCKER_HUB_PASSWORD
docker pull chickendje02/$SERVICE_NAME:latest
docker rm -f $SERVICE_NAME-container
docker run -d -p 8081:8081 --name $SERVICE_NAME-container chickendje02/$SERVICE_NAME:latest