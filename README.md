# TP Rendu DUDCL

### à rendre pour le 20 juillet 2016.

Le projet ci-dessous vous fournit une structure de projet classique pour un projet Web avec une partie serveur en Java et une partie cliente qui utilise AngularJS.

La partie serveur expose ses APIs sous la forme de service Rest.

La documentation est donnée à l'aide de [swagger](http://swagger.io/).

##Etape 1.
Testez l'application.

Cloner le repository

```bash
git clone
https://github.com/barais/DUDCLJEETP.git
```


Lancez la base de données

```bash
run-hsqldb-server.bat #sous windows
#utilisez le .sh sous linux
```

Visualisez la base
```bash
show-hsqldb.bat #sous windows
#utilisez le .sh sous linux
```

Si tout est ok. Préparons maintenant l'application.

Dans la ligne de commande npm. Il faut installez nodejs pour windows.
```bash
cd src/main/webapp
npm i
npm install -g grunt-cli bower yo generator-karma generator-angular
bower i
```

Importez l'application dans eclipse. C'est un projet Maven.

Il y a une classe JpaTest.java qui permet de peupler la base. Lancez le main de cette classe.

Il y a une classe src/main/java/app/RestApplication.java qui permet de lancez le serveur Web.

La structuration en packages sépare clairement les classes métier (package domain), les classes DAO (package repository), les classes de services (package web.rest).

Une fois l'application lancez, testez cette application.

* [http://localhost:8080](http://localhost:8080) doit vous donner accès à l'application
* [http://localhost:8080/department](http://localhost:8080/department) doit vous donner accès aux flux json retourner pour obtenir la liste des départements.
* [http://localhost:8080/api/](http://localhost:8080/api/) vous donne accès à swagger.

Le code de l'appli angularjs se trouve dans src/main/webapp/app/

Cette application a été générée en utilisant [yeoman](http://yeoman.io/) et le [générateur pour AngularJS](https://github.com/yeoman/generator-angular).

##Travail à faire.

En repartant des TPs effectués pendant le module. Dévelopez une application simple suivant le cahier des charges suivants.

L’objectif de ce projet est de construire la partie métier/persitance d’une application type réseau social permettant de comparer sa consommation électrique avec ses amis, ses voisins, ... dans la lignée de opower.
OPower est une société américaine qui est fondée sur un principe de base déjà porteur : grâce à son logiciel, il permet aux consommateurs de maîtriser leur consommation d’énergie. En effet, il travaille conjointement avec des fournisseurs de services publics (électricité, gaz, téléphone, etc.) pour promouvoir l'efficacité énergétique. Mais lorsqu’il se met à surfer sur la vague Facebook, Opower fait de l’économie d’énergie un jeu… qui pourrait séduire ses clients !

Opower a créé une application (liée à Facebook) qui permet de suivre sa consommation électrique dans le cadre d’un réseau social. Ainsi les consommateurs peuvent comparer leur consommation d’électricité avec celle de ses voisins sur le réseau social… De l’économie d’énergie ludique !

Pour ce faire, le modèle métier est assez simple, il utilise le concept de Personne ayant un nom un prénom, un mail, une ou plusieurs résidence. Chaque résidence a une taille, un nombre de pièce, des chauffages, des équipements électroniques. Ses équipements ont une consommation moyenne en Watt/h.
Prenez la liberté de compléter ce modèle métier au maximum.

1. Développez ce modèle métier dans le package domain.
2. Développez les classes repository contenant les actions de base à faire sur la base de données pour chacune de ces classes métiers.
3. Développez une couche de service pour cette application dans le package (web.rest). Vous devrez modifier la classe RestApplication pour ajoutez vos nouvelles ressources.
4. Développez une interface angularjs simple qui intéragit avec vos services.

N'hésitez pas à me contacter en cas de difficultés.

Olivier
