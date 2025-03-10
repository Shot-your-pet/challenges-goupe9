Pour lancer la BD
````
docker run --detach --name some-mariadb --env MARIADB_USER=shotyourpet --env MARIADB_PASSWORD=shotyourpet --env MARIADB_DATABASE=challenges --env MARIADB_ROOT_PASSWORD=shotyourpet -p 3306:3306 mariadb:latest --port 3306
````