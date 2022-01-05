## Background

🥰🐈 Le but de cet exercice est de développer une mini application web qui permet de trouver le chat le plus mignon.



👻J'ai utilisé **_Springboot_** et **_Mybatis(Mysql)_** pour compléter la partie back-end, et la structure interne est conforme aux normes de développement des entreprises, ce qui offre plus de possibilités pour développer d'autres fonctions ultérieurement👻

## Structure du projet

* controller
  * viewobject(Les données qui sont renvoyées directement au front-end, par exemple les passwords ou des informations sensibles ne peut être transmis au front-end  mets pas dedans)
* dao
* dataobject(Converties directement à partir de la base de données)
* error(Traitement des exceptions)
* response
* service
  * impl
  * model(Converti de dataobject en)
* start
  


## Captures d'écran et explication

Tous les résultats de l'API renvoyés au front-end sous format de JSON ( **_statut_** et **_data_**)

Lorsque l'api est réussie, les résultats suivants sont retournés

![image](https://user-images.githubusercontent.com/58182030/148266490-95f68a21-c966-4e19-bcd3-e0a9d15beb5f.png)

Lorsque l'api est échoue, les résultats suivants sont renvoyés(errcode et errmsg sont différents)

![image](https://user-images.githubusercontent.com/58182030/148269320-74bac97a-b5ec-48b2-8fa3-52a3b4e2e81c.png)

Quand les gens veulent voir tous les chats avec leur score
Appeler API /cat/getAll 

![image](https://user-images.githubusercontent.com/58182030/148270324-622694ab-60e5-4e1e-91db-425d8260a680.png)


Quand les gens veulent voter pour son chat
Appeler API /cat/vote 

![image](https://user-images.githubusercontent.com/58182030/148270548-97f128ef-ac77-4067-9ce1-2227d45c8d09.png)

**_Les votes du chat sélectionné +1_**

![image](https://user-images.githubusercontent.com/58182030/148270783-978b5587-d4a8-45f8-bf63-aee9ca892eb9.png)

![image](https://user-images.githubusercontent.com/58182030/148270808-459f06fd-682b-480b-b0ac-f88f8ed0ffe3.png)

Après le vote on peut appeler API /cat/getMostPopularCat pour le chat plus populaire!

![image](https://user-images.githubusercontent.com/58182030/148271377-5377e6bb-74ff-4d20-abc8-79725b116f5e.png)

## Orientations et possibilités de développement future🤯

* Ajouter une fonction d'enregistrement et de connexion des utilisateurs, chaque utilisateur ne peut voter qu'une seule fois
* Ajouter les dates de début et de fin de l'événement
* Améliorer les performances simultanées pour résoudre le problème de l'accès multiple en ligne par
  * Utiliser Nosql(Redis)
  * Plate-forme de messagerie et de streaming distribuée (RabbitMQ/RocketMQ)







