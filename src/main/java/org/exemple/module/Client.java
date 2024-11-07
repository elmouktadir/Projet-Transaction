package org.exemple.module;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import  com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;


public class Client {
    private int numClient;
    private String nom;
    private String prenom;
    private String adresse;
    private String phone;
    private String email;
    private List<Compte> comptes;

    public Client(){}

    public Client(int numClient, String nom,String prenom, String adresse, String phone, String email){
        this.numClient = numClient;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.phone = phone;
        this.email = email;
        this.comptes = new ArrayList<>();
    }

    public void addCompte(Compte compte){
        comptes.add(compte);
    }

    public int getNumClient() {
        return numClient;
    }

    public void setNumClient(int numClient) {
        this.numClient = numClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    @Override
    public String toString() {
        return "Client{" +
                "numClient=" + numClient +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

//    public String toJson(){
//        Gson gson = new Gson();
//        return gson.toJson(this);
//    }

    public String ToJson(){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(this);
            return json;
        } catch (JacksonException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Client FromJson(String Json){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            return objectMapper.readValue(Json, Client.class);
        } catch (JacksonException e) {
            e.printStackTrace();
        }
        return null;
    }
}
