package compte.models;

public class Cheque extends Compte{

    private double frais;
    public Cheque() {
        type="Cheque";
    }
    public Cheque(double frais) {
        this.frais = frais;
        type="Cheque";
    }

    public double getFrais() {
        return frais;
    }

    public void setFrais(double frais) {
        this.frais = frais;
    }

    @Override
    public void depot(double mnt){
        solde+=mnt -frais;
    }

    @Override
    public String toString() {
        return "Cheque : "+super.toString()+"frais=" + frais + "]";
    }

    
}

