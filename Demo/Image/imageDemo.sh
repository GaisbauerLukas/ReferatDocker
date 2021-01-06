#Bauen der dockerfile
docker build -t gaisbauerlukas\customnginx .

#Staten des Containers
docker run -p 8080:8080 -d gaisbauerlukas\customnginx

#Veröffentlichen
docker push gaisbauerlukas\customnginx