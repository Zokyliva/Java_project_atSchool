Ce guide explique comment importer le fichier structure.sql dans une base de données PostgreSQL.

Pré-requis :
PostgreSQL installé sur votre machine.
Accès à un terminal ou à une ligne de commande.
Fichier structure.sql disponible à l'emplacement souhaité.

Lancez un terminal ou une ligne de commande sur votre machine.
Se Connecter à PostgreSQL : psql -U votre_utilisateur /Remplacez votre_utilisateur par le nom de votre utilisateur PostgreSQL. Il vous sera demandé de saisir le mot de passe.

Créer une Nouvelle Base de Données (si nécessaire) : CREATE DATABASE nom_de_la_base_de_donnees;
\c nom_de_la_base_de_donnees

Importer le Fichier structure.sql : psql -U votre_utilisateur -d nom_de_la_base_de_donnees -f chemin/vers/structure.sql

Remplacez :

votre_utilisateur par le nom d'utilisateur PostgreSQL.
nom_de_la_base_de_donnees par le nom de la base de données que vous avez créée ou choisie.
chemin/vers/structure.sql par le chemin complet vers votre fichier structure.sql.

Vérifier l'Importation : \dt


