# Erstellen eines NGINX Webservers
docker run nginx

# Erstellen mit Parametern
docker run -p 8080:80 --name nginx -d nginx 
# mittels -p kann man den port eines Containers nach ausen frei geben dabei muss mann beachten das der erste Port der außere und 
# der zweite der innere Port ist.
# mit --name kann man den Namen eines Containers festlegen
# -d startet den Container als hintergrund Prozess

# Löschen des Containers
docker stop nginx && docker rm nginx
#or
docker rm -f nginx
#Nginx steht hierbei für den Container Name. Statdessen können auch die ersten beiden Buchstaben der Container id verwendet werden.