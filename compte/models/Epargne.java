package compte.models;

public class Epargne  extends Compte{
    public static final double TAUX=0.18;

    public Epargne() {
        super();//classe
        type="Epargne";
    }

    @Override  //Reecrite ou Redefinie
    public void retrait(double mnt){
       System.out.println("Retrait Impossible");
    }
    @Override
    public void depot(double mnt){
        solde+=mnt+ mnt*TAUX;
    }

    @Override
    public void virement(double mnt,Compte cpteVir){
        System.out.println("Virement Impossible");
    }

    @Override
    public String toString() {
        return "Epargne : "+super.toString()+"taux=" + TAUX + "]";
    }


    
    
}

