package compte.models;

public abstract class Compte {
    protected int numero;//0
    protected double solde;//0
    private static int nbreCompte;//0
    protected String type;

    //ManyToOne => Attribut Navigationnel
    private Client client ; //intialise a null

   
    public Compte() {
       /* nbreCompte++;
        numero= nbreCompte;*/
        //Pre-Increment => Incrementation apres affectation
        numero =++nbreCompte;//numero =>1
        //Post-Increment =>  affectation apres Incrementation 
        //numero =nbreCompte++;//numero =>0
    }
    public int getNumero() {
        return numero;
    }
    public double getSolde() {
        return solde;
    }
    public void setSolde(double solde) {
        this.solde = solde;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    //Methodes Metier
    public void retrait(double mnt){
        if(mnt<solde){
            //solde=solde-mnt;
            solde-=mnt;
        }else{
            System.out.println("Erreur");
        }
        
    }

    public void depot(double mnt){
        solde+=mnt;
    }

    public String consultation (){
        return "Le solde de votre Compte "+solde;
    }
    
    public void virement(double mnt,Compte cpteVir){
        if(mnt<solde){
            //solde=solde-mnt;
            retrait(mnt);//this.retrait(mnt)
            cpteVir.depot(mnt);
        }else{
            System.out.println("Erreur");
        }
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;//relation de Compte vers Client
        client.addCompte(this);//Relation de Client vers Compte   
    }
    public String getType() {
        return type;
    }
    @Override
    public String toString() {
        return client.toString()+"\n[numero=" + numero + ", solde=" + solde + ", type=" + type;
    }
}
