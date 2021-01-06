# Erstellen eines NGINX Webservers
docker run nginx

# Erstellen mit Parametern
docker run -p 8080:80 --name nginx -d nginx 
# mittels -p kann man den port eines Containers nach ausen frei geben dabei muss mann beachten das der erste Port der außere und 
# der zweite der innere Port ist.
# mit --name kann man den Namen eines Containers festlegen
# -d startet den Container als hintergrund Prozess

#In den Container hineinschauen
docker exec -it nginx bash

# Löschen des Containers
docker stop nginx && docker rm nginx
#or
docker rm -f nginx
#Nginx steht hierbei für den Container Name. Statdessen können auch die ersten beiden Buchstaben der Container id verwendet werden.

# Anlegen eines Volumes
docker run -p 8080:80 --name nginx -d -v data:/usr/share/nginx/html nginx 
#Die Daten eines Verzeichnises werden in einen von Docker verwalteten Speicherplatz abgelegt. Dieser wird nach dem Stopen des Containers
#nicht gelöscht.

# Ansehen von Volumes
docker volume ls 
#Listet alle Volumes auf
docker volume inspect {nameDesVolumes}
#Gibt dessen Daten wieder. So kann man beispielsweise den Speicherort eines volumes anzeigen

# Anlegen von Bindmounts
docker run -p 8080:80 --name nginx -d -v /home/lukas/Documents/repos/ReferatDocker/Demo/Container/exampleWebPage:/usr/share/nginx/html nginx
# Der Pfad am Localen Dateisystem muss immer absolut angegeben werden