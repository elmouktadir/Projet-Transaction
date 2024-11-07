package org.exemple.module;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import  com.google.gson.Gson;

public class Compte {
    private int numCompte;
    private Date dateCreation;
    private Date dateUp;
    private double devise;
    private Client client;
    private Banque banque;
    private List<Transaction> transactions;

    public Compte(){}
    //constructeur avec argument
    public Compte(int numCompte, Date dateCreation, Date dateUp, double devise, Client client, Banque banque, List<Transaction> transactions) {
        this.numCompte = numCompte;
        this.dateCreation = dateCreation;
        this.dateUp = dateUp;
        this.devise = devise;
        this.client = client;
        this.banque = banque;
        this.transactions = transactions;
    }
    // le constructeur appeler en temps de la transaction
    public Compte(int numCompte, double devise, Client client, Banque banque) {
        this.numCompte = numCompte;
        this.dateCreation = new Date();
        this.dateUp = new Date();
        this.devise = devise;
        this.client = client;
        this.banque = banque;
        this.transactions = new ArrayList<>();
    }

    public int getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateUp() {
        return dateUp;
    }

    public void setDateUp(Date dateUp) {
        this.dateUp = dateUp;
    }

    public double getDevise() {
        return devise;
    }

    public void setDevise(double devise) {
        this.devise = devise;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "numCompte=" + numCompte +
                ", dateCreation=" + dateCreation +
                ", dateUp=" + dateUp +
                ", devise=" + devise +
                '}';
    }

//    public String toJson(){
//        Gson gson = new Gson();
//        return gson.toJson(this);
//    }

    public void UpdateDate(){
        this.dateUp = new Date();
    }

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

    public Compte FromJson(String Json){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            return objectMapper.readValue(Json, Compte.class);
        } catch (JacksonException e) {
            e.printStackTrace();
        }
        return null;
    }
}
