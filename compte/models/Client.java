package compte.models;

public class Client {
    private int id;
    private String nom;
    private String prenom;
    private static int nbre;
  
    //OneToMany
      //List
  
  
    public Client() {
       id=++nbre;
    }
    public int getId() {
      return id;
    }
    public String getPrenom() {
      return prenom;
    }
    public void setPrenom(String prenom) {
      this.prenom = prenom;
    }
    public String getNom() {
      return nom;
    }
    public void setNom(String nom) {
      this.nom = nom;
    }
    public void setId(int id) {
      this.id = id;
    }
  
    @Override
    public String toString() {
      return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
    }
    @Override
    public boolean equals(Object obj) {
      return this.id == ((Client)obj).getId();
    }
      
  }
  
