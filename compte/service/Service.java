package compte.service;

import compte.models.Client;
import compte.models.Compte;

public class Service implements ICompte {
    public static final int N=10;
    private Compte comptes[] = new Compte[N];
    private int indexCompte; 
    private Client clients[] = new Client[N];
    private int indexClient;

    @Override
    public void addClient(Client client) {
        if(indexClient<N){
            clients[indexClient]=client;
            indexClient++;
        }
        else{
            System.out.println("Le tableau est plein");
        }
    }

    @Override
    public void addCompte(Client client, Compte compte) {
        if(indexCompte<comptes.length){
            //affectation du client au compte
            compte.setClient(client);
            comptes[indexCompte]=compte;
            indexCompte++;
        }
        else{
            System.out.println("Le tableau est plein");
        }
    }

    @Override
    public void listerClient() {
        for (Client client : clients) {
            if(client!=null){
                System.out.println(client.toString());
            }
        }       
    }

    @Override
    public void listerCompte() {
        for (Compte compte : comptes) {
            if(compte!=null){
                System.out.println(compte.toString());
            }
        }    
    }

    @Override
    public void listerCompte(String type) {
        for (Compte compte : comptes) {
            if(compte!=null && compte.getType().compareTo(type)==0){
                System.out.println(compte.toString());
            }
        }    
        
    }

    @Override
    public void listerCompte(Client client) {
        for (Compte compte : comptes) {
            if(compte!=null && compte.getClient().equals(client)){
                System.out.println(compte.toString());
            }
        }    
    }

    @Override
    public Compte searchCompte(int numero) {
        for (Compte compte : comptes) {
            if(compte != null && compte.getNumero()==numero){
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
            if(client != null && client.equals(clientSearch)){
                return client;
            }
        }
        return null;
    }
    
}
