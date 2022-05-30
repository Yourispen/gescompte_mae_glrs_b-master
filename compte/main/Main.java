package compte.main;

import java.util.ArrayList;
import java.util.Scanner;

import compte.models.Cheque;
import compte.models.Client;
import compte.models.Compte;
import compte.models.Epargne;
import compte.service.ICompte;
//import compte.service.Service;
import compte.service.ServiceList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ICompte service = new ServiceList();
        Client client;
        String nom, prenom;
        int choix, type, id, numero, choixOp;
        Compte compte, compteV;
        double solde, frais, mnt;


        do{
        System.out.println("1-Créer un client");
        System.out.println("2-Lister les clients");
        System.out.println("3-Créer un compte");
        System.out.println("4-Lister tous comptes");
        System.out.println("5-Lister les comptes par type");
        System.out.println("6-Lister les comptes par client");
        System.out.println("7-Faire une opération");
        System.out.println("8-Quitter");

        System.out.println("Choisissez une option : ");
        choix=sc.nextInt();
        sc.nextLine();
        switch (choix) {
            case 1:
                    System.out.println("Saisir le nom du client");
                    nom=sc.nextLine();
                    System.out.println("Saisir le prenom du client");
                    prenom=sc.nextLine();
                    client = new Client();
                    client.setNom(nom);
                    client.setPrenom(prenom);
                    service.addClient(client);
                break;
            case 2:
                    service.listerClient();
                break;
            case 3:
                    /**
                     * 1-la saisie des attributs du compte
                     * 2-demande le type  du compte qu'on veut créer
                     * 3-on saisie les attributs du compte dont le type a été saisi
                     * 4-on instancie le type de compte correspondant
                     * 5-on hydrate les attributs de ce compte par downcasting ou par surcharge
                     * 6-on recherche le client à partir de son id
                     * 7-on crée le compte en lui affectant le client
                     */
                    System.out.println("Saisir le solde : ");
                    solde = sc.nextDouble();
                    do{
                        System.out.println("Saisir le type du compte : ");
                        System.out.println("1-Epargne\n2-Cheque");
                        type = sc.nextInt();
                    }while(type<1 || type>2);

                    if(type == 1){
                        compte = new Epargne();
                    }
                    else{
                        System.out.println("Saisir les frais : ");
                        frais = sc.nextDouble();
                        //compte = new Cheque();//on a fait un upcasting
                        //((Cheque)compte).setFrais(frais);//on a fait du downcasting
                        compte = new Cheque(frais);//la surcharge du constructeur
                    }
                    compte.depot(solde);
                    System.out.println("Saisir l'id du client :");
                    id = sc.nextInt();
                    client = service.searchClient(id);
                    if(client!=null){
                        service.addCompte(client, compte);
                    }
                    else{
                        System.out.println("ce client n'existe pas.");
                    }
            
                break;
            case 4 :
                    service.listerCompte();
                break;
            case 5:
                    do{
                        System.out.println("Saisir le type du compte : ");
                        System.out.println("1-Epargne\n2-Cheque");
                        type = sc.nextInt();
                    }while(type<1 || type>2);

                    service.listerCompte(type==1?"Epargne":"Cheque");
                break;
            case 6:
                    System.out.println("Saisir l'id du client :");
                    id = sc.nextInt();
                    client = service.searchClient(id);
                    if(client!=null){
                        ArrayList<Compte> comptes = client.getComptes();
                        for (Compte cpt : comptes) {
                            System.out.println(cpt.toString());
                        }
                    }
                    else{
                        System.out.println("ce client n'existe pas.");
                    }
                break;
            case 7:
                    System.out.println("Saisir le numero du compte : ");
                    numero = sc.nextInt();
                    compte = service.searchCompte(numero);
                    if(compte != null){
                        if(compte.getType().compareTo("Epargne")==0){
                            do {
                                System.out.println("1- Faire un dépot");
                                System.out.println("Choisir une option : ");
                                choixOp = sc.nextInt();
                            } while (choixOp!=1);
                            System.out.println("Saisir le montant : ");
                            mnt = sc.nextDouble();
                            compte.depot(mnt);
                        }
                        else{
                            do {
                                System.out.println("1- Faire un dépot");
                                System.out.println("2- Faire un retrait");
                                System.out.println("3- Faire un virement");
                                System.out.println("4- Consulter le compte");
                                System.out.println("Choisir une option : ");
                                choixOp = sc.nextInt();
                            } while (choixOp<1 || choixOp>4);
                            if(choixOp==4){
                                compte.consultation();
                            }
                            else{
                                System.out.println("Saisir le montant : ");
                                mnt = sc.nextDouble();
                                if(choixOp==1){
                                    compte.depot(mnt);
                                }
                                else if(choixOp==2){
                                    compte.retrait(mnt);
                                }
                                else{
                                    System.out.println("Saisir le numero du compte de réception : ");
                                    numero = sc.nextInt();
                                    compteV = service.searchCompte(numero);
                                    if(compteV!=null){
                                        compte.virement(mnt, compteV);
                                    }
                                    else{
                                        System.out.println("Ce compte n'existe pas.");
                                    }
                                }
                            }
                            
                        }

                    }
                    else{
                        System.out.println("Ce compte n'existe pas.");
                    }
                    
                break;
        }
    }while(choix!=8);
    sc.close();



    }
}
