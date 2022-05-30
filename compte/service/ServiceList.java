package compte.service;

import java.util.ArrayList;

import compte.models.Client;
import compte.models.Compte;

public class ServiceList implements ICompte{
    private ArrayList<Compte> comptes = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();

    @Override
    public void addClient(Client client) {
        clients.add(client); 
    }

    @Override
    public void addCompte(Client client, Compte compte) {
        compte.setClient(client);//Relation de Compte vers Client
        //client.addCompte(compte);//Relation de Client vers Compte
        comptes.add(compte);//ajouter le comptes dans la liste des comptes
    }

    @Override
    public void listerClient() {
        for (Client client : clients) {
            System.out.println(client.toString());
        }       
    }

    @Override
    public void listerCompte() {
        for (Compte compte : comptes) {
            System.out.println(compte.toString());
        }    
    }

    @Override
    public void listerCompte(String type) {
        for (Compte compte : comptes) {
            if(compte.getType().compareTo(type)==0){
                System.out.println(compte.toString());
            }
        }    
        
    }

    @Override
    public void listerCompte(Client client) {
        for (Compte compte : comptes) {
            if(compte.getClient().equals(client)){
                System.out.println(compte.toString());
            }
        }    
    }

    @Override
    public Compte searchCompte(int numero) {
        for (Compte compte : comptes) {
            if(compte.getNumero()==numero){
                return compte;
            }
        }
        return null;
    }

    @Override
    public Client searchClient(int id) {
        Client clientSearch = new Client();
        clientSearch.setId(id);
        for (Client client : clients) {
            if(client.equals(clientSearch)){
                return client;
            }
        }
        return null;
    }
    
}
