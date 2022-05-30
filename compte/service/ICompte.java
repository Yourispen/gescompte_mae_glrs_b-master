package compte.service;

import compte.models.Client;
import compte.models.Compte;

public interface ICompte {
    //Use case
       //1- Creer un client 
       void addClient(Client client);
       // 2-Afficher tous les client
          void listerClient();
       //3- Creer un compte on lui affecte un client
         void addCompte(Client client,Compte compte);
       //4- Afficher  tous les comptes
           void listerCompte();
       //5- Afficher les comptes par type
           void listerCompte(String type);
       //6- Afficher les comptes d'un  client
          void listerCompte(Client client);
       //7-Faire une operation
          Compte  searchCompte(int numero);
          
          Client searchClient(int id);
  }
  
