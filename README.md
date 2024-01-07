# UnePieceRepo
TODO : faire une fonction redirect qui redirige vers la bonne url en fonction de l'état de la partie 
- ex si pas de membres, redirige vers start component
- si actions non terminées dans liste d'actions, redirige vers trajet
- si pas d'actions non terminées, redirige vers ile
## cette fonction serait appelée quand on a besoin de rediriger (ex quand on fait partir en mer) + quand on arrive sur un component (pour empecher d'y accéder en tapant l'url par exemple)

TODO : virer ancienne partie du localStorage quand on fait newGame

TODO pas changer bateaux chaque jour : pas RP

TODO afficher capacite bateau stat-equipage component

TODO capacite bateau devient inférieure à nombre de membres dans l'équipage -> ?

TODO faire "continuer" à restaurant fait action fuite

TODO retirer partie local storage



-> Plutôt que gérer bouton1 / bouton2 comme ça pour action, les boutons devraient juste set "choix" de action sur true ou false, et appeler une méthode 'resolveAction" qui détermine l'issue en fonction de l'evenement et du choix