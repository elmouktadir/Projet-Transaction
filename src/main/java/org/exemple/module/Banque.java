package org.exemple.module;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import  com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;


public class Banque {
    private String id;
    private String pays;
    private List<Compte> comptes;

    public Banque(){}

    public Banque(String id, String pays) {
        this.id = id;
        this.pays = pays;
        this.comptes = new ArrayList<>();
    }

    public void addCompte(Compte compte){
        comptes.add(compte);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    @Override
    public String toString() {
        return "Banque{" +
                "id=" + id +
                ", pays='" + pays + '\'' +
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

    public Banque FromJson(String Json){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            return objectMapper.readValue(Json, Banque.class);
        } catch (JacksonException e) {
            e.printStackTrace();
        }
        return null;
    }

}
